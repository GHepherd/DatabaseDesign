package com.scau.mapper;

import cn.hutool.core.date.DateTime;
import com.scau.entity.user.pojo.User;
import org.apache.ibatis.annotations.*;

@Mapper
public interface UserMapper{
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
        @Select("select user_id,username,pass_word from users where username=#{username}")
        User selectUserByUsername(String username);

        @Insert("INSERT INTO users(username,pass_word,email,created_at) values (#{username},#{password},#{email},#{now})")
        void insertUser(@Param("username") String username, @Param("password") String password, @Param("email") String email, @Param("now") DateTime now);

        @Select("SELECT * from users where user_id=#{userId}")
        User selectUserById(Long userId);

        void updateUserById(@Param("userId") Long userId, @Param("userName") String userName,@Param("email") String email);

        @Update("update users set pass_word=#{password} where user_id=#{userId}")
        void updatePasswordById(@Param("userId") Long userId, @Param("password") String newPassword);
}
