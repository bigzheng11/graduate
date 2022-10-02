package com.bigzheng.service.Impl;
import com.bigzheng.entity.Interest;
import com.bigzheng.mapper.InterestMapper;
import com.bigzheng.service.InterestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * (Like)表服务实现类
 *
 * @author makejava
 * @since 2022-09-27 19:01:52
 */
@Service
public class InterestServiceImpl implements InterestService {
    @Autowired
    private InterestMapper interestMapper;

    @Override
    public List<Interest> topSixInterest(Long userID) {
        return interestMapper.topSixInterest(userID);
    }
}
