package com.project.erp.dao;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.project.erp.vo.RawMaterialVO;

@Mapper
@Repository
public interface RawMaterialMapper {

	public int rawMaterialInsert(RawMaterialVO rawmaterial);
}
