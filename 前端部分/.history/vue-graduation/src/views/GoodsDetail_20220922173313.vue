<template>
   <div class="container">
      <Back></Back>
      商品详情页
      <div class="userDetail">用户头像,信息区域</div>

      <div class="goodsDetail">
         <div>价格|浏览量</div>
         <div>商品文字信息,图片</div>
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
        <br>
         收藏 &nbsp;<van-icon name="star-o" />&nbsp;|留言(跳转留言区域)&nbsp;<van-icon name="comment-o" />&nbsp;|购买&nbsp;<van-button type="info" @click="toBuyPage">购买</van-button>&nbsp;购买&nbsp;</van-button>
      </div>
   </div>
</template>

<script>
import Back from "../components/Back.vue";
export default {
   data() {
      return {};
   },

   created() {},

   methods: {
    toBuyPage(){
      console.log("跳转到购物页面");
    }
   },

   components: { Back },
};
</script>

<style scoped>
.userDetail {
   width: 99vw;
   height: 20vh;
   border: 1px solid blue;
}

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
