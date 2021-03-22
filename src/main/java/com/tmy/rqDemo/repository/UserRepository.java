package com.tmy.rqDemo.repository;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.tmy.rqDemo.entity.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * @author: muyang.tian
 * @Date: 2021-03-19 14:40
 */
@Repository
public interface UserRepository extends BaseMapper<User> {

    User findUserByName(@Param("name") String name);
}
