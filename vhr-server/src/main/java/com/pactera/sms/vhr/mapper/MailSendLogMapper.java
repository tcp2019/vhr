package com.pactera.sms.vhr.mapper;

import com.pactera.sms.vhr.entity.MailSendLog;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @ClassName MailSendLogMapper
 * @Description: TODO
 * @Author TCP
 * @Date 2020/4/20 0020
 * @Version V1.0
 **/
@Component
public interface MailSendLogMapper {
    Integer insert(MailSendLog mailSendLog);

    List<MailSendLog> getMailSendLogByStatus(Integer status);

    void updateMailSendLogStatusByMsgId(@Param("msgId") String msgId, @Param("status") Integer status);

    void updateMailSendLogCount(String msgId);
}
