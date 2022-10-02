<template>
   <div class="container">
      <div class="index"><i class="el-icon-mobile" style="font-size"></i></div>
      <div class="Shopping"><i class="el-icon-goods"></i></div>
      <div class="userCenter"><i class="el-icon-user"></i></div>
   </div>
</template>

<script>
export default {
   data() {
      return {};
   },

   created() {},

   methods: {},

   components: {},
};
</script>

<style scoped>
.container {
   width: 100%;
   height: 10%;
   border: 1px solid red;
   box-sizing: border-box;
   position: fixed;
   bottom: 0;
   display: flex;
   justify-content: space-around;
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
