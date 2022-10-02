<template>
   <div class="container">
      <Back></Back>

      <van-nav-bar
         title="标题"
         left-text="返回"
         right-text="按钮"
         left-arrow
         @click-left="onClickLeft"
         @click-right="onClickRight"
      />

      <div>手机号:<input type="text" v-model="userID" /></div>
      <div>密码:<input type="text" v-model="password" /></div>
      <div>
         用户名:
         <input type="text" v-model="userName" />
      </div>
      <div>性别:男|女</div>
      <input type="radio" name="radios" value="1" v-model="userSex" checked />男
      <input type="radio" name="radios" value="0" v-model="userSex" />女

      <button @click="registerAxios">确认注册</button>
   </div>
</template>
 
 <script>
import Back from "../components/Back.vue";
export default {
   data() {
      return {
         userID: "",
         password: "",
         userName: "",
         userSex: 1,
      };
   },

   created() {},

   methods: {
      //头部栏方法
      onClickLeft() {
         this.$router
      },
      onClickRight() {
         Toast("按钮");
      },

      //注册方法
      registerAxios() {
         this.$axios
            .post(
               "api/user/save",
               this.$qs.stringify({
                  userID: this.userID,
                  password: this.password,
                  userName: this.userName,
                  userSex: this.userSex,
               })
            )
            .then((response) => {
               if (response.data.code) {
                  alert("注册成功");
               }
            })
            .catch((error) => {
               console.log(error);
            });
      },
   },

   components: { Back },
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
 