<template>
    <div class="container">
      
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
 