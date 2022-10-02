<template>
   <div class="container">首页</div>
   <footer
</template>

<script>
    import Footer from '../components/Footer.vue';
export default {
   data() {
      return {};
   },

   created() {
   },

   methods: {},

   components: {Footer},
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