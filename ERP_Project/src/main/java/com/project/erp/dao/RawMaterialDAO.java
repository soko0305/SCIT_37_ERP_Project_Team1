package com.project.erp.dao;

import java.util.ArrayList;

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
		} catch (Exception e) {
			e.printStackTrace();
			return result;
		}
		return result;
	}

	public ArrayList<RawMaterialVO> rawMaterialAllSelect() {
		ArrayList<RawMaterialVO> result = null;

		RawMaterialMapper mapper = sqlSession.getMapper(RawMaterialMapper.class);
		try {
			result = mapper.rawMaterialAllSelect();
		} catch (Exception e) {
			e.printStackTrace();
			return result;
		}
		return result;
	}

	public RawMaterialVO rawMaterialOneSelect(RawMaterialVO rawmaterial) {
		RawMaterialVO result = null;

		RawMaterialMapper mapper = sqlSession.getMapper(RawMaterialMapper.class);
		try {
			result = mapper.rawMaterialOneSelect(rawmaterial);
		} catch (Exception e) {
			e.printStackTrace();
			return result;
		}
		return result;
	}

	public int rawMaterialDelete(RawMaterialVO rawmaterial) {
		int result = 0;

		RawMaterialMapper mapper = sqlSession.getMapper(RawMaterialMapper.class);
		try {
			result = mapper.rawMaterialDelete(rawmaterial);
		} catch (Exception e) {
			e.printStackTrace();
			return result;
		}
		return result;
	}

	public ArrayList<RawMaterialVO> rawMaterialDashSelect() {
		ArrayList<RawMaterialVO> result = null;

		RawMaterialMapper mapper = sqlSession.getMapper(RawMaterialMapper.class);
		try {
			result = mapper.rawMaterialDashSelect();
		} catch (Exception e) {
			e.printStackTrace();
			return result;
		}
		return result;
	}
	
	public int rawMaterialUpdate(RawMaterialVO rawmaterial) {
		int result = 0;

		RawMaterialMapper mapper = sqlSession.getMapper(RawMaterialMapper.class);
		try {
			result = mapper.rawMaterialUpdate(rawmaterial);
		} catch (Exception e) {
			e.printStackTrace();
			return result;
		}
		return result;
	}
}
