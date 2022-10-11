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
  
  