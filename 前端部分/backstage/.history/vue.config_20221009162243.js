const { defineConfig } = require("@vue/cli-service");
module.exports = defineConfig({
    transpileDependencies: true,
    devServer: {
        // port: "8686", // 设置端口号
        proxy: {
            //设置代理，进行跨域
            "/api": {
                //↓目标路径
                target: "http://localhost:8081/", //匹配到要代理的上下文后，将上下
                //文前面的地址替换为此代理地址
                changeOrigin: true, //是否跨域
                pathRewrite: {
                    "^/api": "", //拦截到的上下文重写，这里可以将 elm 重写为空或者其它值，
                    //因为我不需要重写，所以这里这么配置。
                },
            },
        },
    },
});
