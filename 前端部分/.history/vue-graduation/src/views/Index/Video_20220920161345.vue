<template>
   <div class="container">
      <swiper :options="swiperOption">
         <!-- 幻灯内容 -->
         <!-- 循环输出 -->
         <swiper-slide v-for="(item, index) in dataList" :key="index">
            <div>
               <!-- ref：节点 -->
               <videos ref="videos" :videoList="item" :index="index"></videos>
            </div>
            <div class="infobar-warp">
               <info-bar></info-bar>
            </div>
            <div class="right-warp">
               <!-- 接收RightBar.vue穿过来的方法 -->
               <right-bar @changeCom="showCom"></right-bar>
            </div>
         </swiper-slide>
         <!-- <swiper-slide>slide2</swiper-slide> 
      <swiper-slide>slide1</swiper-slide>    
      <swiper-slide>slide2</swiper-slide>  -->
      </swiper>
   </div>
</template>
 
 <script>
    //导入swiper组件'
import { Swiper, SwiperSlide } from "vue-awesome-swiper";
import "swiper/css/swiper.css";
//导入播放组件,子组件
import Videos from "../../components/index/Videos";
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

         // 视频配置项
         playerOptions: {
            autoplay: false, //如果true,浏览器准备好时开始回放。
            muted: false, // 默认情况下将会消除任何音频。
            loop: false, // 导致视频一结束就重新开始。
            preload: "auto",
            fluid: true, // 当true时，Video.js player将拥有流体大小。换句话说，它将按比例缩放以适应其容器。
            sources: [
               {
                  src: require("../../assets/竖屏测试 - 1.竖屏测试(Av381376274,P1).mp4"), // 路径
                  type: "video/mp4", // 类型
               },
            ],
            width: document.documentElement.clientWidth,
            notSupportedMessage: "此视频暂无法播放，请稍后再试", //允许覆盖Video.js无法播放媒体源时显示的默认信息。
            controlBar: false,
         },
      };
   },
   components: {
      //注册swiper组件
      Swiper,
      SwiperSlide,
      Videos,
   },
};
</script>
 
 <style scoped>
#container {
   height: 100%;
}
#container .swiper-container {
   height: 100%;
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