package com.yxp.yzjxc.serviceimpl.sys;

import com.alibaba.fastjson.JSON;
import com.yxp.yzjxc.entity.Menu;
import com.yxp.yzjxc.entity.User;
import com.yxp.yzjxc.repo.sys.MenuRepo;
import com.yxp.yzjxc.repo.sys.UserRepo;
import com.yxp.yzjxc.service.sys.InitSysService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.ScriptOperations;
import org.springframework.data.mongodb.core.script.ExecutableMongoScript;
import org.springframework.data.mongodb.core.script.NamedMongoScript;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class InitSysServiceImpl implements InitSysService {
    @Autowired
    MongoTemplate mongoTemplate;
    @Autowired
    UserRepo userRepo;
    @Autowired
    MenuRepo menuRepo;
    @Override
    public void initSys() {
        //1.判断是否存在admin用户
        if (userRepo.existsById("admin"))
            return;

        //2.插入admin用户
        userRepo.save(new User("admin","admin","a",true,"",null));
        //3.插入菜单项
        List<Menu> menulist=  JSON.parseArray(menuJsonstr(),Menu.class);
        menuRepo.saveAll(menulist);
       //4.存储过程
        ScriptOperations scriptOps = mongoTemplate.scriptOps();
        ExecutableMongoScript script = new ExecutableMongoScript("function(x) { return x; }");
        scriptOps.register(new NamedMongoScript("testfunfun", script)); //指定脚本名称
      //  scriptOps.execute(script, "directly execute script");

    }

    private String menuJsonstr(){
        String jsonstr="[" +
                       "   { 'menuId' :'001', 'menuName' :'采购管理', 'url' : '/','powers':'', 'subMenu':[" +
                       "                   { 'menuId' :'00101', 'menuName' :'产品分类', 'url' : '/','powers':'', 'subMenu':[ ] }," +
                       "                   { 'menuId' :'00102', 'menuName' :'产品档案', 'url' : '/','powers':'', 'subMenu':[ ] }," +
                       "                   { 'menuId' :'00103', 'menuName' :'供货商分类', 'url' : '/','powers':'', 'subMenu':[ ] }," +
                       "                   { 'menuId' :'00104', 'menuName' :'供货商管理', 'url' : '/','powers':'', 'subMenu':[ ] }," +
                       "                   { 'menuId' :'00105', 'menuName' :'采购订单', 'url' : '/','powers':'', 'subMenu':[ ] }," +
                       "                   { 'menuId' :'00106', 'menuName' :'采购入库单', 'url' : '/','powers':'', 'subMenu':[ ] }" +
                       "               ] " +
                       "   },    " +
                        "   { 'menuId' :'002', 'menuName' :'库存管理', 'url' : '/','powers':'', 'subMenu':[" +
                        "                   { 'menuId' :'00201', 'menuName' :'仓库档案', 'url' : '/','powers':'', 'subMenu':[ ] }," +
                        "                   { 'menuId' :'00202', 'menuName' :'产品档案', 'url' : '/','powers':'', 'subMenu':[ ] }," +
                        "                   { 'menuId' :'00103', 'menuName' :'供货商分类', 'url' : '/','powers':'', 'subMenu':[ ] }," +
                        "                   { 'menuId' :'00104', 'menuName' :'供货商管理', 'url' : '/','powers':'', 'subMenu':[ ] }," +
                        "                   { 'menuId' :'00105', 'menuName' :'采购订单', 'url' : '/','powers':'', 'subMenu':[ ] }," +
                        "                   { 'menuId' :'00106', 'menuName' :'采购入库单', 'url' : '/','powers':'', 'subMenu':[ ] }" +
                        "               ] " +
                        "   }     " +
                       "]";
        return jsonstr;
    }


}
