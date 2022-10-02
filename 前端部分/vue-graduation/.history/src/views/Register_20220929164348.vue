<template>
   <div class="container">
      <!-- <Back></Back> -->

      <!-- 顶部栏 -->
      <div id="div_box_nav">
         <van-nav-bar
            title="注册"
            left-text="返回"
            left-arrow
            @click-left="onClickLeft"
            style="height: 50px; font-size: 90px"
         />
      </div>

      <!-- 新输入框 -->
      <van-form @submit="registerAxios" style="margin-top: 30px">
         <van-field
            @blur="checkUserID"
            required
            :error-message="errMsg.checkUserID"
            v-model="userID"
            name="手机号"
            label="手机号"
            placeholder="请输入手机号"
            :rules="[{ required: true, message: '请填写手机号' }]"
         />
         <van-field
            v-model="userName"
            type="userName"
            name="用户名"
            label="用户名"
            placeholder="请输入用户名"
            :rules="[{ required: true, message: '请输入用户名' }]"
         />

         <van-field
            v-model="password"
            type="password"
            name="密码"
            label="密码"
            placeholder="密码"
            :rules="[{ required: true, message: '请填写密码' }]"
         />

         <van-radio-group
            v-model="userSex"
            direction="horizontal"
            style="margin: 30px"
         >
            <van-radio name="1" shape="square" icon-size="24px">男</van-radio>
            <van-radio name="0" shape="square" icon-size="24px">女</van-radio>
         </van-radio-group>

         <div style="margin: 56px">
            <van-button round block type="info" native-type="submit"
               >提交</van-button
            >
         </div>
      </van-form>

      <!-- <div>手机号:<input type="text" v-model="userID" /></div>
      <div>密码:<input type="text" v-model="password" /></div>
      <div>
         用户名:
         <input type="text" v-model="userName" />
      </div>
      <div>性别:男|女</div>
      <input type="radio" name="radios" value="1" v-model="userSex" checked />男
      <input type="radio" name="radios" value="0" v-model="userSex" />女 -->

      <!-- <button @click="registerAxios">确认注册</button> -->
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
         //检查
         errMsg: {
            checkUserID: "",
         },
      };
   },

   created() {},

   methods: {
      //检查方法
      checkUserID() {
         this.errMsg.checkUserID = "";
         if (this.userID.length != 11) {
            this.errMsg.checkUserID = "手机号长度不正确";
         }
      },

      //表单方法
      onSubmit(values) {
         console.log("submit", values);
      },

      //头部栏方法
      onClickLeft() {
         this.$router.push("/login");
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
 
 <style scoped>
::v-deep .van-nav-bar__title {
    font-size: 20px;
    font-family: 楷体;
    font-weight: 3;
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
 