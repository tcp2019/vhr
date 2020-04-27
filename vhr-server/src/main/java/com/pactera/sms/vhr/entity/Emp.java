package com.pactera.sms.vhr.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

/**
 * @ClassName Emp
 * @Description: TODO
 * @Author TCP
 * @Date 2020/3/30 0030
 * @Version V1.0
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Emp implements Serializable {
    private Integer id;
    private String name;
    private String gender;
    //身份证
    private String idCard;
    //婚姻状况
    private String wedLock;
    //民族
    private Integer nationId;
    private Nation nation;
    //籍贯
    private String nativePlace;
    //政治面貌
    private Integer politicId;
    private PoliticsStatus politicsStatus;
    private String email;
    private String phone;
    private String address;
    //所属部门
    private Integer departmentId;
    private Department department;
    //职称id
    private Integer jobLevelId;
    private JobLevel jobLevel;
    //职位id
    private Integer positionId;
    private Position position;
    //聘用形式
    private String engageForm;
    //最高学历
    private String tiptopDegree;
    //所属专业
    private String specialty;
    //毕业院校
    private String school;
    //入职日期
    private Date beginDate;
    //在职状态
    private String workState;
    //工号
    private String workId;
    //合同期限
    private Double contractTerm;
    //    @DateTimeFormat("yyyy-MM-dd")
    private Date birthday;
    //转正日期
    private Date conversionTime;
    //离职日期
    private Date notWorkDate;
    //合同起始日期
    private Date beginContract;
    //合同终止日期
    private Date endContract;
    //工龄
    private Integer workAge;

    private Salary salary;

    public Emp(String name) {
        this.name = name;
    }
    @Override
    public boolean equals(Object o) {

        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Emp that = (Emp) o;
        return Objects.equals(name, that.name);
    }
}
