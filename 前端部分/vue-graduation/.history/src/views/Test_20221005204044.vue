<template>
   <div class="container">
      测试页面
      <hr />
      <div
         style="width: 700px; height: 700px; border: 1px solid red"
         id="main"
      ></div>
      <button @click="change">修改</button>
   </div>
</template>
 
 <script>
export default {
   data() {
      return {
         // echarts的数据配置项
         option: {
            // 中间大标题
            title: {
               text: "用户的喜好",
               subtext: "喜好饼状图",
               left: "center",
            },
            tooltip: {
               trigger: "item",
            },
            legend: {
               orient: "vertical",
               left: "left",
            },
            series: [
               {
                  name: "Access From",
                  type: "pie",
                  radius: "50%",
                  data: [
                     { value: 20, name: "芒果" },
                     { value: 20, name: "香蕉" },
                     { value: 20, name: "葡萄" },
                     { value: 20, name: "水蜜桃" },
                  ],
                  emphasis: {
                     itemStyle: {
                        shadowBlur: 10,
                        shadowOffsetX: 0,
                        shadowColor: "rgba(0, 0, 0, 0.5)",
                     },
                  },
               },
            ],
         },
      };
   },
   created() {
    this.$axios
         .get("api/interest/topSixInterest/" + this.user.userID)
         .then((response) => {
            this.recommendGoodList = response.data;
            this.imgSrc = this.recommendGoodList[0].user.userImg;
            this.userName = this.recommendGoodList[0].user.userName;
            this.goodsDescribe = this.recommendGoodList[0].goodsDescribe;

            console.log(
               "=====获取该用户下所有推荐的商品列表======",
               this.recommendGoodList
            );

            //将获取到的数据加入本地播放列表
            for (const item of this.recommendGoodList) {
               let objectTemp = {};
               objectTemp.goodsID = item.video.goodsID;
               objectTemp.url = item.video.video;
               this.dataList.push(objectTemp);
            }
            //加入Vuex中
            this.$store.dispatch(
               "RecommendGoodListActions",
               this.recommendGoodList
            );
         })
         .catch((error) => {
            console.log(error);
         });


   },
   mounted() {
      var chartDom = document.getElementById("main");
      var myChart = this.$echarts.init(chartDom);
      this.option && myChart.setOption(this.option);
   },
   methods: {
      change() {
         // 修改数据
         this.option.series[0].data[0].value += 10;
         //  页面更新
         var chartDom = document.getElementById("main");
         var myChart = this.$echarts.init(chartDom);
         this.option && myChart.setOption(this.option);
      },
   },
};
</script>
 
 <style scoped></style>
 
 <!-- 
 axios:
 
      axios
    .get("https://autumnfish.cn/api/joke/list?num=3") //获得三个笑话
    .then(function (response) {
    console.log(response);
  });
 
 axios.get('url')
   .then(function (response) {
     console.log(response);
   })
   .catch(function (error) {
     console.log(error);
   })
   .then(function () {
   });
  -->
 