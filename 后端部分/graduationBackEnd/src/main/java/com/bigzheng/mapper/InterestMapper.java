package com.bigzheng.mapper;
import com.bigzheng.entity.Interest;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;
import java.util.List;

@Mapper
@Repository
public interface InterestMapper {

    //获取最喜欢的前8个类型,分数从大到小排列
    @Select("select goodsClassify,grade,interestID from interest where userID=#{userID} order by grade desc LIMIT  10")
    List<Interest> topSixInterest(Long userID);

    //「更新」激励加分-根据userID和goodsClassify,对grade更新
    @Update("update `interest` set grade = grade+#{grade} where userID=#{userID} and goodsClassify=#{goodsClassify}")
    int updateGrade(Interest interest);
}
