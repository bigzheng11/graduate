package com.bigzheng.service.Impl;
import com.bigzheng.common.R;
import com.bigzheng.entity.Address;
import com.bigzheng.mapper.AddressMapper;
import com.bigzheng.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class AddressServiceImpl implements AddressService {
    @Autowired
    private AddressMapper addressMapper;

    //根据userID获得所有收货地址
    @Override
    public List<Address> getAllAddress(Long userID) {
        return addressMapper.getAllAddress(userID);
    }

    @Override
    public int updateAddress(Address address) {
        return addressMapper.updateAddress(address);
    }

    @Override
    public int addAddress(Address address) {
        return addressMapper.addAddress(address);
    }
}