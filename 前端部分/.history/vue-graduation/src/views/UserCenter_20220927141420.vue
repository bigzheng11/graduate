<template>
   <div>
      <h1>用户信息展示</h1>
      头像
      <img :src="user.userImg" alt="" />

      用户名:{{ user.userName }}
      <div style="border: red solid 1px; cursor: pointer" @click="toAddress">
         地址(点击修改):{{ addressDefault.address }}
      </div>
      <hr />
      <h2>更新用户信息</h2>
      <div>
         新用户名:
         <input type="text" v-model="newData.userName" />
      </div>

      <div>
         新密码:
         <input type="text" v-model="newData.password" />
      </div>

      <button @click="updataAxios">确认修改</button>

      <hr />
      <h2>我的售卖</h2>
      <hr />
      <h2>我的收藏</h2>
      <hr />
      <h2>我的历史订单</h2>
   </div>
</template>

<script>
import Footer from "../components/Footer.vue";
export default {
   name: "demo",
   data() {
      return {
         user: "",
         addressList: [],
         addressDefault: {},
         newData: {
            userName: "",
            password: "",
         },
      };
   },

   created() {
      //获取用户信息:
      this.user = this.$qs.parse(window.sessionStorage.getItem("userinfo"));

      //请求用户地址:
      this.$axios
         .get("api/address/getall/" + this.user.userID)
         .then((response) => {
            this.addressList = response.data.data.addressList;
            for (const iterator of this.addressList) {
               if (iterator.isDefault === 1) {
                  this.addressDefault = iterator;
               }
            }
         })
         .catch((error) => {
            console.log(error);
         });

      //用户历史订单:

      //用户售卖历史:

      //用户收藏:
   },

   methods: {
      //更新用户信息
      updataAxios() {
         this.$axios
            .post("api/user/update", this.$qs.stringify(this.newData))
            .then((response) => {
               console.log("更新用户信息",response.data);
            })
            .catch((error) => {
               console.log(error);
            });
      },
      //跳转修改地址
      toAddress() {
         this.$router.push("/address");
      },
   },

   components: { Footer },
};
</script>

<style scoped>
h2 {
   cursor: pointer;
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