<template>
   <div class="container">
      <div
         style="
            display: flex;
            flex-direction: column;
            justify-content: center;
            align-items: center;
         "
      >
         <div style="margin-top:20%">
            <svg
               t="1665887161790"
               class="icon"
               viewBox="0 0 1024 1024"
               version="1.1"
               xmlns="http://www.w3.org/2000/svg"
               p-id="3670"
               width="200"
               height="200"
            >
               <path
                  d="M512 981.333333C252.8 981.333333 42.666667 771.2 42.666667 512S252.8 42.666667 512 42.666667s469.333333 210.133333 469.333333 469.333333-210.133333 469.333333-469.333333 469.333333z m-50.432-326.101333L310.613333 504.32a32 32 0 0 0-45.226666 45.226667l174.72 174.762666a32.341333 32.341333 0 0 0 0.341333 0.341334l0.256 0.213333a32 32 0 0 0 50.048-6.144l337.450667-379.605333a32 32 0 1 0-47.872-42.496l-318.762667 358.613333z"
                  fill="#52C41A"
                  p-id="3671"
               ></path>
            </svg>
         </div>
         <p style="margin-top:7%;font-size: 25px;font-weight: 500;">上传成功</p>
         <h5 style="margin-top:2%;font-size: 25px;font-weight: 500;">稍后将跳转回首页</h5>
      </div>
   </div>
</template>
  
  <script>
export default {
   data() {
      return {};
   },

   created() {},

   methods: {},

   mounted() {
      console.log("跳转回首页");
      // setTimeout(() => {
      //    this.$router.push("/video");
      // }, 1200);
   },
};
</script>
  
  <style scoped>
.container {
   width: 100%;
   height: 100%;
   overflow: auto;
   border: 1px solid palegreen;
   box-sizing: border-box;
}
</style>
 