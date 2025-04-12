package com.scau.mapper;

import com.scau.entity.healthData.pojo.ExerciseRecords;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
* @author ASUS
* @description 针对表【exercise_records】的数据库操作Mapper
* @createDate 2025-04-08 22:01:47
* @Entity com.scau.entity.healthData.pojo.ExerciseRecords
*/
public interface ExerciseRecordsMapper {

    List<ExerciseRecords> selectList(@Param("userId")Long userId, @Param("startIndex") int startIndex, @Param("limit") Integer limit, @Param("keyword") String keyword);


    @Insert("INSERT INTO exercise_records values (0,#{userId},#{exerciseType},#{duration},#{distance},#{calories},#{heartRate},#{note},now())")
    void insert(Long userId, String exerciseType, Double duration, Double distance, Double calories, Double heartRate, String note);

    void updateById(Long id, Long userId, String exerciseType, Double duration, Double distance, Double calories, Double heartRate, String note);

    @Delete("delete from exercise_records where exercise_id=#{id} and user_id=#{userId}")
    void deleteById(Long id, Long userId);
}




