package com.scau.mapper;

import com.scau.entity.healthData.pojo.DietRecords;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
* @author ASUS
* @description 针对表【diet_records】的数据库操作Mapper
* @createDate 2025-04-08 22:02:04
* @Entity com.scau.entity.healthData.pojo.DietRecords
*/
public interface DietRecordsMapper {

    List<DietRecords> selectList(@Param("userId")Long userId, @Param("startIndex") int startIndex, @Param("limit") Integer limit, @Param("keyword") String keyword);

    @Insert("INSERT INTO diet_records values (0,#{userId},#{mealTime},#{foodName},#{amount},#{protein},#{carbs},#{fat},#{note},now())")
    void insert(Long userId, String mealTime, String foodName, Double amount, Double protein, Double carbs, Double fat, String note);

    void updateById(Long id, Long userId, String mealTime, String foodName, Double amount, Double protein, Double carbs, Double fat, String note);

    @Delete("delete from diet_records where diet_id=#{id} and user_id=#{userId}")
    void deleteById(Long id, Long userId);

    ;
}




