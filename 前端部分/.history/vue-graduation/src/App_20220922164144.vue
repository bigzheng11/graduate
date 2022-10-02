<template>
   <div id="app">
      <router-view />
   </div>
</template>

<style>
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
      toIssue() {
         if (this.$route.path === "/shopping") {
            console.log("已经在购物页面,拒绝跳转");

            return;
         }
         console.log("跳转卖货页面");
         this.$router.push("/shopping");
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
</style>

<style>
* {
   margin: 0;
   padding: 0;
}
</style>
