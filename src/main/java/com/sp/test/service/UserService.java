package com.sp.test.service;

import com.sp.test.domain.User;

import java.util.List;

/**
 * @Auther: zhangzhipeng
 * @Date: 2018/7/30 12:23
 * @Description: TODO
 * @Version 1.0
 */
public interface UserService {
    /**
     * 查询所有用户列表
     * @return
     */
    public List<User> findUserList();

    /**
     * 更新某一个用户状态
     * @param id :用户id也对应表某条记录主键id
     * @param status：1-激活 0-未激活
     * @return
     */
    int updateUserSts(User user);

    /**
     * 删除某个元素
     * @param id
     * @return
     */
    int deleteUser(Long id);
    User selectByUser(String userName);
    int insert(User user);
    User selectByEmail(String email);


}
