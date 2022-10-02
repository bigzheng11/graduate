<template>
   <div class="container">
      <h1>商品贩卖页面</h1>

      <textarea
         name=""
         id=""
         cols="50"
         rows="20"
         placeholder="在此添加您的文字描述"
         style="margin-left: 15px"
      ></textarea>
      <br />
      <br />

      <hr />

      <br />
      <br />

      <h1>上传图片位置</h1>

      <van-uploader
         v-model="fileList"
         multiple
         :max-count="5"
         @oversize="onOversize"
      />

      <van-button type="info">确定上传</van-button>

      <Footer></Footer>
   </div>
</template>
 
 <script>
import Footer from "../components/Footer.vue";
export default {
   data() {
      return {
         fileList: [],
      };
   },

   created() {},

   methods: {
      afterRead(file) {
         console.log(file);
      },

      onOversize(file) {
         console.log(file);
         Toast("文件大小不能超过 500kb");
      },
   },

   components: { Footer, Footer },
};
</script>
 
 <style scoped>
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