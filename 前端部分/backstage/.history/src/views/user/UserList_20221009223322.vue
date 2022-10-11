<!-- 用户管理组件 -->
<template>
   <div class="userList">
      用户管理页面
      <el-tabs :active-name="activeName">
         <el-tab-pane label="方案测试" name="first"> 方案测试</el-tab-pane>
         <el-tab-pane label="用户测试" name="second"> </el-tab-pane>
      </el-tabs>
   </div>
</template>


<script>
import Nothing from "../../components/../components/index/Nothing.vue";
export default {
   data() {
      return {};
   },
   components: {
      Nothing,
   },
};
</script>


<style>
</style>
