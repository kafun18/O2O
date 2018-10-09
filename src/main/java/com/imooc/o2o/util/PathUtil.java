package com.imooc.o2o.util;

//import org.apache.jasper.tagplugins.jstl.core.If;

public class PathUtil {
	private static String seperator=System.getProperty("file.separator");
	public static String getImgBasePath(){
		String os = System.getProperty("os.name");
		String basePath = "";
		if(os.toLowerCase().startsWith("win")){
			basePath="C:/Users/kafun/Desktop/image/1/";
		}else {
			basePath="C:/Users/kafun/Desktop/image/2/";
		}
		basePath=basePath.replace("/",seperator);
		return basePath;			
	}
	
	public static String getShopImagePath(Long shopId){
		String imagePath="C:/Users/kafun/Desktop/image/3/";
		return imagePath.replace("/", seperator);
		//return imagePath;
		
	}
}
