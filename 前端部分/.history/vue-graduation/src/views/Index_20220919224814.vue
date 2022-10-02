<template>
   <div class="container"></div>
</template>

<script>
export default {
   data() {
      return {};
   },

   created() {
    this.$axios.get()
   },

   methods: {},

   components: {},
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

 // 向给定ID的用户发起请求
axios.get('/user?ID=12345')
  .then(function (response) {
    // 处理成功情况
    console.log(response);
  })
  .catch(function (error) {
    // 处理错误情况
    console.log(error);
  })
  .then(function () {
    // 总是会执行
  });
 -->