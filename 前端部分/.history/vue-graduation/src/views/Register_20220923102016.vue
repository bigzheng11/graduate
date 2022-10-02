<template>
   <div class="container">
      <h1>注册</h1>

      <div>手机号:<input type="text" /></div>
      <div>密码:<input type="text" /></div>
      <div>确认密码:<input type="text" /></div>
      <div>
        性别:男|女
      </div>
      <button>确认注册</button>
   </div>
</template>
 
 <script>
export default {
   data() {
      return {};
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
 