<template>
   <div id="video-list">
      <swiper :options="swiperOption">
         <!-- 幻灯内容 -->
         <!-- 循环输出 -->
         <swiper-slide v-for="(item, index) in dataList" :key="index">
            <div>
               <!-- ref：节点 -->
               <VideoItem
                  ref="videos"
                  :videoList="item"
                  :index="index"
               ></VideoItem>
            </div>

            <!-- <div class="infobar-warp">
               <info-bar></info-bar>
            </div> -->

            <!-- 接收RightBar.vue穿过来的方法 -->
            <!-- <div class="right-warp">
               <right-bar @changeCom="showCom"></right-bar>
            </div> -->
         </swiper-slide>
      </swiper>
   </div>
</template>
    <script>
import { swiper, swiperSlide } from "vue-awesome-swiper"; //导入组件
import { videoPlayer } from "vue-video-player";
import VideoItem from "../../components/VideoItem.vue";

export default {
   name: "videoList",
   components: {
      swiper, //定义组件
      swiperSlide,
      videoPlayer,
      VideoItem,
   },

   data() {
      return {
         showComment: false,
         page: 1,
         swiperOption: {
            //循环
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

            on: {
               //详见：https://www.swiper.com.cn/api/event/226.html
               tap: () => {
                  // console.log('1111');
                  this.playAction(this.page - 1);
               },
               //上滑
               //详见：https://www.swiper.com.cn/api/event/290.html
               slideNextTransitionStart: () => {
                  // alert('开始切换');
                  this.page += 1;
                  this.nextVideo(this.page - 1);
                  console.log(this.page);
                  console.log("已经向后添加数据拉");
                  this.dataList.push({
                     id: "5",
                     url: require("../../assets/竖屏demo01.mp4"),
                  });
               },
               slidePrevTransitionStart: () => {
                  if (this.page > 1) {
                     this.page -= 1;
                     this.preVideo(this.page - 1);
                     console.log(this.page);
                  }
               },
            },
         },

         //数据源
         dataList: [
            {
               id: "1",
               url: require("../../assets/竖屏demo01.mp4"),
            },
            {
               id: "2",
               url: require("../../assets/竖屏demo02.mp4"),
            },
            {
               id: "3",
               url: require("../../assets/竖屏demo03.mp4"),
            },
            {
               id: "4",
               url: require("../../assets/竖屏demo04.mp4"),
            },
         ],
      };
   },

   methods: {
      playAction(index) {
         this.$refs.videos[index].playOrStop();
      },
      //上滑
      nextVideo(index) {
         //通过DOM元素来获取子组件的方法
         //上一个视频停止
         this.$refs.videos[index - 1].stop();
         //下一个视频开始
         this.$refs.videos[index].play();
      },
      //下滑
      preVideo(index) {
         this.$refs.videos[index + 1].stop();
         this.$refs.videos[index].play();
      },
      //弹出评论
      showCom() {
         this.showComment = true;
      },
      close() {
         this.showComment = false;
      },
   },

   mounted() {
      var div = document.querySelector("#video-list");
      console.log(div);
      div.addEventListener("mousedown", () => {
         console.log("sadas");
      });
      div.mousedown = function () {
         console.log("div");
      };
   },
};
</script>
    <style scoped>
#video-list {
   height: 80vh;
}
#video-list .swiper-container {
   height: 100%;
}
</style>