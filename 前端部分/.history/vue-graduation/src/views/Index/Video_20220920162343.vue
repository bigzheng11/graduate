<template>
   <div id="video-list">
      <swiper :options="swiperOption">
         <!-- 幻灯内容 -->
         <swiper-slide>slide1</swiper-slide>
         <swiper-slide>slide2</swiper-slide>
         <swiper-slide>slide3</swiper-slide>
         <swiper-slide>slide4</swiper-slide>
      </swiper>
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
#video-list {
   height: 100%;
}
#video-list .swiper-container {
   height: 100%;
}
</style>