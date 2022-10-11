<template>
   <div id="app">
      index页面===================================

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
import DataHeader from "./components/index/DataHeader.vue";
import SideNav from "./components/index/SideNav.vue";
import Nothing from "./components/index/Nothing.vue";
import Nothing from "";
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
</script>

<style scoped>
#app {
   height: 100%;
   margin: 0;
   display: flex;
   flex-flow: column;
}
.app_header {
   position: relative;
   flex: 0 0 auto;
   z-index: 2;
}
.app_header .title {
   margin-left: 16px;
   color: #fff;
}
.app_content {
   flex: 1;
   display: flex;
   flex-flow: row;
}
.app_nav {
   position: relative;
   flex: 0 0 280px;
   background: #eff2f7;
}
.app_right {
   flex: 1;
   overflow: auto;
   padding: 20px;
}
.breadcrumb {
   padding-bottom: 20px;
   border-bottom: 1px solid #ddd;
}
</style>;
