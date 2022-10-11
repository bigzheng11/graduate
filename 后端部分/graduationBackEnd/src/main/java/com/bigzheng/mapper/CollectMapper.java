package com.bigzheng.mapper;
import com.bigzheng.entity.Collect;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;
import java.util.List;

@Mapper
@Repository
public interface CollectMapper {

    //「所有列表」根据userID获得所有收藏
    @Select("SELECT * from collect where userID = #{userID}")
    List<Collect> getAllCollect(Long userID);

    //「添加」 根据传入对象添加收藏
    @Insert("insert into collect values (null ,#{userID},#{goodsID},1)")
    @Options(useGeneratedKeys = true,keyProperty = "collectID")
    int addCollect(Collect collect);

    //「修改」修改收藏状态
    @Update("update collect set  isCollect = #{isCollect} where userID=#{userID} and goodsID=#{goodsID}")
    int changeIsCollect(Collect collect);

}
