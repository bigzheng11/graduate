<template>
   <div>
      <h1>用户信息展示</h1>
      头像
      <img :src="user.userImg" alt="" style="width: 100px" />

      用户名:{{ user.userName }}
      <div style="border: red solid 1px; cursor: pointer" @click="toAddress">
         地址(点击修改):{{ addressDefault.address }}
      </div>
      <hr />
      <h2>更新用户信息</h2>
      <div>
         新用户名:
         <input type="text" v-model="newData.userName" />
      </div>

      <div>
         新密码:
         <input type="text" v-model="newData.password" />
      </div>

      <button @click="updataAxios">确认修改</button>

      <hr />
      <h2>我的售卖</h2>
      <div v-for="item in goodsList" :key="item.goodsID">
         <img
            :src="item.picList[0].picture"
            alt=""
            style="width: 100px; height: 100px"
         />
         <h3>
            {{ item.goodsName }}
         </h3>
         {{ item.goodsDescribe }}
      </div>
      <hr />
      <h2>我的收藏</h2>
      <hr />
      <h2>我的历史订单</h2>
      <div v-for="item in orderList" :key="item.orderID">
         <img
            :src="item.picList[0].picture"
            alt=""
            style="width: 100px; height: 100px"
         />
         <h3>
            {{ item.goodsName }}
         </h3>
         数量:
         {{ item.quantity }}
      </div>

      <hr />
      <div class="userImg">
         <el-upload
            class="avatar-uploader"
            action="http://localhost:8081/message/getall/1"
            :data="{ userId: user.userId }"
            :show-file-list="false"
            :on-success="handleAvatarSuccess"
            :before-upload="beforeAvatarUpload"
         >
            <img
               v-if="user.userImg"
               :src="user.userImg"
               class="avatar"
               style="border-radius: 60px; width: 40px"
            />
            <i v-else class="el-icon-plus avatar-uploader-icon"></i>
         </el-upload>
      </div>
      <hr />
      <div>222</div>
      <div>222</div>
      <div>222</div>
      <div>222</div>
      <div>222</div>
      <div>222</div>
   </div>
</template>

<script>
export default {
   name: "demo",
   data() {
      return {
         user: "",
         addressList: [],
         addressDefault: {},

         newData: {
            userName: "",
            password: "",
         },

         goodsList: [],
         orderList: [],
      };
   },

   created() {
      //获取用户信息:
      this.user = this.$qs.parse(window.sessionStorage.getItem("userinfo"));

      //请求用户地址:
      this.$axios
         .get("api/address/getall/" + this.user.userID)
         .then((response) => {
            this.addressList = response.data.data.addressList;
            for (const iterator of this.addressList) {
               if (iterator.isDefault === 1) {
                  this.addressDefault = iterator;
               }
            }
         })
         .catch((error) => {
            console.log(error);
         });

      //用户历史订单:
      this.$axios
         .get("api/order/getall/" + this.user.userID)
         .then((response) => {
            this.orderList = response.data.data.orderList;
            console.log("orderList:--->", this.orderList);
         })
         .catch((error) => {
            console.log(error);
         });

      //用户售卖历史:
      this.$axios
         .get("api/goods/getall/" + this.user.userID)
         .then((response) => {
            this.goodsList = response.data;
            console.log("this.goodsList:------>", this.goodsList);
         })
         .catch((error) => {
            console.log(error);
         });
      //用户收藏:
   },

   methods: {
      // 图片上传接口

      handleAvatarSuccess(res, file) {
         this.user.userImg = URL.createObjectURL(file.raw);
      },

      beforeAvatarUpload(file) {
         const isJPG = file.type === "image/jpeg";
         const isLt2M = file.size / 1024 / 1024 < 2;

         if (!isJPG) {
            this.$message.error("上传头像图片只能是 JPG 格式!");
         }
         if (!isLt2M) {
            this.$message.error("上传头像图片大小不能超过 2MB!");
         }
         return isJPG && isLt2M;
      },

      //更新用户信息
      updataAxios() {
         this.$axios
            .post(
               "api/user/update",
               this.$qs.stringify({
                  userID: this.user.userID,
                  userName: this.newData.userName,
                  password: this.newData.password,
               })
            )
            .then((response) => {
               console.log("更新用户信息--->", response.data);
            })
            .catch((error) => {
               console.log(error);
            });
      },

      //跳转修改地址
      toAddress() {
         this.$router.push("/address");
      },
   },
};
</script>

<style scoped>
h2 {
   cursor: pointer;
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