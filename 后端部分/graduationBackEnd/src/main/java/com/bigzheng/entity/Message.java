package com.bigzheng.entity;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Message  {
    private Long messageID;
    private Long toMessageID;
    private Long goodsID;
    private Long userID;
    private User user;
    private String message;
    private String datetime;
    private Integer favour;
    private Integer parentTop;
}

