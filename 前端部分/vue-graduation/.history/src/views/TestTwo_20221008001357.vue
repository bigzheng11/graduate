<template>
   <div class="container">
      <!-- action="api/upload" -->
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

      <hr />
      <van-uploader v-model="fileList" multiple />
      <hr />
      <button @click="demo">测试</button>
   </div>
</template>

<script>
import axios from 'axios';
export default {
   data() {
      return {
         dialogImageUrl: "",
         dialogVisible: false,
         disabled: false,
         fileList: [
            { url: "https://img01.yzcdn.cn/vant/leaf.jpg" },
            // Uploader 根据文件后缀来判断是否为图片文件
            // 如果图片 URL 中不包含类型信息，可以添加 isImage 标记来声明
            { url: "https://cloud-image", isImage: true },
         ],
      };
   },

   created() {},

   methods: {
      handleRemove(file) {
         console.log("handleRemove");
         console.log(file);
      },
      handlePictureCardPreview(file) {
         console.log("handlePictureCardPreview");
         this.dialogImageUrl = file.url;
         this.dialogVisible = true;
      },
      handleDownload(file) {
         console.log("handleDownload");
         console.log(file);
      },
      demo() {
         console.log(this.fileList);
         http://localhost:8081/upload
         this.$axios
            .post("api/upload", this.$qs.stringify(
                multipartFile:
                username

            ))
            .then((response) => {
                console.log(response);
              
            })
            .catch((error) => {
               console.log(error);
            });
      },
   },

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

<!-- 

  信息列表
goodsClassify:[
{id:1,name:"芒果"},
{id:2,name:"鱼肉"},
{id:3,name:"波罗蜜"},
{id:4,name:"柚子"},
{id:5,name:"橙子"},
{id:6,name:"猕猴桃"},
{id:7,name:"苹果"},
{id:8,name:"草莓"},
{id:9,name:"卷心菜"},
{id:10,name:"西红柿"},
{id:11,name:"黄瓜"},
{id:12,name:"大白菜"},
{id:13,name:"西兰花"},
{id:14,name:"萝卜"},
{id:15,name:"生菜"},
{id:16,name:"金针菇"},
{id:17,name:"大葱"},
{id:18,name:"韭菜"},
{id:19,name:"南瓜"},
{id:20,name:"空心菜"},

]


  -->
