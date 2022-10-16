      <template>
   <div class="container">
      <Back></Back>
      <br />
      <br />
      <br />
      <br />
      <br />
      <br />
      <h2>--后面数量++</h2>

      <h1>购买商品页面</h1>
      <van-popup
         v-model="show"
         round
         position="bottom"
         :style="{ height: '30%' }"
         @close="close"
         >!!!!!恭喜你购买成功!!!!!!</van-popup
      >
      <van-button type="primary" @click="show = !show">确认购买</van-button>
   </div>
</template>


<script>
import Back from "../components/Back.vue";
import { Toast } from "vant";
export default {
   data() {
      return { show: false,
         goodsID: this.$route.query.goodsID,

      };
   },

   created() {},

   methods: {
      close() {
         console.log("跳转回首页");
         Toast("购买成功,跳转回首页");
         // setTimeout(() => { 
         //     this.$router.push("/video")
         //    },1200)
      },
   },

   components: { Back },
};
</script>

<style scoped></style>

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
