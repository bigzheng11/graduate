<template>
   <div class="container">
      <div>ι¦ι‘΅-----------------------------πε²ε</div>
      
      <h1>
         <router-link to="video">θ§ι’ι¨ε</router-link>

         | <router-link to="recommend">ηεΈζ¨θι¨ε</router-link>
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
   .get("https://autumnfish.cn/api/joke/list?num=3") //θ·εΎδΈδΈͺη¬θ―
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