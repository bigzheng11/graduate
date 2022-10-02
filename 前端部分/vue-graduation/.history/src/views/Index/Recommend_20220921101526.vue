<template>
   <div class="container">
      <button @click="loadImagex">加载</button>
      <div id="fall-list" class="clearfix">
         <div ref="line1" class="fall-line">
            <div class="fall-item" v-for="(src, index) in data1" :key="index">
               <img :src="src" />
            </div>
         </div>

         <div ref="line2" class="fall-line">
            <div class="fall-item" v-for="(src, index) in data2" :key="index">
               <img :src="src" />
            </div>
         </div>
      </div>
   </div>
</template>
 
 <script>
export default {
   data() {
      return { data1: [], data2: [] };
   },

   created() {},

   methods: {},
   mounted:() {
                    var self = this;
                    this.loadImagex();
                },
};
</script>
 
 <style scoped>
</style>
 
 <!-- 
 axios:
 
      axios
    .get("https://autumnfish.cn/api/joke/list?num=3") //获得三个笑话
    .then(function (response) {
    console.log(response);
  });
 
 axios.get('url')
   .then(function (response) {
     console.log(response);
   })
   .catch(function (error) {
     console.log(error);
   })
   .then(function () {
   });
  -->