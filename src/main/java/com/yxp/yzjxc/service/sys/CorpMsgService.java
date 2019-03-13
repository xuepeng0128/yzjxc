package com.yxp.yzjxc.service.sys;

import com.yxp.yzjxc.entity.CorpMsg;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CorpMsgService {

    public boolean saveCorpMsg(CorpMsg corpMsg);

    public List<CorpMsg> getCorpMsg();

    public List<CorpMsg> getCorpMsgbyadd(String address);
}
