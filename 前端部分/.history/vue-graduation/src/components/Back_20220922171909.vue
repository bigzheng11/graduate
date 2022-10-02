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
 