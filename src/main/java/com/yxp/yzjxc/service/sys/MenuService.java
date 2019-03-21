package com.yxp.yzjxc.service.sys;

import com.yxp.yzjxc.entity.Menu;
import reactor.core.publisher.Flux;

import java.util.List;

public interface MenuService {

    public List<Menu> menuList();

}
