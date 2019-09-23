package com.project.erp.dao;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.project.erp.vo.ManufactureVO;
import com.project.erp.vo.ProductMaterialVO;
import com.project.erp.vo.ProductVO;

@Mapper
@Repository
public interface ProductionMapper {

	public int productionInsert(ProductVO product);
	public ArrayList<ManufactureVO> produceSelect(ManufactureVO manufacture);
 	public ArrayList<ProductVO> productionSelect(ProductVO product);
	public int productionDelete(ProductVO product);
	public ProductVO selectLatestProduct();
	public int insertProudctMaterial(ProductMaterialVO productMaterial);
	
	public ArrayList<ProductMaterialVO> productMaterialSelect(ProductMaterialVO vo);		//생산품 원자재 select
}
