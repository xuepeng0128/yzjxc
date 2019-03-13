package com.yxp.yzjxc.serviceimpl.sys;

import com.yxp.yzjxc.entity.User;
import com.yxp.yzjxc.repo.sys.IUserRepo;
import com.yxp.yzjxc.service.sys.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private IUserRepo repo;
    @Override
    public List<User> getUser(String userId) {
        return repo.findUserByUserId(userId);
    }

    @Override
    public List<User> getUser(String userId, String passWord) {
        return repo.findUserByUserIdAndPassWord(userId,passWord);
    }
}
