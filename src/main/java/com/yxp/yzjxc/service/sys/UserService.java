package com.yxp.yzjxc.service.sys;

import com.yxp.yzjxc.entity.User;

import java.util.List;

public interface UserService {
    public List<User> getUser(String userId);
    public List<User> getUser(String userId,String passWord);


}
