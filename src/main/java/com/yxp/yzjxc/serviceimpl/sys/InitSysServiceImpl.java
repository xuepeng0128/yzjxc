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
           //1.生成订单号
        ScriptOperations scriptOps = mongoTemplate.scriptOps();
        String makeBillIdStr="function (billkind){\n" +
                "     var maxCode='';\n" +
                "     var nowDate = new Date();\n" +
                "     var year =nowDate.getFullYear().toString();\n" +
                "     var month = (nowDate.getMonth() +1) >=10 ?  (nowDate.getMonth() +1).toString() : '0'+ (nowDate.getMonth() +1).toString();\n" +
                "     var date = nowDate.getDate() >=10 ? nowDate.getDate().toString() :  ('0' + nowDate.getDate());\n" +
                "     var nowDatestr = year +month + date;\n" +
                "     var mid;\n" +
                "     if (billkind ==='orderbill'){\n" +
                "          mid= db.getCollection('orderbill').aggregate([\n" +
                "             {$match : { orderId : eval('/' + nowDatestr + '/')}}  ,\n" +
                "             {$group :{\n" +
                "                       \"_id\" :{},\n" +
                "                       maxid :{$max : \"$orderId\"}\n" +
                "                   }\n" +
                "             } ,\n" +
                "             {\n" +
                "                 $project : {\n" +
                "                              \"_id\" :0,\n" +
                "                              \"maxid\" : \"$maxid\"                         \n" +
                "                            }\n" +
                "                 \n" +
                "             }   \n" +
                "             \n" +
                "         \n" +
                "         ]);\n" +
                "            \n" +
                "         \n" +
                "     }else if (billkind ==='purchasebill'){\n" +
                "         \n" +
                "     }else if (billkind ==='allocatebill'){\n" +
                "     }   \n" +
                "    \n" +
                "         if (!mid.maxid){          \n" +
                "             maxCode= billkind.substring(0,2) + nowDatestr +'-0001';\n" +
                "         } else {\n" +
                "             var flowcode=parseInt(mid.maxid.split('-')[1]) +1 ;\n" +
                "             if(flowcode<10)\n" +
                "                maxCode=billkind.substring(0,2) + nowDatestr + '-000' + flowcode; \n" +
                "             else if(flowcode>=10 && flowcode<100)\n" +
                "                 maxCode=billkind.substring(0,2) + nowDatestr + '-00' + flowcode; \n" +
                "             else if(flowcode>=100 && flowcode<1000)\n" +
                "                 maxCode=billkind.substring(0,2) + nowDatestr + '-0' + flowcode;     \n" +
                "             else\n" +
                "                 maxCode=billkind.substring(0,2) + nowDatestr + '-' + flowcode;              \n" +
                "         }\n" +
                "    \n" +
                "    return maxCode;\n" +
                "    \n" +
                "}";


        ExecutableMongoScript script = new ExecutableMongoScript(makeBillIdStr);
        scriptOps.register(new NamedMongoScript("makeBillId", script)); //指定脚本名称
       // scriptOps.execute(script, "directly execute script");

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
