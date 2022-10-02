<template>
   <div class="container" ref="container">
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

   methods: {
      /*
      获取图片的列表,
      */
      loadImagex() {
         let size = [
            "300x460",
            "300x370",
            "300x500",
            "300x250",
            "300x210",
            "300x650",
            "300x290",
         ];
         let color = [
            "E97452",
            "4C6EB4",
            "449F93",
            "D25064",
            "5f27cd",
            "01a3a4",
            "9ca24",
         ];
         //从网站上多次申请假数据,追加到数组尾部
         let imgList = [];
         for (let i = 0; i < size.length; i++) {
            let url = `http://dummyimage.com/${size[i]}/${color[i]}`;
            imgList.push(url);
         }
         this.doSort(0, imgList);
      },

      doSort(index, list) {
         if (index < list.length) {
            if (
               // this.$refs. 获取到的是dom元素
               //从上方ref标记的元素中获取
               this.$refs.line1.offsetHeight <= this.$refs.line2.offsetHeight
               // offsetHeight返回元素的像素高度,
            ) {
               this.data1.push(list[index]);
            } else {
               this.data2.push(list[index]);
            }

            let that = this;
            // $nextTick将回调延迟到下次dom更新之后执行,
            this.$nextTick(() => {
               setTimeout(() => {
                  that.doSort(index + 1, list);
               }, 200);
            });
         }
      },
   },

   mounted() {
      var self = this;
      this.loadImagex();

      const container = this.$refs.container;
      //绑定事件
      container.addEventListener("scroll", function (e) {
         if (
            (container.offsetHeight + container.scrollTop)*0. >=
            container.scrollHeight
         ) {
            //触发事件
            self.loadImagex();
         }
      });
   },
};
</script>
 
 <style scoped>
button {
   position: fixed;
   z-index: 100;
   top: 10%;
   left: 10%;
}
#fall-list {
   /* 父盒子相对定位 */
   position: relative;
}

#fall-list .fall-line {
   /* 指元素沿着其容器的左侧或右侧放置,允许文本或者内联元素环绕他 */
   /* 从文档流中移除 */
   float: left;
   width: 50%;
}
#fall-list .fall-item {
   width: 96%;
   margin: 5px auto;
   background-color: #fff;
}
#fall-list .fall-item img {
   width: 100%;
}

.container {
   overflow: auto;
   width: 100%;
   height: 100%;
}
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