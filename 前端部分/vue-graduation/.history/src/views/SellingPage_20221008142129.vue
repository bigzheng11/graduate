<template>
   <div class="container">
      <h1>商品贩卖页面</h1>

      <div>
         商品名:<el-input
            v-model="goods.goodsName"
            placeholder="请输入内容"
         ></el-input>
      </div>

      <div>
         商品描述:
         <el-input
            type="textarea"
            :rows="2"
            placeholder="请输入内容"
            v-model="goods.goodsDescribe"
         >
         </el-input>
      </div>

      <div>
         商品分类:
         <!-- <h2>请选择分类:苹果|香蕉|蔬菜|黄瓜</h2> -->
         <!-- 类型选择 -->
         <span class="demonstration">默认 click 触发子菜单</span>
         <el-cascader
            v-model="value"
            :options="options"
            @change="handleChange"
         ></el-cascader>
      </div>

      <div>
         价格:<el-input
            v-model="goods.price"
            placeholder="请输入内容"
         ></el-input>
      </div>

      <h1>上传图片位置</h1>
      <!-- -----------------------上传文件---------------------- -->
      <el-upload
         action="api/upload"
         list-type="picture-card"
         :auto-upload="true"
         :data="{ userID: 'Bigzheng' }"
         name="multipartFile"
      >
         <i slot="default" class="el-icon-plus"></i>
         <div slot="file" slot-scope="{ file }">
            <img
               class="el-upload-list__item-thumbnail"
               :src="file.url"
               alt=""
            />
            <!-- ---------------图片的操作--------- -->
            <span class="el-upload-list__item-actions">
               <span
                  class="el-upload-list__item-preview"
                  @click="handlePictureCardPreview(file)"
               >
                  <i class="el-icon-zoom-in"></i>
               </span>
               <span
                  v-if="!disabled"
                  class="el-upload-list__item-delete"
                  @click="handleDownload(file)"
               >
                  <i class="el-icon-download"></i>
               </span>
               <span
                  v-if="!disabled"
                  class="el-upload-list__item-delete"
                  @click="handleRemove(file)"
               >
                  <i class="el-icon-delete"></i>
               </span>
            </span>
            <!-- ---------------图片的操作--------- -->
         </div>
      </el-upload>
      <el-dialog :visible.sync="dialogVisible">
         <img width="100%" :src="dialogImageUrl" alt="" />
      </el-dialog>

      <!-- -----------------------上传文件---------------------- -->
      <van-button plain type="info" @click="toShoppingSuccess"
         >确认上架</van-button
      >
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
         //图片上传
         dialogImageUrl: "",
         dialogVisible: false,
         disabled: false,

         // 输入框内容:
         textarea: "",

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
         value: [],
         // options: [
         //    {
         //       value: "zhinan",
         //       label: "指南",
         //    },
         //    {
         //       value: "zujian",
         //       label: "组件",
         //    },
         //    {
         //       value: "ziyuan",
         //       label: "资源",
         //    },
         //    {
         //       value: "ziyuan",
         //       label: "资源",
         //    },
         //    {
         //       value: "ziyuan",
         //       label: "资源",
         //    },
         //    {
         //       value: "ziyuan",
         //       label: "资源",
         //    },
         // ],

         user: {},
         goods: {
            goodsID: 0,
            goodsName: "",
            goodsDescribe: "",
            goodsClassify: 0,
            price: 0,
         },
         // 分类信息表单
         options: [
            { value: 1, label: "芒果" },
            { value: 2, label: "鱼肉" },
            { value: 3, label: "波罗蜜" },
            { value: 4, label: "柚子" },
            { value: 5, label: "橙子" },
            { value: 6, label: "猕猴桃" },
            { value: 7, label: "苹果" },
            { value: 8, label: "草莓" },
            { value: 9, label: "卷心菜" },
            { value: 10, label: "西红柿" },
            { value: 11, label: "黄瓜" },
            { value: 12, label: "大白菜" },
            { value: 13, label: "西兰花" },
            { value: 14, label: "萝卜" },
            { value: 15, label: "生菜" },
            { value: 16, label: "金针菇" },
            { value: 17, label: "大葱" },
            { value: 18, label: "韭菜" },
            { value: 19, label: "南瓜" },
            { value: 20, label: "空心菜" },
         ],
      };
   },

   created() {
      //获取用户信息:
      this.user = this.$qs.parse(window.sessionStorage.getItem("userinfo"));

      //分类信息表的处理

      // 一开始就申请商品表模板
      this.$axios
         .get("api/goods/addmodel/" + this.user.userID)
         .then((res) => {
            this.goods.goodsID = res.data;
            console.log("新增商品ID", this.goods.goodsID);
         })
         .catch((error) => {
            console.log(error);
         });
   },

   methods: {
      //图片上传
      handleRemove(file) {
         console.log(file);
      },
      handlePictureCardPreview(file) {
         this.dialogImageUrl = file.url;
         this.dialogVisible = true;
      },
      handleDownload(file) {
         console.log(file);
      },

      //商品种类选择方法
      handleChange(value) {
         this.goods.goodsClassify = value[0];
      },

      //跳转到卖货成功页面
      toShoppingSuccess() {
         this.$axios
            .post("api/goods/updatamodel", this.$qs.stringify(this.goods))
            .then((response) => {
               console.log(response.data);
            })
            .catch((error) => {
               console.log(error);
            });

         // this.$router.push("/shoppingsuccess");
      },
      //上传后的钩子函数
      afterRead(file) {
         console.log(file);
         axios
            .post("http://localhost:8081/upload", file)
            .then(function (response) {
               console.log(response);
            });
      },

      //文件过大,触发钩子函数
      onOversize(file) {
         console.log("文件超过大小,过大文件已经捕获");
         console.log(file);
         this.$axios
            .post("http://localhost:8081/upload", file) //
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