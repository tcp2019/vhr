package com.pactera.sms.vhr.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Objects;

/**
 * @ClassName Position
 * @Description: 职位信息
 * @Author TCP
 * @Date 2020/3/30 0030
 * @Version V1.0
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Position implements Serializable {
    private Integer id;
    private String name;
    private Timestamp createDate;
    private Boolean enabled;

    public Position(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Position jobLevel = (Position) o;
        return Objects.equals(name, jobLevel.name);
    }
}
