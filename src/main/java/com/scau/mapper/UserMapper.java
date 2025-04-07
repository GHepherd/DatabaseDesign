package com.scau.mapper;

import com.scau.entity.user.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserMapper {
        /**
         * 判断用户是否存在
         * @param user_id
         * @return 用户对应的记录数
         */
        @Select("select count(*) from databasedesigndb.users where user_id = #{user_id }")
        Integer ifExistUserId(Integer user_id);

        /**
         * 查询用户密码
         * @param username
         * @return
         */
        @Select("select user_id,username,password from users where username=#{username}")
        User selectUserByUsername(String username);
}
