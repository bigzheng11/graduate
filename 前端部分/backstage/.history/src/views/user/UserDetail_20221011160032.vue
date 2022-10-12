<!-- 用户管理组件 -->
<template>
   <div class="userList">
      div#userLis
      <h1>测试区域</h1>
   </div>
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
      var chartDom = document.getElementById("userList");
      var myChart = echarts.init(chartDom);
      var option;

      option && myChart.setOption(option);
   },

   methods: {},
};
</script>


<style>
</style>
