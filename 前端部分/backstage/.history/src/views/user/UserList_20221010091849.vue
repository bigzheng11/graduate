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
         :row-style="{ height: '90px' }"
      >
         <el-table-column label="头像" prop="userImg">
            <template slot-scope="scope">
               <img
                  :src="scope.row.userImg"
                  alt=""
                  style="width: 60px; height: 60px"
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
         :total="userList.length + 1"
         :page-size="6"
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
         currentPage: 1, // 当前页码
         total: 20, // 总条数
         pageSize: 1, // 每页的数据条数
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
      handleSizeChange(val) {
            console.log(`每页 ${val} 条`);
            this.currentPage = 1;
            this.pageSize = val;
        },
        handleCurrentChange(val) {
            console.log(`当前页: ${val}`);
            this.currentPage = val;
        }

————————————————
版权声明：本文为CSDN博主「GarenWang」的原创文章，遵循CC 4.0 BY-SA版权协议，转载请附上原文出处链接及本声明。
原文链接：https://blog.csdn.net/weixin_37695006/article/details/85319527
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
