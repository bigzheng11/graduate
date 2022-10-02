<template>
   <div id="video-list">
      <swiper :options="swiperOption">
         <!-- 幻灯内容 -->
         <swiper-slide>
            <video-player
               class="video-player vjs-custom-skin"
               ref="videoPlayer"
               :playsinline="true"
               :options="playerOptions"
               @pause="onPlayerPause($event)"
            ></video-player>
         </swiper-slide>
         <swiper-slide>slide2</swiper-slide>
         <swiper-slide>slide3</swiper-slide>
         <swiper-slide>slide4</swiper-slide>
      </swiper>
   </div>
</template>
    <script>
import { swiper, swiperSlide } from "vue-awesome-swiper"; //导入组件
import { videoPlayer } from "vue-video-player";
export default {
   name: "videoList",
   components: {
      swiper, //定义组件
      swiperSlide,
      videoPlayer,
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

         //  播放器的配置
         playerOptions: {
            // playbackRates: [0.7, 1.0, 1.5, 2.0], //播放速度
            autoplay: false, //如果true,浏览器准备好时开始回放。
            muted: false, // 默认情况下将会消除任何音频。
            loop: true, // 视频一结束就重新开始。
            preload: "auto",
            autoplay: true, //自动播放
            fluid: true, // 当true时，Video.js player将拥有流体大小。换句话说，它将按比例缩放以适应其容器。
            sources: [
               {
                  src: require("../../assets/竖屏demo01.mp4"), // 路径
                  type: "video/mp4", // 类型
               },
            ],
            //poster: "../../static/images/test.jpg", //你的封面地址
            width: document.documentElement.clientWidth,
            notSupportedMessage: "此视频暂无法播放，请稍后再试", //允许覆盖Video.js无法播放媒体源时显示的默认信息。
            controlBar: false,
         },
      };
   },

   meth
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