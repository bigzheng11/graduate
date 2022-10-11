<!-- 用户管理组件 -->
<template>
   <div class="userList">
      用户管理页面
      <el-table
         :data="
            tableData.filter(
               (data) =>
                  !search ||
                  data.name.toLowerCase().includes(search.toLowerCase())
            )
         "
         style="width: 100%"
      >
         <el-table-column label="头像" prop="userImg"> </el-table-column>
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
   </div>
</template>

<script>
import Nothing from "../../components/../components/index/Nothing.vue";
export default {
   data() {
      return {
         tableData: [
            {
               userImg:"用户头像",
               userID:15518745323,
               userName:"用户",
               date: "2016-05-02",
               name: "王小虎1",
               address: "上海市普陀区金沙江路 1518 弄",
            },
            {
               date: "2016-05-04",
               name: "王小虎2",
               address: "上海市普陀区金沙江路 1517 弄",
            },
         ],
         search: "",
      };
   },
   components: {
      Nothing,
   },

   methods: {
      handleEdit(index, row) {
         console.log(index, row);
      },
      handleDelete(index, row) {
         console.log(index, row);
      },
   },
};
</script>


<style>
</style>
