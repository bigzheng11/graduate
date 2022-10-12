<!-- 用户管理组件 -->
<template>
   <div class="userList">
      <h1>测试区域</h1>
   </div>
</template>

<script>
export default {
   data() {
      return {};
   },
   created() {},

   mounted() {
      var chartDom = document.getElementById("main");
      var myChart = echarts.init(chartDom);
      var option;
   },

   methods: {},
};
</script>


<style>
</style>
