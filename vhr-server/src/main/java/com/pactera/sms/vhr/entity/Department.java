package com.pactera.sms.vhr.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Objects;

/**
 * @ClassName Department
 * @Description: 部门信息
 * @Author TCP
 * @Date 2020/3/30 0030
 * @Version V1.0
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Department implements Serializable {
    private Integer id;
    private String name;
    private Integer parentId;
    private String depPath;
    private Boolean enabled;
    private Boolean isParent;

    public Department(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Department jobLevel = (Department) o;
        return Objects.equals(name, jobLevel.name);
    }
}
