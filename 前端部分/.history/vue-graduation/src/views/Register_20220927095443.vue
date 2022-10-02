<template>
   <div class="container">
      <Back></Back>

      <h1>注册</h1>

      <div>手机号:<input type="text" v-model="phone" /></div>
      <div>密码:<input type="text" v-model="phone" /></div>
      <!-- <div>确认密码:<input type="text" /></div> -->
      <div>性别:男|女</div>
      <audio src="">nan</audio>
      <button>确认注册</button>
   </div>
</template>
 
 <script>
import Back from "../components/Back.vue";
export default {
   data() {
      return {
         phone:'',
      };
   },

   created() {},

   methods: {},

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
 