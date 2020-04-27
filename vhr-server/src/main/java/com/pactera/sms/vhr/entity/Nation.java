package com.pactera.sms.vhr.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Objects;

/**
 * @ClassName Nation
 * @Description: 民族信息
 * @Author TCP
 * @Date 2020/3/30 0030
 * @Version V1.0
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Nation implements Serializable {
    private Integer id;
    private String name;

    public Nation(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Nation jobLevel = (Nation) o;
        return Objects.equals(name, jobLevel.name);
    }

}
