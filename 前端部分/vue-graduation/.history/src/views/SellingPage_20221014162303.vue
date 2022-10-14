<template>
   <div class="container" style="margin: 10px">
      <h3>商品信息</h3>
      <span style="position: absolute; right: 10px; top: 13px"
         ><van-button plain type="info" @click="toShoppingSuccess"
            >确认上架</van-button
         ></span
      >

      <div style="margin-top: 30px">
         <div>商品名:</div>
         <el-input
            style="width: 300px"
            v-model="goods.goodsName"
            placeholder="请输入内容"
         ></el-input>
      </div>

      <div>
         <div>商品描述:</div>
         <el-input
            type="textarea"
            :rows="5"
            style="width: 300px"
            placeholder="请输入内容"
            v-model="goods.goodsDescribe"
         >
         </el-input>
      </div>

      <div>
         <div>商品分类:</div>
         <!-- <h2>请选择分类:苹果|香蕉|蔬菜|黄瓜</h2> -->
         <!-- 类型选择 -->
         <!-- <span class="demonstration">默认 click 触发子菜单</span> -->
         <el-cascader
            v-model="value"
            :options="options"
            @change="handleChange"
         ></el-cascader>
      </div>

      <div>
         <div><van-icon name="after-sale" />价格:</div>
         <el-input
            style="width: 200px"
            v-model="goods.price"
            placeholder="请输入内容"
         ></el-input>
      </div>

      <h3 style="margin: 20px 0px 10px 10px">上传图片</h3>
      <!-- -----------------------上传图片---------------------- -->
      <el-upload
         action="api/picture/upload"
         list-type="picture-card"
         :auto-upload="true"
         :data="{ goodsID: Number(goods.goodsID) }"
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
      <!-- -----------------------上传视频---------------------- -->
      <el-upload
         style="margin: 10px"
         class="upload-demo"
         action="api/video/upload"
         :on-preview="handlePreviewVideo"
         :on-remove="handleRemoveVideo"
         :before-remove="beforeRemoveVideo"
         multiple
         :limit="3"
         :on-exceed="handleExceedVideo"
         :data="{ goodsID: 103 }"
         name="multipartFile"
      >
         <el-button size="small" type="primary">点击上传视频</el-button>
      </el-upload>
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
         //视频上传
         fileList: [
            {
               name: "multipartFile",
               url: "https://fuss10.elemecdn.com/3/63/4e7f3a15429bfda99bce42a18cdd1jpeg.jpeg?imageMogr2/thumbnail/360x360/format/webp/quality/100",
            },
         ],

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
      // 视频上传
      handleRemoveVideo(file, fileList) {
         console.log(file, fileList);
      },
      handlePreviewVideo(file) {
         console.log(file);
      },
      handleExceedVideo(files, fileList) {
         this.$message.warning(
            `当前限制选择 3 个文件，本次选择了 ${
               files.length
            } 个文件，共选择了 ${files.length + fileList.length} 个文件`
         );
      },
      beforeRemoveVideo(file, fileList) {
         return this.$confirm(`确定移除 ${file.name}？`);
      },

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
               console.log("afterRead");
            });
      },

      //文件过大,触发钩子函数
      onOversize(file) {
         console.log("文件超过大小,过大文件已经捕获");
         console.log(file);
         // 上传图片
         // this.$axios
         //    .post("http://localhost:8081/upload", file) //
         //    .then(function (response) {
         //       console.log("onOversize");
         //       console.log(response);
         //    });
         // Toast("文件大小不能超过 500kb");
         alert("不能超过5000kb");
      },
   },
   components: { Footer },

   beforeCreate() {},
};
</script>
 
 <style scoped>
.container {
   width: vw;
   height: 100%;
   overflow: scroll;
   /* border: 1px solid palegreen; */
   box-sizing: border-box;
   background-color: #f2f3f5;
}
</style>