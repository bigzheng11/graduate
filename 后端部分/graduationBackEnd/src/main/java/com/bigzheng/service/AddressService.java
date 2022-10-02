package com.bigzheng.service;
import com.bigzheng.entity.Address;
import java.util.List;

public interface AddressService {

    //根据userID获得所有收货地址
    public List<Address> getAllAddress(Long userID);

    //「更新」根据addressID修改收货地址
    public int updateAddress(Address address);

    //「增加」根据userID新增收货地址
    public int addAddress(Address address) ;
}
