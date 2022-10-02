package com.bigzheng.entity;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Order{
    private Long orderID;
    private Long userID;
    private Long goodsID;
    private Integer quantity;
    private String goodsName;
    private List<Picture> picList=new ArrayList<>();
}

