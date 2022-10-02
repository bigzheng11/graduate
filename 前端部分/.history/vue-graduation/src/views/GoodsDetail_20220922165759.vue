<template>
   <div class="container">
      商品详情页
      <div class="userDetail">用户头像,信息区域</div>

      <div class="goodsDetail">
         <div>价格|浏览量</div>
         <div>商品文字信息,图片</div>
      </div>

      <div class="leaveMessage">留言区域</div>

      <!-- 回到顶部按钮 -->
      <van-icon name="back-top" style="position: fixed; z"/>

      <div class="fixedBuy">收藏|留言(跳转留言区域)|购买</div>
   </div>
</template>

<script>
export default {
   data() {
      return {};
   },

   created() {},

   methods: {},

   components: {},
};
</script>

<style scoped></style>

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
