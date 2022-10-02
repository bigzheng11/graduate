<template>
   <div class="container">
      <div>首页-----------------------------🔍di'a'ni</div>
      
      <h1>
         <router-link to="video">视频部分</router-link>

         | <router-link to="recommend">瀑布推荐部分</router-link>
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
      return {};
   },

   created() {},

   mounted() {
     
   },

   methods: {},

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

     axios
   .get("https://autumnfish.cn/api/joke/list?num=3") //获得三个笑话
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