<template>
   <div>


      <!-- 顶部-用户信息展示 -->
      <div class="topDiv" ref="topDiv" @touchmove.prevent>
         <span
            title="注销"
            v-show="isShowDelete"
            @click="deleteUser"
            style="
               position: absolute;
               margin: 10px 0px 0px 20px;
               cursor: pointer;
            "
            ><i
               class="el-icon-warning-outline"
               style="font-size: 37px; color: red"
            ></i>
         </span>

         <div class="userImg">
            <el-upload
               class="avatar-uploader"
               action="http://47.101.196.82:8988/elm/user/update"
               :data="{ userId: user.userId }"
               :show-file-list="false"
               :on-success="handleAvatarSuccess"
               :before-upload="beforeAvatarUpload"
            >
               <img
                  v-if="user.userImg"
                  :src="user.userImg"
                  class="avatar"
                  style="border-radius: 60px"
               />
               <i v-else class="el-icon-plus avatar-uploader-icon"></i>
            </el-upload>
         </div>

         <div class="userDetail">
            <h2>{{ user.username }}</h2>
            <br />
            <h5 @click="toAddAddress()">
               {{
                  deliveryAddress.address == null
                     ? "没有设置默认地址"
                     : deliveryAddress.address
               }}
            </h5>
         </div>

         <div class="toDown" title="点击修改信息">
            <i
               class="el-icon-edit"
               ref="toDownLogo"
               @click="toDown"
               style="font-size: 200%; color: azure"
            ></i>
         </div>
      </div>

      <!-- --------------修改用户信息-------------- -->
      <!-- 表单提交 -->
      <div class="updataDetail">
         <div class="changeDetailPointOut">
            <el-button-group>
               <el-button type="primary"
                  >修改个人信息<i class="el-icon-arrow-right el-icon--right"></i
               ></el-button>
            </el-button-group>
         </div>
         <el-form
            :model="ruleForm"
            status-icon
            :rules="rules"
            ref="ruleForm"
            label-width="100px"
            class="demo-ruleForm"
            style="margin: 30px 0px 0px 0px"
         >
            <!-- 修改密码 -->
            <el-form-item label="原密码" prop="password">
               <el-input
                  type="password"
                  v-model="ruleForm.password"
                  autocomplete="off"
                  style="width: 230px"
               ></el-input>
            </el-form-item>

            <!-- 确认修改密码 -->
            <el-form-item label="新密码" prop="checkPass">
               <el-input
                  type="password"
                  v-model="ruleForm.checkPass"
                  autocomplete="off"
                  style="width: 230px"
               ></el-input>
            </el-form-item>

            <!-- 修改用户名 -->
            <el-form-item label="用户名" prop="name">
               <el-input
                  v-model.number="ruleForm.name"
                  style="width: 230px"
               ></el-input>
            </el-form-item>
            <el-form-item>
               <el-button type="primary" @click="submitForm('ruleForm')"
                  >确认修改</el-button
               >
               <el-button @click="resetForm('ruleForm')">重置</el-button>
            </el-form-item>
         </el-form>
      </div>


<!-- ------------------------------------------------------------ -->

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
            action="api/saveimg"
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