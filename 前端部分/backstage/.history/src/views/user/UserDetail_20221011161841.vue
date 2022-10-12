<!-- 用户管理组件 -->
<template>
   <div>
      <h1>商品略图</h1>
      <div class="echart" id="mychart" :style="myChartStyle"></div>
   </div>
</template>

<script>
import * as echarts from "echarts";
export default {
   data() {
      return {
         xData: ["芒果", "鱼肉", "波罗蜜", "柚子", "橙子", "Sat", "Sun"], //横坐标
         yData: [23, 24, 18, 25, 27, 28, 25], //数据
         myChartStyle: { float: "left", width: "1000px", height: "400px" }, //图表样式




         
         goodsList: [],
      };
   },
   created() {
      // 获取所有商品信息
      this.$axios
         .get("/api/goods/backstageselectall")
         .then((response) => {
            this.goodsList = response.data;
            console.log(response.data);
         })
         .catch((error) => {
            console.log(error);
         });
   },

   mounted() {
      this.initEcharts();
   },

   methods: {
      initEcharts() {
         // 基本柱状图
         const option = {
            xAxis: {
               data: this.xData,
            },
            yAxis: {},
            series: [
               {
                  type: "bar", //形状为柱状图
                  data: this.yData,
               },
            ],
         };

         const myChart = echarts.init(document.getElementById("mychart"));
         myChart.setOption(option);
         //随着屏幕大小调节图表
         // window.addEventListener("resize", () => {
         //    myChart.resize();
         // });
      },
   },
};
</script>


<style>
</style>
<!-- 
goodsClassify:[
{id:1,name:"芒果"},
{id:2,name:"鱼肉"},
{id:3,name:"波罗蜜"},
{id:4,name:"柚子"},
{id:5,name:"橙子"},
{id:6,name:"猕猴桃"},
{id:7,name:"苹果"},
{id:8,name:"草莓"},
{id:9,name:"卷心菜"},
{id:10,name:"西红柿"},
{id:11,name:"黄瓜"},
{id:12,name:"大白菜"},
{id:13,name:"西兰花"},
{id:14,name:"萝卜"},
{id:15,name:"生菜"},
{id:16,name:"金针菇"},
{id:17,name:"大葱"},
{id:18,name:"韭菜"},
{id:19,name:"南瓜"},
{id:20,name:"空心菜"},

] -->
