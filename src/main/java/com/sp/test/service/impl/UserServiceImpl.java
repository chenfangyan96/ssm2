package com.sp.test.service.impl;

import com.sp.test.domain.User;
import com.sp.test.mapper.UserMapper;
import com.sp.test.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Auther: zhangzhipeng
 * @Date: 2018/7/30 12:23
 * @Description: TODO
 * @Version 1.0
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public List<User> findUserList() {
        return userMapper.findAllUser();
    }
    @Override
    public  int  deleteUser( Long id){
        return userMapper.deleteUser(id);
    }

    @Override
    public int updateUserSts(Long id, String status) {
        return userMapper.updateUserSts(id,status);
    }
    @Override
    public  User  selectByUser(String userName){
        return  userMapper.selectByUser(userName);
    }
}
