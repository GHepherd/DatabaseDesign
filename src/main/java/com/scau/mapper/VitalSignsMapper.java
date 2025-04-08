package com.scau.mapper;

import com.scau.entity.healthData.pojo.VitalSigns;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
* @author ASUS
* @description 针对表【vital_signs】的数据库操作Mapper
* @createDate 2025-04-08 22:02:19
* @Entity com.scau.entity.healthData.pojo.VitalSigns
*/
public interface VitalSignsMapper {

    List<VitalSigns> selectList(@Param("userId")Long userId, @Param("startIndex") int startIndex, @Param("limit") Integer limit, @Param("keyword") String keyword);
}




