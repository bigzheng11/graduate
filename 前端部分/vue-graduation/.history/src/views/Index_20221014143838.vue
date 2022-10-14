<template>
   <div class="container">
      <div class="navTop">
         <router-link to="video" style="margin-left: 60px; color: black"
            >视频</router-link
         >
         <router-link to="recommend" style="color: black">总览</router-link>
         <p @click="toSelectPage"><i class="el-icon-search"></i></p>
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

   watch: {
      $route: function (r) {
         console.log("路由", r);
      },
   },
};
</script>

<style scoped>
.container {
   background-color: white;
   padding-top: 20px;
}
.main {
   width: 100vw;
   height: 86vh;
   box-sizing: border-box;
}
.navTop {
   display: flex;
   justify-content: space-evenly;
   align-items: center;
   font-size: 25px;
   margin-bottom: 20px;
}
</style>
