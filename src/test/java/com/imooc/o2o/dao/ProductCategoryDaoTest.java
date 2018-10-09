package com.imooc.o2o.dao;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.FixMethodOrder;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;

import com.imooc.o2o.BaseTest;
import com.imooc.o2o.entity.ProductCategory;

//让下面方法按顺序执行，NAME_ASCENDING按名字顺序执行
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ProductCategoryDaoTest extends BaseTest {
	@Autowired
	private ProductCategoryDao productCategoryDao;

	@Test
	@Ignore
	public void testBatchInsertProductCategory() throws Exception {
		ProductCategory productCategory = new ProductCategory();
		productCategory.setProductCategoryName("商品类别1");
		productCategory.setPriority(1);
		productCategory.setCreateTime(new Date());		
		productCategory.setShopId(15L);
		
		ProductCategory productCategory2 = new ProductCategory();
		productCategory2.setProductCategoryName("商品类别2");
		productCategory2.setPriority(2);
		productCategory2.setCreateTime(new Date());
		productCategory2.setShopId(15L);
		List<ProductCategory> productCategoryList = new ArrayList<ProductCategory>();
		productCategoryList.add(productCategory);
		productCategoryList.add(productCategory2);
		int effectedNum = productCategoryDao
				.batchInsertProductCategory(productCategoryList);
		assertEquals(2, effectedNum);
	}

	@Test
	@Ignore
	public void testAQueryByShopId() throws Exception {
		long shopId = 20;
		List<ProductCategory> productCategoryList = productCategoryDao
				.queryProductCategoryList(shopId);
		assertEquals(2, productCategoryList.size());
		System.out.println(productCategoryList.get(0).toString());

	}

	@Test
	public void testCDeleteProductCategory() throws Exception {
		long shopId = 73;
		List<ProductCategory> productCategoryList = productCategoryDao
				.queryProductCategoryList(shopId);
		int effectedNum = productCategoryDao.deleteProductCategory(
				productCategoryList.get(0).getProductCategoryId(), shopId);
		assertEquals(1, effectedNum);
		effectedNum = productCategoryDao.deleteProductCategory(
				productCategoryList.get(1).getProductCategoryId(), shopId);
		assertEquals(1, effectedNum);
	}
}
