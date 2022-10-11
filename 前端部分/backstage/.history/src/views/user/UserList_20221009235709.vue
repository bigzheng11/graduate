<!-- 用户管理组件 -->
<template>
   <div class="userList">
      <el-table
         :data="
            tableData.filter(
               (data) =>
                  !search ||
                  data.name.toLowerCase().includes(search.toLowerCase())
            )
         "
         style="width: 100%"
         :row-style="{ height: '100px' }"
      >
         <el-table-column label="头像" prop="userImg">
            <template slot-scope="scope">
               <img
                  :src="scope.row.userImg"
                  alt=""
                  style="width: 60px; height: 70px"
               />
            </template>
         </el-table-column>
         <el-table-column label="用户ID" prop="userID"> </el-table-column>
         <el-table-column label="用户名" prop="userName"> </el-table-column>
         <el-table-column label="注册时间" prop="date"> </el-table-column>
         <el-table-column label="性别" prop="userSex"> </el-table-column>
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
                  >Edit</el-button
               >
               <el-button
                  size="mini"
                  type="danger"
                  @click="handleDelete(scope.$index, scope.row)"
                  >Delete</el-button
               >
            </template>
         </el-table-column>
         <!-- 搜索部分&&操作部分 ↑↑ -->
      </el-table>

      <!-- 分页 -->
      <el-pagination
         background
         layout="prev, pager, next"
         :total="tableData.length"
         :page-size="7"
         @current-change="handleCurrentChange"
      >
      </el-pagination>
   </div>
</template>

<script>
import Nothing from "../../components/../components/index/Nothing.vue";
export default {
   data() {
      return {
         userList: [],
         tableData: [],
         search: "",
         // 默认显示第几页
      };
   },
   created() {
      // 获取用户信息
      this.$axios
         .get("/api/user/backstageselectall")
         .then((response) => {
            this.userList = response.data;
            console.log(this.userList);
            this.tableData = this.userList.splice(0, 6);
            console.log(this.tableData);
         })
         .catch((error) => {
            console.log(error);
         });
   },

   methods: {
      // 显示第几页
      handleCurrentChange(val) {
         console.log(`当前页: ${val}`);
      },

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
