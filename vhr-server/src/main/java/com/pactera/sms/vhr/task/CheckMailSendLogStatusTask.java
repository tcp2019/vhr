package com.pactera.sms.vhr.task;

import com.pactera.sms.vhr.constants.MsgConstants;
import com.pactera.sms.vhr.entity.Emp;
import com.pactera.sms.vhr.entity.MailSendLog;
import com.pactera.sms.vhr.service.EmpService;
import com.pactera.sms.vhr.service.MailSendLogService;
import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @ClassName ChekMailSendLogStatus
 * @Description: 定时检测消息发送的状态，如果发送延时，即重试时间小于当前系统时间，则重复发送，超过三次，设置为发送失败
 * @Author TCP
 * @Date 2020/4/21 0021
 * @Version V1.0
 **/
@Component
public class CheckMailSendLogStatusTask {
    @Autowired
    private MailSendLogService mailSendLogService;

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Autowired
    private EmpService empService;

    @Scheduled(cron = "0/10 * * * * ? ")
    public void checkMailSendLogStatus() {
        //查询出正在发送但重试时间已过的数据
        List<MailSendLog> mailSendLogList = mailSendLogService.getMailSendLogByStatus(MsgConstants.DELIVERING);
        if (mailSendLogList != null && mailSendLogList.size() > 0) {
            for (MailSendLog mailSendLog : mailSendLogList) {
                //查询当前 mailSendLog 的count数
                Integer count = mailSendLog.getCount();

                if (count >= MsgConstants.MAX_TRY_COUNT) {
                    //将消息发送状态改为2 即发送失败
                    mailSendLogService.updateMailSendLogStatusByMsgId(mailSendLog.getMsgId(), MsgConstants.FAILURE);
                } else {
                    //count++ 重新发送消息
                    mailSendLogService.updateMailSendLogCount(mailSendLog.getMsgId());
                    Emp emp = empService.getEmpById(mailSendLog.getEmpId());
                    rabbitTemplate.convertAndSend(MsgConstants.MAIL_EXCHANGE_NAME, MsgConstants.MAIL_ROUTING_KEY_NAME, emp, new CorrelationData(mailSendLog.getMsgId()));
                }
            }
        }
    }
}
