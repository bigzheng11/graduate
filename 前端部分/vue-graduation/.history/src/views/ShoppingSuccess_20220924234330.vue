<template>
   <div class="container">
      <h1>上传成功</h1>
      <h1>稍后调换回首页</h1>
   </div>
</template>
  
  <script>
export default {
   data() {
      return {};
   },
   
   created() {},

   methods: {},

   mounted() {
      console.log("跳转回首页");
      setTimeout(() => {
         this.$router.push("/video");
      }, 1200);
   },
};
</script>
  
  <style scoped>
.container {
   width: 100%;
   height: 100%;
   overflow: auto;
   border: 1px solid palegreen;
   box-sizing: border-box;
}
</style>
 