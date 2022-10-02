<template>
   <div class="container" @click="toBack">
      <van-icon name="arrow-left" />
   </div>
</template>
 
 <script>
export default {
   data() {
      return {};
   },

   created() {},

   methods: {
    toBack(){
        this.$router.go(-1)
    }
   },

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
   font-size: 25px;
   cursor: pointer;
   border-radius: 6px;
   border: 1px solid white;
   box-shadow: 2.8px 2.8px 2.2px rgba(0, 0, 0, 0.02),
      6.7px 6.7px 5.3px rgba(0, 0, 0, 0.028),
      12.5px 12.5px 10px rgba(0, 0, 0, 0.035),
      22.3px 22.3px 17.9px rgba(0, 0, 0, 0.042),
      41.8px 41.8px 33.4px rgba(0, 0, 0, 0.05),
      100px 100px 80px rgba(0, 0, 0, 0.07);
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
 