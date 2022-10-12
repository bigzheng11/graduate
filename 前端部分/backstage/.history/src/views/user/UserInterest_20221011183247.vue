<template>
   <div class="container" style="position: relative">
      <div
         style="width: 700px; height: 700px; display: inline-block"
         id="main"
      ></div>
      <button @click="change">修改</button>
      <div
         class="card"
         style="display: inline-block; position: absolute; left: 630px"
      >
         <el-row>
            <el-col :span="8" :offset="index > 0 ? 2 : 0" style="width: 200px">
               <el-card :body-style="{ padding: '0px' }">
                  <img
                     src="https://shadow.elemecdn.com/app/element/hamburger.9cf7b091-55e9-11e9-a976-7f4d0b07eef6.png"
                     class="image"
                  />
                  <div style="padding: 14px">
                     <span>好吃的汉堡</span>
                     <div class="bottom clearfix">
                        <time class="time">{{ currentDate }}</time>
                     </div>
                  </div>
               </el-card>
            </el-col>
         </el-row>
      </div>
   </div>
</template>
 
 <script>
export default {
   data() {
      return {
         currentDate: new Date(),

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
         .get("/api/user/detail/" + this.$route.query.userID)
         .then((response) => {
            console.log(response.data);
            
            this.option.title.text = "用户:" + response.data.userName;
         })
         .catch((error) => {
            console.log(error);
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
         .catch((error) => {
            console.log(error);
         });

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
 
 <style scoped>
/* 卡片 */
.time {
   font-size: 13px;
   color: #999;
}

.bottom {
   margin-top: 13px;
   line-height: 12px;
}

.button {
   padding: 0;
   float: right;
}

.image {
   width: 100%;
   display: block;
}

.clearfix:before,
.clearfix:after {
   display: table;
   content: "";
}

.clearfix:after {
   clear: both;
}
</style>