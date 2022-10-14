<template>
   <div class="container">
      <!-- ------------------------------------------------------------ -->
      <!-- 顶部-用户信息展示 -->
      <!-- ------------------------------------------------------------ -->
      <div class="topDiv" ref="topDiv" @touchmove.prevent>
         <!-- 注销部分 -->
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
               :data="{ userID: user.userID }"
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
            <h2>{{ user.userName }}</h2>
            <br />
            <h5 @click="toAddress">
               {{
                  addressDefault == null
                     ? "没有设置默认地址"
                     : addressDefault
               }}(点击修改)
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

      <!-- --------------------------------------------- -->
      <!-- --------------修改用户信息-------------- -->
      <!-- --------------------------------------------- -->
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
            <!-- 原密码 -->
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

      <!-- --------------------------------------------- -->
      <!-- ------------------swiper轮播图------------------- -->
      <!-- --------------------------------------------- -->
      <el-divider content-position="center">我的售卖</el-divider>
      <div class="box" @mouseenter="swiper_enter" @mouseleave="swiper_leave">
         <div
            class="swiper-button-prev swiper-button-prev2"
            style="position: relative; top: 80px"
         ></div>
         <swiper ref="swiper" :options="options">
            <swiper-slide
               v-for="(item, index) in goodsList"
               :key="item.goodsID"
               style="margin: -10px"
            >
               <el-col :span="21">
                  <el-card shadow="always">
                     <!-- <div style="width:100%;height:150px;overflow:hidden"> -->
                     <p class="ziti">
                        {{ item.goodsName }}
                     </p>
                     <img
                        v-for="(item2, index) in item.picList.slice(0, 1)"
                        :key="index"
                        :src="item2.picture"
                        alt=""
                        style="
                           width: 100px;
                           height: 100px;
                           border-radius: 10px;
                           margin-left: -13px;
                        "
                     />
                     <!-- </div> -->
                  </el-card>
               </el-col>

               <!-- <div class="card">
                  <img
                     :src="item.picList[0].picture"
                     alt=""
                     style="width: 100px; height: 100px; border-radius: 10px"
                  />
                  <h4>
                     {{ item.goodsName }}
                  </h4>
               </div> -->
            </swiper-slide>
         </swiper>
         <div
            class="swiper-button-next swiper-button-next2"
            style="position: relative; left: 90vw; top: -66px"
         ></div>
      </div>

      <!-- ------------------------------------------------------------ -->
      <!-- --------------------------collectList---------------------------------- -->
      <!-- ------------------------------------------------------------ -->
      <el-divider content-position="center">我的收藏</el-divider>
      <div
         class="collectList"
         v-for="item in collectList"
         :key="item.collectID"
         style="margin: 0 0 10px 4px; border-radius: 10px; position: relative"
         @click="toGoodsDetail(item.goodsID)"
      >
         <el-card shadow="never" style="border-radius: 10px">
            <!-- 商品名 -->
            <span
               class="collectName"
               style="position: relative; top: 10px; left: 10px"
               v-for="(item2, index) in item.goods"
               :key="index"
            >
               <h4 v-show="index == 'goodsName'">{{ item2 }}</h4>
            </span>
            <!-- 购买数量 -->
            <!-- 购买时间 -->
            <!-- <div
               class="userComment"
               style="
                  position: absolute;
                  left: 20px;
                  bottom: 10px;
                  font-size: 11px;
               "
            >
               2022-10-7,12:00
            </div> -->
         </el-card>
      </div>
      <el-divider content-position="center">我的历史订单</el-divider>
      <!-- <div v-for="item in orderList" :key="item.orderID">
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
      </div> -->

      <!-- <div class="userImg">
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
      </div> -->

      <!-- -----------------历史订单------------ -->
      <div
         class="historyOrder"
         v-for="item in orderList"
         :key="item.orderID"
         style="margin: 0 0 10px 4px; border-radius: 10px; position: relative"
         @click="toGoodsDetail(item.goodsID)"
      >
         <el-card shadow="never" style="border-radius: 10px">
            <!-- 商品图片 -->
            <img
               :src="item.picList[0].picture"
               alt=""
               style="height: 74px; border-radius: 10px; position: relative"
            />
            <!-- 商品名 -->
            <span
               class="orderName"
               style="position: relative; top: -60px; left: 10px"
            >
               {{ item.goodsName }}
            </span>
            <!-- 购买数量 -->
            <span style="position: absolute; top: 50px; right: 20px">
               实际付款数量:{{ item.quantity }}
            </span>
            <!-- 购买时间 -->
            <div
               class="userComment"
               style="
                  position: absolute;
                  left: 20px;
                  bottom: 10px;
                  font-size: 11px;
               "
            >
               2022-10-7,12:00
            </div>
            <button style="position: absolute; right: 20px; bottom: 10px">
               交易成功
            </button>
         </el-card>
      </div>
   </div>
</template>

<script>
import "swiper/css/swiper.css";
import { Swiper, SwiperSlide } from "vue-awesome-swiper";
export default {
   name: "demo",
   data() {
      //修改信息,的检查规则----------Element-Ui自带---------
      const checkAge = (rule, value, callback) => {
         if (!value) {
            return callback(new Error("用户名不能为空"));
         }
      };
      const validatePass = (rule, value, callback) => {
         if (value === "") {
            callback(new Error("请输入原密码"));
         } else {
            if (this.ruleForm.checkPass !== "") {
               this.$refs.ruleForm.validateField("checkPass");
            }
            //检查原密码是否正确
            this.$axios
               .post(
                  "api/user/login",
                  this.$qs.stringify({
                     userID: this.user.userID,
                     password: this.ruleForm.password,
                  })
               )

               .then((response) => {
                  if (response.data.code != 1) {
                     this.open3();
                     this.ruleForm.password == " ";
                     this.resetForm("ruleForm");
                  }
               })
               .catch((error) => {
                  console.log(error);
               });
            callback();
         }
      };
      const validatePass2 = (rule, value, callback) => {
         if (value === "") {
            callback(new Error("请输入新密码"));
         } else {
            callback();
         }
      };

      return {
         //-----------滑动组件swipere---------------
         options: {
            pagination: {
               el: ".case-swiper-pagination",
               //区分不同Swiper的组件
            },
            //显示分页
            loop: false,
            //开启循环
            loopedSlides: 6,
            //设置平滑
            slidesPerView: 3,
            //设置能够同时显示的数量（可设置 auto）
            speed: 1000,
            //切换速度

            navigation: {
               prevEl: ".swiper-button-prev2",
               nextEl: ".swiper-button-next2",
            },
            //左右箭头按钮(可自定义)

            // autoplay: false,
            //是否开启自动轮播

            autoplay: {
               delay: 1000,
               stopOnLastSlide: false,
               disableOnInteraction: false,
            },
            // 开启自动轮播后，设置自动轮播的延迟时间
            loopAdditionalSlides: 1,
            //复制若干个slide
            // slidesPerGroup: 3,
            // 定义slides的数量多少为一组，即每次切换slides的数量，默认每次切换一张
            on: {
               slideChangeTransitionEnd: function () {
                  // console.log(this.activeIndex);
                  //获取当前下标，切换结束时，告诉我现在是第几个slide
               },
            },
         },
         // -------------滑动组件swiper----------------------

         //注销图标是否显示
         isShowDelete: true,

         //修改信息
         ruleForm: {
            password: "",
            checkPass: "",
            age: "",
         },
         rules: {
            password: [{ validator: validatePass, trigger: "blur" }],
            checkPass: [{ validator: validatePass2, trigger: "blur" }],
            age: [{ validator: checkAge, trigger: "blur" }],
         },

         user: "",
         addressList: [],
         addressDefault: {},

         newData: {
            userName: "",
            password: "",
         },

         goodsList: [],
         orderList: [],
         collectList: [],
      };
   },
   computed: {
      swiper() {
         return this.$refs.swiper.$swiper;
      },
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
                  if (
                     this.$qs.parse(window.sessionStorage.getItem("userinfo"))
                        .addressDefault == ""
                  ) {
                     this.addressDefault = iterator.provinceCity+iterator.addressDetail;
                  }
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
      this.$axios
         .get("api/collect/getall/" + this.user.userID)
         .then((response) => {
            this.collectList = response.data.data.collectList;
            console.log("收藏列表collectList:------>", this.collectList);
         })
         .catch((error) => {
            console.log(error);
         });
   },

   methods: {
      // 跳转到商品详情页面
      toGoodsDetail(goodsID) {
         this.$router.push({
            path: "/goodsdetail",
            query: {
               goodsID: goodsID,
            },
         });
      },

      //轮播图swiper方法
      swiper_enter() {
         this.swiper.autoplay.stop();
      },
      //鼠标悬停停止swiper自动轮播
      swiper_leave() {
         this.swiper.autoplay.start();
      },
      //鼠标移出开启swiper自动轮播

      //用户注销事件
      deleteUser() {
         if (confirm("确定要注销吗")) {
            // localStorage.clear();
            // sessionStorage.clear();
            // this.$router.go(0);
            alert("用户已经注销");
         } else {
            return;
         }
      },

      //警告提示
      open3() {
         this.$message({
            message: "您的密码不正确",
            type: "warning",
         });
      },

      //弹窗提示
      open1() {
         this.$notify({
            title: "修改成功",
            message: "您的用户信息已更新",
            type: "success",
         });
      },

      //到底提示
      openCenter() {
         this.$message({
            message: "到底了",
            center: true,
         });
      },

      //未添加地址提示
      open4() {
         this.$message.error("您尚未添加默认地址");
      },

      //修改个人信息
      submitForm(formName) {
         this.$refs[formName].validate((valid) => {
            if (valid) {
               //删除elementui中form表单自带的对象属性
               delete this.ruleForm.age;
               this.ruleForm.checkPass;

               console.log("this.ruleForm.password:", this.ruleForm.checkPass);
               this.$axios({
                  url: "api/user/update",
                  method: "POST",
                  headers: {
                     "content-type": "application/x-www-form-urlencoded",
                  }, //修改请求头,成为form表单提交
                  data: this.$qs.stringify({
                     userID: this.user.userID,
                     password: this.ruleForm.checkPass,
                     userName: this.ruleForm.name,
                  }),
               })
                  .then((response) => {
                     if (response.data.code === 1) {
                        if (this.ruleForm.name != 0) {
                           //更新信息
                           this.user.userName = this.ruleForm.name;
                           window.sessionStorage.setItem(
                              "userinfo",
                              this.$qs.stringify(this.user)
                           );
                        }
                        //清空输入框
                        this.resetForm("ruleForm");
                        //弹窗 和 动画效果
                        this.open1();
                        this.toDown();
                     }
                  })
                  .catch((error) => {
                     console.log(error);
                  });
            } else {
               console.log("error submit!!");
               return false;
            }
         });
      },

      resetForm(formName) {
         this.$refs[formName].resetFields();
      },

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

      //用户信息下滑动画
      toDown() {
         //获取DOM元素
         let topDivRef = this.$refs.topDiv;
         let toDownLogoRef = this.$refs.toDownLogo;
         // 给他添加过度动画,all全部添加,1s动画持续1s
         topDivRef.style.transition = "all 1s";

         //在上方时:
         if (toDownLogoRef.getAttribute("class") === "el-icon-edit") {
            // 根据clss名判断位置
            this.isShowDelete = false;
            topDivRef.style.transform = "translateY(80%)";
            topDivRef.style.borderRadius = "60px 60px 0px 0px";
            toDownLogoRef.setAttribute("class", "el-icon-caret-top");
            topDivRef.style.height = "52vh";
            topDivRef.style.backgroundPosition = "40% 60%";

            document.getElementsByClassName("container")[0].style.overflow =
               "hidden";
         } else {
            this.isShowDelete = true;
            //在下方时,
            topDivRef.style.transform = "translateY(0%)";
            topDivRef.style.borderRadius = "0px 0px 60px 60px";
            toDownLogoRef.setAttribute("class", "el-icon-edit");
            topDivRef.style.backgroundPosition = "20% 20%";
            topDivRef.style.height = "46vh";
            document.getElementsByClassName("container")[0].style.overflow =
               "auto";
         }
      },

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
         this.$router.push("/AddressList");
      },
   },

   components: { Swiper, SwiperSlide },
};
</script>

<style scoped>
/* 总视口大小 */
.container {
   position: relative;
   height: 93vh;
   overflow: scroll;
   background-color: #f2f3f5;
}
h2 {
   cursor: pointer;
}

/* 用户展示区部分 */
.topDiv {
   z-index: 100;
   position: absolute;
   background-image: url("../assets/渐变蓝背景.jpg");
   background-position: 20% 20%;
   width: 100vw;
   height: 46vh;
   top: 0px;

   box-shadow: rgba(0, 0, 0, 0.4) 0px 2px 4px,
      rgba(0, 0, 0, 0.3) 0px 7px 13px -3px,
      rgba(0, 0, 0, 0.2) 0px -3px 0px inset;

   border-radius: 0px 0px 60px 60px;
}
.topDiv .userImg {
   position: relative;
   width: 90px;
   border-radius: 100%;
   top: 20%;
   left: 28%;
}
.topDiv .userDetail {
   position: relative;
   top: 20%;
   left: 32%;
   max-width: 40vw;
}

.toDown {
   position: absolute;
   top: 20px;
   right: 20px;
   cursor: pointer;
}

/* 修改用户信息部分 */
.changeDetailPointOut {
   position: absolute;
   left: 0%;
   top: 2%;
}
.updataDetail {
   margin-top: 20%;
   height: 40vh;
}

.avatar-uploader .el-upload {
   border: 1px dashed #d9d9d9;
   border-radius: 6px;
   cursor: pointer;
   position: relative;
   overflow: hidden;
}
.avatar-uploader .el-upload:hover {
   border-color: #409eff;
}
.avatar-uploader-icon {
   font-size: 28px;
   color: #8c939d;
   width: 178px;
   height: 178px;
   line-height: 178px;
   text-align: center;
}
.avatar {
   width: 178px;
   height: 178px;
   display: block;
}
#testImg {
   position: absolute;
   z-index: 122;
}
.ziti {
   font-family: "Helvetica Neue", Helvetica, "PingFang SC", "Hiragino Sans GB",
      "Microsoft YaHei", "微软雅黑", Arial, sans-serif;
   font-size: 13px;
}
/* 评论 */
.historyOrder {
   width: 98vw;
   box-shadow: rgba(0, 0, 0, 0.4) 0px 2px 4px,
      rgba(0, 0, 0, 0.3) 0px 7px 13px -3px,
      rgba(0, 0, 0, 0.2) 0px -3px 0px inset;
}

.collectList {
   width: 98vw;
   box-shadow: rgba(0, 0, 0, 0.4) 0px 2px 4px,
      rgba(0, 0, 0, 0.3) 0px 7px 13px -3px,
      rgba(0, 0, 0, 0.2) 0px -3px 0px inset;
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