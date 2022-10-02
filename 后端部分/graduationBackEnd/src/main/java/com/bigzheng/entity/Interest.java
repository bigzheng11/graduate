package com.bigzheng.entity;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Interest  {
    private Long interestID;
    private Long userID;
    private Integer goodsclassify;
    private Integer grade;

}

