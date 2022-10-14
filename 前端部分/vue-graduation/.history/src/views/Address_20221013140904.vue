<template>
   <div>
      <!-- @ready为内部全局事件,地图组件渲染完毕触发 -->
      <baidu-map
         class="map"
         :center="map.center"
         :zoom="map.zoom"
         @ready="handler"
         :scroll-wheel-zoom="true"
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
         <bm-local-search
            :keyword="keyword"
            :auto-viewport="true"
            :location="location"
         ></bm-local-search>
      </baidu-map>
      <!-- <Footer></Footer> -->
      城市:<input type="text" v-model="location" /> 地点:<input
         type="text"
         v-model="keyword"
      />
   </div>
</template>
 
 <script>
import Footer from "../components/Footer.vue";
export default {
   name: "demo",
   data: () => ({
      location: "湖州",
      keyword: "万马",
      map: {
         // 初始位置
         center: { lng: 120.226663, lat: 30.862832 },
         zoom: 15,
         show: true,
         dragging: true,
      },

   }),
   methods: {

      //点击事件
      handler({ BMap, map }) {
         let me = this;
         console.log("B",BMap);
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