<template>
   <div id="video-list">
      <Swiper :options="swiperOption">
         <!-- 幻灯内容 -->
         <!-- 循环输出 -->
         <Swiper-slide v-for="(item, index) in recommendGoodList" :key="index">
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
               <div class="toDetail" @click="toGoodsDetail(item)">
                  <van-icon name="arrow" />
               </div>
               <div class="Message"><van-icon name="chat-o" /></div>
            </div>

            <!-- <div class="infobar-warp">
               <info-bar></info-bar>
            </div> -->

            <!-- 接收RightBar.vue穿过来的方法 -->
            <!-- <div class="right-warp">
               <right-bar @changeCom="showCom"></right-bar>
            </div> -->
         </Swiper-slide>
      </Swiper>
   </div>
</template>
    <script>
import { Swiper, SwiperSlide } from "vue-awesome-swiper"; //导入组件
import { videoPlayer } from "vue-video-player";
import VideoItem from "../../components/VideoItem.vue";
// import { set } from "vue";

export default {
   name: "videoList",
   components: {
      Swiper, //定义组件
      SwiperSlide,
      videoPlayer,
      VideoItem,
   },

   data() {
      return {
         //获取登录用户信息
         user: "",

         recommendGoodList: [],

         imgSrc: "",
         userName: "",
         goodsDescribe: "",

         //计时器
         timer01: 0,
         timer02: 0,
         stayTime: 0,

         //视频数据源
         dataList: [],

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
                  // 点击触发
                  this.playAction(this.page - 1);
               },
               //向上拉触发↓
               //详见：https://www.swiper.com.cn/api/event/290.html
               slidePrevTransitionStart: () => {
                  if (this.page > 1) {
                     //计时01:
                     this.timer01 = Date.now();
                     console.log("===========timer01=========", this.timer01);
                     //计算停留时常
                     this.stayTime = (this.timer01 - this.timer02) / 100;

                     this.updateAxios(
                        this.recommendGoodList[this.page - 1].goodsClassify,
                        Math.round(this.stayTime)
                     );

                     console.log(
                        "===========停留时长=========",
                        this.stayTime,
                        "秒"
                     );
                     console.log(
                        "上一个商品goodsID",
                        this.recommendGoodList[this.page - 1].goodsID
                     );
                     console.log(
                        "上一个商品分类",
                        this.recommendGoodList[this.page - 1].goodsClassify
                     );
                     console.log(
                        "上一个商品名",
                        this.recommendGoodList[this.page - 1].goodsName
                     );

                     //计时02:
                     this.timer02 = this.timer01;

                     console.log("向前拉");
                     this.page -= 1;
                     this.preVideo(this.page - 1);
                     console.log(this.page);
                     this.imgSrc =
                        this.recommendGoodList[this.page - 1].user.userImg;
                     this.userName =
                        this.recommendGoodList[this.page - 1].user.userName;
                     this.goodsDescribe =
                        this.recommendGoodList[this.page - 1].goodsDescribe;
                  }
               },
               //向下拉触发↓
               slideNextTransitionStart: () => {
                  //计时01:
                  this.timer01 = Date.now();
                  console.log("===========timer01=========", this.timer01);
                  //计算停留时常
                  this.stayTime = (this.timer01 - this.timer02) / 100;

                  this.updateAxios(
                     this.recommendGoodList[this.page - 1].goodsClassify,
                     Math.round(this.stayTime)
                  );
                  console.log(
                     "===========停留时长=========",
                     this.stayTime,
                     "秒"
                  );
                  console.log(
                     "上一个商品goodsID",
                     this.recommendGoodList[this.page - 1].goodsID
                  );

                  console.log(
                     "上一个商品分类",
                     this.recommendGoodList[this.page - 1].goodsClassify
                  );
                  console.log(
                     "上一个商品名",
                     this.recommendGoodList[this.page - 1].goodsName
                  );

                  //计时02:
                  this.timer02 = this.timer01;

                  console.log("向下拉");
                  this.page += 1;
                  this.nextVideo(this.page - 1);
                  console.log(this.page);
                  this.imgSrc =
                     this.recommendGoodList[this.page - 1].user.userImg;
                  this.userName =
                     this.recommendGoodList[this.page - 1].user.userName;
                  this.goodsDescribe =
                     this.recommendGoodList[this.page - 1].goodsDescribe;
               },
            },
         },
      };
   },

   methods: {
      //更新用户喜好
      updateAxios(goodsClassify, grade) {
         this.$axios
            .post(
               "api/interest/update",
               this.$qs.stringify({
                  userID: this.user.userID,
                  goodsClassify: goodsClassify,
                  grade: grade,
               })
            )
            .then((response) => {
               console.log(response);
            })
            .catch((error) => {
               console.log(error);
            });
      },

      //跳转商品详情页面
      toGoodsDetail(item) {
         // window.sessionStorage.setItem("nowGoodItem", this.$qs.stringify(item));
         // this.$store.dispatch("nowGoodItemActions", item);
         // this.$router.push("/goodsdetail");
         this.$router.push({
            path: "/goodsdetail",
            query: {
               goods: item,
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
         .get("api/interest/topSixInterest/" + this.user.userID)
         .then((response) => {
            this.recommendGoodList = response.data;
            this.imgSrc = this.recommendGoodList[0].user.userImg;
            this.userName = this.recommendGoodList[0].user.userName;
            this.goodsDescribe = this.recommendGoodList[0].goodsDescribe;

            console.log(
               "=====获取该用户下所有推荐的商品列表======",
               this.recommendGoodList
            );

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
      this.timer02 = Date.now();
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
   background-color: black;
}
#video-list .swiper-container {
   height: 100%;
}

/* 视频信息|操作 */
.userImg,
.toDetail,
.Message {
   width: 60px;
   height: 60px;
   position: absolute;
   z-index: 999;
}
.userImg {
   right: 20px;
   top: 40%;
   cursor: pointer;
}
.userName {
   width: 160px;
   height: 60px;
   position: absolute;
   z-index: 999;
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
.toDetail {
   right: 18px;
   top: 50%;
   font-size: 56px;
   color: white;
   cursor: pointer;
}

.Message {
   right: 12px;
   top: 60%;
   font-size: 40px;
   color: white;
   cursor: pointer;
}
</style>