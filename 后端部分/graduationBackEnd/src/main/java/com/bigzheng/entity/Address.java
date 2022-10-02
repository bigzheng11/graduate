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
    private String address;
    private Integer isDefault;
}