package com.bigzheng.mapper;

import com.bigzheng.common.R;
import com.bigzheng.entity.Collect;
import com.bigzheng.entity.Message;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Mapper
@Repository
public interface MessageMapper {

    //「所有列表」根据goodsID获得所有留言
    @Select("SELECT * from message where goodsID = #{goodsID}")
    List<Message> getAllMessage(Long goodsID);

    //「修改」修改留言点赞数
    @Update("update message set favour=#{favour} where messageID=#{messageID}")
    int updateFavour(Message message);

    // 「新增」 新增留言
    @Insert("insert into message values (null ,#{toMessageID},#{goodsID},#{userID},#{message},null,0,#{parentTop})")
    @Options(useGeneratedKeys = true,keyProperty = "messageID")
    int addMessage(Message message);
}
