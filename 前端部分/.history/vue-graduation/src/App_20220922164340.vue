<template>
   <div id="app">
      <router-view />
      <footer></footer>
   </div>
</template>
<script>
import Footer from "./"
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
