<template>
   <div class="container">
      <div>é¦é¡µ</div>
      <div @click="toSelectPage">ðç¹å»æç´¢</div>

      <h1>
         <router-link to="video">è§é¢é¨å</router-link>

         | <router-link to="recommend">çå¸æ¨èé¨å</router-link>
      </h1>

      <div class="main">
         <router-view></router-view>
      </div>

      <!-- <Footer></Footer> -->
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

   created() {
      //è·åç¨æ·ä¿¡æ¯:
      this.user = this.$qs.parse(window.sessionStorage.getItem("userinfo"));
      console.log("è¿å¥indexé¡µé¢");

      //è·åè¯¥ç¨æ·ä¸æææ¨èçåååè¡¨
      this.$axios
         .get("api/interest/topSixInterest/15518745323")
         .then((response) => {
            this.recommendGoodList = response.data;
            console.log(this.recommendGoodList);

            this.$store.dispatch(
               "RecommendGoodListActions",
               this.recommendGoodList
            );
         })
         .catch((error) => {
            console.log(error);
         });
   },

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
.main {
   border: 1px solid blue;
   width: 100vw;
   height: 83vh;
   box-sizing: border-box;
}
</style>

<!-- 
axios:

     this.$axios
   .get("https://autumnfish.cn/api/joke/list?num=3") //è·å¾ä¸ä¸ªç¬è¯
   .then(function (response) {
   console.log(response);
 });

axios.get('url')
  .then(function (response) {
    console.log(response);
  })
  .catch(function (error) {
    console.log(error);
  })
  .then(function () {
  });
 -->