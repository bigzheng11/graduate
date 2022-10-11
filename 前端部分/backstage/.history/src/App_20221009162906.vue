<template>
   <div id="app">
      <router-view />
   </div>
</template>
<script>
export default {
   name: "App",
   watch: {
      //监听 解决刷新浏览器 没有对于路由 tab的问题
      //http://localhost/system/menus
      $route(to, from) {
         if (to.path != "/login") {
          // 下一个去的方向不是
            let obj = {
               title: to.meta.title,
               name: to.name,
            };
            this.$store.commit("addTabs", obj);
         }
      },
   },
};
</script>


<style>
html,
body,
#app {
   font-family: "Microsoft Yahei", sans-serif;
   height: 100%;
   padding: 0;
   margin: 0;
   color: #494949;
   font-size: 15px;
}
</style>
