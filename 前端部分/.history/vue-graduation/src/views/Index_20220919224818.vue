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

axios.get('/user?ID=12345')
  .then(function (response) {
    console.log(response);
  })
  .catch(function (error) {
    console.log(error);
  })
  .then(function () {
  });
 -->