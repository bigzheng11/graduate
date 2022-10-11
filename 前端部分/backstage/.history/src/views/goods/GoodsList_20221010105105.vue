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
         <el-table-column label="goodsID" prop="goodsID"> </el-table-column>
         <el-table-column label="卖家ID" prop="userID"> </el-table-column>
         <el-table-column label="商品名" prop="goodsName"> </el-table-column>
         <el-table-column label="商品描述" prop="goodsDescribe">
         </el-table-column>
         <el-table-column label="商品分类" prop="goodsClassify">
         </el-table-column>
         <el-table-column label="价格" prop="price"> </el-table-column>
         <el-table-column label="是否已售卖" prop="isSell"> </el-table-column>
         <el-table-column label="是否删除" prop="deleteTag"> </el-table-column>
         <!-- 搜索部分&&操作部分 ↓↓ -->
         <el-table-column align="right">
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
      <el-button type="text" @click="open">点击打开 Message Box</el-button>

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
      // 


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
      handleDelete(index, row) {
         console.log(index, row);
      },
   },
   components: {
      Nothing,
   },
};
</script>


<style>
</style>
