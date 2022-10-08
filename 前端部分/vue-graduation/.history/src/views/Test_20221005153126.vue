<template>
   <div class="container">
      测试页面
      <hr />
      <div
         style="width: 700px; height: 700px; border: 1px solid red"
         id="main"
      ></div>
   </div>
</template>

<script>
export default {
   data() {
      return {
         option: {
            title: {
               text: "Referer of a Website",
               subtext: "Fake Data",
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
                  name: "Access From",
                  type: "pie",
                  radius: "50%",
                  data: [
                     { value: 1048, name: "Search Engine" },
                     { value: 735, name: "Direct" },
                     { value: 580, name: "Email" },
                     { value: 484, name: "Union Ads" },
                     { value: 300, name: "Video Ads" },
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
         },
      };
   },
   mounted() {
      var chartDom = document.getElementById("main");
      var myChart = this.$echarts.init(chartDom);

      option && myChart.setOption(this.option);
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
