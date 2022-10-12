<template>
   <div class="container">
      <div style="width: 100px; height: 100px"></div>
      <div
         class="block"
         style="
            width: 400px;
            height: 500px;
            border: 1px solid blue;
            overflow: scroll;
            position: relative;
         "
      >
         <span class="testSpan"> 测试内容</span>
         <span class="testSpan"> 测试内容</span>
         <span class="testSpan"> 测试内容</span>
         <span class="testSpan"> 测试内容</span>
         <span class="testSpan"> 测试内容</span>
         <span class="testSpan"> 测试内容</span>
         <span class="testSpan"> 测试内容</span>
         <span class="testSpan"> 测试内容</span>
         <span class="testSpan"> 测试内容</span>
         <span class="testSpan"> 测试内容</span>
         <span class="testSpan"> 测试内容</span>
         <span class="testSpan"> 测试内容</span>
         <span class="testSpan"> 测试内容</span>
         <span class="testSpan"> 测试内容</span>
         <span class="testSpan"> 测试内容</span>
         <span class="testSpan"> 测试内容</span>
         <span class="testSpan"> 测试内容</span>
         <span class="testSpan"> 测试内容</span>
         <span class="testSpan"> 测试内容</span>
         <span class="testSpan"> 测试内容</span>
         <span class="testSpan"> 测试内容</span>
         <span class="testSpan"> 测试内容</span>
         <span class="testSpan"> 测试内容</span>
         <span class="testSpan"> 测试内容</span>
         <span class="testSpan"> 测试内容</span>
         <span class="testSpan"> 测试内容</span>
         <span class="testSpan"> 测试内容</span>
         <span class="testSpan"> 测试内容</span>
         <span class="testSpan"> 测试内容</span>
         <span class="testSpan"> 测试内容</span>
         <span class="testSpan"> 测试内容</span>
         <span class="testSpan"> 测试内容</span>
         <span class="testSpan"> 测试内容</span>
         <span class="testSpan"> 测试内容</span>
         <span class="testSpan"> 测试内容</span>
         <span class="testSpan"> 测试内容</span>
         <span class="testSpan"> 测试内容</span>
         <span class="testSpan"> 测试内容</span>
      </div>
   </div>
</template>

<script>
import axios from "axios";
export default {
   data() {
      return {
         timer01:"",
         timer02:""
      };
   },
   methods: {},
   mounted() {
      // const divHeZi = document.querySelectorAll(".testSpan")[0];
      const divHeZi = document.querySelectorAll(".block")[0];
      console.log(divHeZi);

      //获取元素的纵坐标(相对于窗口)

      function getTop(e) {
         var offset = e.offsetTop;
         if (e.offsetParent != null) offset += getTop(e.offsetParent);
         return offset;
      }

      console.log(document.querySelectorAll(".testSpan")[15]);
      divHeZi.addEventListener("scroll", function (e) {
         //TODOconsole.log("scrollTop", divHeZi.scrollTop);//滚动条到顶部的距离
         const divHeZi2 = document.querySelectorAll(".testSpan")[15];
         divHeZi2.style.border = "4px solid blue";

         let top = divHeZi2.getBoundingClientRect().top;

         if (top > 200 && top < 400) {
            console.log("进入「高能」可视区域", top);
         }
         if (top > 400 && top < 472) {
            console.log("进入「低能」可视区域", top);
            this.timer01 = Date.now();
         }

         // 进入低能区添加计时器
         if (top > 400 && top < ) {
            console.log("进入「低能」可视区域", top);
            this.timer01 = Date.now();
         }

      });
   },
};
</script>

<style scoped>
.testSpan {
   width: 100px;
   height: 100px;
   border: 1px solid red;
   display: inline-block;
}
</style>

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

<!-- 

  信息列表
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

]


  -->
