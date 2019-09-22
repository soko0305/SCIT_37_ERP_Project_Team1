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
	public ArrayList<ManufactureVO> produceSelect();
 	public ArrayList<ProductVO> productionSelect();
	public int productionDelete(ProductVO product);
	public ProductVO selectLatestProduct();
	public int insertProudctMaterial(ProductMaterialVO productMaterial);
	public int deleteProduce(ManufactureVO manufacture);
	public int deleteProduction(ProductVO product);
	public ProductVO selelctProductByCode(String pd_code);
	public ArrayList<ProductMaterialVO> selectAllProductMaterial(String pd_code);
	public int productionUpdate(ProductVO product);
	public int deleteProudctMaterial(String pd_code);
}

