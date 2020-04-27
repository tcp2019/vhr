package com.pactera.sms.vhr.service.impl;

import com.pactera.sms.vhr.constants.MsgConstants;
import com.pactera.sms.vhr.entity.*;
import com.pactera.sms.vhr.mapper.EmpMapper;
import com.pactera.sms.vhr.service.EmpService;
import com.pactera.sms.vhr.service.MailSendLogService;
import com.pactera.sms.vhr.vo.PageResultVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DecimalFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * @ClassName EmpServiceImpl
 * @Description: TODO
 * @Author TCP
 * @Date 2020/3/30 0030
 * @Version V1.0
 **/
@Service
@Slf4j
public class EmpServiceImpl implements EmpService {
    @Autowired
    private EmpMapper empMapper;

    @Autowired
    private MailSendLogService mailSendLogService;

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Override
    public PageResultVo getEmpList(Emp emp, Date[] beginDateScope, Integer page, Integer size) {
        if (page != null && size != null) {
            page = (page - 1) * size;
        }
        Long count = empMapper.getCount(emp, beginDateScope);
        List<Emp> empList = empMapper.getEmpList(emp, beginDateScope, page, size);

        return new PageResultVo(count.intValue(), empList);
    }

    @Override
    public List<Position> getPositionList() {
        return empMapper.getPositionList();
    }

    @Override
    public String getMaxWorkID() {
        String workID = empMapper.getMaxWorkID();
        String maxWorkID = String.format("%08d", Integer.parseInt(workID) + 1);
        log.info("maxWorkId:===>{}", maxWorkID);
        return maxWorkID;
    }

    @Override
    public List<JobLevel> getJobLevels() {
        return empMapper.getJobLevels();
    }

    @Override
    public List<PoliticsStatus> getPoliticsStatus() {
        return empMapper.getPoliticsStatus();
    }

    @Override
    public List<Department> getDepartmentList() {
        return empMapper.getDepartmentList();
    }

    @Override
    public Integer addEmp(Emp emp) {
        //计算合同期限
        Date beginContract = emp.getBeginContract();
        Date endContract = emp.getEndContract();
        long beginContractTime = beginContract.getTime();
        long endContractTime = endContract.getTime();
        emp.setContractTerm(Double.valueOf(new DecimalFormat("##.00").format((endContractTime - beginContractTime) / 1000 / 3600 / 24 / 365)));
        log.info("合同期限为：", emp.getContractTerm());

        Integer result = empMapper.insertSelective(emp);
        if (result == 1) {
            log.info("empId为====>>：{}", emp.getId());
            empMapper.getEmpById(emp.getId());
            //将员工添加成功插入到mail_sned_log表
            MailSendLog mailSendLog = new MailSendLog();
            String msgId = UUID.randomUUID().toString();
            mailSendLog.setMsgId(msgId);
            mailSendLog.setCreateTime(new Date());
            mailSendLog.setUpdateTime(new Date());
            mailSendLog.setEmpId(emp.getId());
            mailSendLog.setTryTime(new Date(System.currentTimeMillis() + 1000 * 60 * MsgConstants.MSG_TIMEOUT));
            mailSendLog.setRouteKey(MsgConstants.MAIL_ROUTING_KEY_NAME);
            mailSendLog.setExChange(MsgConstants.MAIL_EXCHANGE_NAME);
            mailSendLogService.insert(mailSendLog);
            //发送消息
            rabbitTemplate.convertAndSend(MsgConstants.MAIL_EXCHANGE_NAME, MsgConstants.MAIL_ROUTING_KEY_NAME, emp, new CorrelationData(msgId));
        }
        return result;
    }

    @Override
    public void updateEmp(Emp emp) {
        //计算合同期限
        Date beginContract = emp.getBeginContract();
        Date endContract = emp.getEndContract();
        long beginContractTime = beginContract.getTime();
        long endContractTime = endContract.getTime();
        emp.setContractTerm(Double.parseDouble(new DecimalFormat("##.00").format((Double.parseDouble(String.valueOf(endContractTime - beginContractTime))) / 1000 / 3600 / 24 / 365)));
        log.info("合同期限为：{}", emp.getContractTerm());
        empMapper.updateSelective(emp);
    }

    @Override
    public void deleteEmp(Integer id) {
        empMapper.deleteEmp(id);
    }

    @Override
    public List<Nation> getNationList() {
        return empMapper.getNationList();
    }

    @Override
    public PageResultVo getEmpListByPageWithSalary(Integer page, Integer size) {
        if (page != null) {
            page = (page - 1) * size;
        }
        List<Emp> empListByPageWithSalary = empMapper.getEmpListByPageWithSalary(page, size);
        Long total = empMapper.getCount(null, null);
        return new PageResultVo(total.intValue(), empListByPageWithSalary);
    }

    @Override
    public Emp getEmpById(Integer empId) {
        return empMapper.getEmpById(empId);
    }
}
