<template>
   <div class="Container">
      index页面

      <div class="app_header">
         <data-header></data-header>
      </div>
      <div class="app_content">
         <div class="app_nav">
            <side-nav></side-nav>
         </div>
         <div class="app_right">
            <div class="breadcrumb">
               <el-breadcrumb separator="/">
                  <el-breadcrumb-item :to="{ path: '/' }"
                     >首页</el-breadcrumb-item
                  >
                  <el-breadcrumb-item>{{ pathName }}</el-breadcrumb-item>
               </el-breadcrumb>
            </div>
            <router-view></router-view>
         </div>
      </div>
   </div>
</template>
 
 <script>
import DataHeader from "./components/common/DataHeader.vue";
import SideNav from "./components/common/SideNav.vue";
import Nothing from "./components/common/Nothing.vue";
export default {
   data() {
      return {};
   },

   methods: {},

   created() {},

   mounted() {},

   components: {
      components: {
         DataHeader,
         SideNav,
         Nothing,
      },
   },

   watch: {},
};
<style scoped>
</style>;
