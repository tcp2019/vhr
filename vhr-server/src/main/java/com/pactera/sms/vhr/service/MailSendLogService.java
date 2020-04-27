package com.pactera.sms.vhr.service;

import com.pactera.sms.vhr.entity.MailSendLog;

import java.util.List;

/**
 * @ClassName MailSendLogService
 * @Description: TODO
 * @Author TCP
 * @Date 2020/4/20 0020
 * @Version V1.0
 **/
public interface MailSendLogService {
    /**
     * 记录发送记录
     *
     * @param mailSendLog
     * @return
     */
    Integer insert(MailSendLog mailSendLog);

    /**
     * 查询出所有status为0并且超过重试时间的消息
     * @param delivering
     * @return
     */
    List<MailSendLog> getMailSendLogByStatus(Integer delivering);

    void updateMailSendLogStatusByMsgId(String msgId, Integer status);

    void updateMailSendLogCount(String msgId);

}
