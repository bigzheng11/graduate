<template>
   <div class="container">
      这是用户中心页面
      <Footer></Footer>
   </div>
</template>
 
 <script>
import Footer from "../components/Footer.vue";
import "https://api.map.baidu.com/api?v=1.0&&type=webgl&ak=M5vGUgenF5VEYzsE1ftVdfSt7X3694zu";

export default {
   data() {
      return {};
   },

   created() {},

   methods: {},

   components: { Footer },
};
</script>
 
 <style scoped>
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