package com.sam.test;

import java.io.*;
import java.util.LinkedList;

public class ImgTests {

	public static void main(String[] args) {
		traverseFolder1("F:\\20181115\\images");
	}

	public static void traverseFolder1(String path) {
		int fileNum = 0;
		int folderNum = 0;
		File file = new File(path);
		if (file.exists()) {
			LinkedList<File> list = new LinkedList<File>();
			File[] files = file.listFiles();
			for (File file2 : files) {
				if (file2.isDirectory()) {
					System.out.println("文件夹:" + file2.getAbsolutePath());
					list.add(file2);
					folderNum++;
				} else {
					// System.out.println("文件:" + file2.getAbsolutePath());
					copy(file2.getAbsolutePath(), "F:\\20181115\\images2\\");
					fileNum++;
				}
			}
		} else {
			System.out.println("文件不存在!");
		}
		System.out.println("文件夹共有:" + folderNum + ",文件共有:" + fileNum);

	}

	/**
	 * @param originalPath
	 * 原文件路径
	 * @param newPath
	 * 复制目的路径
	 * @return true:成功； false：失败
	 */
	private static void copy(String originalPath, String newPath) {
		File file = new File(originalPath);
		String fileName = file.getName();
		String fileType = fileName.substring(fileName.lastIndexOf("."));
		FileInputStream fis = null;
		FileOutputStream fos = null;
		try {
			fis = new FileInputStream(file);
			byte[] b = new byte[1024];
			int i = 0;

			String newFileName = fileName.substring(
					fileName.lastIndexOf("_") + 1, fileName.indexOf("."));
			newFileName += ".jpg";
			System.out.println(newPath + newFileName);
			File oFile = new File(newPath + newFileName);
			fos = new FileOutputStream(oFile);
			if (!oFile.exists()) {
				oFile.createNewFile();
			}
			while ((i = fis.read(b)) != -1) {
				fos.write(b);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (fis != null) {
					fis.close();
				}
				if (fos != null) {
					fos.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
