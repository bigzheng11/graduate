<template>
   <div id="app">
      <router-view />
      <Footer v-show="$route.path==="""></Footer>
   </div>
</template>
<script>
import Footer from "./components/Footer.vue";
export default {
   components: { Footer },
};
</script>

<style>
* {
   margin: 0;
   padding: 0;
}
</style>
