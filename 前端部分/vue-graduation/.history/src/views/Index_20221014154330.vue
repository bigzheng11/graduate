<template>
   <div class="container">
      <div class="navTop">
         <router-link
            to="video"
            :style="
               'margin-left: 60px; color: white;' + 'fontSize:' + sizeVideo
            "
            >视频</router-link
         >
         <router-link
            to="recommend"
            :style="'color: white;' + 'fontSize:' + sizeRecommend"
            >总览</router-link
         >
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
         sizeVideo: "30px",
         sizeRecommend: "22px",
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
         if (r.path === "/video") {
            this.sizeRecommend = "22px";
            this.sizeVideo = "30px";
            console.log("index页面", r.path);
         }
         if (r.path === "/recommend") {
            this.sizeVideo = "22px";
            this.sizeRecommend = "30px";
            console.log("index页面", r.path);
         }
      },
   },
};
</script>

<style scoped>
.container {
   background-color: black;
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
