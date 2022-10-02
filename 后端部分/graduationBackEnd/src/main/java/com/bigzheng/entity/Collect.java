package com.bigzheng.entity;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Collect {
    private Long collectID;
    private Long userID;
    private Long goodsID;
    private Integer isCollect;
}