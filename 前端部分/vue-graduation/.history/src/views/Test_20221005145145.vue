<template>
   <div class="container">
      测试页面
      <hr />
      <div style="width: 100vw; height: 100vh" ref="chart"></div>
   </div>
</template>

<script>
export default {
   mounted() {
      this.initCharts();
   },
   methods: {
      initCharts() {
         let myChart = this.$echarts.init(this.$refs.chart);
         myChart.setOption({
            title: {
               text: "目标文件类型图",
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
                  name: "访问来源",
                  type: "pie",
                  radius: "50%",
                  data: [
                     {
                        value: 1048,
                        name: "军事目标",
                        itemStyle: {
                           color: "#ee6666",
                        },
                     },
                     {
                        value: 735,
                        name: "工业目标",
                        itemStyle: {
                           color: "#91cc75",
                        },
                     },
                     {
                        value: 580,
                        name: "交通目标",
                        itemStyle: {
                           color: "#fac858",
                        },
                     },
                     {
                        value: 484,
                        name: "城市目标",
                        itemStyle: {
                           color: "#2455a4",
                        },
                     },
                     {
                        value: 300,
                        name: "其它",
                        itemStyle: {
                           color: "#73c0de",
                        },
                     },
                  ],
                  emphasis: {
                     itemStyle: {
                        shadowBlur: 10,
                        shadowOffsetX: 0,
                        shadowColor: "rgba(0, 0, 0, 0.5)",
                     },
                  },
               },
            ],
         });
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
