package com.project.erp.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.project.erp.vo.RawMaterialVO;

@Repository
public class RawMaterialDAO {
	
	@Autowired
	SqlSessionTemplate sqlSession;
	
	public int rawMaterialInsert(RawMaterialVO rawmaterial) {
		int result = 0;
		
		RawMaterialMapper mapper = sqlSession.getMapper(RawMaterialMapper.class);
		try {
			result = mapper.rawMaterialInsert(rawmaterial);
		}catch (Exception e) {
			e.printStackTrace();
			return result;
		}
		return result;
	}
}
