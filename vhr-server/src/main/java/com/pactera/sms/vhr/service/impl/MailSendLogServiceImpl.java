package com.pactera.sms.vhr.service.impl;

import com.pactera.sms.vhr.entity.MailSendLog;
import com.pactera.sms.vhr.mapper.MailSendLogMapper;
import com.pactera.sms.vhr.service.MailSendLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName MailSendLogServiceImpl
 * @Description: TODO
 * @Author TCP
 * @Date 2020/4/20 0020
 * @Version V1.0
 **/
@Service
public class MailSendLogServiceImpl implements MailSendLogService {
    @Autowired
    private MailSendLogMapper mailSendLogMapper;
    @Override
    public Integer insert(MailSendLog mailSendLog) {
        return mailSendLogMapper.insert(mailSendLog);
    }

    @Override
    public List<MailSendLog> getMailSendLogByStatus(Integer status) {
        return mailSendLogMapper.getMailSendLogByStatus(status);
    }

    @Override
    public void updateMailSendLogStatusByMsgId(String msgId, Integer status) {
        mailSendLogMapper.updateMailSendLogStatusByMsgId(msgId,status);
    }

    @Override
    public void updateMailSendLogCount(String msgId) {
        mailSendLogMapper.updateMailSendLogCount(msgId);
    }
}
