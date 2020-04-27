package com.pactera.sms.vhr.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @ClassName Hr_Role
 * @Description: TODO
 * @Author TCP
 * @Date 2020/3/26 0026
 * @Version V1.0
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class HrRole implements Serializable {
    private Integer id;
    private Integer hrId;
    private Integer roleId;
}
