package com.yxp.yzjxc.serviceimpl.sys;

import com.yxp.yzjxc.entity.CorpMsg;
import com.yxp.yzjxc.repo.sys.IcorpMsgRepo;
import com.yxp.yzjxc.service.sys.CorpMsgService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

public class CorpMsgServiceImpl implements CorpMsgService {
    @Autowired
    private IcorpMsgRepo repo;
    @Override
    public void saveCorpMsg(CorpMsg corpMsg) {
        repo.save(corpMsg);
    }

    @Override
    public CorpMsg getCorpMsg() {
          return Optional.ofNullable( repo.findAll().get(0)).orElseGet(() ->{ return new CorpMsg();});
    }
}
