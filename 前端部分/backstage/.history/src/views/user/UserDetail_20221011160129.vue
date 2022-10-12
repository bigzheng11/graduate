<!-- 用户管理组件 -->
<template>
   <div class="userList">
      <h1>测试区域</h1>
      <div id="test"></div>
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
      var myChart = echarts.init(document.getElementById("test"));

      this.option && myChart.setOption(this.option);
   },

   methods: {},
};
</script>


<style>
</style>
