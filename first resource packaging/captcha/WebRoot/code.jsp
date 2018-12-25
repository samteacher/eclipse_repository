<%@page import="com.moov.util.StringUtil"%>
<%@page import="java.awt.Font"%>
<%@page import="javax.imageio.ImageIO"%>
<%@page import="java.awt.Color"%>
<%@page import="java.awt.Graphics"%>
<%@page import="java.io.OutputStream"%>
<%@page import="java.awt.image.BufferedImage"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%

	response.setContentType("image/jpeg");
	response.setHeader("Pragma", "No-cache");
	response.setHeader("Cache-Control", "no-cache");
	response.setDateHeader("Expire", 0);
	
	//建立随机数
	Random random = new Random();
	//验证码的宽度和高度
	int width = 110;
	int height = 30;
	//画图对象
	BufferedImage image = new BufferedImage(width,height,BufferedImage.TYPE_INT_BGR);
	//利用输出流
	OutputStream os = response.getOutputStream();
	//画布  初始化画布
	Graphics g = image.getGraphics();
	//给画布添加颜色，字体建立颜色
	g.setColor(getRandomColor(200, 255));
	//描绘画布  给整个图片渲染
	g.fillRect(0, 0, width, height);
	
	
	
	g.setFont(new Font("微软雅黑",Font.PLAIN,20));
	g.setColor(Color.WHITE);
	//绘制直线  drawLine  绘制干扰线
	for(int i = 0;i<60;i++){
		int x = random.nextInt(width);
		int y = random.nextInt(height);
		int x1 = random.nextInt(120);
		int y2 = random.nextInt(120);
		g.drawLine(x, y, x1, y2);
	}
	
	int start = random.nextInt(100);
	int end = random.nextInt(100);
	//绘制文字数字  使用for循环主要是为了控制每一个字符的x,y轴位置
	g.setColor(getRandomColor(10, 180));
	HashMap<String,String> map = getRandDomString();
	g.drawString(map.get("randomString"), 17*random.nextInt(3)+10,22);
	
	//放入session作用域
	session.setAttribute("code", map.get("result"));
	g.dispose();
	
	//输出图片
	ImageIO.write(image, "JPEG", os);
	//关闭流，缓冲	
	os.flush();
	os.close();
	os = null;
	response.flushBuffer();
	
	//java.lang.IllegalStateException   写上这两名就不报错了
	out.close();
	out = pageContext.pushBody();
	
%>


<%!
	//数字算法验证码封装
	public static HashMap<String,String> getRandDomString(){
		Random random = new Random();
		int start = random.nextInt(100);
		int end = random.nextInt(100);
		int mark = random.nextInt(4);
		int result = 0;
		String rm ="";
		StringBuffer buffer = new StringBuffer();
		switch(mark){
		case 1:
			result = start + end;
			rm = "+";
			break;
		case 2:
			result = start - end;
			rm = "-";
			break;
		case 3:
			result = start * end;
			rm = "*";
			break;
		case 4:
			result = start / end;
			rm = "/";
			break;
		default:
			result = start % end;
			rm = "%";
			break;
		}
		buffer.append(start);
		buffer.append(rm);
		buffer.append(end);
		HashMap<String,String> map = new HashMap<String,String>();
		map.put("randomString", buffer.toString());
		map.put("result",String.valueOf(result));
		return map;
	}

	/**
	* 随机颜色
	*/
	public static Color getRandomColor(int rc,int bc){
		Random random = new Random();
		if(rc>255)rc=255;
		if(bc>255)bc=255;
		int red = rc + random.nextInt(bc-rc);
		int green = rc + random.nextInt(bc-rc);
		int blue = rc + random.nextInt(bc-rc);
		return new Color(red,green,blue);
	}

%>