<template>
    <div class="container">
      <h1>视频页面</h1>
      <video src=".."></video>
    </div>
 </template>
 
 <script>
 export default {
    data() {
       return {};
    },
 
    created() {},
 
    methods: {},
 
 };
 </script>
 
 <style scoped>

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