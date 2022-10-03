<template>
   <div class="container">
      <!-- <Back></Back> -->
      <!-- 顶部栏 -->
      <div id="div_box_nav">
         <van-nav-bar
            title="商品详情"
            left-text="返回"
            left-arrow
            @click-left="onClickLeft"
            style="height: 54px"
         />
      </div>

      <!-- 用户信息 -->
      <div class="userDetail" style="margin: 5px; padding: 6px">
         <!-- <div class="userPic"> -->
         <img
            :src="goodsDetail.user.userImg"
            style="width: 70px; height: 70px; border-radius: 100%"
         />
         <!-- </div> -->
         <span
            style="
               vertical-align: top;
               position: relative;
               left: 40px;
               top: 10px;
            "
            ><strong>{{ goodsDetail.user.userName }}</strong></span
         >
         <span style="position: relative; left: -34px; top: -10px">
            发布于: {{ addressDefault }}
         </span>
      </div>

      <!-- 商品详情 -->
      <div class="goodsDetail">
         <h2>{{ goodsDetail.goodsName }}</h2>
         <span style="position: absolute; left: 70%; color: red">
            ￥<span style="font-size: 30px">{{ goodsDetail.price }}</span>
         </span>
         <h2>描述:</h2>
         {{ goodsDetail.goodsDescribe }}
         <div><strong>分类</strong>:{{ goodsDetail.goodsID }}</div>
         <img
            :src="item.picture"
            alt=""
            v-for="(item, index) in goodsDetail.picList"
            :key="index"
            style="width: 90%; border-radius: 10px"
         />
      </div>

      <div class="leaveMessage">
         <div v-for="item in messageList" :key="item.messageID">
            <div style="position: relative; width: 89vw; height: 8vh">
               <!-- 用户头像 -->
               <img
                  :src="item.user.userImg"
                  alt=""
                  style="
                     height: 50px;
                     width: 50px;
                     border-radius: 100%;
                     position: absolute;
                     left: 2%;
                     top: 5%;
                  "
               />
               <!-- 用户名 -->
               <span
                  style="
                  position: absolute;
                  left: 22%;
                  top:5%
                  font-size: 17px;
                  font-weight: 600;
                  color: #a3a3a3;
               "
                  >{{ item.user.userName }}</span
               >
               <!-- 留言内容 -->
               <span style="position: absolute; left: 22%; top: 42%">
                  {{ item.message }}
               </span>
               <!-- 点赞 -->
               <span
                  @click="addfavour()"
                  style="
                     position: absolute;
                     right: 6%;
                     top: 12%;
                     font-size: 25px;
                     border-radius: 100%;
                     border: 1px solid grey;
                     width: 30px;
                     height: 30px;
                     text-align: center;
                     line-height: 33px;
                  "
               >
                  <van-icon name="like-o" />
                  <p style="font-size: 15px; margin-top: -7px">
                     {{ item.favour }}
                  </p>
               </span>
            </div>
            <!-- -----------子评论---------------- -->
            <div
               v-for="itemTwo in item.childList"
               :key="itemTwo.messageID"
               style="position: relative; width: 80vw; height: 7vh; left: 4vh"
            >
               <!-- 用户头像 -->
               <img
                  :src="itemTwo.user.userImg"
                  alt=""
                  style="
                     height: 40px;
                     width: 40px;
                     border-radius: 100%;
                     position: absolute;
                     left: 2%;
                     top: 5%;
                  "
               />
               <!-- 用户名 -->
               <span
                  style="
                  position: absolute;
                  left: 22%;
                  top:5%
                  font-size: 17px;
                  font-weight: 600;
                  color: #a3a3a3;
               "
                  >{{ itemTwo.user.userName }}</span
               >
               <!-- 留言内容 -->
               <span style="position: absolute; left: 22%; top: 42%">
                  {{ itemTwo.message }}
               </span>
               <!-- 点赞 -->
               <span
                  style="
                     position: absolute;
                     right: 6%;
                     top: 12%;
                     font-size: 25px;
                     border-radius: 100%;
                     border: 1px solid grey;
                     width: 30px;
                     height: 30px;
                     text-align: center;
                     line-height: 33px;
                  "
               >
                  <van-icon name="like-o" />
                  <p style="font-size: 15px; margin-top: -7px">
                     {{ itemTwo.favour }}
                  </p>
               </span>
            </div>
         </div>
      </div>

      <!-- 回到顶部按钮 -->
      <van-icon
         name="back-top"
         style="
            position: fixed;
            z-index: 999;
            right: 20px;
            bottom: 170px;
            font-size: 40px;
         "
      />

      <!-- <div class="fixedBuy">
         <br />
         收藏<van-icon
            :name="isCollect ? 'star' : 'star-o'"
            style="cursor: pointer"
            @click="changeIsCollect"
         />&nbsp;|&nbsp;留言(跳转留言区域)&nbsp;<van-icon
            name="comment-o"
         />&nbsp;|购买&nbsp;<van-button type="info" @click="toBuyPage"
            >购买</van-button
         >
      </div> -->
   </div>
</template>
<!-- 
   本人进入此页面:
   显示「下架」按钮

 -->
<script>
import Back from "../components/Back.vue";
export default {
   data() {
      return {
         goodsDetail: this.$route.query.goodsDetail,
         user: {},
         //收藏
         collectList: [],
         isCollect: false,
         addressDefault: "",
         //留言
         messageList: [],
         
      };
   },

   created() {
      console.log("=============传入的商品详情============", this.goodsDetail);

      //留言列表遍历
      for (const item of this.goodsDetail.messagesList) {
         console.log("开始遍历");
         if (item.toMessageID === null) {
            this.messageList.push(item);
            let childList = [];
            for (const item2 of this.goodsDetail.messagesList) {
               if (item2.parentTop === item.messageID) {
                  childList.push(item2);
               }
            }
            this.messageList[this.messageList.length - 1].childList = childList;
         }
      }
      console.log("遍历之后的留言表", this.messageList);

      //获取用户信息:
      this.user = this.$qs.parse(window.sessionStorage.getItem("userinfo"));
      // this.user = this.goodsDetail.user;
      console.log("=============登录用户信息==== =======", this.user);

      //获取该用户下所有收藏
      this.$axios
         .get("api/collect/getall/" + this.user.userID)
         .then((response) => {
            this.collectList = response.data.data.collectList;
            for (const item of this.collectList) {
               if (item.goodsID == this.goodsDetail.goodsID) {
                  this.isCollect = true;
               }
            }
         })
         .catch((error) => {
            console.log(error);
         });

      //获取卖家地址
      // addressDefault;
      this.$axios
         .get("api/address/getall/" + this.goodsDetail.userID)
         .then((response) => {
            console.log(
               "=======商家地址========",
               response.data.data.addressList
            );
            for (const item of response.data.data.addressList) {
               if (item.isDefault === 1) {
                  console.log(item.isDefault);
                  this.addressDefault = item.address;
               }
            }
         })
         .catch((error) => {
            console.log(error);
         });
   },

   methods: {
      //点赞方法
      addfavour(messageID) {
         // this.$axios
         //    .get("api/collect/getall/" + this.user.userID)
         //    .then((response) => {
         //       console.log(response);
         //    })
         //    .catch((error) => {
         //       console.log(error);
         //    });
      },
      //头部栏方法
      onClickLeft() {
         this.$router.go(-1);
      },
      // onClickRight() {
      //    Toast("按钮");
      // },

      //修改收藏状态
      changeIsCollect() {
         if (this.isCollect) {
            //原先为true,现在修改为false
            this.$axios
               .post(
                  "api/collect/changeiscollect",
                  this.$qs.stringify({
                     userID: this.user.userID,
                     goodsID: this.goodsDetail.goodsID,
                     isCollect: !this.isCollect ? "1" : "0",
                  })
               )
               .then((response) => {
                  console.log("=========iscollect=============", response.data);
               })
               .catch((error) => {
                  console.log(error);
               });
         }
         this.isCollect = !this.isCollect;
      },
      //页面跳转
      toBuyPage() {
         console.log("跳转到购物页面");
         this.$router.push("/buypage");
      },
   },

   components: { Back },
};
</script>

<style scoped>
.container {
   background-color: grey;
}

/* 用户信息部分 */
.userDetail {
   width: 94vw;
   border-radius: 13px;
   background-color: white;
}

/* 商品信息部分 */
.goodsDetail {
   width: 89vw;
   border-radius: 13px;
   background-color: white;
   margin: 5px;
   padding: 15px;
}

.leaveMessage {
   width: 89vw;
   border-radius: 13px;
   background-color: white;
   margin: 5px;
   padding: 15px;
}

.fixedBuy {
   position: fixed;
   width: 99vw;
   height: 10vh;
   border: 1px solid black;
   bottom: 58px;
}

/* 导航栏样式 */
::v-deep .van-nav-bar__title {
   font-size: 25px;
   font-family: 楷体;
   font-weight: 800;
}

::v-deep .van-nav-bar__text {
   font-size: 20px;
   font-family: 楷体;
   font-weight: 800;
}
</style>


