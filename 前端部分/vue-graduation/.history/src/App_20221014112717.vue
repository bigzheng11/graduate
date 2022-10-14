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
         footer_black: false,
      };
   },

   watch: {
      $route: function (r) {
         this.footer_show = r.path !== "/goodsdetail";
         this.footer_show = r.path !== "/v";
      },
   },

   components: { Footer },
};
</script>

<style>
* {
   margin: 0;
   padding: 0;
   font-family: "Hiragino Sans GB";
}
</style>
