<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<html>
  <head>
  
  	<title>潭州学院添加页面</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<style>
		*{padding: 0;margin:0}
		ul,li{list-style:none;}
		a{color:#333;text-decoration: none;}
		body{font-size:14px;font-family: "微软雅黑";background:#333;background-size:cover;background-position:center;}
		#box{width:235px;background:#fff;text-align:center;border:1px solid #ccc;margin:10px auto;color:#fff;padding:0px 5px 5px 5px;position:absolute;top:10px;left:780px;}
		#box ul{height:170px;position:relative;z-index: 2}
		#box ul li{float:left;height:50px;width:75px;background:red;margin:5px 5px 0px 0;}
		#box ul li:nth-child(3n){margin-right:0px;}
		#box ul li img{height:50px;width:75px;}
		#box .uppadbox{height:160px;background:#eaeaea;border:2px dashed #c5c5c5;position:relative;z-index: 2}
		#box .uppadbox h3{line-height: 125px;font-size:24px;color:#c5c5c5;text-shadow: 1px 1px 1px #999;}
		#box .uppadbox p{color:#c5c5c5}
		
		#box .buttons{height:75px;line-height: 75px;position:relative;z-index: 2}
		#box .buttons a{padding:8px 16px;background:#333;color:#fff;border-radius:2px;}
		#box .buttons a:hover{background:#111}
		
		#prograssbar{position:absolute;width:100%;height:0%;bottom:0;left:0;background:linear-gradient(green,red);z-index:1}
		
		
		.jcrop-holder #preview-pane{display:block;position:absolute;z-index:2000;top:10px;right:-280px;padding:6px;border:1px rgba(0,0,0,.4) solid;background-color:white;-webkit-border-radius:6px;-moz-border-radius:6px;border-radius:6px;-webkit-box-shadow:1px 1px 5px 2px rgba(0,0,0,0.2);-moz-box-shadow:1px 1px 5px 2px rgba(0,0,0,0.2);box-shadow:1px 1px 5px 2px rgba(0,0,0,0.2);}
		#preview-pane .preview-container{width:250px;height:170px;overflow:hidden;}
		
	</style>
	
	<link rel="stylesheet" href="http://localhost/tzupload/css/jquery.Jcrop.min.css"/>
  	<script type="text/javascript" src="http://localhost/tzupload/js/jquery-1.11.2.min.js"></script>
  	<script type="text/javascript" src="http://localhost/tzupload/js/jquery.Jcrop.min.js"></script>
  </head>
  <body>
  
  <img src="../images/bg.jpg" data-bgsrc="images/bg.jpg" width="600" height="400" id="target" />
  <div id="preview-pane">
    <div class="preview-container">
      <img src="../images/bg.jpg" class="jcrop-preview" id="preview"/>
    </div>
  </div>
  <input type="t" size="4" id="x" name="x1" />
  <input type="t" size="4" id="y" name="y1" />
  <input type="t" size="4" id="w" name="w" />
  <input type="t" size="4" id="h" name="h" />
  <input type="button" value="确定裁剪头像" onclick="tzcut()">

  <script type="text/javascript">
	  var jcrop_api = null;	
	  $(function(){
		 var boundx,
			boundy,
			imgw,
			imgh,
			$preview = $('#preview-pane'),
			$pcnt = $('#preview-pane .preview-container'),
			$pimg = $('#preview-pane .preview-container img'),

			xsize = $pcnt.width(),
			ysize = $pcnt.height();
		  	
			$("#target").Jcrop({
			  onChange: updatePreview,
			  onSelect: updatePreview,
			  aspectRatio: xsize / ysize
			},function(){
			  var bounds = this.getBounds();
			  boundx = bounds[0];
			  boundy = bounds[1];
			  jcrop_api = this;
			  $preview.appendTo(jcrop_api.ui.holder);
			});

			function updatePreview(c){
			  if (parseInt(c.w) > 0){
				var rx = xsize / c.w;
				var ry = ysize / c.h;
				$pimg.css({
				  width: Math.round(rx * boundx) + 'px',
				  height: Math.round(ry * boundy) + 'px',
				  marginLeft: '-' + Math.round(rx * c.x) + 'px',
				  marginTop: '-' + Math.round(ry * c.y) + 'px'
				});
				 var ratiox = (c.imgw / 600);
				 var ratioy = (c.imgh / 400);
				 $("#x").val(c.x*ratiox);
				 $("#y").val(c.y*ratioy);
				 $("#w").val(c.w*ratiox);
				 $("#h").val(c.h*ratioy);
			  }
			};  
	  });
	  	
	  
	  
	  function  tzcut(){
		  var src = $("#target").data("bgsrc");
		  var x = parseInt($("#x").val());
		  var y = parseInt($("#y").val());
		  var w = parseInt($("#w").val());
		  var h = parseInt($("#h").val());
		  var params = {bgsrc:src,x:x,y:y,w:w,h:h,smallsrc:"avatar/2015/1110/kekeheader.jpg"};
		  $.ajax({
			  type:"post",
			  url:"http://localhost/tzupload/up/cut.html",
			  data:params,
			  success:function(data){
				  //上传的图片删掉
			  }
		  });
	  }
	</script>
	
	
	
	
	
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  	<div id="box">
  		<ul>
  			<li><img src="http://image.paiwo.co/10450/style/52bdf344d4c032ce520b8bdca8f5399e@!280x280"/></li>
  			<li><img src="http://image.paiwo.co/10450/style/1a74e5ecd19c3ee721232af0a641f9c3@!280x200"/></li>
  			<li><img src="http://image.paiwo.co/10450/style/abfb89ab65cf9a84ca305de54b0c6c34@!280x200"/></li>
  			<li><img src="http://image.paiwo.co/10450/style/61143eb65e3768e0c41d49a00173acc3@!280x200"/></li>
  			<li><img src="http://image.paiwo.co/10450/style/1a74e5ecd19c3ee721232af0a641f9c3@!280x200"/></li>
  			<li><img src="http://image.paiwo.co/10450/style/1a74e5ecd19c3ee721232af0a641f9c3@!280x200"/></li>
  			<li><img src="http://image.paiwo.co/10450/style/1a74e5ecd19c3ee721232af0a641f9c3@!280x200"/></li>
  			<li><img src="http://image.paiwo.co/10450/style/d89e400a3f2b5de44c6f7d4828dd916e@!280x200"/></li>
  			<li><img src="http://image.paiwo.co/10450/style/1a74e5ecd19c3ee721232af0a641f9c3@!280x200"/></li>
  		</ul>
  		<div class="uppadbox" id="file_uploadarea">
  			<h3>将文件拖放该区域</h3>
  			<p>请上传小于5MB的图片</p>
  			
  		</div>
  		<div class="buttons">
  			<a href="#" class="sure">确认</a>
  			<a href="#" class="cancle">取消</a>
  		</div>
  		<div id="prograssbar"></div>
  	</div>
  	

  	<script type="text/javascript">
		  	//鼠标拖离事件
		  	document.ondragleave = function(e){
		  		e.preventDefault();//阻止浏览器的默认行为
		  	};
		  	
		  	//拖放后事件
		  	document.ondrop = function(e){
		  		e.preventDefault();//阻止浏览器的默认行为
		  	};
		  	//鼠标拖动按下去的时候
		  	document.ondragover = function(e){
		  		e.preventDefault();
		  	};
		  	//鼠标拖动按下去的时候
		  	document.ondragenter = function(e){
		  		e.preventDefault();
		  	};
		  	
		  	var index = 0;
		  	function tzupload(){
		  		var fileboxDom = document.getElementById("file_uploadarea");
		  		var prograssbarDom = document.getElementById("prograssbar");
		  		fileboxDom.addEventListener("dragenter",function(e){
		  			fileboxDom.style.background="#ccc";
		  		},false);
		  		
		  		fileboxDom.addEventListener("dragleave",function(e){
		  			fileboxDom.style.background="";
		  		},false);
		  		
		  		fileboxDom.addEventListener("drop",function(e){
		  			fileboxDom.style.background="";
		  			//file是一个文件列表
		  			var files = e.dataTransfer.files;
		  			//取第一张图片
		  			var file =files[0];
		  			//文件的名称
		  			var name = file.name;
		  			//file.name:文件名称
		  			//file.size:文件大小
		  			//file.type:文件类型
		  			if(name.indexOf("jpg")==-1){
		  				alert("请选择图片....");
		  				return;
		  			}
		  			
		  			//没错通过ajax
		  			var xhr = new XMLHttpRequest();
		  			xhr.open("post","http://localhost/tzupload/up/file.html",true);
		  			xhr.setRequestHeader("X-Requested-With", "XMLHttpRequest");
		  			//设置文件数据
		  			var fd = new FormData();
		  			fd.append("doc",file);
			  		xhr.upload.addEventListener("progress",function(evt){
			  			if(evt.lengthComputable){
							var percent = event.loaded / event.total;
							var p = Math.floor(percent*100);
							prograssbarDom.style.height = p+"%";
							if(p>=100){
								var timer = null;
								timer = setInterval(function(){
									if(p>0){
										p--;
										prograssbarDom.style.height = p+"%";
									}else{
										clearInterval(timer);
										prograssbarDom.style.height = "0%";
									}
								},17);
							}
						}
			  		},true);
		  			xhr.send(fd);
		  			xhr.onreadystatechange = function(){
		  				if(xhr.readyState==4 && xhr.status == 200){
		  					var data = $.trim(xhr.responseText);
		  					var json =JSON.parse(data);
		  					var inum = index%9;
		  					console.log(inum);
		  					var src = json.url+"?"+new Date().getTime();
		  					$("#box").find("li").eq(inum).find("img").attr("src","http://localhost/tzupload/"+src);
		  					//$("body").css("backgroundImage","url('http://localhost/tzupload/"+src+"')");
		  					$("#target,#preview").data("bgsrc",json.url).attr("src","http://localhost/tzupload/"+src);
		  					jcrop_api.setImage("http://localhost/tzupload/"+src);
		  					index++;
		  				}
		  			};
		  		}, false);
		  	};
		  	
		  	tzupload();
  	</script>
  </body>
</html>
