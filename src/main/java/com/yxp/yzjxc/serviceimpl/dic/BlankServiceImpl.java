package com.yxp.yzjxc.serviceimpl.dic;

import com.yxp.yzjxc.entity.Blank;
import com.yxp.yzjxc.repo.dic.BlankRepo;
import com.yxp.yzjxc.service.dic.BlankService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class BlankServiceImpl implements BlankService {
    @Autowired
    BlankRepo repo;
    @Override
    public Mono<Blank> insertBlank(Blank blank) {
        return  repo.insert(blank);
    }

    @Override
    public Mono<Blank> updateBlank(Blank blank) {
        return repo.save(blank);
    }

    @Override
    public void deleteBlank(String blankId) {
           repo.deleteById(blankId);
    }

    @Override
    public Flux<Blank> blankList() {
        return repo.findAll();
    }
}
