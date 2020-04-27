package com.pactera.sms.vhr.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @ClassName PageResultVo
 * @Description: TODO
 * @Author TCP
 * @Date 2020/3/30 0030
 * @Version V1.0
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PageResultVo {
    private int total;
    private List<?> data;
}
