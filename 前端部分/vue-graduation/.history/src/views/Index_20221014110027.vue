<template>
   <div class="container">

      <div class="navTop">

      </div>
      < @click="toSelectPage">๐็นๅปๆ็ดข</>
      <h1>
         <router-link to="video">่ง้ข้จๅ</router-link>

         | <router-link to="recommend">็ๅธๆจ่้จๅ</router-link>
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
