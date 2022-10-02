package com.bigzheng.service.Impl;
import com.bigzheng.entity.Video;
import com.bigzheng.mapper.VideoMapper;
import com.bigzheng.service.VideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;

/**
 * (Video)表服务实现类
 *
 * @author makejava
 * @since 2022-09-26 11:07:33
 */
@Service
public class VideoServiceImpl implements VideoService {
    @Autowired
    private VideoMapper videomapper;

    //「根据goodsID」获取视频
    @Override
    public Video getAllvideo(Long goodsID) {
        return videomapper.getAllvideo(goodsID);
    }
}
