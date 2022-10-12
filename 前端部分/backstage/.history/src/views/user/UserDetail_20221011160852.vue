<!-- 用户管理组件 -->
<template>
   <div class="echart" id="mychart" :style="myChartStyle"></div>
</template>

<script>
export default {
   data() {
      return {
         option: {
            xAxis: {
               type: "category",
               data: ["Mon", "Tue", "Wed", "Thu", "Fri", "Sat", "Sun"],
            },
            yAxis: {
               type: "value",
            },
            series: [
               {
                  data: [120, 200, 150, 80, 70, 110, 130],
                  type: "bar",
               },
            ],
         },
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
