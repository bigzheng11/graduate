<template>
    <div class="container">
      和
 
       <Footer></Footer>
    </div>
 </template>
 
 <script>
 import Footer from "../components/Footer.vue";
 export default {
    data() {
       return {};
    },
 
    created() {},
 
    methods: {},
 
    components: { Footer },
 };
 </script>
 
 <style scoped>
 .main {
    border: 1px solid red;
    width: 100vw;
    height: 70vh;
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