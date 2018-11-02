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
     * @param status：1-启用 0-禁用
     * @return
     */
    int updateUserSts(Long id,String status);

    /**
     * 删除某个元素
     * @param id
     * @return
     */
    int deleteUser(Long id);
    User selectByUser(String userName);

}
