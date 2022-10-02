package com.bigzheng.controller;
import com.bigzheng.common.R;
import com.bigzheng.entity.Address;
import com.bigzheng.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/address")
public class AddressController {
    @Autowired
    private AddressService addressService;

    //根据userID获得所有收货地址
    @GetMapping("/getall/{userID}")
    public R allAddress(@PathVariable Long userID){
        List<Address> addressList = addressService.getAllAddress(userID);
        System.out.println("controller---->"+addressList);
            return  R.ok().data("addressList",addressList);
        }

    //「更新」根据addressID修改收货地址
    @PostMapping("/update")
    public R updateAddress(Address address) {
        addressService.updateAddress(address);
        return R.ok();
    }

    //「增加」根据userID新增收货地址
    @PostMapping("/add")
    public Long addAddress(Address address) {
       int i = addressService.addAddress(address);
        System.out.println(i);
        return address.getAddressID();
        //返回addressID
    }


}