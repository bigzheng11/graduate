<template>
   <div class="hello">
     <div id="bmapContainer"></div>
   </div>
 </template>
  
 <script>
 import { lazyBMapApiLoaderInstance } from 'vue-bmap-gl'
 export default {
   data() {
     return {
       position_NKYYGS: {
         Name: '四川省农业科学院',
         address: '成都市锦江区静居寺路20号',
         phoneNumber: '(028)84504011',
         bdLNG: 116.297611,
         bdLAT: 40.047363,
       },
       map: '', //地图实例
       pathArr: [
         // {
         //   lng: 116.297611,
         //   lat: 40.047363,
         // },
         // {
         //   lng: 116.302839,
         //   lat: 40.048219,
         // },
         // {
         //   lng: 116.308301,
         //   lat: 40.050566,
         // },
         // {
         //   lng: 116.305732,
         //   lat: 40.054957,
         // },
         // {
         //   lng: 116.304754,
         //   lat: 40.057953,
         // },
         // {
         //   lng: 116.307223,
         //   lat: 40.056379,
         // },
         // {
         //   lng: 116.306487,
         //   lat: 40.058312,
         // },
       ],
     }
   },
   mounted() {
     this.baidu()
     // lazyBMapApiLoaderInstance.load().then(() => {})
   },
   methods: {
     async baidu() {
       let { data: res } = await this.$http.get('API/DriverPath/GetDirverPath', { params: { driverid: 3 } })
 
       console.log(res.Data.lnglat)
       this.pathArr = res.Data.lnglat
       //  this.$nextTick(() => {
       //         // 初始化地图
       //         this.baiduMap()
       //       })
       lazyBMapApiLoaderInstance.load().then(this.baiduMap())
     },
     // 百度地图
     baiduMap() {
       this.map = new BMapGL.Map('bmapContainer') // 创建Map实例
       // this.map.centerAndZoom(new BMapGL.Point(116.297611, 40.047363), 18) // 初始化地图,设置中心点坐标和地图级别
       this.map.enableScrollWheelZoom(true) // 开启鼠标滚轮缩放
       this.map.addControl(new BMapGL.NavigationControl()) // 添加控件类(平移缩放控件)
       this.map.clearOverlays()
 
       var sContent =
         '<div style="width:300px;"><p style="font-size:16px;font-weight:bold;margin-top: 10px;color:#D07852">' +
         this.position_NKYYGS.Name +
         '</p><p style="font-size:13px;margin: 5px 0;">地址：' +
         this.position_NKYYGS.address +
         '</p><p style="font-size:13px;margin: 5px 0;">电话：' +
         this.position_NKYYGS.phoneNumber +
         '</p><p style="font-size:13px;margin: 5px 0;">坐标：' +
         this.position_NKYYGS.bdLNG +
         ',' +
         this.position_NKYYGS.bdLAT
       ;('</div>')
       // this.map.setMapType(BMAP_EARTH_MAP) // 设置地图类型为地球模式
       var point = new BMapGL.Point(this.position_NKYYGS.bdLNG, this.position_NKYYGS.bdLAT) // 创建点坐标
       var marker = new BMapGL.Marker(point) // 创建标注
       this.map.addOverlay(marker) //添加标注到地图
       this.map.centerAndZoom(point, 18) // 初始化地图，设置中心点坐标和地图级别
 
       // 创建点标记
       var marker = new BMapGL.Marker(point)
       this.map.addOverlay(marker)
       // 创建信息窗口
 
       // // 创建信息窗口
       // var opts = {
       //   width: 200,
       //   height: 100,
       //   title: '故宫博物院',
       // }
       // var infoWindow = new BMapGL.InfoWindow(sContent)
       //  //点击图标时候调用信息窗口
       // marker.addEventListener('click', function () {
       //   this.openInfoWindow(infoWindow)
       //   console.log("点标记")
       // })
 
       var path = []
       path = this.pathArr
 
       var point = []
       for (var i = 0; i < path.length; i++) {
         point.push(new BMapGL.Point(path[i].lng, path[i].lat))
       }
       path.forEach(item => {
         // console.log(item)
         var point = new BMapGL.Point(item.lng, item.lat) // 创建点坐标
         var marker = new BMapGL.Marker(point) // 创建标注
         this.map.addOverlay(marker) //添加标注到地图
         var opts = {
           width: 200,
           height: 100,
           title: '故宫博物院',
         }
         var infoWindow = new BMapGL.InfoWindow('地址：北京市东城区王府井大街88号乐天银泰百货八层', opts)
         // 点击标注开启一个自定义窗口
           marker.addEventListener('click', function () {
           this.openInfoWindow(infoWindow, point)
         })
       })
       //将点坐标练成直线
       var pl = new BMapGL.Polyline(point)
       this.map.addOverlay(new BMapGL.Polyline(point, { strokeColor: 'blue', strokeWeight: 6, strokeOpacity: 0.5 })) //地图类型
     },
   },
 }
 </script>
  
 <style scoped>
 #bmapContainer {
   width: 100%;
   height: 100%;
 }
 </style>
 