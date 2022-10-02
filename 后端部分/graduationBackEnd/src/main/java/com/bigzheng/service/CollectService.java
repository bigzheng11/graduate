package com.bigzheng.service;
import com.bigzheng.entity.Collect;
import java.util.List;


public interface CollectService {

    //「所有列表」根据userID获得所有收藏
    List<Collect> getAllCollect(Long userID);

    //「添加」 根据传入对象添加收藏
    int addCollect(Collect collect);

    //「修改」修改收藏状态收藏
    int changeIsCollect(Collect collect);


}
