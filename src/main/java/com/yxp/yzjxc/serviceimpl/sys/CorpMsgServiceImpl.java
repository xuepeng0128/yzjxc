package com.yxp.yzjxc.serviceimpl.sys;

import com.yxp.yzjxc.entity.CorpMsg;
import com.yxp.yzjxc.repo.sys.IcorpMsgRepo;
import com.yxp.yzjxc.service.sys.CorpMsgService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CorpMsgServiceImpl implements CorpMsgService {
    @Autowired
    private IcorpMsgRepo repo;
    @Override
    public boolean saveCorpMsg(CorpMsg corpMsg) {
     //  repo.deleteAll();
       CorpMsg m=   repo.save(corpMsg);
       return true;
    }

    @Override
    public List<CorpMsg> getCorpMsg() {
         List<CorpMsg> list = repo.findAll();
        return list;
         // return Optional.ofNullable( repo.findAll().get(0)).orElseGet(() ->{ return new CorpMsg();});
    }

    @Override
    public List<CorpMsg> getCorpMsgbyadd(String address) {
        List<CorpMsg> list = repo.findCorpMsgByAddress(address);
        return list;
    }
}
