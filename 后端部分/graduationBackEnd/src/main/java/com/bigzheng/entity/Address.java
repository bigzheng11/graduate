package com.bigzheng.entity;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Address {
    private Long addressID;
    private Long userID;
    private Long phone;
    private String adName;
    private String provinceCity;
    private String addressDetail;
    private Integer isDefault;
}