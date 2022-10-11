<template>
   <div class="container">
      <div class="block">
         <span class="demonstration">默认 click 触发子菜单</span>
         <el-cascader
            v-model="value"
            :options="options"
            @change="handleChange"
         ></el-cascader>
      </div>
      <div class="block">
         <span class="demonstration">hover 触发子菜单</span>
         <el-cascader
            v-model="value"
            :options="options"
            :props="{ expandTrigger: 'hover' }"
            @change="handleChange"
         ></el-cascader>
      </div>
   </div>
</template>

<script>
import axios from "axios";
export default {
   data() {
      return {
         value: [],
         options: [
            {
               value: "zhinan",
               label: "指南",
            },
            {
               value: "zujian",
               label: "组件",
            },
            {
               value: "ziyuan",
               label: "资源",
            },
            
         ],
      };
   },
   methods: {
      handleChange(value) {
         console.log(value);
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
