package com.imooc.o2o.service;

import static org.junit.Assert.assertEquals;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Date;

import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.imooc.o2o.BaseTest;
import com.imooc.o2o.dto.ShopExecution;
import com.imooc.o2o.entity.Area;
import com.imooc.o2o.entity.PersonInfo;
import com.imooc.o2o.entity.Shop;
import com.imooc.o2o.entity.ShopCategory;
import com.imooc.o2o.enums.ShopStateEnum;

public class ShopServiceTest extends BaseTest{
	@Autowired
	private ShopService shopService;
	
	@Test
	public void testQueryShopListAndCount(){
		Shop shopCondition=new Shop();
		ShopCategory sc=new ShopCategory();
		sc.setShopCategoryId(12L);
		shopCondition.setShopCategory(sc);
		ShopExecution se=shopService.getShopList(shopCondition, 1, 3);
		System.out.println("店铺列表数为："+se.getShopList().size());
		System.out.println("店铺总数数为："+se.getCount());
	}
	
	@Test
	@Ignore
	public void testModifyShop() throws FileNotFoundException{
		Shop shop = new Shop();
		shop.setShopId(75L);
		shop.setShopName("修改后店铺名称");
		File shopImg = new File("C:/Users/kafun/Desktop/image/4/bb.jpg");
	    InputStream is=new FileInputStream(shopImg);
	    ShopExecution shopExecution=shopService.modifyShop(shop, is, "bb.jpg");
	    System.out.println("新图片地址："+shopExecution.getShop().getShopImg());
	}
	
	@Test
	@Ignore
	public void testAddShop() throws FileNotFoundException{
		Shop shop = new Shop();
		  PersonInfo owner = new PersonInfo();
		  Area area = new Area();
		  ShopCategory shopCategory = new ShopCategory();
		  owner.setUserId(10L);
		  area.setAreaId(3);
		  shopCategory.setShopCategoryId(14L);
		  shop.setOwner(owner);
		  shop.setArea(area);
		  shop.setShopCategory(shopCategory);
		  shop.setShopName("test1");
		  shop.setShopDesc("tes");
		  shop.setShopAddr("tes");
		  shop.setPhone("test");
		  shop.setCreateTime(new Date());
		  shop.setEnableStatus(ShopStateEnum.CHECK.getState());
		  shop.setAdvice("审核中");
		  File shopImg = new File("C:/Users/kafun/Desktop/image/4/bb.jpg");
		  InputStream is=new FileInputStream(shopImg);
		  ShopExecution se = shopService.addShop(shop, is, shopImg.getName());
		  assertEquals(ShopStateEnum.CHECK.getState(),se.getState());
	}

}
