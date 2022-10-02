<template>
   <div class="container">
      <h1>登录</h1>

      <div>手机号:<input type="text" /></div>
    <!-- 输入任意文本 -->
<van-field v-model="text" label="文本" />
      <div>密码:<input type="text" /></div>
      <button>登录</button>
      <button @click="toRegister">注册</button>
   </div>
</template>

<script>
export default {
   data() {
      return {};
   },

   created() {},

   methods: {
      toRegister() {
         this.$router.push("/register");
      },
   },

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
