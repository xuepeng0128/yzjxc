package com.yxp.yzjxc.service.dic;

import com.yxp.yzjxc.entity.Blank;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface BlankService {
    public Mono<Blank> insertBlank(Blank blank);
    public Mono<Blank> updateBlank(Blank blank);
    public void deleteBlank(String blankId);
    public Flux<Blank> blankList();
}
