<template>
   <div class="dynamic">
     <div>
        <h3>
           <span>地图信息</span>
           <i title="地图" class="el-icon-map-location" @click="amplification"></i>
        </h3>
        <baidu-map class="bm-view" :center="markerPoint" :zoom="16" :dragging="true" :scroll-wheel-zoom="true" @ready="handler">
           <bm-map-type :map-types="['BMAP_NORMAL_MAP', 'BMAP_HYBRID_MAP']" anchor="BMAP_ANCHOR_TOP_RIGHT"></bm-map-type>
           <bm-marker :position="position" :dragging="false" animation="BMAP_ANIMATION_BOUNCE">
              <bm-info-window :show="show" style="font-size:13px"></bm-info-window>
           </bm-marker> 
        </baidu-map>
   </div>
</template>

<script>
export default {
   data() {
      return {
         markerPoint: { lng: 108.951, lat: 34.3285 },
         show: false,
         isBig: false,
         values: [],
         position: { lng: 108.951, lat: 34.3285 },
      };
   },
   methods: {
      handler({ BMap, map }) {
         // console.log(BMap, map)
         this.center.lng = 108.951;
         this.center.lat = 34.3285;
         this.zoom = 15;
      },
   },
};
</script>

<style scoped>
.dynamic2 {
   display: flex;
   position: relative;
}
.map {
   width: 50%;
   height: 330px;
   transition: 0.5s;
}
.mapBig {
   position: absolute;
   width: 100%;
   height: 536px;
   z-index: 3;
   transition: 0.5s;
   top: -218px;
}
.information {
   width: 30%;
}
/* 地图 */
.bm-view {
   width: 100%;
   height: 89%;
}
h3 {
   font-size: 14px;
   line-height: 35px;
   padding: 0 10px;
   background: #f8f8f8;
   border: 1px solid #ddd;
   border-left: 0;
}
.map h3,
.mapBig h3,
.information h3 {
   display: flex;
   justify-content: space-between;
   align-items: center;
}
.map h3 i,
.mapBig h3 i {
   font-weight: 700;
   font-size: 17px;
   cursor: pointer;
}
.information h3 img {
   display: block;
   width: 25px;
   transform: rotateY(180deg);
}
</style>
