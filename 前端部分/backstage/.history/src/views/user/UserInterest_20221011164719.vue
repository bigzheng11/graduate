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
         //定时器
         num: 0,
         timer: null,
         //用户信息
         user: {},

         // echarts的数据配置项
         option: {
            // 中间大标题
            title: {
               text: "用户15518745323",
               subtext: "购买倾向图",
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
                  data: [],
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
      console.log("获取的userID", this.$route.query.userID);
      //获取用户信息:

      this.$axios
         .get("/api/interest/backstage/15518745323")
         .then((response) => {
            console.log(response.data);
           
         })
         .catch((error) => {
            console.log(er'ro'e);
         });

      this.$axios
         .get("/api/interest/backstage/15518745323")
         .then((response) => {
            console.log(response.data);
            let temp = {};
            for (const item of response.data) {
               temp.name = item.goodsClassify;
               temp.value = item.grade;
               this.option.series[0].data.push(temp);
               temp = {};
            }
            var chartDom = document.getElementById("main");
            var myChart = this.$echarts.init(chartDom);
            this.option && myChart.setOption(this.option);
         })
         .catch((error) => {});

      // 实现轮询
      this.timer = window.setInterval(() => {
         setTimeout(this.getProjectList(), 0);
      }, 1000);
   },

   mounted() {
      var chartDom = document.getElementById("main");
      var myChart = this.$echarts.init(chartDom);
      this.option && myChart.setOption(this.option);
   },

   methods: {
      //查询
      stop() {
         clearInterval(this.timer);
         this.timer = null;
      },

      // 请求是否有新消息
      getProjectList() {
         console.log("请求" + this.num++ + "次");
         this.$axios
            .get("/api/interest/backstage/15518745323")
            .then((response) => {
               console.log(response.data);
               this.option.series[0].data = [];
               let temp = {};
               for (const item of response.data) {
                  temp.name = item.goodsClassify;
                  temp.value = item.grade;
                  this.option.series[0].data.push(temp);
                  temp = {};
               }
               var chartDom = document.getElementById("main");
               var myChart = this.$echarts.init(chartDom);
               this.option && myChart.setOption(this.option);
            })
            .catch((error) => {});
         if (this.num == 180) {
            this.stop();
         }
      },

      change() {
         // 修改数据
         this.option.series[0].data[0].value += 10;
         //  页面更新
         var chartDom = document.getElementById("main");
         var myChart = this.$echarts.init(chartDom);
         this.option && myChart.setOption(this.option);
      },
   },

   destroyed() {
      //离开页面是销毁
      clearInterval(this.timer);
      this.timer = null;
   },
};
</script>
 
 <style scoped></style>