<template>
   <div class="container">
      <Back></Back>
      商品详情页
      <div class="userDetail">
         <div class="userPic">
            用户头像
            <img :src="this.$goodsDetail.user.userImg" alt="" style="width: 90px; height: 90px" />
         </div>
         用户名:{{ user.userName }}

         用户信息区域 用户地点
      </div>

      <div class="goodsDetail">
         <h2>商品名:{{ goodsDetail.goodsName }}</h2>
         <h2>描述:</h2>
         {{ goodsDetail.goodsDescribe }}
         <div><strong>分类</strong>:{{ goodsDetail.goodsID }}</div>
         <H4>图片</H4>
         <img
            :src="item.picture"
            alt=""
            v-for="(item, index) in goodsDetail.picList"
            :key="index"
            style="width: 100px; height: 100px"
         />

         <div style="border: 4px solid blue">价格|浏览量</div>
      </div>

      <div class="leaveMessage">留言区域</div>

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

      <div class="fixedBuy">
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
      </div>
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
      };
   },

   created() {
      console.log("=============传入的商品详情============", this.goodsDetail);
      //获取用户信息:
      this.user = this.$qs.parse(window.sessionStorage.getItem("userinfo"));
      // this.user = this.goodsDetail.user;
      console.log("=============登录用户信息============", this.user);

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
   },

   methods: {
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
/* 用户信息部分 */
.userDetail {
   width: 99vw;
   height: 20vh;
   border: 1px solid blue;
}
.userPic {
   width: 100px;
   height: 100px;
   border: 1px solid red;
   cursor: pointer;
}

/* 商品信息部分 */
.goodsDetail {
   width: 99vw;
   height: 60vh;
   border: 1px solid purple;
}

.leaveMessage {
   width: 99vw;
   height: 40vh;
   border: 1px solid red;
}

.fixedBuy {
   position: fixed;
   width: 99vw;
   height: 10vh;
   border: 1px solid black;
   bottom: 58px;
}
</style>


