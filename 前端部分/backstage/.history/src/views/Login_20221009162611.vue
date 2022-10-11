<template>
    <el-row>
       <el-col :xl="6" :lg="7">
          <div class="login-form">
             <h2>欢迎使用VueAdmin后台管理系统</h2>
             <el-image
                style="width: 130px; height: 130px"
                :src="require('@/assets/logo.jpg')"
             ></el-image>
             <p>科文学院毕业设计</p>
             <p>Vue+SpringBoot后台权限管理系统V1.0</p>
          </div>
       </el-col>
       <el-col :span="1">
          <el-divider direction="vertical"></el-divider>
       </el-col>
       <el-col :xl="6" :lg="7">
          <!-- ref="loginForm"就相当于  id="loginForm"  -->
          <el-form
             :model="loginForm"
             label-position="right"
             :rules="rules"
             label-width="80px"
             ref="loginForm"
          >
             <el-form-item label="用户名" style="width: 380px" prop="username">
                <el-input v-model="loginForm.username"></el-input>
             </el-form-item>
 
             <el-form-item label="密码" style="width: 380px" prop="password">
                <el-input
                   type="password"
                   v-model="loginForm.password"
                ></el-input>
             </el-form-item>
 
             <el-form-item
                label="验证码"
                style="width: 380px"
                prop="captchaCode"
             >
                <el-input
                   v-model="loginForm.captchaCode"
                   maxlength="5"
                   style="width: 170px; float: left"
                ></el-input>
                <!-- <el-image
                   class="captchaImg"
                   :src="captchaImg"
                   @click="getChaptcha()"
                ></el-image> -->
             </el-form-item>
 
             <el-form-item>
                <el-button type="primary" @click="SubmitForm('loginForm')"
                   >登录</el-button
                >
                <el-button>取消</el-button>
             </el-form-item>
          </el-form>
       </el-col>
    </el-row>
 </template>
 
 <script type="text/javascript">
 export default {
    name: "Login",
    data() {
       return {
          //验证码图片base64编码字符串
          captchaImg: "",
          //登录的用户信息对象
          loginForm: {
             username: "",
             password: "",
             key: "",
             captchaCode: "",
          },
          rules: {
             username: [
                { required: true, message: "请输入用户名", trigger: "blur" },
             ],
             password: [
                { required: true, message: "请输入密码", trigger: "blur" },
             ],
             captchaCode: [
                { required: true, message: "请输入验证码", trigger: "blur" },
                {
                   min: 5,
                   max: 5,
                   message: "验证码长度必须为5个字符",
                   trigger: "blur",
                },
             ],
          },
       };
    },
    methods: {
       //点击验证码，刷新验证码的图片
    //    getChaptcha() {
    //       this.$axios.get("/captcha").then((response) => {
    //          console.log("返回的验证码信息:", response);
    //          console.log(response.data);
    //          this.loginForm.key = response.data.data.key;
    //          this.captchaImg = response.data.data.captchaImg;
    //       });
    //    },
       //提交登录表单方法  formName传递过来 loginForm   this.$refs[formName]获得ref='loginForm'这个元素
       SubmitForm(formName) {
          this.$refs[formName].validate((valid) => {
             if (valid) {
                this.$axios
                   .post("/login?" + this.$qs.stringify(this.loginForm)) //  http://localhost/login?username=XXX&password=XXX
                   .then((response) => {
                      console.log(response.data);
                      //token通过response的头信息返回的   key:value   token:'yeqwuyeuiwqyuieywqiueyiuqwyeiwqyeui'
                      console.log(response.headers);
                      const jwt = response.headers["token"]; //响应的token的数据只能在Java服务器端实现
 
                      //const jwt = 'yeqwuyeuiwqyuieywqiueyiuqwyeiwqyeui' //因为无法写回reponse响应头，手动书写一个token
 
                      //获得jwt存储Vuex中 使用commit调用mutations中的存储token的方法SET_TOKEN
                      this.$store.commit("SET_TOKEN", jwt);
 
                      this.$router.push("/");
                   });
             } else {
                this.getChaptcha();
                console.log("登录提交失败");
                return false;
             }
          });
       },
    },
    created() {
    //    this.getChaptcha(); //生命周期方法 调用获得验证码
    },
 };
 </script>
 
 <style scoped>
 .el-row {
    background: #fafafa;
    height: 100%;
 
    display: flex;
    justify-content: center;
    align-items: center;
    text-align: center;
 }
 .el-divider {
    height: 200px;
 }
 
 .codeImg {
    float: left;
    width: 100px;
    height: 40px;
    margin-left: 8px;
    border-radius: 4px;
 }
 </style>
 