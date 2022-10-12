<!-- 用户管理组件 -->
<template>
   <div class="userList"></div>
</template>

<script>
import Nothing from "../../components/../components/index/Nothing.vue";
export default {
   data() {
      return {
        
      };
   },
   created() {
      // 获取用户信息
      this.$axios
         .get("/api/user/backstageselectall")
         .then((response) => {
            this.userList = response.data;
            this.tableData = response.data;
            // this.tableData = this.userList.splice(0, 6);
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
