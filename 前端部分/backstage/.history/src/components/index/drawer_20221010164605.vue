<template>
   <div class="Container">
      <el-drawer
         title="更新用户信息"
         :before-close="handleClose"
         :visible.sync="dialog"
         direction="ltr"
         custom-class="demo-drawer"
         ref="drawer"
      >
         <div>goodsID:1</div>
         <div>userID:15518745323</div>
         <div>
            商品名:<el-input
               v-model="newData.goodsID"
               placeholder="请输入内容"
            ></el-input>
         </div>
         <div>
            商品描述:<el-input
               v-model="newData.goodsID"
               placeholder="请输入内容"
            ></el-input>
         </div>
         <div>
            商品分类:<el-input
               v-model="newData.goodsID"
               placeholder="请输入内容"
            ></el-input>
         </div>
         <div>
            商品价格:<el-input
               v-model="newData.goodsID"
               placeholder="请输入内容"
            ></el-input>
         </div>
         <div>
            已售:<el-input
               v-model="newData.goodsID"
               placeholder="请输入内容"
            ></el-input>
         </div>
         <div>
            删除<el-input
               v-model="newData.goodsID"
               placeholder="请输入内容"
            ></el-input>
         </div>
         <el-button @click="cancelForm">取 消</el-button>
         <el-button
            type="primary"
            @click="$refs.drawer.closeDrawer()"
            :loading="loading"
            >{{ loading ? "提交中 ..." : "确 定" }}</el-button
         >
      </el-drawer>
   </div>
</template>
 
 <script>
export default {
   data() {
      return {};
   },

   methods: {},

   created() {},

   mounted() {},

   components: {},

   watch: {},
};
<style scoped></style>;
