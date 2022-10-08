package com.bigzheng.mapper;

import com.bigzheng.entity.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface UserMapper {
    //根据userID查询该用户信息
    @Select("SELECT * from `user` where userID = #{userID}")
    public User getUserByUserId(Long userID);

    //「注册」新增用户信息
    @Insert("insert into `user` values (#{userID},#{password},#{userName},#{userSex},#{userImg})")
    public int saveUser(User user);

    //「更新」根据user更新用户信息
    @Update("update `user` set password=#{password},userName=#{userName},userImg=#{userImg} where userID=#{userID}")
    public int updateUser(User user);
}
