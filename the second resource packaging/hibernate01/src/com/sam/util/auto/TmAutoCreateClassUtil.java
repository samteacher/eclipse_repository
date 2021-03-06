package com.sam.util.auto;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;

import com.sam.util.TmStringUtils;
import com.sam.util.date.TmDateUtil;
import com.sam.util.file.TmFileUtil;

public class TmAutoCreateClassUtil {
	
	
	//replace用替换的内容
	public static String author = "xuchengfei";
	public static String date = TmDateUtil.getCurrentDateTime();
	public static String description = "学生管理";
	
	//功能点
	public static String entityClass = "Student";//实体名称
	public static String lowerentity = "student";//实体的变量名
	//Department department;
	
	//action
	public static String actionpackage = "com.tz.web."+lowerentity;
	public static String daopackage = "com.tz.dao."+lowerentity;
	public static String daoImplpackage = "com.tz.dao."+lowerentity+".impl";
	public static String servicepackage =  "com.tz.service."+lowerentity;
	public static String serviceImplpackage = "com.tz.service."+lowerentity+".impl";
	public static String entitypackage = "com.tz.model";
	
	/**
	 * 构建entity
	 * @throws IOException
	 */
	public static void createEntity() throws IOException{
		String newClassName = getHomeDir("src/com/tz/model")+"/"+entityClass+".java";
		String actionTempContent = TmFileUtil.readFile(getHomeDir("src/template")+"entity.txt");
		new File(newClassName).getParentFile().mkdirs();
		if(!TmFileUtil.isExist(newClassName)){
			bulidClass(actionTempContent,newClassName,entitypackage);
			System.out.println("[TM构建类][Entity]===>  " +newClassName+"  [OK]");
		}else{
			System.out.println("[TM构建类][Entity]===>  " +entityClass+".java 该Dao类以及存在是否覆盖[y/n]!");
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			String line = reader.readLine();
			if(line!=null && line.equalsIgnoreCase("y")){
				bulidClass(actionTempContent,newClassName,entitypackage);
				System.out.println("[TM构建类][Entity]===>  " +newClassName+"  [覆盖OK]");
			}
		}
	}
	
	
	/**
	 * 构建Dao
	 * @throws IOException
	 */
	public static void createDaoClass() throws IOException{
		String newClassName = getHomeDir("src/com/tz/dao")+lowerentity+"/I"+entityClass+"Dao.java";
		String actionTempContent = TmFileUtil.readFile(getHomeDir("src/template")+"dao.txt");
		new File(newClassName).getParentFile().mkdirs();
		if(!TmFileUtil.isExist(newClassName)){
			bulidClass(actionTempContent,newClassName,daopackage);
			System.out.println("[TM构建类][Dao]===>  " +newClassName+"  [OK]");
		}else{
			System.out.println("[TM构建类][Dao]===>  " +entityClass+"Dao.java 该Dao类以及存在是否覆盖[y/n]!");
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			String line = reader.readLine();
			if(line!=null && line.equalsIgnoreCase("y")){
				bulidClass(actionTempContent,newClassName,daopackage);
				System.out.println("[TM构建类][Dao]===>  " +newClassName+"  [覆盖OK]");
			}
		}
	}
	
	
	
	/**
	 * 构建Dao
	 * @throws IOException
	 */
	public static void createDaoImplClass() throws IOException{
		String newClassName = getHomeDir("src/com/tz/dao")+lowerentity+"/impl/"+entityClass+"DaoImpl.java";
		String actionTempContent = TmFileUtil.readFile(getHomeDir("src/template")+"daoImpl.txt");
		new File(newClassName).getParentFile().mkdirs();
		if(!TmFileUtil.isExist(newClassName)){
			bulidClass(actionTempContent,newClassName,daoImplpackage);
			System.out.println("[TM构建类][DaoImpl]===>  " +newClassName+"  [OK]");
		}else{
			System.out.println("[TM构建类][DaoImpl]===>  " +entityClass+"DaoImpl.java 该DaoImpl类以及存在是否覆盖[y/n]!");
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			String line = reader.readLine();
			if(line!=null && line.equalsIgnoreCase("y")){
				bulidClass(actionTempContent,newClassName,daoImplpackage);
				System.out.println("[TM构建类][DaoImpl]===>  " +newClassName+"  [覆盖OK]");
			}
		}
	}
	
	
	/**
	 * 构建Dao
	 * @throws IOException
	 */
	public static void createSeviceClass() throws IOException{
		String newClassName = getHomeDir("src/com/tz/service")+lowerentity+"/I"+entityClass+"Service.java";
		String actionTempContent = TmFileUtil.readFile(getHomeDir("src/template")+"service.txt");
		new File(newClassName).getParentFile().mkdirs();
		if(!TmFileUtil.isExist(newClassName)){
			bulidClass(actionTempContent,newClassName,servicepackage);
			System.out.println("[TM构建类][Service]===>  " +newClassName+"  [OK]");
		}else{
			System.out.println("[TM构建类][Service]===>  " +entityClass+"Service.java 该Service类以及存在是否覆盖[y/n]!");
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			String line = reader.readLine();
			if(line!=null && line.equalsIgnoreCase("y")){
				bulidClass(actionTempContent,newClassName,servicepackage);
				System.out.println("[TM构建类][Service]===>  " +newClassName+"  [覆盖OK]");
			}
		}
	}
	
	
	/**
	 * 构建Dao
	 * @throws IOException
	 */
	public static void createServiceImplClass() throws IOException{
		String newClassName = getHomeDir("src/com/tz/service")+lowerentity+"/impl/"+entityClass+"ServiceImpl.java";
		String actionTempContent = TmFileUtil.readFile(getHomeDir("src/template")+"serviceImpl.txt");
		new File(newClassName).getParentFile().mkdirs();
		if(!TmFileUtil.isExist(newClassName)){
			bulidClass(actionTempContent,newClassName,serviceImplpackage);
			System.out.println("[TM构建类][ServiceImpl]===>  " +newClassName+"  [OK]");
		}else{
			System.out.println("[TM构建类][ServiceImpl]===>  " +entityClass+"ServiceImpl.java 该ServiceImpl类以及存在是否覆盖[y/n]!");
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			String line = reader.readLine();
			if(line!=null && line.equalsIgnoreCase("y")){
				bulidClass(actionTempContent,newClassName,serviceImplpackage);
				System.out.println("[TM构建类][ServiceImpl]===>  " +newClassName+"  [覆盖OK]");
			}
		}
	}
	
	/**
	 * 产生一个controller
	 * com.tz.util.auto 
	 * 方法名：createController
	 * 创建人：xuchengfei 
	 * 时间：2015年4月7日-上午12:56:04 
	 * @throws IOException void
	 * @exception 
	 * @since  1.0.0
	 */
	public static void createController() throws IOException{
		String newClassName = getHomeDir("src/com/tz/web")+lowerentity+"/"+entityClass+"Controller.java";
		String actionTempContent = TmFileUtil.readFile(getHomeDir("src/template")+"action.txt");
		new File(newClassName).getParentFile().mkdirs();
		if(!TmFileUtil.isExist(newClassName)){
			bulidClass(actionTempContent,newClassName,actionpackage);
			System.out.println("[TM构建类][Controller]===>  " +newClassName+"  [OK]");
		}else{
			System.out.println("[TM构建类][Controller]===>  " +entityClass+"Controller.java 该Controller类以及存在是否覆盖[y/n]!");
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			String line = reader.readLine();
			if(line!=null && line.equalsIgnoreCase("y")){
				bulidClass(actionTempContent,newClassName,actionpackage);
				System.out.println("[TM构建类][Controller]===>  " +newClassName+"  [覆盖OK]");
			}
		}
	}
	
	
	public static void createList() throws IOException{
		String newClassName = getHomeDir("/WebRoot/WEB-INF/pages")+lowerentity+"/list.jsp";
		String actionTempContent = TmFileUtil.readFile(getHomeDir("src/template")+"list.txt");
		new File(newClassName).getParentFile().mkdirs();
		if(!TmFileUtil.isExist(newClassName)){
			bulidClass(actionTempContent,newClassName,null);
			System.out.println("[TM构建类][list]===>  " +newClassName+"  [OK]");
		}else{
			System.out.println("[TM构建类][list]===>  " +entityClass+"list.jsp 该list类以及存在是否覆盖[y/n]!");
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			String line = reader.readLine();
			if(line!=null && line.equalsIgnoreCase("y")){
				bulidClass(actionTempContent,newClassName,null);
				System.out.println("[TM构建类][list]===>  " +newClassName+"  [覆盖OK]");
			}
		}
	}
	
	public static void createListTemplate() throws IOException{
		String newClassName = getHomeDir("/WebRoot/WEB-INF/pages")+lowerentity+"/listTemplate.jsp";
		String actionTempContent = TmFileUtil.readFile(getHomeDir("src/template")+"listTemplate.txt");
		new File(newClassName).getParentFile().mkdirs();
		if(!TmFileUtil.isExist(newClassName)){
			bulidClass(actionTempContent,newClassName,null);
			System.out.println("[TM构建类][listTemplate]===>  " +newClassName+"  [OK]");
		}else{
			System.out.println("[TM构建类][listTemplate]===>  " +entityClass+"listTemplate.jsp 该list类以及存在是否覆盖[y/n]!");
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			String line = reader.readLine();
			if(line!=null && line.equalsIgnoreCase("y")){
				bulidClass(actionTempContent,newClassName,null);
				System.out.println("[TM构建类][listTemplate]===>  " +newClassName+"  [覆盖OK]");
			}
		}
	}
	
	public static void createAddPage() throws IOException{
		String newClassName = getHomeDir("/WebRoot/WEB-INF/pages")+lowerentity+"/add.jsp";
		String actionTempContent = TmFileUtil.readFile(getHomeDir("src/template")+"add.txt");
		new File(newClassName).getParentFile().mkdirs();
		if(!TmFileUtil.isExist(newClassName)){
			bulidClass(actionTempContent,newClassName,null);
			System.out.println("[TM构建类][add]===>  " +newClassName+"  [OK]");
		}else{
			System.out.println("[TM构建类][add]===>  " +entityClass+"listTemplate.jsp 该add类以及存在是否覆盖[y/n]!");
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			String line = reader.readLine();
			if(line!=null && line.equalsIgnoreCase("y")){
				bulidClass(actionTempContent,newClassName,null);
				System.out.println("[TM构建类][add]===>  " +newClassName+"  [覆盖OK]");
			}
		}
	}
	
	
	public static void bulidClass(String actionTempContent,String newFilepath,String pkg){
		actionTempContent = actionTempContent
				.replaceAll("\\[author\\]", author)
				.replaceAll("\\[date\\]", date)
				.replaceAll("\\[actionpackage\\]", pkg)
				.replaceAll("\\[description\\]", description)
				.replaceAll("\\[lowerentity\\]", lowerentity)
				.replaceAll("\\[capentity\\]", lowerentity)
				.replaceAll("\\[entityClass\\]", entityClass);
		 TmFileUtil.writeFileByLine(actionTempContent,newFilepath);
	}
	
	
	public static void main(String[] args) throws IOException {
		createEntity();
		createDaoClass();
		createDaoImplClass();
		createSeviceClass();
		createServiceImplClass();
		createController();
		createList();
		createListTemplate();
		createAddPage();
	}
	
	/**
	 * 获取工程的目录
	 */
	public static String getHomeDir(){
		return System.getProperty("user.dir");
	}
	
	public static String getHomeDir(String path){
		if(TmStringUtils.isNotEmpty(path)){
			return TmStringUtils.conversionSpecialCharacters(System.getProperty("user.dir"))+"/"+path+"/";
		}else{
			return getHomeDir();
		}
	}
}
