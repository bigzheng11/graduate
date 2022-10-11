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
                     data.name.toLowerCase().includes(search.toLowerCase())
               )
         "
         style="width: 100%"
         :row-style="{ height: '90px' }"  
      >
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
         <el-table-column label="是否删除" prop="deleteTag"><template slot-scope="scope">
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
   </div>
</template>

<script>
import Nothing from "../../components/index/Nothing.vue";
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
         console.log(index, row);
      },
      //删除操作
      async handleDelete(index, row) {
         console.log("======删除=======");
         console.log(index);
         console.log(row.goodsID);
         console.log("======删除=======");
         const resultConfirm = await this.$confirm(
            "此操作将永久删除该用户, 是否继续?",
            "永久删除用户",
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
                  console.log(response.data);
               })
               .catch((error) => {
                  console.log(error);
               });

            return this.$message.success("删除用户成功");
         }
      },

      // handleDelete(index, row) {
      //    let test = this.open();
      //    console.log(test);

      //    console.log(index, row);
      // },
   },
   components: {
      Nothing,
   },
};
</script>


<style>
</style>
