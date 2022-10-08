<template>
   <div class="container">
      测试页面
      <hr />
      <div style="width: 100vw; height: 100vh" ref="chart"></div>
   </div>
</template>

<script>
export default {
   mounted() {
   
   },
   
   
};
</script>

<style scoped></style>

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
