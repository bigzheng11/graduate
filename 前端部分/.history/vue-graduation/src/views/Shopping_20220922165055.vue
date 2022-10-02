<template>
   <div class="container">
      <h1>商品贩卖页面</h1>

      <textarea
         name=""
         id=""
         cols="40"
         rows="20"
         placeholder="在此添加您的文字描述"
         style="margin-left: 15px"
      ></textarea>
      <h1>上传图片位置</h1>
      <!-- 上传文件 -->
      <van-uploader
         v-model="fileList"
         multiple
         :max-count="5"
         :max-size="5000 * 1024"
         @oversize="onOversize"
      />
      <van-button plain type="info">que'r</van-button>

      <!-- <Footer></Footer> -->
   </div>
</template>
 
 <script>
import Footer from "../components/Footer.vue";
import { Toast } from "vant";
export default {
   data() {
      return {
         fileList: [
            {
               url: "https://img01.yzcdn.cn/vant/sand.jpg",
               deletable: true,
               beforeDelete: () => {
                  Toast("图片已经删除");
                  return true;
               },
            },
            {
               url: "https://img01.yzcdn.cn/vant/tree.jpg",
               deletable: true,
               imageFit: "cover",
               previewSize: 120,
            },
         ],
      };
   },

   created() {},

   methods: {
      //上传成功后的钩子函数
      afterRead(file) {
         console.log(file);
      },

      //文件过大,触发钩子函数
      onOversize(file) {
         console.log("文件超过大小,过大文件已经捕获");
         console.log(file);
         // Toast("文件大小不能超过 500kb");
         alert("不能超过5000kb");
      },
   },

   components: { Footer },
};
</script>
 
 <style scoped>
.container {
   width: 100%;
   height: 100%;
   overflow: auto;
   border: 1px solid palegreen;
   box-sizing: border-box;
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