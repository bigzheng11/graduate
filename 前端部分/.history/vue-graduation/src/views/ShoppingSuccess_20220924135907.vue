<template>
    <div class="container">
      
    </div>
 </template>
  
  <script>
 export default {
    data() {
       return {
         
       };
    },
 
    created() {},
 
    methods: {
       
    },
 
    components: { Footer },
 };
 </script>
  
  <style scoped>
 .container {
    width: 100%;
    height: 100%;
    overflow: auto;
    border: 1px solid palegreen;
    box-sizing: border-box;
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