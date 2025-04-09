package com.scau.mapper;

import com.scau.entity.healthData.pojo.SleepRecords;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
* @author ASUS
* @description 针对表【sleep_records】的数据库操作Mapper
* @createDate 2025-04-08 22:00:13
* @Entity com.scau.entity.healthData.pojo.SleepRecords
*/
public interface SleepRecordsMapper {

    List<SleepRecords> selectList(@Param("userId")Long userId, @Param("startIndex") int startIndex, @Param("limit") Integer limit, @Param("keyword") String keyword);

    @Insert("INSERT INTO sleep_records values (0,#{userId},#{startTime},#{endTime},#{deepSleep},#{note},now())")
    void insert(Long userId, String startTime, String endTime, Integer deepSleep, String note);

    void updateById(Long id, Long userId, String startTime, String endTime, Integer deepSleep, String note);

    @Delete("delete from sleep_records where sleep_id=#{id} and user_id=#{userId}")
    void deleteById(Long id, Long userId);

    ;
}




