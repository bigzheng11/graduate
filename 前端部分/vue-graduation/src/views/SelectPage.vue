<template>
    <div>
       <h1>搜索页面</h1>
       点击搜索<input type="text">
    </div>
 </template>
 
 <script>
 export default {
    name: "demo",
    data() {
       return {};
    },
    methods: {
       toAddress() {
          this.$router.push("/address");
       },
    },
 };
 </script>
 
 <style scoped>
 h2 {
    cursor: pointer;
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