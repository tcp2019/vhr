package com.pactera.sms.vhr.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

/**
 * @ClassName Menu
 * @Description: TODO
 * @Author TCP
 * @Date 2020/3/26 0026
 * @Version V1.0
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Menu implements Serializable {
    private Integer id;
    private String url;
    private String path;
    private String component;
    private String name;
    private String iconCls;
    private Integer parentId;
    private Boolean enabled;
    private List<Role> roleList;
    private List<Menu> children;
    private Meta meta;

    public Menu(String name) {
        this.name = name;
    }
}
