package com.project.erp.dao;

import java.util.ArrayList;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.project.erp.vo.SupplierVO;

@Repository
public class SupplierDAO {

	@Autowired
	SqlSessionTemplate sqlSession;

	public int supplierInsert(SupplierVO supplier) {
		int result = 0;

		SupplierMapper mapper = sqlSession.getMapper(SupplierMapper.class);
		try {
			result = mapper.supplierInsert(supplier);
		} catch (Exception e) {
			e.printStackTrace();
			return result;
		}
		return result;
	}

	public ArrayList<SupplierVO> supplierAllSelect() {
		ArrayList<SupplierVO> result = null;

		SupplierMapper mapper = sqlSession.getMapper(SupplierMapper.class);
		try {
			result = mapper.supplierAllSelect();
		} catch (Exception e) {
			e.printStackTrace();
			return result;
		}
		return result;
	}

	public int supplierDelete(SupplierVO supplier) {
		int result = 0;

		SupplierMapper mapper = sqlSession.getMapper(SupplierMapper.class);
		try {
			result = mapper.supplierDelete(supplier);
		} catch (Exception e) {
			e.printStackTrace();
			return result;
		}
		return result;
	}

	public int supplierUpdate(SupplierVO supplier) {
		int result = 0;

		SupplierMapper mapper = sqlSession.getMapper(SupplierMapper.class);
		try {
			result = mapper.supplierUpdate(supplier);
		} catch (Exception e) {
			e.printStackTrace();
			return result;
		}
		return result;
	}
	
	public SupplierVO supplierOneSelect(SupplierVO supplier) {
		SupplierVO result = null;
		
		SupplierMapper mapper = sqlSession.getMapper(SupplierMapper.class);
		try {
			result = mapper.supplierOneSelect(supplier);
		} catch (Exception e) {
			e.printStackTrace();
			return result;
		}
		return result;
	}
}
