<template>
   <div class="container">
      <h1>登录</h1>

      <!-- <div>手机号:<input type="text" /></div> -->
      <!-- 输入手机号，调起手机号键盘 -->
      <van-field v-model="tel" type="tel" label="手机号" />
      <!-- <div>密码:<input type="text" /></div> -->
      <!-- 输入密码 -->
      <van-field v-model="password" type="password" label="密码" />
      <button @click="toLogin">登录</button>
      <button @click="toRegister">注册</button>
   </div>
</template>

<script>
export default {
   data() {
      return {
         tel: "",
         password: "",
      };
   },

   created() {},

   methods: {
    //登录方法
    toLogin(){},
    //跳转到注册页面
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
