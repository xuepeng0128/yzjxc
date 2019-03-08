package com.yxp.yzjxc.service.sys;

import com.yxp.yzjxc.entity.CorpMsg;
import org.springframework.stereotype.Service;

@Service
public interface CorpMsgService {

    public void saveCorpMsg(CorpMsg corpMsg);

    public CorpMsg getCorpMsg();
}
