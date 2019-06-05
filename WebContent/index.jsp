<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>Home</title>
    <meta name="description" content="">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="robots" content="all,follow">
    <!-- Bootstrap CSS-->
    <link rel="stylesheet" href="vendor/bootstrap/css/bootstrap.min.css">
    <!-- Font Awesome CSS-->
    <link rel="stylesheet" href="vendor/font-awesome/css/font-awesome.min.css">
    <!-- Fontastic Custom icon font-->
    <link rel="stylesheet" href="css/fontastic.css">
    <!-- Google fonts - Poppins -->
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Poppins:300,400,700">
    <!-- theme stylesheet-->
    <link rel="stylesheet" href="css/style.default.css" id="theme-stylesheet">
    <!-- Custom stylesheet - for your changes-->
    <link rel="stylesheet" href="css/custom.css">
    <!-- Favicon-->
    <link rel="shortcut icon" href="img/favicon.ico">
    <!-- Tweaks for older IEs--><!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
        <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script><![endif]-->

    <link href="http://vjs.zencdn.net/5.5.3/video-js.css" rel="stylesheet">
    <!-- If you'd like to support IE8 -->
    <script src="http://vjs.zencdn.net/ie8/1.1.1/videojs-ie8.min.js"></script>
    <script src="http://vjs.zencdn.net/5.5.3/video.js"></script>  
  </head>
  <body>
    <div class="page">
      <!-- Main Navbar-->
      <header class="header">
        <nav class="navbar">
          <!-- Search Box-->
          <div class="search-box">
            <button class="dismiss"><i class="icon-close"></i></button>
            <form id="searchForm" action="#" role="search">
              <input type="search" placeholder="What are you looking for..." class="form-control">
            </form>
          </div>
          <div class="container-fluid">
            <div class="navbar-holder d-flex align-items-center justify-content-between">
              <!-- Navbar Header-->
              <div class="navbar-header">
                <!-- Navbar Brand --><a href="index.html" class="navbar-brand d-none d-sm-inline-block">
                  <div class="brand-text d-none d-lg-inline-block"><strong>人流量监控平台</strong></div>
                  <div class="brand-text d-none d-sm-inline-block d-lg-none"><strong>BD</strong></div></a>
                <!-- Toggle Button--><a id="toggle-btn" href="#" class="menu-btn active"><span></span><span></span><span></span></a>
              </div>
              <!-- Navbar Menu -->
              <ul class="nav-menu list-unstyled d-flex flex-md-row align-items-md-center">
                <!-- Search-->
                <li class="nav-item d-flex align-items-center"><a id="search" href="#"><i class="icon-search"></i></a></li>
                <!-- Notifications-->
                <li class="nav-item dropdown"> <a id="notifications" rel="nofollow" data-target="#" href="#" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false" class="nav-link"><i class="fa fa-bell-o"></i><span class="badge bg-red badge-corner">12</span></a>
                  <ul aria-labelledby="notifications" class="dropdown-menu">
                    <li><a rel="nofollow" href="#" class="dropdown-item"> 
                        <div class="notification">
                          <div class="notification-content"><i class="fa fa-envelope bg-green"></i>You have 6 new messages </div>
                          <div class="notification-time"><small>4 minutes ago</small></div>
                        </div></a></li>
                    <li><a rel="nofollow" href="#" class="dropdown-item"> 
                        <div class="notification">
                          <div class="notification-content"><i class="fa fa-twitter bg-blue"></i>You have 2 followers</div>
                          <div class="notification-time"><small>4 minutes ago</small></div>
                        </div></a></li>
                    <li><a rel="nofollow" href="#" class="dropdown-item"> 
                        <div class="notification">
                          <div class="notification-content"><i class="fa fa-upload bg-orange"></i>Server Rebooted</div>
                          <div class="notification-time"><small>4 minutes ago</small></div>
                        </div></a></li>
                    <li><a rel="nofollow" href="#" class="dropdown-item"> 
                        <div class="notification">
                          <div class="notification-content"><i class="fa fa-twitter bg-blue"></i>You have 2 followers</div>
                          <div class="notification-time"><small>10 minutes ago</small></div>
                        </div></a></li>
                    <li><a rel="nofollow" href="#" class="dropdown-item all-notifications text-center"> <strong>view all notifications                                            </strong></a></li>
                  </ul>
                </li>
                <!-- Messages                        -->
                <!-- <li class="nav-item dropdown"> <a id="messages" rel="nofollow" data-target="#" href="#" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false" class="nav-link"><i class="fa fa-envelope-o"></i><span class="badge bg-orange badge-corner">10</span></a>
                  <ul aria-labelledby="notifications" class="dropdown-menu">
                    <li><a rel="nofollow" href="#" class="dropdown-item d-flex"> 
                        <div class="msg-profile"> <img src="img/avatar-1.jpg" alt="..." class="img-fluid rounded-circle"></div>
                        <div class="msg-body">
                          <h3 class="h5">Jason Doe</h3><span>Sent You Message</span>
                        </div></a></li>
                    <li><a rel="nofollow" href="#" class="dropdown-item d-flex"> 
                        <div class="msg-profile"> <img src="img/avatar-2.jpg" alt="..." class="img-fluid rounded-circle"></div>
                        <div class="msg-body">
                          <h3 class="h5">Frank Williams</h3><span>Sent You Message</span>
                        </div></a></li>
                    <li><a rel="nofollow" href="#" class="dropdown-item d-flex"> 
                        <div class="msg-profile"> <img src="img/avatar-3.jpg" alt="..." class="img-fluid rounded-circle"></div>
                        <div class="msg-body">
                          <h3 class="h5">Ashley Wood</h3><span>Sent You Message</span>
                        </div></a></li>
                    <li><a rel="nofollow" href="#" class="dropdown-item all-notifications text-center"> <strong>Read all messages   </strong></a></li>
                  </ul>
                </li> -->
                <!-- Languages dropdown    -->
                <!-- <li class="nav-item dropdown"><a id="languages" rel="nofollow" data-target="#" href="#" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false" class="nav-link language dropdown-toggle"><img src="img/flags/16/GB.png" alt="English"><span class="d-none d-sm-inline-block">English</span></a>
                  <ul aria-labelledby="languages" class="dropdown-menu">
                    <li><a rel="nofollow" href="#" class="dropdown-item"> <img src="img/flags/16/DE.png" alt="English" class="mr-2">German</a></li>
                    <li><a rel="nofollow" href="#" class="dropdown-item"> <img src="img/flags/16/FR.png" alt="English" class="mr-2">French                                         </a></li>
                  </ul>
                </li> -->
                <!-- Logout    -->
                <li class="nav-item"><a href="login.html" class="nav-link logout"> <span class="d-none d-sm-inline">Logout</span><i class="fa fa-sign-out"></i></a></li>
              </ul>
            </div>
          </div>
        </nav>
      </header>
      <div class="page-content d-flex align-items-stretch"> 
        <!-- Side Navbar -->
        <nav class="side-navbar">
          <!-- Sidebar Header-->
          <div class="sidebar-header d-flex align-items-center">
            <div class="avatar"><img src="img/avatar-1.jpg" alt="..." class="img-fluid rounded-circle"></div>
            <div class="title">
              <h1 class="h4">Li Benkang</h1>
              <p>管理员1</p>
            </div>
          </div>
          <!-- Sidebar Navidation Menus-->
          <span class="heading">Main</span>
          <ul class="list-unstyled">
                    <li class="active"><a href="index.html"> <i class="icon-home"></i>Home </a></li>
                    <!-- <li><a href="tables.html"> <i class="icon-grid"></i>Tables </a></li> -->
                    <!-- <li><a href="charts.html"> <i class="fa fa-bar-chart"></i>Charts </a></li> -->
                    <!-- <li><a href="forms.html"> <i class="icon-padnote"></i>Forms </a></li> -->
                    <!-- <li><a href="#exampledropdownDropdown" aria-expanded="false" data-toggle="collapse"> <i class="icon-interface-windows"></i>Example dropdown </a>
                      <ul id="exampledropdownDropdown" class="collapse list-unstyled ">
                        <li><a href="#">Page</a></li>
                        <li><a href="#">Page</a></li>
                        <li><a href="#">Page</a></li>
                      </ul>
                    </li> -->
                    <!-- <li><a href="login.html"> <i class="icon-interface-windows"></i>Login page </a></li> -->
          </ul>
          
          <!-- <span class="heading">Extras</span>
          <ul class="list-unstyled">
            <li> <a href="#"> <i class="icon-flask"></i>Demo </a></li>
            <li> <a href="#"> <i class="icon-screen"></i>Demo </a></li>
            <li> <a href="#"> <i class="icon-mail"></i>Demo </a></li>
            <li> <a href="#"> <i class="icon-picture"></i>Demo </a></li>
          </ul> -->
        </nav>
        <div class="content-inner">
          <!-- Page Header-->
          <header class="page-header">
            <div class="container-fluid">
              <h2 class="no-margin-bottom">Dashboard</h2>
            </div>
          </header>
          <!-- Dashboard Counts Section-->
          
          <!-- Dashboard Header Section    -->
        
          <section class="dashboard-header">
            <div class="container-fluid">
              <!-- title -->
              <div class="project">
                <div class="row bg-white has-shadow">
                  <div class="left-col col-lg-6 d-flex align-items-center justify-content-between">
                    <div class="project-title d-flex align-items-center">
                      <div class="image has-shadow">
                        <img src="img/project-1.jpg" alt="..." class="img-fluid">
                      </div>
                      <div class="text">
                        <h3 class="h4">Camera 1</h3>
                        <small>the Xi'an railway station</small>
                      </div>
                    </div>
                  </div>
                  <div class="right-col col-lg-6 d-flex align-items-center">
                    <div class="time">
                      <i class="fa fa-clock-o"></i>
                      <span id="cg" class="hidden-sm-down">2016 / 12 / 21上午12:00:00</span>
                    </div>
                    <div class="project-progress">
                      <div class="progress">
                        <div role="progressbar" style="width: 45%; height: 6px;" aria-valuenow="25" aria-valuemin="0" aria-valuemax="100" class="progress-bar bg-red"></div>
                      </div>
                    </div>
                  </div>
                </div>
              </div>
              <!-- datas and groph -->
              <div class="row">
                <!-- Statistics -->
                <div class="statistics col-lg-2 col-12">
                  <div class="statistic d-flex align-items-center bg-white has-shadow">
                    <div class="icon bg-red"><i class="fa fa-tasks"></i></div>
                    <div class="text"><strong id="Camera1historyHighest">234</strong><br><small>历史最高人数</small></div>
                  </div>
                  <div class="statistic d-flex align-items-center bg-white has-shadow">
                    <div class="icon bg-green"><i class="fa fa-calendar-o"></i></div>
                    <div class="text"><strong id="Camera1hourHighest">152</strong><br><small>近一小时最高人数</small></div>
                  </div>
                  <div class="statistic d-flex align-items-center bg-white has-shadow">
                    <div class="icon bg-orange"><i class="fa fa-paper-plane-o"></i></div>
                    <div class="text"><strong id="Camera1currentCount">147</strong><br><small>当前人数</small></div>
                  </div>
                  <div class="statistic d-flex align-items-center bg-white has-shadow">
                    <div class="icon bg-blue"><i class="fa fa-circle-thin"></i></div>
                    <div class="text"><strong id="Camera1prediction">147</strong><br><small>预测未来5分钟内人数</small></div>
                  </div>
                  <div class="articles card">
                  	<div class="card-body no-padding">
                      <div class="item d-flex align-items-center">
                        <div class="image"><img src="img/avatar-1.jpg" alt="..." class="img-fluid rounded-circle"></div>
                        <div class="text"><a href="#">
                            <h3 class="h5">Security Officer 1</h3></a><small>Tel: 18351567516</small></div>
                      </div>
                     </div>
                   </div>
                </div>
                <div class="chart col-lg-5 col-12">
                  <div class="line-chart-example card">
                    <!-- <canvas id="lineCahrt"></canvas> -->
                    <div class="card-header d-flex align-items-center">
                      <h3 class="h4">监控视频</h3>
                    </div>
                    <div class="card-body">
                      <video id="my-video1" class="video-js" controls preload="auto" width="600" height="400" poster="img/mockup1.jpg"
                      data-setup="{}">
                      <source src="rtmp://localhost:1935/live/home" type="rtmp/flv"> </p>
                      </video>
                    </div>
                  </div>
               </div>

                <div class="chart col-lg-5 col-12">
                  <div class="card">
                    <div class="card-header d-flex align-items-center">
                      <h3 class="h4" id="camera1CurrentThreshole">当前阈值：10</h3>
                    </div>
                    <div class="card-body">
                      <div class="form-group">
                         <div class="input-group">
                            <input id="camera1Threshold" type="text" class="form-control" placeholder="大于零的数字">
                              <div class="input-group-append">
                                <button type="button" onclick="settingCamera1()" class="btn btn-primary">Go!</button>
                              </div>
                         </div>
                       </div>
                    </div>
                  </div>
                  <div class="line-chart-example card">
                    <div class="card-header d-flex align-items-center">
                      <h3 class="h4">近十分钟人流量</h3>
                    </div>
                    <div class="card-body">
                      <canvas id="lineChart1"></canvas>
                    </div>
                  </div>
                </div>
              </div>
            </div>
          </section>
          

          
          <section class="dashboard-header">
            <div class="container-fluid">
              <!-- title -->
              <div class="project">
                <div class="row bg-white has-shadow">
                  <div class="left-col col-lg-6 d-flex align-items-center justify-content-between">
                    <div class="project-title d-flex align-items-center">
                      <div class="image has-shadow">
                        <img src="img/project-1.jpg" alt="..." class="img-fluid">
                      </div>
                      <div class="text">
                        <h3 class="h4">Camera 2</h3>
                        <small>the NWPU</small>
                      </div>
                    </div>
                  </div>
                  <div class="right-col col-lg-6 d-flex align-items-center">
                    <div class="time">
                      <i class="fa fa-clock-o"></i><span id="cg2" class="hidden-sm-down">2016 / 12 / 21 ä¸å12:00:00</span>
                    </div>
                    
                    <div class="project-progress">
                      <div class="progress">
                        <div role="progressbar" style="width: 45%; height: 6px;" aria-valuenow="25" aria-valuemin="0" aria-valuemax="100" class="progress-bar bg-red"></div>
                      </div>
                    </div>
                  </div>
                </div>
              </div>
              <!-- datas and groph -->
              <div class="row">
                <!-- Statistics -->
                <div class="statistics col-lg-2 col-12">
                  <div class="statistic d-flex align-items-center bg-white has-shadow">
                    <div class="icon bg-red"><i class="fa fa-tasks"></i></div>
                    <div class="text"><strong id="Camera2historyHighest">234</strong><br><small>历史最高人数</small></div>
                  </div>
                  <div class="statistic d-flex align-items-center bg-white has-shadow">
                    <div class="icon bg-green"><i class="fa fa-calendar-o"></i></div>
                    <div class="text"><strong id="Camera2hourHighest">152</strong><br><small>近一小时最高人数</small></div>
                  </div>
                  <div class="statistic d-flex align-items-center bg-white has-shadow">
                    <div class="icon bg-orange"><i class="fa fa-paper-plane-o"></i></div>
                    <div class="text"><strong id="Camera2currentCount">147</strong><br><small>目前人数</small></div>
                  </div>
                  <div class="statistic d-flex align-items-center bg-white has-shadow">
                    <div class="icon bg-blue"><i class="fa fa-circle-thin"></i></div>
                    <div class="text"><strong id="Camera2prediction">147</strong><br><small>预测未来5分钟内人数</small></div>
                  </div>
                  <div class="articles card">
                  	<div class="card-body no-padding">
                      <div class="item d-flex align-items-center">
                        <div class="image"><img src="img/avatar-1.jpg" alt="..." class="img-fluid rounded-circle"></div>
                        <div class="text"><a href="#">
                            <h3 class="h5">Security Officer 2</h3></a><small>Tel: 13798561254</small></div>
                      </div>
                     </div>
                   </div>
                </div>
                <!-- Line Chart            -->
                <div class="chart col-lg-5 col-12">
                  <div class="line-chart-example card">
                    <!-- <canvas id="lineCahrt"></canvas> -->
                    <div class="card-header d-flex align-items-center">
                      <h3 class="h4">监控视频</h3>
                    </div>
                    <div class="card-body">
                      <video id="my-video2" class="video-js" controls preload="auto" width="600" height="400" poster="img/mockup1.jpg"
                      data-setup="{}">
                      <source src="rtmp://localhost:1935/live/home" type="rtmp/flv"> </p>
                      </video>
                    </div>
                  </div>
                </div>

                <div class="chart col-lg-5 col-12">
                  <div class="card">
                    <div class="card-header d-flex align-items-center">
                      <h3 class="h4" id="camera2CurrentThreshole">当前阈值：10</h3>
                    </div>
                    <div class="card-body">
                      <div class="form-group">
                         <div class="input-group">
                            <input type="text" id="camera2Threshold" class="form-control" placeholder="大于零的数字">
                              <div class="input-group-append">
                                <button type="button" onclick="settingCamera2()" class="btn btn-primary">Go!</button>
                              </div>
                         </div>
                       </div>
                    </div>
                  </div>
                  <div class="line-chart-example card">
                    <div class="card-header d-flex align-items-center">
                      <h3 class="h4">近十分钟人流量</h3>
                    </div>
                    <div class="card-body">
                      <canvas id="lineChart2"></canvas>
                    </div>
                  </div>
                </div>
              </div>
            </div>
          </section>
          <!-- Projects Section-->
          
          <!-- Client Section-->
          
          <!-- Feeds Section-->
          
          <!-- Updates Section                                                -->
          
          <!-- Page Footer-->
          <footer class="main-footer">
            <div class="container-fluid">
              <div class="row">
                <div class="col-sm-6">
                  <p>Copyright &copy; 2019.NWPU All rights reserved.</p>
                </div>
                <div class="col-sm-6 text-right">
                  <p></p>
                  <!-- Please do not remove the backlink to us unless you support further theme's development at https://bootstrapious.com/donate. It is part of the license conditions. Thank you for understanding :)-->
                </div>
              </div>
            </div>
          </footer>
        </div>
      </div>
    </div>
    <!-- JavaScript files-->
    <script src="vendor/jquery/jquery.min.js"></script>
    <script src="vendor/popper.js/umd/popper.min.js"> </script>
    <script src="vendor/bootstrap/js/bootstrap.min.js"></script>
    <script src="vendor/jquery.cookie/jquery.cookie.js"> </script>
    <script src="vendor/chart.js/Chart.min.js"></script>
    <script src="vendor/jquery-validation/jquery.validate.min.js"></script>
    <script src="js/charts-home.js"></script>
    <script src="js/charts-custom.js"></script>
    <script src="js/front.js"></script>
    <script>
        setInterval("cg.innerHTML=new Date().toLocaleString()",1000);
    </script>
    <script>
        setInterval("cg2.innerHTML=new Date().toLocaleString()",1000);
    </script>
	<script>
		function reloadView(x) {
			$.ajax({
				type : 'GET', // 请求类型, 默认为 GET
				url : "PeopleCount", // 	必需。规定把请求发送到哪个 URL。
				//data: "info="+value, // 可选。映射或字符串值。规定连同请求发送到服务器的数据。
				success : function(result) { // 可选。请求成功时执行的回调函数。
					// 展示结果
					console.log(result)
					var resultArr = result.split(",");
					$("#Camera1historyHighest").html(resultArr[0]);
					$("#Camera1hourHighest").html(resultArr[1]);
					$("#Camera1currentCount").html(resultArr[2]);
					$("#Camera1prediction").html(resultArr[3]);
					$("#Camera2historyHighest").html(resultArr[4]);
					$("#Camera2hourHighest").html(resultArr[5]);
					$("#Camera2currentCount").html(resultArr[6]);
					$("#Camera2prediction").html(resultArr[7]);
				}
			});
		};
		setInterval('reloadView()', 500);
		
		function settingCamera1(){
			var value = document.getElementById("camera1Threshold").value;
			$.ajax({
				type : 'POST', // 请求类型, 默认为 GET
				url : "ThresholeSetting", // 	必需。规定把请求发送到哪个 URL。
				data: {Threshole: "camera1" + value}, 
				success : function(result) { // 可选。请求成功时执行的回调函数。
					$("#camera1CurrentThreshole").html("当前阈值：" + result + "人");
					document.getElementById("camera1Threshold").value = "";
				}
			});
		};
		
		function settingCamera2(){
			var value = document.getElementById("camera2Threshold").value;
			$.ajax({
				type : 'POST', 
				url : "ThresholeSetting", 
				data: {Threshole: "camera2" + value}, 
				success : function(result) {
					$("#camera2CurrentThreshole").html("当前阈值：" + result + "人");
					document.getElementById("camera2Threshold").value = "";
				}
			});
		};
	</script>
	<!-- Main File-->
    
  </body>
</html>