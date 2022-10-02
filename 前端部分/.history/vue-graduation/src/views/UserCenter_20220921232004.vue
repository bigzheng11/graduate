<template>
	<div id="index">
		<baidu-map class="map" :center="center" :zoom="zoom" @ready="handler" />
	</div>
</template>

<script>
export default {
	name: 'Index',
	components: {},
	data() {
		return {
			center: { lng: 0, lat: 0 },
			zoom: 0
		}
	},
	created() {},
	mounted() {},
	methods: {
		handler({ BMap, map }) {
			console.log(BMap, map)
			this.center.lng = 121.487899486
			this.center.lat = 31.24916171
			this.zoom = 15
		}
	}
}
</script>

<style  scoped>
.map{
	width: 500px;
	height: 500px;
}
</style>
