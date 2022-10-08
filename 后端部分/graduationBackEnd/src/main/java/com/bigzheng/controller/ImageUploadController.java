package com.bigzheng.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import java.io.File;

/**
 * 图片上传Controller
 */
@Controller
public class ImageUploadController {

    @Value("${tencent.path}")
    private String IMAGE_PATH;

//    @Autowired
//    private UserInfoService userInfoService;

    /**
     * 上传头像
     */
    @RequestMapping("/upload")
    @ResponseBody
    public String upload(MultipartFile multipartFile,String username) throws Exception {
        System.out.println("======================================");
        System.out.println("传入文件:"+multipartFile);
        System.out.println("username:"+username);
//        System.out.println("model:"+model);
        System.out.println("======================================");

        //获取文件的名称
        String fileName = multipartFile.getOriginalFilename();

        System.out.println("======================================");
        System.out.println("文件的名称:"+fileName);
        System.out.println("======================================");

        //判断有无后缀
        if (fileName.lastIndexOf(".") < 0)
//            return new ForumResult(500, "上传图片格式不正确", null);
            return "上传图片格式不正确";

        //获取文件后缀
        String prefix = fileName.substring(fileName.lastIndexOf("."));

        //如果不是图片
        if (!prefix.equalsIgnoreCase(".jpg") && !prefix.equalsIgnoreCase(".jpeg") && !prefix.equalsIgnoreCase(".svg") && !prefix.equalsIgnoreCase(".gif") && !prefix.equalsIgnoreCase(".png")) {
//            return new ForumResult(500, "上传图片格式不正确", null);
            return "上传图片格式不正确";
        }

        //使用uuid作为文件名，防止生成的临时文件重复
        final File excelFile = File.createTempFile("imagesFile-" + System.currentTimeMillis(), prefix);
        //将Multifile转换成File
        multipartFile.transferTo(excelFile);

        //调用腾讯云工具上传文件
        String imageName = TencentCOS.uploadfile(excelFile, "avatar");

        System.out.println("======================================");
        System.out.println("调用腾讯云工具上传文件:"+imageName);
        System.out.println("======================================");
        System.out.println("最终的路径");
        System.out.println("https://testdemo01-1307738235.cos.ap-nanjing.myqcloud.com/"+imageName);

        //程序结束时，删除临时文件
        deleteFile(excelFile);

        //存入图片名称，用于网页显示
//        model.addAttribute("imageName", imageName);

        //更新数据库
//        userInfoService.updateUserAvatar(imageName, username);

        //返回成功信息
//        return new ForumResult(200, "头像更换成功", imageName);
        return imageName;
    }

    /**
     * 删除临时文件
     *
     * @param files 临时文件，可变参数
     */
    private void deleteFile(File... files) {
        for (File file : files) {
            if (file.exists()) {
                file.delete();
            }
        }
    }

}
