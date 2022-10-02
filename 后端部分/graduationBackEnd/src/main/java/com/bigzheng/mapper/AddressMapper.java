package com.bigzheng.mapper;


import com.bigzheng.entity.Address;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface AddressMapper {

    //根据userID获得所有收货地址
    @Select("SELECT * from address where userID = #{userID}")
     List<Address> getAllAddress(Long userID);

    //「更新」根据addressID修改收货地址
    @Update("update address set address = #{address} where addressID=#{addressID}")
    int updateAddress(Address address);

    //「增加」根据userID新增收货地址
    @Insert("insert into address values (null ,#{userID},#{address})")
    @Options(useGeneratedKeys = true,keyProperty = "addressID")
    int addAddress(Address address) ;
}
