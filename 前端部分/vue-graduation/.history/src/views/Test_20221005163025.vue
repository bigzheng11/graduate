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
      return {};
   },
   mounted() {
      var chartDom = document.getElementById("main");
      var myChart = this.$echarts.init(chartDom, "dark");
      var option;

      setTimeout(this.demo(),0);

      option && myChart.setOption(option);
   },
   methods: {
      demo() {
         
         myChart.on("updateAxisPointer", function (event) {
            const xAxisInfo = event.axesInfo[0];
            if (xAxisInfo) {
               const dimension = xAxisInfo.value + 1;
               myChart.setOption({
                  series: {
                     id: "pie",
                     label: {
                        formatter: "{b}: {@[" + dimension + "]} ({d}%)",
                     },
                     encode: {
                        value: dimension,
                        tooltip: dimension,
                     },
                  },
               });
            }
         });
         myChart.setOption(option);
      },

      change() {
         var chartDom = document.getElementById("main");
         var myChart = this.$echarts.init(chartDom, "dark");
         var option;
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
