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
<!--
Fluid Gallery Template
http://www.templatemo.com/tm-500-fluid-gallery
-->
    <!-- load stylesheets -->
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Open+Sans:300,400,600">  
    <!-- Google web font "Open Sans" -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/Font-Awesome-4.7/css/font-awesome.min.css">  
    <link rel="stylesheet"  href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.8.2/css/all.min.css">             
    <!-- Font Awesome -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css">                                      
    <!-- Bootstrap style -->
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
		
            var tm_gray_site = false;
            
            if(tm_gray_site) {
                $('html').addClass('gray');
            }
            else {
                $('html').removeClass('gray');   
            }
            
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
            
            function go_addAlbum(){
            	window.location.href="${pageContext.request.contextPath}/regist";
            }
        </script>
        
        <style>
        	#addAlbum {
        		width:200px;
        		height:50px;
        		background-color:steelblue;
        		color:#fff;
        		cursor:pointer;
        		border:none
        	}
        </style>
      
</head>

    <body>
        
        <!-- Content -->
        <div class="cd-hero">

            <!-- Navigation -->        
            <div class="cd-slider-nav">
                <nav class="navbar">
                    <div class="tm-navbar-bg">
                        
                        <a class="navbar-brand text-uppercase" href="/">
                        <span style="color:red">A</span><span style="color:#fcba03">r</span><span style="color:green">c</span>hive&nbsp;Gallery</a>
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
                  	   <c:if test="${empty list}">
                              <p style="text-align:center;color:#000;font-size:20px;margin-top:220px">고객님의 소중한 사진을 등록해 주세요.<br><br>
                              <button id="addAlbum"  onclick="go_addAlbum()">앨범등록</button>
                              </p> 
                       </c:if>
                        <div class="container-fluid js-tm-page-content" data-page-no="1" data-page-type="gallery">
                            <div class="tm-img-gallery-container">
                                <div class="tm-img-gallery gallery-one">
                                <!-- Gallery One pop up connected with JS code below -->
                              	  
                                   <c:forEach items="${list}" var="list" varStatus="status">
                                   	<c:set var="TextValue" value="${list.sdate}"/>
                                    <div class="grid-item">
                                        <figure class="effect-sadie">
                                            <img src="${pageContext.request.contextPath}/resources/upload/m-thumb/${list.m_thumb}" alt="Image" class="img-fluid tm-img">
                                            <figcaption>
                                          	    <h2 class="tm-figure-title">${list.subject }</h2>
                                                <p class="tm-figure-description">${fn:substring(TextValue,0,11)}</p>
                                                <a href="./detail?idx=${list.idx }">View more</a>
                                            </figcaption>           
                                        </figure>
                                    </div>
                                    </c:forEach>
                                    
                                                                                                    
                                </div>                                 
                            </div>
                        </div>                                                    
                    </div>                    
                </li>

           
            </ul> <!-- .cd-hero-slider -->
            
        <!--     <footer class="tm-footer">

                
                <p class="tm-copyright-text">제주에서 J&STAY 에 머물다</p>

            </footer>
                     -->
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