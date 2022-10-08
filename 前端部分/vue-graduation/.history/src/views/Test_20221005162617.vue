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
      var myChart = thisecharts.init(chartDom, "dark");
      var option;

      setTimeout(function () {
         option = {
            legend: {},
            tooltip: {
               trigger: "axis",
               showContent: false,
            },
            dataset: {
               source: [
                  ["product", "2012", "2013", "2014", "2015", "2016", "2017"],
                  ["Milk Tea", 56.5, 82.1, 88.7, 70.1, 53.4, 85.1],
                  ["Matcha Latte", 51.1, 51.4, 55.1, 53.3, 73.8, 68.7],
                  ["Cheese Cocoa", 40.1, 62.2, 69.5, 36.4, 45.2, 32.5],
                  ["Walnut Brownie", 25.2, 37.1, 41.2, 18, 33.9, 49.1],
               ],
            },
            xAxis: { type: "category" },
            yAxis: { gridIndex: 0 },
            grid: { top: "55%" },
            series: [
               {
                  type: "line",
                  smooth: true,
                  seriesLayoutBy: "row",
                  emphasis: { focus: "series" },
               },
               {
                  type: "line",
                  smooth: true,
                  seriesLayoutBy: "row",
                  emphasis: { focus: "series" },
               },
               {
                  type: "line",
                  smooth: true,
                  seriesLayoutBy: "row",
                  emphasis: { focus: "series" },
               },
               {
                  type: "line",
                  smooth: true,
                  seriesLayoutBy: "row",
                  emphasis: { focus: "series" },
               },
               {
                  type: "pie",
                  id: "pie",
                  radius: "30%",
                  center: ["50%", "25%"],
                  emphasis: {
                     focus: "self",
                  },
                  label: {
                     formatter: "{b}: {@2012} ({d}%)",
                  },
                  encode: {
                     itemName: "product",
                     value: "2012",
                     tooltip: "2012",
                  },
               },
            ],
         };
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
      });

      option && myChart.setOption(option);
   },
   methods: {
      change() {},
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
