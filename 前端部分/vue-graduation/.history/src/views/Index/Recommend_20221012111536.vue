<template>
   <div class="container" ref="container">
      <div id="fall-list" class="clearfix">
         <div ref="line1" class="fall-line">
            <div
               class="fall-item"
               v-for="(item, index) in data1"
               :key="index"
               @click="toGoodsDetail(item)"
            >
               <img :src="item.picList[0].picture" />
               <h3>
                  {{ item.goodsName }}
               </h3>
               {{ item.goodsDescribe }}
            </div>
         </div>

         <div ref="line2" class="fall-line">
            <div
               class="fall-item"
               v-for="(item, index) in data2"
               :key="index"
               @click="toGoodsDetail(item)"
            >
               <img :src="item.picList[0].picture" />
               <h3>
                  {{ item.goodsName }}
               </h3>
               {{ item.goodsDescribe }}
            </div>
         </div>
      </div>
   </div>
</template>
 
 <script>
export default {
   data() {
      return {
         user: "",

         data1: [],
         data2: [],
         goodsAllList: [],
      };
   },

   created() {
      console.log("--------------------进入瀑布流------------------");
      //获取用户信息:
      this.user = this.$qs.parse(window.sessionStorage.getItem("userinfo"));
      //获取商品列表
      this.$axios
         .get("api/goods/getall/" + this.user.userID)
         .then((response) => {
            this.goodsAllList = response.data;
            console.log("goodsAllList:-------->", this.goodsAllList);
         })
         .catch((error) => {
            console.log(error);
         });
   },

   methods: {
      //跳转到商品详情页面
      toGoodsDetail(item) {
         // this.$router.push("/goodsdetail");

         this.$router.push({
            path: "/goodsdetail",
            query: {
               goodsDetail: item,
            },
         });
      },
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
         console.log("doSort内的接收参数");
         if (index < list.length) {
            if (
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
      // this.$store.state.recommendGoodList
      var self = this;
      // this.loadImagex();
      this.doSort(0, this.$store.state.recommendGoodList);

      const container = this.$refs.container;
      //绑定事件
      container.addEventListener("scroll", function (e) {
         if (
            (container.offsetHeight + container.scrollTop) * 1.2 >=
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