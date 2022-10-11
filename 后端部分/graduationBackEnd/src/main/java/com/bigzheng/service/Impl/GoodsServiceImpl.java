package com.bigzheng.service.Impl;
import com.bigzheng.entity.Goods;
import com.bigzheng.mapper.GoodsMapper;
import com.bigzheng.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GoodsServiceImpl implements GoodsService {
    @Autowired
    private GoodsMapper goodsMapper;

    @Override
    public Goods getGoodsById(Long goodsID) {
        return goodsMapper.getGoodsById(goodsID);
    }

    @Override
    public List<Goods> getAllGoods(Long userID) {
        return goodsMapper.getAllGoods(userID);
    }

    @Override
    public List<Goods> getRecommendGoods(Goods goodsParameter) {
        return goodsMapper.getRecommendGoods(goodsParameter);
    }

    @Override
    public int addGoodsModel(Long userID) {
    return goodsMapper.addGoodsModel(userID);
    }

    @Override
    public String selectNewId() {
        return goodsMapper.selectNewId();
    }

    @Override
    public int updataModel(Goods goods) {
        return goodsMapper.updataModel(goods);
    }

    @Override
    public List<Goods> backstageSelectAll() {
        return goodsMapper.backstageSelectAll();
    }

    @Override
    public int backstageDeleteById(Long goodsID) {
        return goodsMapper.backstageDeleteById(goodsID);
    }

    @Override
    public int backstageUpdataById(Goods goods) {
        return goodsMapper.backstageUpdataById(goods);
    }
}