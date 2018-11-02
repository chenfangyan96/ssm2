package com.sp.test.mapper;

import com.sp.test.domain.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 用户映射
 * @author Administrator
 *
 */
@Component
public interface UserMapper {
	/**
	 * 查询所有用户
	 * @return
	 */
	User selectByUser(@Param("userName") String userName);
	List<User> findAllUser();
	/**
	 * 更新用户状态
	 * @param id
	 * @param status
	 * @return
	 */
	int updateUserSts(@Param("id") Long id, @Param("status") String status);
	int deleteUser(@Param("id") Long id);

}
