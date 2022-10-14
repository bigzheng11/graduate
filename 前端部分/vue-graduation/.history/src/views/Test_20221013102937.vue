   <template>
	<div class="map-container relative">
      <div class="status-bar">
        <div class="status-item" v-for="(item, index) in statusArr" :key="index">
          <img :src="item.icon" />
          {{ item.text }}
        </div>
      </div>
<!--      :map-style="mapStyle"-->
      <baidu-map class="map" :center="markerPoint" :scroll-wheel-zoom="true" :zoom="16" :mapClick="false" @ready="handler" >
        <bm-marker v-for="marker in deviceList" :icon="markerIcon(marker)" :key="marker.id" :position="{ lng: +marker.longitude, lat: +marker.latitude }" @mouseover="infoWindowOpen(marker)" @mouseout="infoWindowClose">
        </bm-marker>
        <bm-info-window :show="show" :offset="{width: -20, height: 10}" :position="{ lng: +marker.longitude, lat: +marker.latitude }">
          <div>
            <div class="info-title">详情</div>
            <div class="info-content">
              <div>回收机编号：<span>{{ marker.oid }}</span></div>
              <div>回收机名称：<span>{{ marker.name }}</span></div>
              <div>地址：<span>{{ marker.address }}</span></div>
              <div>负责人：<span>{{ marker.manager }}</span></div>
              <div>电话：<span>{{ marker.managerPhone }}</span></div>
            </div>
          </div>
        </bm-info-window>
      </baidu-map>
    </div>
</template>

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
