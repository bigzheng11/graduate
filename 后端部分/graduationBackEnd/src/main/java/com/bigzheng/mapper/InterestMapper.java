package com.bigzheng.mapper;
import com.bigzheng.entity.Interest;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;
import java.util.List;

@Mapper
@Repository
public interface InterestMapper {

    //获取最喜欢的前8个类型,分数从大到小排列
    @Select("select goodsClassify,grade from interest where userID=#{userID} order by grade desc LIMIT  6")
    List<Interest> topSixInterest(Long userID);

}
