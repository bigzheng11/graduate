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
    private Long goodID;
    private Long userID;
    private String message;
    private String datetime;
    private Integer favour;
}

