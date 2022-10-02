<template>
    <div class="container">
       <h1>首页部分</h1>
    </div>
 </template>
  
  <script>
    //页面引入swiper
import 'swiper/dist/css/swiper.css'
import { swiper, swiperSlide } from 'vue-awesome-swiper'
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