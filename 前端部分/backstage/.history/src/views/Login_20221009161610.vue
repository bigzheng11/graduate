<template>
   <div class="Container">模板</div>
</template>

<script>
export default {
   name: "app",
   data() {
      return {
         pathName: this.$route.name,
      };
   },
   components: {
   },
   watch: {
      $route: function () {
         this.pathName = this.$route.name;
      },
   },
};
<style scoped>

</style>;
