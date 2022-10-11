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
         <el-table-column label="Date" prop="date"> </el-table-column>
         <el-table-column label="Name" prop="name"> </el-table-column>
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
      </el-table>
   </div>
</template>


<script>
import Nothing from "../../components/../components/index/Nothing.vue";
export default {
   data() {
      return {};
   },
   components: {
      Nothing,
   },
};
</script>


<style>
</style>
