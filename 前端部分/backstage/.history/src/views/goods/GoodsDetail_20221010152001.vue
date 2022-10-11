<!-- 用户管理组件 -->
<template>
   <div class="godd">单个商品详情页面</div>
</template>
   
   <script>
export default {
   data() {
      return { goodsID: this.$route.query.goodsID };
   },
   created() {
      console.log(goodsID);
   },
};
</script>
   
   
   <style>
</style>
   