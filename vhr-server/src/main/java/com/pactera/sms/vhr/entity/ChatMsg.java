package com.pactera.sms.vhr.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @ClassName ChatMsg
 * @Description: 消息类
 * @Author TCP
 * @Date 2020/4/20 0020
 * @Version V1.0
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ChatMsg {
    private String from;
    private String to;
    private String content;
    private Date date;
    private String fromNickname;
}
