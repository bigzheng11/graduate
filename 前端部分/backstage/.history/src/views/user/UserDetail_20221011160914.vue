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
      myChartStyle: { float: "left", width: "100%", height: "400px" } //图表样式
      };
   },
   created() {},

   mounted() {
      var chartDom = document.getElementById("main");
      var myChart = this.$echarts.init(chartDom);
      myChart.setOption(this.option);
   },

   methods: {},
};
</script>


<style>
</style>
