<template>
   <div class="container">
      商品贩卖页面
      h

      <textarea name="" id="" cols="30" rows="10" placeholder="在此添加您的文字描述"></textarea>
      <Footer></Footer>
   </div>
</template>
 
 <script>
import Footer from "../components/Footer.vue";
export default {
   data() {
      return {};
   },

   created() {},

   methods: {},

   components: { Footer, Footer },
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