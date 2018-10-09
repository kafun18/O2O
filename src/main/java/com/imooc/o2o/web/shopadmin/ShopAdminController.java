package com.imooc.o2o.web.shopadmin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value="shopadmin",method=(RequestMethod.GET))
public class ShopAdminController {
	
	/**
	 * 店铺信息编辑
	 * @return
	 */
	@RequestMapping("/shopoperation")
	public String shopOperation(){
		return "shop/shopoperation";
		
	}
	
	/**
	 * 店铺列表
	 * @return
	 */
	@RequestMapping("/shoplist")
	public String shopList(){
		return "shop/shoplist";
		
	}
	
	/**
	 * 店铺管理页面
	 * @return
	 */
	@RequestMapping("/shopmanage")
	public String shopManage(){
		return "shop/shopmanage";
		
	}
	
	@RequestMapping(value="/productcategorymanagement",method=(RequestMethod.GET))
	public String productCategoryManage(){
		return "shop/productcategorymanage";
		
	}
	
}	
	
