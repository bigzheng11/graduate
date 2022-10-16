package com.bigzheng.controller;
import com.bigzheng.entity.Video;
import com.bigzheng.service.VideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import java.io.File;
/**
 * 视频上传接口
 */
@Controller
@RequestMapping("/video")
public class VideoUploadController {
    @Autowired
    private VideoService videoService;

    @RequestMapping("/upload")
    @ResponseBody
    public String upload(MultipartFile multipartFile,Long goodsID) throws Exception {
        System.out.println("======================================");
        System.out.println("传入文件:"+multipartFile);
        System.out.println("goodsID:"+goodsID);
        System.out.println("======================================");

        //获取文件的名称
        String fileName = multipartFile.getOriginalFilename();

        System.out.println("======================================");
        System.out.println("文件的名称:"+fileName);
        System.out.println("======================================");

        //判断有无后缀
        if (fileName.lastIndexOf(".") < 0)
//            return new ForumResult(500, "上传图片格式不正确", null);
            return "上传格式不正确";

        //获取文件后缀
        String prefix = fileName.substring(fileName.lastIndexOf("."));

        //如果不是图片
        if ( !prefix.equalsIgnoreCase(".gif") &&  !prefix.equalsIgnoreCase(".mp4")) {
//            return new ForumResult(500, "上传图片格式不正确", null);
            return "上传视频格式不正确";
        }

        //使用uuid作为文件名，防止生成的临时文件重复
        final File excelFile = File.createTempFile("imagesFile-" + System.currentTimeMillis(), prefix);
        //将Multifile转换成File
        multipartFile.transferTo(excelFile);

        //调用腾讯云工具上传文件
        String videoName = TencentCOS.uploadfile(excelFile, "视频");

        System.out.println("======================================");
        System.out.println("调用腾讯云工具上传文件:"+videoName);
        System.out.println("======================================");
        System.out.println("最终的路径");
        String videoUrl="https://testdemo01-1307738235.cos.ap-nanjing.myqcloud.com/"+videoName;
        System.out.println(videoUrl);

        //程序结束时，删除临时文件
        deleteFile(excelFile);

        //存入图片名称，用于网页显示
//        model.addAttribute("imageName", imageName);

        /*
        更新数据库
        * */
        Video video=new Video();
        video.setGoodsID(goodsID);
        video.setVideo(videoUrl);
        videoService.addVideo(video);
        //返回成功信息
//        return new ForumResult(200, "头像更换成功", imageName);
        return videoName;
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