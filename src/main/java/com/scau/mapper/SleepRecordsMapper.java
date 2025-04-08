package com.scau.mapper;

import com.scau.entity.healthData.pojo.SleepRecords;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
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
    ;
}




