<template>
   <div id="app">
      <router-view />
      <Footer></Footer>
   </div>
</template>
<script>
import Footer from "./components/Footer.vue";
export default {
   data() {
      return {
         footer_show: true,
      };
   },

   watch: {
      $route: function (r) {
         console.log();
         this.footer_show = r.path !== "goodsdetail";
      },
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
