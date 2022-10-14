<template>
   <div class="container">
      <van-tabbar route>
         <van-tabbar-item
            replace
            to="/video"
            icon="home-o"
            :style="'background:' + footerColor"
            >首页</van-tabbar-item
         >
         <van-tabbar-item
            replace
            to="/sellingpage"
            icon="search"
            :style="'background:' + footerColor"
            >上架</van-tabbar-item
         >
         <van-tabbar-item
            id="three"
            replace
            to="/usercenter"
            icon="search"
            :style="'background:' + footerColor"
            >个人中心</van-tabbar-item
         >
      </van-tabbar>
   </div>
</template>

<script>
export default {
   data() {
      return {
         footerColor: this.$store.state.footerColor,
      };
   },

   created() {
      console.log("this.footerColor);
   },

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
   /* border: 1px solid red; */
}
</style>
