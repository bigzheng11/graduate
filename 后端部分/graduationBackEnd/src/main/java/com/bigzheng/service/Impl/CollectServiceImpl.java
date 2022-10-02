package com.bigzheng.service.Impl;
import com.bigzheng.entity.Address;
import com.bigzheng.entity.Collect;
import com.bigzheng.mapper.CollectMapper;
import com.bigzheng.service.CollectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;


@Service
public class CollectServiceImpl implements CollectService {
    @Autowired
    private CollectMapper collectMapper;

    //「所有列表」根据userID获得所有收藏
    @Override
    public List<Collect> getAllCollect(Long userID) {
        return collectMapper.getAllCollect(userID);
    }

    //「添加」 根据传入对象添加收藏
    @Override
    public int addCollect(Collect collect) {
        return collectMapper.addCollect(collect);
    }

    //「修改」修改收藏状态
    public int changeIsCollect(Collect collect) {
        return collectMapper.changeIsCollect(collect);
    }
}
