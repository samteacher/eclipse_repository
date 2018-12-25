<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML>
<html>
 <head>
<meta charset="utf-8">
<title>详情页</title>
<link href="../css/sg.css" rel="stylesheet" type="text/css" />
<link href="../css/teacher.css" rel="stylesheet" type="text/css" />
</head>

<body>
<!-- 引入头部页面 -->
<%@include file="header.jsp" %>

<div id="container">
     <div class="detail_con">
          <div class="det_bt">${comment.title}</div>
          <div class="det_sm">
               <div class="fl"><span>发表于：${comment.createtime }  作者：${user.account }</span></div>
               <div class="fr"><a href="#"><i class="discuss teac_icon"></i><span>评论</span></a><a href="#"><i class="forward teac_icon"></i><span>转发</span></a><a href="#"><i class="praise teac_icon"></i><span>点赞</span></a></div>
               <div class="clearfix"></div>
          </div>
          <div class="det_nr">${comment.content}</div>
          <div id="message">
                <div class="mes_nr">
                     <textarea name="" cols="" rows="" class="text_area" id="content"></textarea>
                     <div class="tongbu"><span>同步到：</span><a href="#" class="teac_icon xinlang"></a><a href="#" class="teac_icon tengxun"></a><a href="#" class="teac_icon renren"></a></div>
                     <div class="fabiao"><input name="" type="button" id="sendcontent" class="submit" value="发表评论" /><span>还可以输入140字</span></div>
                     <div class="clearfix"></div>
                </div>
                <div class="mes_list">
                     <div class="sort"><a href="#" class="current">按时间</a>&nbsp;&nbsp;|&nbsp;&nbsp;<a href="#">按热门</a></div>
                     <div class="disc_list">
                          <div class="pic"><a href="#"><img src="../images/pic.jpg" width="43" height="43" /></a></div>
                          <div class="liuyan1">
                               <dl>
                                   <dt>天上的星星</dt>
                                   <dd>推荐你们去看一部电影，叫代理人，其实未来的世界就是那样的！</dd>                                   
                               </dl>
                               <div class="pubdata">
                                    <span>发表于：2014-9-05 19:13:48 |</span>
                                    <a href="#" class="fl">只看该作者</a>
                                    <a href="#" class="fr"><span class="nolike teac_icon"></span><p>不喜欢(21)</p></a>
                                    <a href="#" class="fr"><span class="onlike teac_icon"></span><p>喜欢(123)</p></a>
                               </div>
                          </div>
                          <div class="clearfix"></div>
                     </div>
                     <div class="disc_list">
                          <div class="pic"><a href="#"><img src="../images/img1.jpg" width="43" height="43" /></a></div>
                          <div class="liuyan1">
                               <dl>
                                   <dt>未来世界</dt>
                                   <dd>推荐你们去看一部电影，叫代理人，其实未来的世界就是那样的！推荐你们去看一部电影，叫代理人，其实未来的世界就是那样的！推荐你们去看一部电影，叫代理人，其实未来的世界就是那样的！推荐你们去看一部电影，叫代理人，其实未来的世界就是那样的！</dd>
                               </dl>
                               <div class="pubdata">
                                    <span>发表于：2014-9-05 19:13:48 |</span>
                                    <a href="#" class="fl">只看该作者</a>
                                    <a href="#" class="fr"><span class="nolike teac_icon"></span><p>不喜欢(3)</p></a>
                                    <a href="#" class="fr"><span class="onlike teac_icon"></span><p>喜欢(234)</p></a>
                               </div>
                          </div>
                          <div class="clearfix"></div>
                     </div>
                     
                     <div class="pagesize">
                          <ul>
                              <li><span>跳转到：</span><input name="" type="text" class="text_box" /><input name="" type="button" value="GO" class="text_btn" /></li>
                              <li><a href="#">下一页</a></li>
                              <li><a href="#">上一页</a></li>
                          </ul>                              
                     </div>
                     <div class="clearfix"></div>
                </div>
           </div>
     </div>
</div>
<div id="footer"><p>Copyright © 2013-2014 www.mooncollege.cn All Rights Reserved版权所有：湖南潭州教育咨询有限公司 备案号：备13016338号</p></div>

<script type="text/javascript" src=/book/js/jquery-1.11.1.min.js></script>
<script type="text/javascript" src=/book/js/util.js></script>
<script type="text/javascript">
	
	$("#sendcontent").click(function(){
		var content = $("#content").val();
		if(isEmpty(content)){
			$("#content").foucs();
			alert("请输入评论");
			return;
		}
		$.ajax({
			type:"post",
			url:"/book/page/saveComment",
			data:{"content":content,"userId":userId,"logId":logId},
			beforeSend:function(){},
			success:function(data){
				if(data=="success"){
					alert("保存成功");
				}else{
					alert("保存失败");
				}
			}
		});
		
		
	});

</script>

</body>
</html>
