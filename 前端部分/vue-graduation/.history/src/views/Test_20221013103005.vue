   <template>
   <div class="map-container relative">
      <div class="status-bar">
         <div
            class="status-item"
            v-for="(item, index) in statusArr"
            :key="index"
         >
            <img :src="item.icon" />
            {{ item.text }}
         </div>
      </div>
      <!--      :map-style="mapStyle"-->
      <baidu-map
         class="map"
         :center="markerPoint"
         :scroll-wheel-zoom="true"
         :zoom="16"
         :mapClick="false"
         @ready="handler"
      >
         <bm-marker
            v-for="marker in deviceList"
            :icon="markerIcon(marker)"
            :key="marker.id"
            :position="{ lng: +marker.longitude, lat: +marker.latitude }"
            @mouseover="infoWindowOpen(marker)"
            @mouseout="infoWindowClose"
         >
         </bm-marker>
         <bm-info-window
            :show="show"
            :offset="{ width: -20, height: 10 }"
            :position="{ lng: +marker.longitude, lat: +marker.latitude }"
         >
            <div>
               <div class="info-title">详情</div>
               <div class="info-content">
                  <div>
                     回收机编号：<span>{{ marker.oid }}</span>
                  </div>
                  <div>
                     回收机名称：<span>{{ marker.name }}</span>
                  </div>
                  <div>
                     地址：<span>{{ marker.address }}</span>
                  </div>
                  <div>
                     负责人：<span>{{ marker.manager }}</span>
                  </div>
                  <div>
                     电话：<span>{{ marker.managerPhone }}</span>
                  </div>
               </div>
            </div>
         </bm-info-window>
      </baidu-map>
   </div>
</template>

<script>
import { getDeviceMap } from "@/api";
import kuaiman from "../assets/imgs/kuaiman-icon.png";
import weiman from "../assets/imgs/weiman-icon.png";
import yiman from "../assets/imgs/yiman-icon.png";
const styleJson = require("./mapStyle.json");
export default {
   data() {
      return {
         statusArr: [
            {
               icon: weiman,
               text: "未满",
            },
            {
               icon: kuaiman,
               text: "快满",
            },
            {
               icon: yiman,
               text: "已满",
            },
         ],
         marker: {},
         deviceList: [],
         markerPoint: { lng: 120.90102, lat: 31.986646 },
         show: false,
         // mapStyle: {    //自定义地图样式
         //   // styleJson
         // }
      };
   },
   created() {
      getDeviceMap({}).then((res) => {
         this.deviceList = res.data;
      });
   },
   methods: {
      handler({ BMap, map }) {},
      infoWindowClose() {
         this.show = false;
      },
      infoWindowOpen(marker) {
         this.marker = Object.assign(marker);
         this.show = true;
      },
      markerIcon(marker) {
         let img =
            marker.over == 2 ? kuaiman : marker.over == 1 ? yiman : weiman;
         return { url: img, size: { width: 28, height: 42 } };
      },
   },
};
</script>

<style lang="less" scoped>
.map-container {
   width: 100%;
   height: calc(100vh - 124px);
   .map {
      width: 100%;
      height: 100%;
   }
}
/deep/ .info-title {
   color: #333;
   font-size: 16px;
   font-weight: 600;
   line-height: 48px;
   width: 100%;
   border-bottom: 1px solid #dedede;
   background: #fff;
   text-indent: 20px;
}
/deep/ .info-content {
   min-height: 120px;
   background: #fff;
   color: #333;
   font-size: 14px;
   padding: 20px;
   div {
      line-height: 2;
      color: #666;
      span {
         color: #333;
      }
   }
}

/deep/ .BMap_bottom {
   display: none;
}
/deep/ .BMap_pop {
   > div,
   > img:nth-child(10) {
      display: none;
      overflow: unset;
   }
   > div:nth-child(9) {
      display: block;
      overflow: unset;
      width: 340px !important;
   }
   > div:nth-child(8) {
      /*display: block;*/
   }
   .BMap_top {
      display: none;
   }
   .BMap_center {
      background: transparent;
      border: none;
      position: sticky !important;
      height: 100%;
   }
}

/deep/ .BMap_bubble_content {
   background: rgba(0, 0, 0, 0.5);
   border-radius: 8px;
}
/deep/ .BMap_shadow {
   display: none;
}
.status-bar {
   position: absolute;
   display: flex;
   left: 20px;
   top: 10px;
   z-index: 99;
   width: 400px;
   justify-content: space-between;
   padding: 7px 20px;
   box-sizing: border-box;
   height: 44px;
   box-shadow: 0px 2px 3px 0px rgba(51, 51, 51, 0.22);
   border-radius: 4px;
   background: #fff;
   opacity: 0.8;
   .status-item {
      font-size: 14px;
      color: #010101;
      img {
         width: 18px;
         height: 30px;
         vertical-align: middle;
         margin-right: 6px;
      }
   }
}
</style>
