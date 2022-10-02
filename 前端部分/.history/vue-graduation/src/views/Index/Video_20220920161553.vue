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
import "swiper/css/swiper.css";
//导入播放组件,子组件
import Videos from "../../components/Index/Videos";
import { swiper, swiperSlide } from "vue-awesome-swiper"; //导入组件
export default {
   name: "videoList",
   components: {
      swiper, //定义组件
      swiperSlide,
   },
   data() {
      return {
         showComment: false,
         page: 1,
         swiperOption: {
            //垂直方向滑动
            direction: "vertical",
            grabCursor: true,
            setWrapperSize: true,
            autoHeight: true, //自动高度。设置为true时，wrapper和container会随着当前slide的高度而发生变化
            slidesPerView: 1,
            mousewheel: true,
            mousewheelControl: true,
            // 高度设置，占满设备高度
            height: window.innerHeight,
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
         dataList: [
            {
               id: "1",
               url: "http://video.jishiyoo.com/3720932b9b474f51a4cf79f245325118/913d4790b8f046bfa1c9a966cd75099f-8ef4af9b34003bd0bc0261cda372521f-ld.mp4",
            },
            {
               id: "2",
               url: "http://video.jishiyoo.com/1eedc49bba7b4eaebe000e3721149807/d5ab221b92c74af8976bd3c1473bfbe2-4518fe288016ee98c8783733da0e2da4-ld.mp4",
            },
            {
               id: "3",
               url: "http://video.jishiyoo.com/549ed372c9d14b029bfb0512ba879055/8e2dc540573d496cb0942273c4a4c78c-15844fe70971f715c01d57c0c6595f45-ld.mp4",
            },
            {
               id: "4",
               url: "http://video.jishiyoo.com/161b9562c780479c95bbdec1a9fbebcc/8d63913b46634b069e13188b03073c09-d25c062412ee3c4a0758b1c48fc8c642-ld.mp4",
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