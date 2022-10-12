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
         <el-table-column label="用户ID" prop="userID"> </el-table-column>
         <el-table-column label="用户名" prop="userName"> </el-table-column>
         <el-table-column label="注册时间" prop="date"> </el-table-column>
         <el-table-column label="性别" prop="userSex"> </el-table-column>
         <el-table-column label="是否删除" prop="deleteTag"><template slot-scope="scope" width="100">
               <p v-show="scope.row.deleteTag">{{scope.row.deleteTag?"保留":"已经删除"}}</p>
               <el-tag type="danger" v-if="!scope.row.deleteTag" disable-transitions="false">{{scope.row.deleteTag?"未删":"已经删除"}}</el-tag>
            </template> 
         </el-table-column>

         <!-- 搜索部分&&操作部分 ↓↓ -->
         <el-table-column align="right" >
            <template slot="header" slot-scope="scope">
               <el-input
                  v-model="search"
                  size="mini"
                  placeholder="进行本页搜索"
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
            <img src="" alt="" style="width:80px;height:80px">
         </div>
         <br>
         <div>
            <el-tag style="font-size: 17px;">userID&nbsp;&nbsp;&nbsp;</el-tag> &nbsp;
            <strong>15518745323</strong>
            
         </div>
         <br>
         <div>
            <div style="margin-bottom:10px">
               用户名:
            </div>
               <el-input v-model="newData.userName" placeholder="请输入内容" style="width:360px"></el-input>
         </div>
         <br>
         <div>
            <div style="margin-bottom:10px">
            商品描述:
            </div>
               <el-input v-model="newData.deleteTag" placeholder="请输入内容" style="width:360px"></el-input>
         </div>
         <br>
         
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
                     this.$route.go(0);
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
.red {
   color: red;
}
</style>
