<template>
   <div class="Container">模板</div>
</template>

import DataHeader from './components/common/DataHeader.vue'
import SideNav from './components/common/SideNav.vue'
import Nothing from './components/common/Nothing.vue'

export default {
  name: 'app',
  data () {
    return {
      pathName: this.$route.name,
    }
  },
  components:{
    DataHeader,
    SideNav,
    Nothing
  },
  watch: {
    '$route': function(){
      this.pathName = this.$route.name;

    }
  }
}
<style scoped>
</style>

<template>
    <div id="app">
      <div class="app_header">
        <data-header></data-header>
      </div>
      <div class="app_content">
        <div class="app_nav">
          <side-nav></side-nav>
        </div>
        <div class="app_right">
          <div class="breadcrumb">
            <el-breadcrumb separator="/">
              <el-breadcrumb-item :to="{ path: '/' }">首页</el-breadcrumb-item>
              <el-breadcrumb-item>{{pathName}}</el-breadcrumb-item>
  
            </el-breadcrumb>
          </div>
          <router-view></router-view>
        </div>
      </div>
  
    </div>
  </template>
  
  <script>
  import DataHeader from './components/common/DataHeader.vue'
  import SideNav from './components/common/SideNav.vue'
  import Nothing from './components/common/Nothing.vue'
  
  export default {
    name: 'app',
    data () {
      return {
        pathName: this.$route.name,
      }
    },
    components:{
      DataHeader,
      SideNav,
      Nothing
    },
    watch: {
      '$route': function(){
        this.pathName = this.$route.name;
  
      }
    }
  }
  </script>
  
  