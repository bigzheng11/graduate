<template>
   <div>
      <baidu-map
         class="map"
         :center="map.center"
         :zoom="map.zoom"
         @ready="handler"
      >
         <!--放大/缩放 按钮-->
         <bm-navigation anchor="BMAP_ANCHOR_TOP_LEFT"></bm-navigation>
         <!--定位-->
         <bm-geolocation
            anchor="BMAP_ANCHOR_BOTTOM_RIGHT"
            :showAddressBar="true"
            :autoLocation="true"
         ></bm-geolocation>

         <!--定位小红点-->
         <bm-marker
            :position="map.center"
            :dragging="map.dragging"
            animation="BMAP_ANIMATION_DROP"
         >
            <!--提示信息-->
            <bm-info-window :show="map.show">实训地点</bm-info-window>
         </bm-marker>
      </baidu-map>
      <Footer></Footer>
   </div>
</template>

<script>
import Footer from "../components/Footer.vue";
export default {
   name: "demo",
   data: () => ({
      map: {
         // 初始位置
         center: { lng: 120.21998763084412, lat: 30.85783674113258 },

         zoom: 15,
         show: true,
         dragging: true,
         
      },
   }),
   methods: {
      handler({ BMap, map }) {
         let me = this;
         console.log(BMap, map);
         // 鼠标缩放
         map.enableScrollWheelZoom(true);
         // 点击事件获取经纬度
         map.addEventListener("click", function (e) {
            console.log(e.point.lng, e.point.lat);
         });
      },
   },

   components: { Footer },
};
</script>

<style scoped>
.map {
   width: 100%;
   height: 600px;
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