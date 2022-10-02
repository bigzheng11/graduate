<template>
   <div class="container">
      <Back></Back>

      <h1>注册</h1>

      <div>手机号:<input type="text" v-model="phone" /></div>
      <div>密码:<input type="text" v-model="password" /></div>
      <div>
         用户名:
         i
      </div>
      <div>性别:男|女</div>
      <input type="radio" name="radios" value="1" v-model="sex" checked />男
      <input type="radio" name="radios" value="0" v-model="sex" />女

      <button @click="registerAxios">确认注册</button>
   </div>
</template>
 
 <script>
import Back from "../components/Back.vue";
export default {
   data() {
      return {
         phone: "",
         password: "",
         sex: 1,
      };
   },

   created() {
   },

   methods: {
      registerAxios(){
         this.$axios
            .post("api/user/save", this.$qs.stringify(this.user))
            .then((response) => {
               

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
 