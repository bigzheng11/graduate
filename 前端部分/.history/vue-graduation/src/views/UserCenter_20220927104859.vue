<template>
   <div>
      <h1>用户信息展示</h1>
      头像:??? 用户名: 
      <div style="border:red ">

         地址(点击):
      </div>
      <hr />
      <h2>更新用户信息</h2>
      <div>
         新用户名:
         <input type="text" />
      </div>
      <div>
         新密码:
         <input type="text" />
      </div>
      <button >确认修改</button>

      <hr />
      <h2 @click="toAddress">用户地址|修改地址</h2>
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
      return {};
   },
   methods: {
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