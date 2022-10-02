<template>
   <div class="container">
      <div class="index" @click="toIndex">
         <i class="el-icon-mobile" style="font-size: 40px"></i>首页
      </div>
      <div class="Shopping" @click="toIssue">
         <i class="el-icon-circle-plus-outline" style="font-size: 40px"></i>商店
      </div>
      <div class="userCenter" @click="toUserCenter">
         <i class="el-icon-user" style="font-size: 40px"></i>中心
      </div>
   </div>
</template>

<script>
export default {
   data() {
      return {};
   },

   created() {},

   methods: {
      toIndex() {
         console.log("跳转到首页");
         this.$router.push("/");
      },
      toIssue() {
         console.log("跳转购物页面");
         this.$router.push("/shopping");
      },
      toUserCenter() {
         console.log("跳转到用户中心");
         this.$router.push("/usercenter");
      },
   },

   components: {},
};
</script>

<style scoped>
.container {
   width: 100%;
   height: 7%;
   border: 1px solid red;
   box-sizing: border-box;
   position: fixed;
   bottom: 0;
   display: flex;
   justify-content: space-around;
   align-items: center;
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
