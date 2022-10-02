<template>
   <div class="container">
      <h1>购买商品页面</h1>
      <van-popup
         v-model="show"
         round
         position="bottom"
         :style="{ height: '30%' }"
      />

      <van-button type="primary" @click="show=!">确认购买</van-button>
   </div>
</template>

<script>
export default {
   data() {
      return { show: false };
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
