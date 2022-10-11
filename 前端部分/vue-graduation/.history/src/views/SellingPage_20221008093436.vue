<template>
   <div class="container">
      <h1>商品贩卖页面</h1>

      <van-field
         v-model="message"
         rows="1"
         autosize
         label="留言"
         type="textarea"
         placeholder="请输入留言"
      />

     
      <h1>上传图片位置</h1>
      <!-- 上传文件 -->
      <van-uploader
         v-model="fileList"
         multiple
         :max-count="5"
         :max-size="5000 * 1024"
         @oversize="onOversize"
      />
      <van-button plain type="info" @click="toShoppingSuccess"
         >确认上架</van-button
      >
      <!-- <h2>请选择分类:苹果|香蕉|蔬菜|黄瓜</h2> -->

      <!-- 类型选择 -->
      <van-field
         readonly
         clickable
         label="分类"
         :value="value"
         placeholder="选择商品分类"
         @click="showPicker = true"
      />
      <van-popup v-model="showPicker" round position="bottom">
         <van-picker
            show-toolbar
            :columns="columns"
            @cancel="showPicker = false"
            @confirm="onConfirm"
         />
      </van-popup>
   </div>
</template>
 <!-- 
需求:
   若当前「有」描述和图片,跳转前提示会被清除
 -->
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

         //商品种类的选择
         value: "",
         showPicker: false,
         columns: ["苹果", "香蕉", "芒果", "菠萝", "大米", "黄瓜"],
      };
   },

   created() {},

   methods: {
      //商品种类选择方法
      onConfirm(value) {
         this.value = value;
         this.showPicker = false;
      },

      //跳转到卖货成功页面
      toShoppingSuccess() {
         this.$router.push("/shoppingsuccess");
      },
      //上传后的钩子函数
      afterRead(file) {
         console.log(file);
         axios
            .post("http://localhost:8081/upload", file) //获得三个笑话
            .then(function (response) {
               console.log(response);
            });
      },

      //文件过大,触发钩子函数
      onOversize(file) {
         console.log("文件超过大小,过大文件已经捕获");
         console.log(file);
         this.$axios
            .post("http://localhost:8081/upload", file) //获得三个笑话
            .then(function (response) {
               console.log(response);
            });
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