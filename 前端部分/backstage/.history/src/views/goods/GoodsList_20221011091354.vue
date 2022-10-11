<!-- 用户管理组件 -->
<template>
   <div class="goodsList">
      <el-table
         :data="
            tableData
               .slice((currentPage - 1) * pageSize, currentPage * pageSize)
               .filter(
                  (data) =>
                     !search ||
                     data.goodsName.toLowerCase().includes(search.toLowerCase())
               )
         "
         style="width: 100%"
         :row-style="{ height: '90px' }">
         </el-table-column>
         <el-table-column label="goodsID" prop="goodsID" width="80"> </el-table-column>
         <el-table-column label="卖家ID" prop="userID"> </el-table-column>
         <el-table-column label="商品名" prop="goodsName"> </el-table-column>
         <el-table-column label="商品描述" prop="goodsDescribe" width="400">
         </el-table-column>
         <el-table-column label="商品分类" prop="goodsClassify" width="100">
         </el-table-column>
         <el-table-column label="价格" prop="price" width="100"> </el-table-column>
         <el-table-column label="是否已售卖" prop="isSell" width="100"> 
            <template slot-scope="scope">
               <p>{{scope.row.isSell?'已经卖了':'未售'}}</p>
            </template>
         </el-table-column>
         <el-table-column label="是否删除" prop="deleteTag"><template slot-scope="scope" width="100">
               <p>{{scope.row.deleteTag?"未删":"已经删除"}}</p>
            </template> </el-table-column>
         <!-- 搜索部分&&操作部分 ↓↓ -->
         <el-table-column align="right" >
            <template slot="header" slot-scope="scope">
               <el-input
                  v-model="search"
                  size="mini"
                  placeholder="输入关键字搜索"
               />
            </template>
            <template slot-scope="scope">
               <el-button
                  size="mini"
                  @click="handleEdit(scope.$index, scope.row)"
                  >编辑</el-button
               >
               <el-button
                  size="mini"
                  type="danger"
                  @click="handleDelete(scope.$index, scope.row)"
                  >删除</el-button
               >
            </template>
         </el-table-column>
         <!-- 搜索部分&&操作部分 ↑↑ -->
      </el-table>
      <!-- 弹窗 -->

      <!-- 分页 -->
      <el-pagination
         background
         layout="prev, pager, next"
         :total="tableData.length"
         :page-size="6"
         @current-change="handleCurrentChange"
         @size-change="handleSizeChange"
      >
      </el-pagination>

      <!-- 抽屉 -->
      <el-drawer
      title="更新用户信息"
      :before-close="handleClose"
      :visible.sync="dialog"
      direction="rtl"
      custom-class="demo-drawer"
      ref="drawer"
      style="padding:60px;"
      >  

      <div style="margin:35px;font-size: 17px;">
         <div>
            <el-tag style="font-size: 17px;">goodsID</el-tag> &nbsp;
            <strong>1</strong>
         </div>
         <br>
         <div>
            <el-tag style="font-size: 17px;">userID&nbsp;&nbsp;&nbsp;</el-tag> &nbsp;
            <strong>15518745323</strong>
            
         </div>
         <br>
         <div>
            <div style="margin-bottom:10px">
               商品名:
            </div>
               <el-input v-model="newData.goodsName" placeholder="请输入内容" style="width:360px"></el-input>
         </div>
         <br>
         <div>
            <div style="margin-bottom:10px">
            商品描述:

         </div>
               <el-input v-model="newData.goodsDescribe" placeholder="请输入内容" style="width:360px"></el-input>
         </div>
         <br>
         <div>
            <div style="margin-bottom:10px">
            商品分类:
         </div>
               <el-cascader
               v-model="newData.goodsClassify"
               :options="options"
               @change="handleChange"
               ></el-cascader>
         </div>
         <br>
         <div> 
            <div style="margin-bottom:10px">
            商品价格:

            </div>
               <el-input v-model="newData.price" placeholder="请输入内容" style="width:300px"></el-input>
         </div>
         <br>
         <div>
            <el-switch
            style="display: block"
            v-model="newData.deleteTag"
            active-color="#13ce66"
            inactive-color="#ff4949"
            active-text="保留"
            inactive-text="删除">
            </el-switch>
         </div>
         <br>
         <el-button @click="cancelForm">取 消</el-button>
      <el-button type="primary" @click="$refs.drawer.closeDrawer()" :loading="loading">{{ loading ? '提交中 ...' : '确 定' }}</el-button>
   </div>

</el-drawer>
   </div>
</template>

<script>
export default {
   data() {
      return {
         goodsList: [],
         tableData: [],
         search: "",
         // 默认显示第几页
         currentPage: 1, // 当前页码
         total: 20, // 总条数
         pageSize: 6, // 每页的数据条数

         //抽屉
         table: false,
         dialog: false,
         loading: false,
         formLabelWidth: "80px",
         timer: null,
         deleteTag: false,

         //新信息
         newData: {
            goodsID: "",
            goodsName: "",
            goodsDescribe: "",
            goodsClassify: "",
            price: "",
            deleteTag: "",
         },

         // 分类信息表单
         value: "",
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
      // 获取商品信息
      this.$axios
         .get("/api/goods/backstageselectall")
         .then((response) => {
            this.tableData = response.data;
            console.log(this.tableData);
         })
         .catch((error) => {
            console.log(error);
         });
   },

   methods: {
      //商品种类选择方法
      handleChange(value) {
         console.log(value[0]);
      },

      // 抽屉方法
      handleClose(done) {
         if (this.loading) {
            return;
         }
         this.$confirm("确定要提交表单吗？")
            .then((_) => {
               this.loading = true;

               //goodsClassify的数据类型进行修改
               if (typeof this.newData.goodsClassify === "object") {
                  console.log("判断为对象");
                  this.newData.goodsClassify = this.newData.goodsClassify[0];
               }
               if (this.newData.deleteTag) {
                  this.newData.deleteTag = "1";
               } else {
                  this.newData.deleteTag = "0";
               }

               //修改商品信息
               this.$axios({
                  url: "/api/goods/backstageUpdataById",
                  method: "post",
                  headers: {
                     "Content-Type": "application/json",
                  },
                  data: this.newData,
               }).then((respanse) => {
                  if (respanse.data == 1) {
                     console.log("更新成功");
                     this.$route.go(0)
                  }
               });

               console.log("发送请求");
               this.timer = setTimeout(() => {
                  done();
                  // 动画关闭需要一定的时间
                  setTimeout(() => {
                     this.loading = false;
                  }, 400);
               }, 2000);
            })
            .catch((_) => {});
      },
      cancelForm() {
         this.loading = false;
         this.dialog = false;
         clearTimeout(this.timer);
      },

      // 消息提示
      open2(message) {
         this.$message({
            message: message,
            type: "success",
         });
      },

      // 弹窗
      open() {
         this.$confirm("此操作将永久删除, 是否继续?", "提示", {
            confirmButtonText: "确定",
            cancelButtonText: "取消",
            type: "warning",
         })
            .then(() => {
               this.$message({
                  type: "success",
                  message: "删除成功!",
               });
            })
            .catch(() => {
               this.$message({
                  type: "info",
                  message: "已取消删除",
               });
            });
      },

      handleSizeChange(val) {
         console.log(`每页 ${val} 条`);
         this.currentPage = 1;
         this.pageSize = val;
      },
      handleCurrentChange(val) {
         console.log(`当前页: ${val}`);
         this.currentPage = val;
      },

      // 显示第几页
      // handleCurrentChange(val) {
      //    console.log(`当前页: ${val}`);
      // },

      //编辑操作
      handleEdit(index, row) {
         this.dialog = true;
         // this.$router.push({
         //    path: "/index/GoodsDetail",
         //    query: { goodsID: row.goodsID },
         // });
         console.log("编辑---", index, row);

         this.newData.goodsID = row.goodsID;
         this.newData.goodsName = row.goodsName;
         this.newData.goodsDescribe = row.goodsDescribe;
         this.newData.goodsClassify = row.goodsClassify;
         this.newData.price = row.price;
         if (row.deleteTag == 1) {
            this.newData.deleteTag = true;
         } else {
            this.newData.deleteTag = false;
         }
      },
      //删除操作--------------------------------------
      async handleDelete(index, row) {
         console.log("======删除=======");
         console.log(index);
         console.log(row.goodsID);
         console.log("======删除=======");
         const resultConfirm = await this.$confirm(
            "此操作将修改deleteTag标签为删除,是否继续?",
            "删除--deleteTag",
            {
               confirmButtonText: "确定",
               cancelButtonText: "取消",
               type: "warning",
            }
         ).catch((err) => err);
         // 如果点击的是 确定则resultConfirm 返回的是confirm
         // 否则点击其他的都是返回cancel
         console.log(resultConfirm);
         if (resultConfirm !== "confirm") {
            // 取消
            return this.$message.info("取消删除");
         } else {
            this.$axios
               .get("/api/goods/backstageDeleteById/" + row.goodsID)
               .then((response) => {
                  if (response.data == 1) {
                     // 删除成功
                     this.open2("删除成功");
                     for (const item of this.tableData) {
                        if (item.goodsID == row.goodsID) {
                           console.log(item.goodsID);
                           item.deleteTag = false;
                        }
                     }
                  }
               })
               .catch((error) => {
                  console.log(error);
               });
         }
      },

      // handleDelete(index, row) {
      //    let test = this.open();
      //    console.log(test);

      //    console.log(index, row);
      // },
   },
};
</script>


<style scoped>
.
</style>
