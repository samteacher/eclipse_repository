package com.sam.test;

import java.io.File;
import java.io.IOException;
import java.util.Map;
import java.util.Map.Entry;



public class Test {
	
	//新字符串,如果是去掉前缀后缀就留空，否则写上需要替换的字符串
	static String newString = "";
	//要被替换的字符串
	static String oldString = "home.cnblogs.comu";
	//文件所在路径，所有文件的根目录，记得修改为你电脑上的文件所在路径
	static String dir = "G:/";

	public static void main(String[] args) throws IOException {
		recursiveTraversalFolder(dir);//递归遍历此路径下所有文件夹
	}
	
	public static void recursiveTraversalFolder(String path) {
	File folder = new File(path);
    if (folder.exists()) {
    	File[] fileArr = folder.listFiles();
        if (null == fileArr || fileArr.length == 0) {
        	System.out.println("文件夹是空的!");
            return;
        } else {
        	File newDir = null;//文件所在文件夹路径+新文件名
            String newName = "";//新文件名
            String fileName = null;//旧文件名
            File parentPath = new File("");//文件所在父级路径
            for (File file : fileArr) {
            	if (file.isDirectory()) {//是文件夹，继续递归，如果需要重命名文件夹，这里可以做处理
            		System.out.println("文件夹:" + file.getAbsolutePath() + "，继续递归！");
                    recursiveTraversalFolder(file.getAbsolutePath());
                } else {//是文件，判断是否需要重命名
                	fileName = file.getName();
                    parentPath = file.getParentFile();
                    if (fileName.contains(oldString)) {//文件名包含需要被替换的字符串
                    	newName = fileName.replaceAll(oldString, newString);//新名字
                        newDir = new File(parentPath + "/" + newName);//文件所在文件夹路径+新文件名
                        file.renameTo(newDir);//重命名
                        System.out.println("修改后：" + newDir);
                     }
                 }
             }
         }
     } else {
         System.out.println("文件不存在!");
     }
 }
	
}
