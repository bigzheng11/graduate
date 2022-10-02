<template>
   <div class="container">
      <div class="top">

         <img
         src="../assets/noName.png"
         alt=""
         style="width: 100px; height: 100px"
         />
         <h1>欢迎来到蔬荐</h1>
      </div>

      <!-- <div>手机号:<input type="text" /></div> -->
      <!-- 输入手机号，调起手机号键盘 -->
      <van-field v-model="user.userID" type="tel" label="手机号" />
      <!-- <div>密码:<input type="text" /></div> -->
      <!-- 输入密码 -->
      <van-field v-model="user.password" type="password" label="密码" />
      <van-button type="info" @click="toLogin">登录</van-button>
      <van-button plain type="info" @click="toRegister">注册</van-button>
   </div>
</template>

<script>
export default {
   data() {
      return {
         user: {
            userID: "",
            password: "",
         },
      };
   },

   created() {},

   methods: {
      //登录方法
      toLogin() {
         this.$axios
            .post("api/user/login", this.$qs.stringify(this.user))
            .then((response) => {
               if (response.data.code == 1) {
                  let userinfo = response.data.data.userinfo;
                  console.log(userinfo);
                  //将用户信息存入session
                  window.sessionStorage.setItem(
                     "userinfo",
                     this.$qs.stringify(userinfo)
                  );
                  alert("登录成功");
               }
            })
            .catch((error) => {
               console.log(error);
            });
      },

      //跳转到注册页面
      toRegister() {
         this.$router.push("/register");
      },
   },

   components: {},
};
</script>

<style scoped>
.container {
   background-color: #f5f6fa;
   width: 100vw;
   height: 93vh;
   font-family: 楷体;
}

</style>

<!-- 
rgb(229, 211, 215);
rgb(0, 49, 83);
font-family: 楷体;
 -->
