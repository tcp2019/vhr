package com.pactera.sms.vhr.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Objects;

/**
 * @ClassName PoliticsStatus
 * @Description: 政治面貌信息
 * @Author TCP
 * @Date 2020/3/30 0030
 * @Version V1.0
 **/
@AllArgsConstructor
@Data
@NoArgsConstructor
public class PoliticsStatus implements Serializable {
    private Integer id;
    private String name;

    public PoliticsStatus(String name) {
        this.name = name;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PoliticsStatus jobLevel = (PoliticsStatus) o;
        return Objects.equals(name, jobLevel.name);
    }
}
