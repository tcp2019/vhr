package com.pactera.sms.vhr.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @ClassName MenuRole
 * @Description: TODO
 * @Author TCP
 * @Date 2020/3/26 0026
 * @Version V1.0
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
public class MenuRole implements Serializable {
    private Integer id;
    private Integer menuId;
    private Integer roleId;
}
