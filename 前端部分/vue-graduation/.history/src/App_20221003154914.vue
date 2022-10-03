<template>
   <div id="app">
      <router-view />
      <Footer v-if="!$route.path === '/goodsdetail'"></Footer>
   </div>
</template>
<script>
import func from 'vue-editor-bridge';
import Footer from "./components/Footer.vue";
export default {
   data() {
      return {
         footer_show: true,
      };
   },

   watch:{
      $route:function(r){
         this.
      }
   },
   
   components: { Footer },
};
</script>

<style>
* {
   margin: 0;
   padding: 0;
}
</style>
