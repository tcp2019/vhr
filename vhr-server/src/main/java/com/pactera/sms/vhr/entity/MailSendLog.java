package com.pactera.sms.vhr.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @ClassName MessageSendLog
 * @Description: TODO
 * @Author TCP
 * @Date 2020/4/20 0020
 * @Version V1.0
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class MailSendLog {
    /**
     * 生成的uuid 消息id
     */
    private String msgId;
    private Integer empId;
    /**
     * 消息的发送状态
     * 0:发送中
     * 1：发送成功
     * 2:发送失败
     */
    private Integer status;
    /**
     * 路由key
     */
    private String routeKey;
    /**
     *
     */
    private String exChange;
    private Integer count;
    private Date tryTime;
    private Date createTime;
    private Date updateTime;
}
