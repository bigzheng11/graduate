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
         <el-table-column label="头像" prop="userImg">
            <template slot-scope="scope">
               <img
                  :src="scope.row.userImg"
                  alt=""
                  style="width: 100px; height: 100px"
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
   </div>
</template>

<script>
import Nothing from "../../components/../components/index/Nothing.vue";
export default {
   data() {
      return {
         tableData: [
            {
               userImg:
                  "https://upload-images.jianshu.io/upload_images/5809200-a99419bb94924e6d.jpg?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240",
               userID: 15518745323,
               userName: "bigZheng",
               date: "2016-05-02",
               userSex: "男",
               //TODO address: "上海市普陀区金沙江路 1518 弄",
            },
            {
               userImg: "用户头像2",
               userID: 15518745320,
               userName: "王正",
               date: "2022-05-02",
               userSex: "女",
               //TODO address: "上海市普陀区金沙江路 1518 弄",
            },
         ],
         search: "",
      };
   },
   created() {
      // 获取用户信息
      this.$axios.get("api/user/backstageselectall").then((res) => {
         console.log(res.data)).catch((err) => {
            
         })
      });
   },

   methods: {
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
