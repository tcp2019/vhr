package com.pactera.sms.vhr.constants;

/**
 * @ClassName MsgConstants
 * @Description: TODO
 * @Author TCP
 * @Date 2020/4/20 0020
 * @Version V1.0
 **/
public class MsgConstants {
    /**
     * 消息的超时时间1min
     */
    public static final Integer MSG_TIMEOUT = 1;
    /**
     * 消息发送状态：0：发送中 1：发送成功 2:发送失败
     */
    public static final Integer DELIVERING = 0;
    public static final Integer SUCCESS = 1;
    public static final Integer FAILURE = 2;
    /**
     * 最大重试次数
     */
    public static final Integer MAX_TRY_COUNT = 3;
    /**
     * 队列名称
     */
    public static final String MAIL_QUEUE_NAME = "java.mail.queue";
    /**
     * 交换器名称
     */
    public static final String MAIL_EXCHANGE_NAME = "java.mail.exchange";
    /**
     * 路由key
     */
    public static final String MAIL_ROUTING_KEY_NAME = "java.mail.routing.key";

}
