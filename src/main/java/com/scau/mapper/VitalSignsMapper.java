package com.scau.mapper;

import com.scau.entity.healthData.pojo.VitalSigns;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;

import java.math.BigDecimal;
import java.util.List;

/**
* @author ASUS
* @description 针对表【vital_signs】的数据库操作Mapper
* @createDate 2025-04-08 22:02:19
* @Entity com.scau.entity.healthData.pojo.VitalSigns
*/
public interface VitalSignsMapper {

    List<VitalSigns> selectList(@Param("userId")Long userId, @Param("startIndex") int startIndex, @Param("limit") Integer limit, @Param("keyword") String keyword);

    @Insert("INSERT INTO vital_signs values (0,#{userId},#{height},#{weight},#{bloodPressure},#{bloodSugar},#{bloodLipids},#{note},now())")
    void insert(@Param("userId") Long userId, @Param("height")Double height, @Param("weight") Double weight, @Param("bloodPressure") Integer bloodPressure, @Param("bloodSugar") Double bloodSugar, @Param("bloodLipids")Double bloodLipids, @Param("note")String note);

    void updateById(Long id, Long userId, Double height, Double weight, Integer bloodPressure, Double bloodSugar, Double bloodLipids, String note);

    @Delete("delete from vital_signs where record_id=#{id} and user_id=#{userId}")
    void deleteById(Long id, Long userId);
}




