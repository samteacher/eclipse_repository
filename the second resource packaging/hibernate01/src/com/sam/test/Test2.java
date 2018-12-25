package com.sam.test;

import java.io.File;

public class Test2 {

	public static void main(String[] args) {
		
		String realPath = "F:\\20181115\\images\\_0001_05040001.jpg";
		String folderPath = realPath.substring(0, realPath.lastIndexOf("\\"));
		File file = new File(folderPath);
		//目录路径
		String dirPath = file.getAbsolutePath();
		if (file.isDirectory()) {
	        File[] files = file.listFiles();//获取此目录下的文件列表
	        for (File fileFrom : files) {
		        String fromFile = fileFrom.getName();//得到单个文件名
		        if (fromFile.endsWith(".x")) {
	                 fromFile = fromFile.substring(0, fromFile.lastIndexOf(".x"));
	                 String toFileName = dirPath + "/" + fromFile;
	                 File toFile = new File(toFileName);
	                 if (fileFrom.exists() && !toFile.exists()) {
	                     //开始更名
	                     fileFrom.renameTo(toFile);
	                 }
		        }
	        }
		}  
	        
	}
}
