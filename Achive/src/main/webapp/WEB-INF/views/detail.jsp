<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>         
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>    
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <title>J&STAY | 여행 프로그램 서비스 제공 장기체류 숙박</title>
    <!-- load stylesheets -->
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Open+Sans:300,400,600">  
    <!-- Google web font "Open Sans" -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/Font-Awesome-4.7/css/font-awesome.min.css">                
    <!-- Font Awesome -->
 
                   
    <!-- Bootstrap style -->
    
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css">     
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/hero-slider-style.css">                              
    <!-- Hero slider style (https://codyhouse.co/gem/hero-slider/) -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/magnific-popup.css">                                 
    <!-- Magnific popup style (http://dimsemenov.com/plugins/magnific-popup/) -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/templatemo-style.css">   
	                                  
    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
        <!--[if lt IE 9]>
          <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
          <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
          <![endif]-->

        <!-- These two JS are loaded at the top for gray scale including the loader. -->

        <script src="${pageContext.request.contextPath}/resources/js/jquery-1.11.3.min.js"></script>
        <!-- jQuery (https://jquery.com/download/) -->

        <script>

            function go_url(){
            	window.location.href="${pageContext.request.contextPath}/regist";
            }
            
            function go_url2(){
            	window.location.href="${pageContext.request.contextPath}/avi";
            }
            
            function go_url3(){
            	window.location.href="${pageContext.request.contextPath}/achiveList";
            }
            
            function go_url4(){
            	window.location.href="${pageContext.request.contextPath}/explain";
            }
        </script>
</head>

    <body>
        
        <!-- Content -->
        <div class="cd-hero">

            <!-- Navigation -->        
            <div class="cd-slider-nav">
                <nav class="navbar">
                    <div class="tm-navbar-bg">
                        
                        <a class="navbar-brand text-uppercase" href="/"><span style="color:red">A</span>
                        <span style="color:#fcba03">r</span><span style="color:green">c</span>hive&nbsp;Gallery</a>

                        <button class="navbar-toggler hidden-lg-up" type="button" data-toggle="collapse" data-target="#tmNavbar">
                            &#9776;
                        </button>
                         <div class="collapse navbar-toggleable-md text-xs-center text-uppercase tm-navbar" id="tmNavbar">
                            <ul class="nav navbar-nav">
                                <li class="nav-item active selected">
                                    <a class="nav-link" href="${pageContext.request.contextPath}/regist" data-no="1" onclick="go_url()">앨범등록</a>
                                </li>                                
                               <%--  <li class="nav-item">
                                    <a class="nav-link" href="${pageContext.request.contextPath}/avi" data-no="2" onclick="go_url2()">동영상 등록</a>
                                </li> --%>
                                 <li class="nav-item">
                                    <a class="nav-link" href="${pageContext.request.contextPath}/achiveList" data-no="3" onclick="go_url3()">앨범삭제</a>
                                </li>
                                <li class="nav-item">
                                    <a class="nav-link" href="${pageContext.request.contextPath}/explain" data-no="4" onclick="go_url4()">등록방법</a>
                                </li>
                            </ul>
                        </div>                         
                    </div>

                </nav>
            </div> 

            <ul class="cd-hero-slider">

                <!-- Page 1 Gallery One -->
                <li class="selected">                    
                    <div class="cd-full-width">
                        <div class="container-fluid js-tm-page-content" data-page-no="1" data-page-type="gallery">
                            <div class="tm-img-gallery-container">
                                <div class="tm-img-gallery">
                                <!-- Gallery One pop up connected with JS code below -->
          									<div class="col-md-2"></div>
                                     		<div class="col-md-8">
                                     				<br><br>
                                     				<c:set var="TextValue" value="${jsvo.sdate}"/>
                                     				<div style="width:100%;height:auto;padding:10px">
                                     				   <h2 style="color:#000;">${jsvo.subject }</h2>
                                     				  <span class="badge badge-pill">Date</span>&nbsp;<span style="color:#000;font-size:12px">${fn:substring(TextValue,0,11)}</span><br>
                                     				   <br>
                                     				   
                                     				<c:if test="${not empty jsvo.contents }">
                                     					<hr>
                                     					${jsvo.contents }
                                     				</c:if>
                                     				</div>
                                     				<br><br>
                                     				<c:if test="${not empty jsvo.aviSaveFileName1 }">
                                     					<div style="background-color:#fff;padding:20px;margin:20px">
                                     						<img src="${pageContext.request.contextPath}/resources/image/${jsvo.idx}/${jsvo.aviSaveFileName1}" />
                                     					</div>	
                                     				</c:if>
                                     				<c:if test="${not empty jsvo.aviSaveFileName2 }">
                                     				<div style="background-color:#fff;padding:20px;margin:20px">
                                     					<img src="${pageContext.request.contextPath}/resources/image/${jsvo.idx}/${jsvo.aviSaveFileName2}" />
                                     					</div>
                                     				</c:if>
                                     				<c:if test="${not empty jsvo.aviSaveFileName3 }">
                                     					<div style="background-color:#fff;padding:20px;margin:20px">
                                     						<img src="${pageContext.request.contextPath}/resources/image/${jsvo.idx}/${jsvo.aviSaveFileName3}" />
                                     					</div>
                                     				</c:if>
                                     				<c:if test="${not empty jsvo.aviSaveFileName4 }">
                                     					<div style="background-color:#fff;padding:20px;margin:20px">
                                     						<img src="${pageContext.request.contextPath}/resources/image/${jsvo.idx}/${jsvo.aviSaveFileName4}" />
                                     					</div>
                                     				</c:if>
                                     				<c:if test="${not empty jsvo.aviSaveFileName5 }">
                                     					<div style="background-color:#fff;padding:20px;margin:20px">
                                     						<img src="${pageContext.request.contextPath}/resources/image/${jsvo.idx}/${jsvo.aviSaveFileName5}" />
                                     					</div>
                                     				</c:if>
                                     				<c:if test="${not empty jsvo.aviSaveFileName6 }">
                                     					<div style="background-color:#fff;padding:20px;margin:20px">
                                     						<img src="${pageContext.request.contextPath}/resources/image/${jsvo.idx}/${jsvo.aviSaveFileName6}" />
                                     					</div>
                                     				</c:if>
                                     				<c:if test="${not empty jsvo.aviSaveFileName7 }">
                                     					<div style="background-color:#fff;padding:20px;margin:20px">
                                     						<img src="${pageContext.request.contextPath}/resources/image/${jsvo.idx}/${jsvo.aviSaveFileName7}" />
                                     					</div>
                                     				</c:if>
                                     				<c:if test="${not empty jsvo.aviSaveFileName8 }">
                                     					<div style="background-color:#fff;padding:20px;margin:20px">
                                     						<img src="${pageContext.request.contextPath}/resources/image/${jsvo.idx}/${jsvo.aviSaveFileName8}" />
                                     					</div>
                                     				</c:if>
                                     				<c:if test="${not empty jsvo.aviSaveFileName9 }">
                                     					<div style="background-color:#fff;padding:20px;margin:20px">
                                     						<img src="${pageContext.request.contextPath}/resources/image/${jsvo.idx}/${jsvo.aviSaveFileName9}" />
                                     					</div>
                                     				</c:if>
                                     				<c:if test="${not empty jsvo.aviSaveFileName10}">
                                     					<div style="background-color:#fff;padding:20px;margin:20px">
                                     					<img src="${pageContext.request.contextPath}/resources/image/${jsvo.idx}/${jsvo.aviSaveFileName10}" />
                                     					</div>
                                     				</c:if>
                                     			
                                     			<%-- <c:if test="${jsvo.gubun eq 'media'}">
                                     			<c:if test="${not empty jsvo.aviSaveFileName1 }">
                                     			<video src='${pageContext.request.contextPath}/resources/avi/${jsvo.idx}/${jsvo.aviSaveFileName1}' type="video/quicktime" width='100%' height="400px" controls autoplay>
												    해당 브라우저는 video 태그를 지원하지 않습니다.
												</video>
												</c:if>
												<br><br>
												<c:if test="${not empty jsvo.aviSaveFileName2 }">
												<video src='${pageContext.request.contextPath}/resources/avi/${jsvo.idx}/${jsvo.aviSaveFileName2}' type="video/quicktime"  width='100%' height="400px" controls autoplay>
												    해당 브라우저는 video 태그를 지원하지 않습니다.
												</video>
												</c:if>
												<br><br>
												<c:if test="${not empty jsvo.aviSaveFileName3 }">
												<video src='${pageContext.request.contextPath}/resources/avi/${jsvo.idx}/${jsvo.aviSaveFileName3}' type="video/quicktime"   width='100%' height="400px" controls autoplay>
												    해당 브라우저는 video 태그를 지원하지 않습니다.
												</video>
												</c:if>
                                     			</c:if> --%>
                                     		</div>
  											<div class="col-md-2"></div>
                                </div>                                 
                            </div>
                        </div>                                                    
                    </div>                    
                </li>

           
            </ul> <!-- .cd-hero-slider -->
            <div style="text-align:center;margin-bottom:30px">
			<button id="list" style="width:200px;height:50px;background-color:steelblue;color:#fff;border:none;cursor:pointer">목록</button>

            </div>
        </div> <!-- .cd-hero -->
        

        <!-- Preloader, https://ihatetomatoes.net/create-custom-preloading-screen/ -->
        <div id="loader-wrapper">
            
            <div id="loader"></div>
            <div class="loader-section section-left"></div>
            <div class="loader-section section-right"></div>

        </div>
        
        <!-- load JS files -->
        
        <script src="${pageContext.request.contextPath}/resources/js/tether.min.js"></script> <!-- Tether (http://tether.io/)  --> 
        <script src="${pageContext.request.contextPath}/resources/js/bootstrap.min.js"></script>             <!-- Bootstrap js (v4-alpha.getbootstrap.com/) -->
        <script src="${pageContext.request.contextPath}/resources/js/hero-slider-main.js"></script>          <!-- Hero slider (https://codyhouse.co/gem/hero-slider/) -->
        <script src="${pageContext.request.contextPath}/resources/js/jquery.magnific-popup.min.js"></script> <!-- Magnific popup (http://dimsemenov.com/plugins/magnific-popup/) -->
        
        <script>
        
        	$("#list").click(function(){
        		location.href="./";
        	});

            function adjustHeightOfPage(pageNo) {

                var pageContentHeight = 0;

                var pageType = $('div[data-page-no="' + pageNo + '"]').data("page-type");

                if( pageType != undefined && pageType == "gallery") {
                    pageContentHeight = $(".cd-hero-slider li:nth-of-type(" + pageNo + ") .tm-img-gallery-container").height();
                }
                else {
                    pageContentHeight = $(".cd-hero-slider li:nth-of-type(" + pageNo + ") .js-tm-page-content").height() + 20;
                }
               
                // Get the page height
                var totalPageHeight = $('.cd-slider-nav').height()
                                        + pageContentHeight
                                        + $('.tm-footer').outerHeight();

                // Adjust layout based on page height and window height
                if(totalPageHeight > $(window).height()) 
                {
                    $('.cd-hero-slider').addClass('small-screen');
                    $('.cd-hero-slider li:nth-of-type(' + pageNo + ')').css("min-height", totalPageHeight + "px");
                }
                else 
                {
                    $('.cd-hero-slider').removeClass('small-screen');
                    $('.cd-hero-slider li:nth-of-type(' + pageNo + ')').css("min-height", "100%");
                }
            }

            /*
                Everything is loaded including images.
            */
            $(window).load(function(){

       
                adjustHeightOfPage(1); // Adjust page height

                /* Gallery One pop up
                -----------------------------------------*/
                $('.gallery-one').magnificPopup({
                    delegate: 'a', // child items selector, by clicking on it popup will open
                    type: 'image',
                    gallery:{enabled:true}                
                });
				
				/* Gallery Two pop up
                -----------------------------------------*/
				$('.gallery-two').magnificPopup({
                    delegate: 'a',
                    type: 'image',
                    gallery:{enabled:true}                
                });

                /* Gallery Three pop up
                -----------------------------------------*/
                $('.gallery-three').magnificPopup({
                    delegate: 'a',
                    type: 'image',
                    gallery:{enabled:true}                
                });

                /* Collapse menu after click 
                -----------------------------------------*/
                $('#tmNavbar a').click(function(){
                    $('#tmNavbar').collapse('hide');

                    adjustHeightOfPage($(this).data("no")); // Adjust page height       
                });

                /* Browser resized 
                -----------------------------------------*/
                $( window ).resize(function() {
                    var currentPageNo = $(".cd-hero-slider li.selected .js-tm-page-content").data("page-no");
                    
                    // wait 3 seconds
                    setTimeout(function() {
                        adjustHeightOfPage( currentPageNo );
                    }, 1000);
                    
                });
        
                // Remove preloader (https://ihatetomatoes.net/create-custom-preloading-screen/)
                $('body').addClass('loaded');

                // Write current year in copyright text.
                $(".tm-copyright-year").text(new Date().getFullYear());
                           
            });

        
        </script>            

</body>
</html>