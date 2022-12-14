package com.bigzheng.entity;
import lombok.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Goods {
    private Long goodsID;
    private Long userID;
    private String goodsName;
    private String goodsDescribe;
    private Integer goodsClassify;
    private Long picID;
    private Long videoID;
    private int price;
    private int deleteTag;
    private int isSell;


    //一对多:一个商品对应的多个图片
    private List<Picture> picList=new ArrayList<>();
    private Video video;
    private User user;
    private int n;
    private List<Message> messagesList=new ArrayList<>();

    //推送时,排除掉登录用户的自己的userID
    private Long loginUserID;


}