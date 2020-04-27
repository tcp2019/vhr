package com.pactera.sms.vhr.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @ClassName Salary
 * @Description: TODO
 * @Author TCP
 * @Date 2020/4/17 0017
 * @Version V1.0
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Salary {
    private Integer id;
    private Integer basicSalary;
    private Integer bonus;
    private Integer lunchSalary;
    private Integer trafficSalary;
    private Integer allSalary;
    private Integer pensionBase;
    private Float pensionPer;
    private Date createDate;
    private Integer medicalBase;
    private Float medicalPer;
    private Integer accumulationFundBase;
    private Float accumulationFundPer;
    private String name;
}
