<template>
   <div class="container">
      <div @click="toSelectPage">πηΉε»ζη΄’</div>
      <!-- gitζ΅θ― -->
      <h1>
         <router-link to="video">θ§ι’ι¨ε</router-link>

         | <router-link to="recommend">ηεΈζ¨θι¨ε</router-link>
      </h1>

      <div class="main">
         <router-view></router-view>
      </div>
   </div>
</template>

<script>
import Footer from "../components/Footer.vue";
export default {
   data() {
      return {
         user: "",
         recommendGoodList: [],
      };
   },

   created() {},

   mounted() {},

   methods: {
      toSelectPage() {
         this.$router.push("/selectpage");
      },
   },

   components: { Footer },
};
</script>

<style scoped>
.container {
   background-color: grey;
}
.main {
   border: 1px solid blue;
   width: 100vw;
   height: 86vh;
   box-sizing: border-box;
}
</style>
