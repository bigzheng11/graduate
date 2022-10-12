<!-- 用户管理组件 -->
<template>
   <div class="echart" id="mychart" :style="myChartStyle"></div>
</template>

<script>
import * as echarts from "echarts";
export default {
   data() {
      return {
         xData: ["Mon", "Tue", "Wed", "Thu", "Fri", "Sat", "Sun"], //横坐标
         yData: [23, 24, 18, 25, 27, 28, 25], //数据
         myChartStyle: { float: "left", width: "100%", height: "400px" }, //图表样式
      };
   },
   created() {},

   mounted() {
      var chartDom = document.getElementById("main");
      var myChart = this.$echarts.init(chartDom);
      myChart.setOption(this.option);
   },

   methods: {
      initEcharts() {
      // 基本柱状图
      const option = {
        xAxis: {
          data: this.xData
        },
        yAxis: {},
        series: [
          {
            type: "bar", //形状为柱状图
            data: this.yData
          }
        ]
      };
      const myChart = echarts.init(document.getElementById("mychart"));
      myChart.setOption(option);
      //随着屏幕大小调节图表
      window.addEventListener("resize", () => {
        myChart.resize();
      });
    }
————————————————
版权声明：本文为CSDN博主「Saga Two」的原创文章，遵循CC 4.0 BY-SA版权协议，转载请附上原文出处链接及本声明。
原文链接：https://blog.csdn.net/m0_46309087/article/details/122395659

   },
};
</script>


<style>
</style>
