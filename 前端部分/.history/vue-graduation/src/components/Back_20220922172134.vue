<template>
   <div class="container">
      <van-icon name="arrow-left" />
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
   width: 30px;
   height: 30px;
   position: fixed;
   top: 30px;
   left: 20px;
   border: 1px solid;
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
 