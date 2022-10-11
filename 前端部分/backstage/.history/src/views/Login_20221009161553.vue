<template>
   <div class="Container">模板</div>
</template>

<script>
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
  
  