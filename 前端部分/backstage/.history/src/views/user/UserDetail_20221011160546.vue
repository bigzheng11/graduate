<!-- 用户管理组件 -->
<template>
   <div class="userList">
      <h1>测试区域</h1>
      <div
         id="test"
         style="width: 700px; height: 600px; border: 1px solid red"
      ></div>
   </div>
</template>

<script>
import * as echarts from "echarts";
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
      this.option && myChart.setOption(this.option);
   },

   methods: {},
};
</script>


<style>
</style>
