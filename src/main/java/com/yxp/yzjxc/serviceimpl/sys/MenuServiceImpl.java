package com.yxp.yzjxc.serviceimpl.sys;

import com.yxp.yzjxc.entity.Menu;
import com.yxp.yzjxc.repo.sys.MenuRepo;
import com.yxp.yzjxc.service.sys.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MenuServiceImpl implements MenuService {
    @Autowired
    private MenuRepo repo;
    @Override
    public List<Menu> menuList() {
        List<Menu> list = repo.findAll();
        return list;
    }
}
