package com.bigzheng.service.Impl;
import com.bigzheng.entity.Picture;
import com.bigzheng.mapper.PictureMapper;
import com.bigzheng.service.PictureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class PictureServiceImpl implements PictureService {
    @Autowired
    private PictureMapper pictureMapper;

    @Override
    public List<Picture> getAllPicture(Long goodsID) {
        return pictureMapper.getAllPicture(goodsID);
    }

    @Override
    public int addPicture(Picture picture) {
        return pictureMapper.addPicture(picture);
    }
}
