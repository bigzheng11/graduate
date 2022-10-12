<template>
   <div class="container">
      <div
         class="block"
         style="
            width: 400px;
            height: 500px;
            border: 1px solid blue;
            overflow: scroll;
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
      </div>
   </div>
</template>

<script>
import axios from "axios";
export default {
   data() {
      return {};
   },
   methods: {},
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
