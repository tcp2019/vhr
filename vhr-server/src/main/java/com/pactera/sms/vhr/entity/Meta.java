package com.pactera.sms.vhr.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @ClassName Meta
 * @Description: TODO
 * @Author TCP
 * @Date 2020/3/30 0030
 * @Version V1.0
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Meta {
    private Boolean keepAlive;
    private Boolean requireAuth;
}
