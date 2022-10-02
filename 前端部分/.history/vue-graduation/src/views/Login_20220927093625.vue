<template>
   <div class="container">
      <h1>登录</h1>

      <!-- <div>手机号:<input type="text" /></div> -->
      <!-- 输入手机号，调起手机号键盘 -->
      <van-field v-model="user.userID" type="tel" label="手机号" />
      <!-- <div>密码:<input type="text" /></div> -->
      <!-- 输入密码 -->
      <van-field v-model="user.password" type="password" label="密码" />
      <button @click="toLogin">登录</button>
      <button @click="toRegister">注册</button>
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
         console.log(this.tel);
         console.log(this.password);
         this.$axios
            .post("api/user/login", this.$qs.stringify(this.user))
            .then((response) => {
               let userinfo = response.data.userinfo;

               //将用户信息存入session
               this.$setSessionStorage("userinfo", userinfo);
               # 商业转载请联系作者获得授权，非商业转载请注明出处。
# For commercial use, please contact the author for authorization. For non-commercial use, please indicate the source.
# 协议(License)：署名-非商业性使用-相同方式共享 4.0 国际 (CC BY-NC-SA 4.0)
# 作者(Author)：王正
# 链接(URL)：http://101.43.132.60/index.php/2022/04/29/web-storage-%e5%ad%98%e5%82%a8/
# 来源(Source)：Big正のBlog

sessionStorage.setltem(key, value)
               console.log(userinfo);
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
