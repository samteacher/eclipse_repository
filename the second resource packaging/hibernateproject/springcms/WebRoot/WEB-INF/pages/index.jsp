<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta  charset="utf-8" />
<title>Shamcey - Metro Style Admin Template</title>
<link rel="stylesheet" href="${basePath}/css/style.default.css" type="text/css" />
<link rel="stylesheet" href="${basePath}/css/responsive-tables.css">
<script type="text/javascript" src="${basePath}/js/jquery-1.9.1.min.js"></script>
<script type="text/javascript" src="${basePath}/js/jquery-migrate-1.1.1.min.js"></script>
<script type="text/javascript" src="${basePath}/js/jquery-ui-1.9.2.min.js"></script>
<script type="text/javascript" src="${basePath}/js/modernizr.min.js"></script>
<script type="text/javascript" src="${basePath}/js/jquery.cookie.js"></script>
<script type="text/javascript" src="${basePath}/js/jquery.uniform.min.js"></script>
<script type="text/javascript" src="${basePath}/js/flot/jquery.flot.min.js"></script>
<script type="text/javascript" src="${basePath}/js/flot/jquery.flot.resize.min.js"></script>
<script type="text/javascript" src="${basePath}/js/responsive-tables.js"></script>
<!--[if lte IE 8]><script language="javascript" type="text/javascript" src="${basePath}/js/excanvas.min.js"></script><![endif]-->
</head>

<body>

<div class="mainwrapper">
    
    <div class="header">
        <div class="logo">
            <a href="dashboard.html"><img src="images/logo.png" alt="" height="40"/></a>
        </div>
        <div class="headerinner">
            <ul class="headmenu">
                <li class="odd">
                    <a class="dropdown-toggle" data-toggle="dropdown" href="#">
                        <span class="headmenu-label">首页</span>
                    </a>
                </li>
                <li>
                    <a class="dropdown-toggle" data-toggle="dropdown" data-target="#">
                    <span class="headmenu-label">内容管理</span>
                    </a>
                </li>
                <li class="odd">
                    <a class="dropdown-toggle" data-toggle="dropdown" data-target="#">
						<span class="headmenu-label">栏目管理</span>
                    </a>
                </li>
				<li class="odd">
                    <a class="dropdown-toggle" data-toggle="dropdown" data-target="#">
						<span class="headmenu-label">用户管理</span>
                    </a>
                </li>
				<li class="odd">
                    <a class="dropdown-toggle" data-toggle="dropdown" data-target="#">
						<span class="headmenu-label">组件管理</span>
                    </a>
                </li>
				<li class="odd">
                    <a class="dropdown-toggle" data-toggle="dropdown" data-target="#">
						<span class="headmenu-label">参数配置</span>
                    </a>
                </li>
                <li class="right">
                    <div class="userloggedinfo">
                        <img src="images/ross_03.jpg" alt="" />
                        <div class="userinfo">
                            <h5>xuchengfeifei@163.com</h5>
                            <ul>
                                <li><a href="javascript:void(0);">退出</a></li>
                            </ul>
                        </div>
                    </div>
                </li>
            </ul><!--headmenu-->
        </div>
    </div>
    
     <div class="leftpanel">
        <div class="leftmenu">        
            <ul class="nav nav-tabs nav-stacked">
            	<li class="nav-header">Navigation</li>
                <li><a href="index.html"><span class="iconfa-laptop"></span> 首页</a></li>
                <li><a href="buttons.html"><span class="iconfa-hand-up"></span> 按钮和图标</a></li>
                <li class="dropdown"><a href="forms.html"><span class="iconfa-pencil"></span> 表单</a></li>
                <li class="dropdown"><a href="elements.html"><span class="iconfa-briefcase"></span> 页面元素</a></li>
                <li class="dropdown active"><a href="table.html"><span class="iconfa-th-list"></span> 表格</a></li>
				<li><a href="charts.html"><span class="iconfa-signal"></span> 统计报表</a></li>
                <li class="dropdown"><a href="404.html"><span class="iconfa-book"></span> 错误页面</a></li>
				<li><a href="date.html"><span class="iconfa-calendar"></span> 日期组件</a></li>
				<li><a href="media.html"><span class="iconfa-picture"></span> 媒体元素</a></li>
               <li><a href="dialog.html"><span class="iconfa-envelope"></span> 弹出层</a></li>
            </ul>
        </div><!--leftmenu-->
    </div><!-- leftpanel -->
    
    <div class="rightpanel">
        
        <ul class="breadcrumbs">
            <li><a href="dashboard.html"><i class="iconfa-home"></i></a> <span class="separator"></span></li>
            <li>Dashboard</li>
            <li class="right">
                    <a href="" data-toggle="dropdown" class="dropdown-toggle"><i class="icon-tint"></i> Color Skins</a>
                    <ul class="dropdown-menu pull-right skin-color">
                        <li><a href="default">Default</a></li>
                        <li><a href="navyblue">Navy Blue</a></li>
                        <li><a href="palegreen">Pale Green</a></li>
                        <li><a href="red">Red</a></li>
                        <li><a href="green">Green</a></li>
                        <li><a href="brown">Brown</a></li>
                    </ul>
            </li>
        </ul>
        
        <div class="maincontent">
            <div class="maincontentinner">
                <div class="row-fluid">
                    <div id="dashboard-left" class="span8">
                        
                        <h5 class="subtitle">Recently Viewed Pages</h5>
                        <ul class="shortcuts">
                            <li class="events">
                                <a href="">
                                    <span class="shortcuts-icon iconsi-event"></span>
                                    <span class="shortcuts-label">Events</span>
                                </a>
                            </li>
                            <li class="products">
                                <a href="">
                                    <span class="shortcuts-icon iconsi-cart"></span>
                                    <span class="shortcuts-label">Products</span>
                                </a>
                            </li>
                            <li class="archive">
                                <a href="">
                                    <span class="shortcuts-icon iconsi-archive"></span>
                                    <span class="shortcuts-label">Archives</span>
                                </a>
                            </li>
                            <li class="help">
                                <a href="">
                                    <span class="shortcuts-icon iconsi-help"></span>
                                    <span class="shortcuts-label">Help</span>
                                </a>
                            </li>
                            <li class="last images">
                                <a href="">
                                    <span class="shortcuts-icon iconsi-images"></span>
                                    <span class="shortcuts-label">Images</span>
                                </a>
                            </li>
                        </ul>
                        
                        <br />
                        
                        <h5 class="subtitle">Daily Statistics</h5><br />
                        <div id="chartplace" style="height:300px;"></div>
                        
                        <div class="divider30"></div>
                        
                        <table class="table table-bordered responsive">
                            <thead>
                                <tr>
                                    <th class="head1">Rendering engine</th>
                                    <th class="head0">Browser</th>
                                    <th class="head1">Platform(s)</th>
                                    <th class="head0">Engine version</th>
                                    <th class="head1">CSS grade</th>
                                </tr>
                            </thead>
                            <tbody>
                                <tr>
                                    <td>Trident</td>
                                    <td>Internet  Explorer 5.5</td>
                                    <td>Win 95+</td>
                                    <td class="center">5.5</td>
                                    <td class="center">A</td>
                                </tr>
                                <tr>
                                    <td>Trident</td>
                                    <td>Internet Explorer 6</td>
                                    <td>Win 98+</td>
                                    <td class="center">6</td>
                                    <td class="center">A</td>
                                </tr>
                                <tr>
                                    <td>Trident</td>
                                    <td>Internet Explorer 7</td>
                                    <td>Win XP SP2+</td>
                                    <td class="center">7</td>
                                    <td class="center">A</td>
                                </tr>
                            </tbody>
                        </table>
                        
                        <br />
                        
                        <h4 class="widgettitle"><span class="icon-comment icon-white"></span> Recent Comments</h4>
                        <div class="widgetcontent nopadding">
                            <ul class="commentlist">
                                <li>
                                    <img src="images/photos/thumb2.png" alt="" class="pull-left" />
                                    <div class="comment-info">
                                        <h4><a href="">Sed ut perspiciatis unde omnis iste natus error sit voluptatem</a></h4>
                                        <h5>in <a href="">Sit Voluptatem</a></h5>
                                        <p>Nemo enim ipsam voluptatem quia voluptas sit aspernatur aut odit aut fugit, sed quia consequuntur magni dolores eos qui ratione voluptatem sequi nesciunt. </p>
                                        <p>
                                            <a href="" class="btn btn-success btn-small"><span class="icon-thumbs-up icon-white"></span> Approve</a>
                                            <a href="" class="btn btn-small"><span class="icon-thumbs-down"></span> Reject</a>
                                        </p>
                                    </div>
                                </li>
                                <li>
                                    <img src="images/photos/thumb1.png" alt="" class="pull-left" />
                                    <div class="comment-info">
                                        <h4><a href="">But I must explain to you how all this mistaken</a></h4>
                                        <h5>in <a href="">At vero eos et accusamus et iusto odio dignissimos</a></h5>
                                        <p>Temporibus autem quibusdam et aut officiis debitis aut rerum necessitatibus saepe eveniet ut et voluptates repudiandae sint et molestiae non recusandae.</p>
                                        <p>
                                            <a href="" class="btn btn-success btn-small"><span class="icon-thumbs-up icon-white"></span> Approve</a>
                                            <a href="" class="btn btn-small"><span class="icon-thumbs-down"></span> Reject</a>
                                        </p>
                                    </div>
                                </li>
                                <li>
                                    <img src="images/photos/thumb10.png" alt="" class="pull-left" />
                                    <div class="comment-info">
                                        <h4><a href="">On the other hand, we denounce with righteous indignation</a></h4>
                                        <h5>in <a href="">These cases are perfectly simple and easy to distinguish</a></h5>
                                        <p>Nemo enim ipsam voluptatem quia voluptas sit aspernatur aut odit aut fugit, sed quia.</p>
                                        <p>
                                            <a href="" class="btn btn-success btn-small"><span class="icon-thumbs-up icon-white"></span> Approve</a>
                                            <a href="" class="btn btn-small"><span class="icon-thumbs-down"></span> Reject</a>
                                        </p>
                                    </div>
                                </li>
                                <li><a href="">View More Comments</a></li>
                            </ul>
                        </div>
                        
                        <br />
                        
                        
                    </div><!--span8-->
                    
                    <div id="dashboard-right" class="span4">
                        
                        <h5 class="subtitle">Announcements</h5>
                        
                        <div class="divider15"></div>
                        
                        <div class="alert alert-block">
                              <button data-dismiss="alert" class="close" type="button">&times;</button>
                              <h4>Warning!</h4>
                              <p style="margin: 8px 0">Best check yo self, you're not looking too good. Nulla vitae elit libero, a pharetra augue. Praesent commodo cursus magna.</p>
                        </div><!--alert-->
                        
                        <br />
                        
                        <h5 class="subtitle">Summaries</h5>
                            
                        <div class="divider15"></div>
                        
                        <div class="widgetbox">                        
                        <div class="headtitle">
                            <div class="btn-group">
                                <button data-toggle="dropdown" class="btn dropdown-toggle">Action <span class="caret"></span></button>
                                <ul class="dropdown-menu">
                                  <li><a href="#">Action</a></li>
                                  <li><a href="#">Another action</a></li>
                                  <li><a href="#">Something else here</a></li>
                                  <li class="divider"></li>
                                  <li><a href="#">Separated link</a></li>
                                </ul>
                            </div>
                            <h4 class="widgettitle">Widget Box</h4>
                        </div>
                        <div class="widgetcontent">
                            Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.
                        </div><!--widgetcontent-->
                        </div><!--widgetbox-->
                        
                        <h4 class="widgettitle">Event Calendar</h4>
                        <div class="widgetcontent nopadding">
                            <div id="datepicker"></div>
                        </div>
                        
                        <div class="tabbedwidget tab-primary">
                            <ul>
                                <li><a href="#tabs-1"><span class="iconfa-user"></span></a></li>
                                <li><a href="#tabs-2"><span class="iconfa-star"></span></a></li>
                                <li><a href="#tabs-3"><span class="iconfa-comments"></span></a></li>
                            </ul>
                            <div id="tabs-1" class="nopadding">
                                <h5 class="tabtitle">Last Logged In Users</h5>
                                <ul class="userlist">
                                    <li>
                                        <div>
                                            <img src="images/photos/thumb1.png" alt="" class="pull-left" />
                                            <div class="uinfo">
                                                <h5>Draniem Daamul</h5>
                                                <span class="pos">Software Engineer</span>
                                                <span>Last Logged In: 04/20/2013 8:40PM</span>
                                            </div>
                                        </div>
                                    </li>
                                    <li>
                                        <div>
                                            <img src="images/photos/thumb2.png" alt="" class="pull-left" />
                                            <div class="uinfo">
                                                <h5>Therineka Chonpe</h5>
                                                <span class="pos">Regional Manager</span>
                                                <span>Last Logged In: 04/20/2013 3:30PM</span>
                                            </div>
                                        </div>
                                    </li>
                                    <li>
                                        <div>
                                            <img src="images/photos/thumb3.png" alt="" class="pull-left" />
                                            <div class="uinfo">
                                                <h5>Zaham Sindilmaca</h5>
                                                <span class="pos">Chief Technical Officer</span>
                                                <span>Last Logged In: 04/19/2013 1:30AM</span>
                                            </div>
                                        </div>
                                    </li>
                                    <li>
                                        <div>
                                            <img src="images/photos/thumb4.png" alt="" class="pull-left" />
                                            <div class="uinfo">
                                                <h5>Annie Cerona</h5>
                                                <span class="pos">Engineering Manager</span>
                                                <span>Last Logged In: 04/19/2013 11:30AM</span>
                                            </div>
                                        </div>
                                    </li>
                                    <li>
                                        <div>
                                            <img src="images/photos/thumb5.png" alt="" class="pull-left" />
                                            <div class="uinfo">
                                                <h5>Delher Carasbong</h5>
                                                <span class="pos">Software Engineer</span>
                                                <span>Last Logged In: 04/19/2013 11:00AM</span>
                                            </div>
                                        </div>
                                    </li>
                                </ul>
                            </div>
                            <div id="tabs-2" class="nopadding">
                                <h5 class="tabtitle">Favorites</h5>
                                <ul class="userlist userlist-favorites">
                                                                        <li>
                                        <div>
                                            <img src="images/photos/thumb3.png" alt="" class="pull-left" />
                                            <div class="uinfo">
                                                <h5>Zaham Sindilmaca</h5>
                                                <p class="link">
                                                    <a href=""><i class="iconfa-envelope"></i> Message</a>
                                                    <a href=""><i class="iconfa-phone"></i> Call</a>
                                                </p>
                                            </div>
                                        </div>
                                    </li>
                                    <li>
                                        <div>
                                            <img src="images/photos/thumb4.png" alt="" class="pull-left" />
                                            <div class="uinfo">
                                                <h5>Annie Cerona</h5>
                                                <p class="link">
                                                    <a href=""><i class="iconfa-envelope"></i> Message</a>
                                                    <a href=""><i class="iconfa-phone"></i> Call</a>
                                                </p>
                                            </div>
                                        </div>
                                    </li>
                                    <li>
                                        <div>
                                            <img src="images/photos/thumb5.png" alt="" class="pull-left" />
                                            <div class="uinfo">
                                                <h5>Delher Carasbong</h5>
                                                <p class="link">
                                                    <a href=""><i class="iconfa-envelope"></i> Message</a>
                                                    <a href=""><i class="iconfa-phone"></i> Call</a>
                                                </p>
                                            </div>
                                        </div>
                                    </li>
                                    <li>
                                        <div>
                                            <img src="images/photos/thumb1.png" alt="" class="pull-left" />
                                            <div class="uinfo">
                                                <h5>Draniem Daamul</h5>
                                                <p class="link">
                                                    <a href=""><i class="iconfa-envelope"></i> Message</a>
                                                    <a href=""><i class="iconfa-phone"></i> Call</a>
                                                </p>
                                            </div>
                                        </div>
                                    </li>
                                    <li>
                                        <div>
                                            <img src="images/photos/thumb2.png" alt="" class="pull-left" />
                                            <div class="uinfo">
                                                <h5>Therineka Chonpe</h5>
                                                <p class="link">
                                                    <a href=""><i class="iconfa-envelope"></i> Message</a>
                                                    <a href=""><i class="iconfa-phone"></i> Call</a>
                                                </p>
                                            </div>
                                        </div>
                                    </li>
                                </ul>
                            </div>
                            <div id="tabs-3" class="nopadding">
                                <h5 class="tabtitle">Top Comments</h5>
                                <ul class="userlist">
                                    <li>
                                        <div>
                                            <img src="images/photos/thumb4.png" alt="" class="pull-left" />
                                            <div class="uinfo">
                                                <h5>Annie Cerona</h5>
                                                <p class="par">Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididun</p>
                                            </div>
                                        </div>
                                    </li>
                                    <li>
                                        <div>
                                            <img src="images/photos/thumb5.png" alt="" class="pull-left" />
                                            <div class="uinfo">
                                                <h5>Delher Carasbong</h5>
                                                <p class="par">Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididun</p>
                                            </div>
                                        </div>
                                    </li>
                                    <li>
                                        <div>
                                            <img src="images/photos/thumb1.png" alt="" class="pull-left" />
                                            <div class="uinfo">
                                                <h5>Draniem Daamul</h5>
                                                <p class="par">Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididun</p>
                                            </div>
                                        </div>
                                    </li>
                                    <li>
                                        <div>
                                            <img src="images/photos/thumb2.png" alt="" class="pull-left" />
                                            <div class="uinfo">
                                                <h5>Therineka Chonpe</h5>
                                                <p class="par">Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididun</p>
                                            </div>
                                        </div>
                                    </li>
                                    <li>
                                        <div>
                                            <img src="images/photos/thumb3.png" alt="" class="pull-left" />
                                            <div class="uinfo">
                                                <h5>Zaham Sindilmaca</h5>
                                                <p class="par">Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididun</p>
                                            </div>
                                        </div>
                                    </li>
                                </ul>
                            </div>
                        </div><!--tabbedwidget-->
                        
                        <br />
                                                
                    </div><!--span4-->
                </div><!--row-fluid-->
                
                <div class="footer">
                    <div class="footer-left">
                        <span>&copy; 2013. Shamcey Admin Template. All Rights Reserved.</span>
                    </div>
                    <div class="footer-right">
                        <span>Designed by: <a href="http://themepixels.com/">ThemePixels</a></span>
                    </div>
                </div><!--footer-->
                
            </div><!--maincontentinner-->
        </div><!--maincontent-->
        
    </div><!--rightpanel-->
    
</div><!--mainwrapper-->
<script type="text/javascript">
    jQuery(document).ready(function() {
        
      // simple chart
		var flash = [[0, 11], [1, 9], [2,12], [3, 8], [4, 7], [5, 3], [6, 1]];
		var html5 = [[0, 5], [1, 4], [2,4], [3, 1], [4, 9], [5, 10], [6, 13]];
      var css3 = [[0, 6], [1, 1], [2,9], [3, 12], [4, 10], [5, 12], [6, 11]];
			
		function showTooltip(x, y, contents) {
			jQuery('<div id="tooltip" class="tooltipflot">' + contents + '</div>').css( {
				position: 'absolute',
				display: 'none',
				top: y + 5,
				left: x + 5
			}).appendTo("body").fadeIn(200);
		}
	
			
		var plot = jQuery.plot(jQuery("#chartplace"),
			   [ { data: flash, label: "Flash(x)", color: "#6fad04"},
              { data: html5, label: "HTML5(x)", color: "#06c"},
              { data: css3, label: "CSS3", color: "#666"} ], {
				   series: {
					   lines: { show: true, fill: true, fillColor: { colors: [ { opacity: 0.05 }, { opacity: 0.15 } ] } },
					   points: { show: true }
				   },
				   legend: { position: 'nw'},
				   grid: { hoverable: true, clickable: true, borderColor: '#666', borderWidth: 2, labelMargin: 10 },
				   yaxis: { min: 0, max: 15 }
				 });
		
		var previousPoint = null;

		jQuery("#chartplace").bind("plothover", function (event, pos, item) {
			jQuery("#x").text(pos.x.toFixed(2));
			jQuery("#y").text(pos.y.toFixed(2));
			
			if(item) {
				if (previousPoint != item.dataIndex) {
					previousPoint = item.dataIndex;
						
					jQuery("#tooltip").remove();
					var x = item.datapoint[0].toFixed(2),
					y = item.datapoint[1].toFixed(2);
						
					showTooltip(item.pageX, item.pageY,
									item.series.label + " of " + x + " = " + y);
				}
			
			} else {
			   jQuery("#tooltip").remove();
			   previousPoint = null;            
			}
		
		});
		
		jQuery("#chartplace").bind("plotclick", function (event, pos, item) {
			if (item) {
				jQuery("#clickdata").text("You clicked point " + item.dataIndex + " in " + item.series.label + ".");
				plot.highlight(item.series, item.datapoint);
			}
		});
    
        
        //datepicker
        jQuery('#datepicker').datepicker();
        
        // tabbed widget
        jQuery('.tabbedwidget').tabs();
        
        
    
    });
</script>
</body>
</html>