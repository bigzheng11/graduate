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
         user: {},

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
                     //  { value: 20, name: "芒果" },
                     //  { value: 20, name: "香蕉" },
                     //  { value: 20, name: "葡萄" },
                     //  { value: 20, name: "水蜜桃" },
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
      //获取用户信息:
      //   this.user = this.$qs.parse(window.sessionStorage.getItem("userinfo"));

      this.$axios
         .get("api/interest/backstage/15518745323")
         .then((response) => {
            console.log(response.data);

            let temp = {};
            for (const item of response.data) {
               temp.goodsClassify = item.goodsClassify;
               temp.grade = item.grade;
               this.option.series[0]
            }
         })
         .catch((error) => {});
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
 