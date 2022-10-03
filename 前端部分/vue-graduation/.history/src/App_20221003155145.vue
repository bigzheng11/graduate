<template>
   <div id="app">
      <router-view />
      <Footer v-if="footer_show"></Footer>
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
         console.log(r);

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
