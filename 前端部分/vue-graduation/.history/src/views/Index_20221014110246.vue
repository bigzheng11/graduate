<template>
   <div class="container">
      <div class="navTop">
         <router-link to="video">视频部分</router-link>

         <router-link to="recommend">瀑布推荐部分</router-link>
         <p @click="toSelectPage">🔍</p>
      </div>
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
.navTop {
   background-color: black;
}
</style>
