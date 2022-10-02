<template>
   <div class="container">
      <!-- <div class="index" @click="toIndex">
         <i class="el-icon-mobile" style="font-size: 40px"></i>首页
      </div>
      <div class="SellingPage" @click="toSellingPage">
         <i class="el-icon-circle-plus-outline" style="font-size: 40px"></i> 卖
      </div>
      <div class="userCenter" @click="toUserCenter">
         <i class="el-icon-user" style="font-size: 40px"></i>中心
      </div> -->

      <van-tabbar route>
         <van-tabbar-item replace to="/inde" icon="home-o"
            >标签</van-tabbar-item
         >
         <van-tabbar-item replace to="/search" icon="search"
            >标签</van-tabbar-item
         >
      </van-tabbar>
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
         if (
            this.$route.path === "/" ||
            this.$route.path === "/video" ||
            this.$route.path === "/recommend"
         ) {
            console.log("已经在首页,拒绝跳转");
            return;
         }
         console.log("跳转到首页");
         this.$router.push("/");
      },
      toSellingPage() {
         if (this.$route.path === "/sellingpage") {
            console.log("已经在销售页面,拒绝跳转");
            return;
         }
         console.log("跳转卖货页面");
         this.$router.push("/sellingpage");
      },
      toUserCenter() {
         if (this.$route.path === "/usercenter") {
            console.log("已经在用户中心页面,拒绝跳转");
            return;
         }
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
