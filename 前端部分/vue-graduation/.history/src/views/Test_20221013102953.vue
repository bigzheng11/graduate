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

<script>
  import { getDeviceMap } from '@/api'
  import kuaiman from '../assets/imgs/kuaiman-icon.png'
  import weiman from '../assets/imgs/weiman-icon.png'
  import yiman from '../assets/imgs/yiman-icon.png'
  const styleJson = require('./mapStyle.json')
  export default {
    data() {
      return {
        statusArr: [
          {
            icon: weiman,
            text: '未满'
          },
          {
            icon: kuaiman,
            text: '快满'
          },
          {
            icon: yiman,
            text: '已满'
          }
        ],
        marker: {},
        deviceList: [],
        markerPoint:{ lng: 120.90102, lat: 31.986646 },
        show:false,
        // mapStyle: {    //自定义地图样式
        //   // styleJson
        // }
      }
    },
    created() {
      getDeviceMap({}).then((res) => {
        this.deviceList= res.data
      })
    },
    methods: {
      handler({BMap, map}) {
      },
      infoWindowClose () {
        this.show = false
      },
      infoWindowOpen (marker) {
        this.marker = Object.assign(marker)
        this.show = true
      },
      markerIcon(marker) {
        let img = marker.over == 2 ? kuaiman : marker.over == 1 ? yiman : weiman
        return { url: img,  size: { width: 28, height: 42 }}
      }
    }
  }
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
