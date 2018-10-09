package com.imooc.o2o.util;


import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

import javax.imageio.ImageIO;

import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import net.coobird.thumbnailator.Thumbnails;
import net.coobird.thumbnailator.geometry.Positions;

public class ImageUtil {
	private static String basePath=Thread.currentThread().getContextClassLoader().getResource("").getPath();
	private static final SimpleDateFormat sDateFormat = 
			new SimpleDateFormat("yyyyMMddHHmmss");
	private static final Random r = new Random();
	
	/**
	 * 处理缩略图，并返回新生成图片的相对值路径
	 * @param thumbnail
	 * @param targetAddr
	 * @return
	 */
	public static String generateThumbnail(InputStream thumbnailInputStream,String fileName,String targetAddr){
		String realFileName=getRandomFileName();
		String extension=getFileExtension(fileName);
		makeDirPath(targetAddr);
		String relativeAddr = targetAddr+realFileName+extension;
		File dest = new File(PathUtil.getImgBasePath()+relativeAddr);
		try {
			Thumbnails.of(thumbnailInputStream).size(200, 200)
			.watermark(Positions.BOTTOM_RIGHT, ImageIO.read(new File(basePath+"/timg.jpg"))
					, 0.2f).outputQuality(0.8f).toFile(dest);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return relativeAddr;
	}
	
	/*public static String generateThumbnail(CommonsMultipartFile thumbnail,String targetAddr){
		String realFileName=getRandomFileName();
		String extension=getFileExtension(thumbnail);
		makeDirPath(targetAddr);
		String relativeAddr = targetAddr+realFileName+extension;
		File dest = new File(PathUtil.getImgBasePath()+relativeAddr);
		try {
			Thumbnails.of(thumbnail.getInputStream()).size(200, 200)
			.watermark(Positions.BOTTOM_RIGHT, ImageIO.read(new File(basePath+"/timg.jpg"))
					, 0.2f).outputQuality(0.25f).toFile(dest);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return relativeAddr;
	}*/
	/**
	 * 创建目标路径所涉及到的目录，即
	 * @param targetAddr
	 */
	private static void makeDirPath(String targetAddr) {
		String realFileParentPath=PathUtil.getImgBasePath()+targetAddr;
		File dirPath=new File(realFileParentPath);
		if(!dirPath.exists()){
			dirPath.mkdirs();
		}
	}
	/**
	 * 获取输入文件流的扩展名
	 * @param thumbnail
	 * @return
	 */
	private static String getFileExtension(String fileName) {
		 
		return fileName.substring(fileName.lastIndexOf("."));
	}
	
	/*private static String getFileExtension(CommonsMultipartFile cFile) {
		String originalFileName=cFile.getOriginalFilename(); 
		return originalFileName.substring(originalFileName.lastIndexOf("."));
	}*/
	

	/**
	 * 生成随机文件名，当前年月日小时分钟秒钟+五位随机数
	 * @param args
	 * @throws IOException
	 */
	public static String getRandomFileName(){
		//获取随机的五位数
		int rannum=r.nextInt(89999)+10000;
		String nowTime = sDateFormat.format(new Date());
		return nowTime+rannum;
		
	}
	public static void main(String[] args) throws IOException {
		String basePath=Thread.currentThread().getContextClassLoader().getResource("").getPath();
		Thumbnails.of("C:/Users/kafun/Desktop/image/4/bb.jpg")
		.size(200, 200).watermark(Positions.BOTTOM_RIGHT, 
		ImageIO.read(new File(basePath+"/timg.jpg")), 0.25f)
		.outputQuality(0.8f).toFile("C:/Users/kafun/Desktop/image/4/bb1.jpg");
	}
	/**
	 * storePath是文件的路径还是目录的路径，
	 * 如果storePath是文件路径则删除文件，
	 * 如果storePath是目录路径则删除该目录下的所有文件
	 * @param storePath
	 */
	public static void deleteFileOrPath(String storePath){
		File fileOrPath=new File(PathUtil.getImgBasePath()+storePath);
		//判断是不是目录,是的话就删除目录
		if(fileOrPath.isDirectory()){
			File files[]=fileOrPath.listFiles();
			for(int i=0;i<files.length;i++){
				files[i].delete();
			}
		}
		//是文件的话删除
		fileOrPath.delete();
	}

}
