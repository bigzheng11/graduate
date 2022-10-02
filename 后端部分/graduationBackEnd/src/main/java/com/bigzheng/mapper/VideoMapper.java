package com.bigzheng.mapper;

import com.bigzheng.entity.Picture;
import com.bigzheng.entity.Video;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface VideoMapper {

    //「根据goodsID」获取视频
    @Select("SELECT * from `video` where goodsID = #{goodsID}")
    Video getAllvideo(Long goodsID);
}
