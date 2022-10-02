<template>
   <div class="container">
      <video
         src="../../assets/【微信8.0_状态_竖屏】 Life goes on 鸭鸭 - 1.【微信8.0_状态_竖屏】 Life goes on 鸭鸭(Av598880332,P1).mp4"
         style="width: 99vw"
         autoplay
      ></video>
   </div>
</template>
 
 <script>
import { swiper, swiperSlide } from "vue-awesome-swiper"; //导入组件
export default {
   name: "videoList",
   components: {
      swiper, //定义组件
      swiperSlide,
   },
   data() {
      return {
         swiperOption: {
            direction: "vertical",
            grabCursor: true,
            setWrapperSize: true,
            autoHeight: true, //自动高度。设置为true时，wrapper和container会随着当前slide的高度而发生变化
            slidesPerView: 1,
            mousewheel: true,
            mousewheelControl: true,
            height: window.innerHeight, // 高度设置，占满设备高度
            resistanceRatio: 0,
            observeParents: true,
         },
      };
   },
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