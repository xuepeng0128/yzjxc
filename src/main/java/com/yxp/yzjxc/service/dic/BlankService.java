package com.yxp.yzjxc.service.dic;

import com.yxp.yzjxc.entity.Blank;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

public interface BlankService {
    public Blank insertBlank(Blank blank);
    public Blank updateBlank(Blank blank);
    public void deleteBlank(String blankId);
    public List<Blank> blankList();
}
