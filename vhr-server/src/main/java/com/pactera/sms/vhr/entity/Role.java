package com.pactera.sms.vhr.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @ClassName Role
 * @Description: TODO
 * @Author Administrator
 * @Date 2020/3/26 0026
 * @Version V1.0
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Role implements Serializable {
    private Integer id;
    private String name;
    private String nameZh;

    public Role(String name) {
        this.name = name;
    }
}
