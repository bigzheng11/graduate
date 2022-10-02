<template>
   <div id="video-list">
      <swiper :options="swiperOption">
         <!-- 幻灯内容 -->
         <!-- 循环输出 -->
         <swiper-slide v-for="(item, index) in recommendGoodList" :key="index">
            <div>
               <!-- ref：节点 -->
               <VideoItem
                  ref="videos"
                  :videoList="item"
                  :index="index"
                  style="border-radius: 30px; overflow: hidden"
               ></VideoItem>

               <div class="userName">@{{ userName }}</div>
               <div class="goodsDescribe">{{ goodsDescribe }}</div>
               <div class="userImg">
                  <img
                     :src="imgSrc"
                     alt=""
                     style="width: 55px; height: 55px; border-radius: 30px"
                  />
               </div>
               <div class="to">查看详情</div>
               <div class="Message">立即留言</div>
               <button
                  style="position: relative; top: -130px"
                  @click="toGoodsDetail(item)"
               >
                  查看详情
               </button>
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
import { set } from "vue";

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
         imgSrc: "",
         userName: "",
         goodsDescribe: "",

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
                  this.imgSrc =
                     this.recommendGoodList[this.page - 1].user.userImg;
                  this.userName =
                     this.recommendGoodList[this.page - 1].user.userName;
                  this.goodsDescribe =
                     this.recommendGoodList[this.page - 1].goodsDescribe;

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
                     console.log("向前拉");
                     this.imgSrc =
                        this.recommendGoodList[this.page - 1].user.userImg;
                     this.userName =
                        this.recommendGoodList[this.page - 1].user.userName;
                     this.goodsDescribe =
                        this.recommendGoodList[this.page - 1].goodsDescribe;
                  }
               },
            },
         },

         //数据源
         dataList: [
            // {
            //    url: require("../../assets/竖屏demo01.mp4"),
            // },
            // {
            //    url: require("../../assets/竖屏demo02.mp4"),
            // },
            // {
            //    url: require("../../assets/竖屏demo03.mp4"),
            // },
            // {
            //    url: require("../../assets/竖屏demo04.mp4"),
            // },
         ],

         user: "",
         recommendGoodList: [],
      };
   },

   methods: {
      //跳转商品详情页面
      toGoodsDetail(item) {
         // this.$router.push("/goodsdetail");
         this.$router.push({
            path: "/goodsdetail",
            query: {
               goodsDetail: item,
            },
         });
      },

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

   created() {
      //获取用户信息:
      this.user = this.$qs.parse(window.sessionStorage.getItem("userinfo"));
      console.log("进入index页面");

      //获取该用户下所有推荐的商品列表
      this.$axios
         .get("api/interest/topSixInterest/15518745323")
         .then((response) => {
            this.recommendGoodList = response.data;
            this.imgSrc = this.recommendGoodList[0].user.userImg;
            this.userName = this.recommendGoodList[0].user.userName;
            this.goodsDescribe = this.recommendGoodList[0].goodsDescribe;

            console.log(this.recommendGoodList);

            //将获取到的数据加入本地播放列表
            for (const item of this.recommendGoodList) {
               let objectTemp = {};
               objectTemp.goodsID = item.video.goodsID;
               objectTemp.url = item.video.video;
               this.dataList.push(objectTemp);
            }
            //加入Vuex中
            this.$store.dispatch(
               "RecommendGoodListActions",
               this.recommendGoodList
            );
         })
         .catch((error) => {
            console.log(error);
         });
   },

   mounted() {
      var div = document.querySelector("#video-list");
      div.addEventListener("mousedown", () => {
         console.log("sadas");
      });
   },
};
</script>
    <style scoped >
#video-list {
   height: 85vh;
}
#video-list .swiper-container {
   height: 100%;
}

/* 视频信息|操作 */
.userImg,
.Collect,
.userName,
.Message {
   width: 60px;
   height: 60px;
   position: absolute;
   z-index: 999;
}
.userImg {
   right: 20px;
   top: 40%;
}
.userName {
   left: 7%;
   top: 70%;
   color: white;
   font-size: 22px;
}
.goodsDescribe {
   width: 44%;
   height: 60px;
   position: absolute;
   z-index: 999;
   left: 7%;
   top: 75%;
   color: white;
   font-size: 20px;
}
</style>