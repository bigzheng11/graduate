<!-- 用户管理组件 -->
<template>
   <div class="goodsDetail">
    goods
   </div>
</template>
   
   <script>
export default {
   data() {
      return { goodsID: this.$route.query.goodsID };
   },
   created() {
      console.log("接收到的goodsID为", this.goodsID);
   },
};
</script>
   
   
   <style>
</style>
   