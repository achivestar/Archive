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
                                <li class="nav-item">
                                    <a class="nav-link" href="${pageContext.request.contextPath}/regist" data-no="1" onclick="go_url()">앨범등록</a>
                                </li>                                
                               <%--  <li class="nav-item">
                                    <a class="nav-link" href="${pageContext.request.contextPath}/avi" data-no="2" onclick="go_url2()">동영상 등록</a>
                                </li> --%>
                                  <li class="nav-item ">
                                    <a class="nav-link" href="${pageContext.request.contextPath}/achiveList" data-no="3" onclick="go_url3()">앨범삭제</a>
                                </li>
                                 <li class="nav-item active selected">
                                    <a class="nav-link" href="${pageContext.request.contextPath}/explain" data-no="4" onclick="go_url4()">등록방법</a>
                                </li>
                               
                            </ul>
                        </div>                         
                    </div>

                </nav>
            </div> 
            <div style="height:140px"> </div>
                 <div class="container">
						<div class="cd-full-width">
                        <div class="container-fluid js-tm-page-content tm-page-pad" data-page-no="5">
                            <div class="tm-contact-page">                                
                                <div class="row">
                                    <div class="col-xs-12">
                                        <div class="tm-flex tm-contact-container">                                
                                            <div class="tm-bg-white-translucent text-xs-left tm-textbox tm-2-col-textbox-2 tm-textbox-padding tm-textbox-padding-contact">
                                                <h2 class="tm-contact-info" style="border-bottom:2px solid steelblue;padding-bottom:8px">사진 등록 방법</h2>
                                             		<br>
		                                   			<ol style="font-size:14px">
		            									<li>앨범명을 입력합니다.</li><br>
		            									<li>아래 그림과 같이 에디터에 앨범에 대한 간단한 메모를 작성합니다.
		            										<br><br>
		            										<img src="${pageContext.request.contextPath}/resources/img/caption1.PNG" />
		            									</li><br>
		            									
		            									<li>촬영한 사진을 아래 그림과같이 이미지 버튼을 클릭하여 등록합니다.<br>
		            										 한번에 여러장의 사진을 등록하실 수 있지만 최대 10개 이하로 제한합니다.
		            										 <br> <br>
		            										 <img src="${pageContext.request.contextPath}/resources/img/caption2.PNG" />
		            									</li><br>
		            									<li>앨범의 대표이미지가 필요하므로 이미지를 아래 그림과 같이 이미지 한개를 등록합니다.
		            									<br><br>
		            									<img src="${pageContext.request.contextPath}/resources/img/caption3.PNG" />
		            									</li><br>
		            									<li>사진을 촬영했던 촬영일자를 입력하고 등록 버튼을 누르면 앨범이 등록이 됩니다.</li>
		            								</ol>
                              
                                            </div>

                                           <%--  <div class="tm-bg-white-translucent text-xs-left tm-textbox tm-2-col-textbox-2 tm-textbox-padding tm-textbox-padding-contact">
                                                 <h2 class="tm-contact-info" style="border-bottom:2px solid steelblue;padding-bottom:8px">동영상 등록 방법</h2>
                                             		<br>
		                                   			<ol style="font-size:14px">
		            									<li>앨범명을 입력합니다.</li><br>
		            									<li>썸네일이 필요하므로 대표 이미지를 하나 등록합니다.</li><br>
		            									<li>영상을 촬영했던 촬영일자를 입력합니다.</li><br>
		            									<li>촬영한 영상을 아래와 같이 동영상추가 버튼을 클릭하여 등록합니다.<br>
		            									<img src="${pageContext.request.contextPath}/resources/img/avicaption.PNG" /><br>
		            										 한번에  최대 2개 이하의 영상을 업로드 합니다.<br>
		            										 영상 한개당 업로드 사이즈는 약 (200MB) 2분이내의 영상을 업로드 하시길 권장합니다.<br>
		            										 	(스마트폰 카메라 촬영 기준)
		            									</li><br>
		            									<li>등록 버튼을 누르면 동영상 등록이 완료 됩니다.<br>
		            									동영상파일 크기에 따라 동영상 등록 완료 로딩 시간이 다르며, 최장 2분정도 소요 될 수 있습니다.</li>
		            									
		            								</ol>
                                             
                                            </div> --%>

                                        </div>

                                    </div>

                                </div>

                            </div>    

                        </div>
                        
                    </div> <!-- .cd-full-width -->
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

            	
            	 var agent = navigator.userAgent.toLowerCase();
                 if(navigator.appName == 'Netscape' && navigator.userAgent.search('Trident') != -1){
                 	alert("IE 브라우저는 지원하지 않습니다. 최신의 Edge 브라우저 또는 크롬/사파리/오페라 브라우저를 권장합니다.");
             		location.href="https://www.google.co.kr/chrome/?brand=IBEF&gclid=Cj0KCQjwxdSHBhCdARIsAG6zhlUja7eY7i6JGDc7zeqGlh_55dk_5xIKBUmC5osrAHwE97tnYcvGo68aApiNEALw_wcB&gclsrc=aw.ds";
                 }

       
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
	<script>
	   $( function() {
	    $( "#datepicker" ).datepicker({
	    	showOn : "both",
	    	buttonImage : "${pageContext.request.contextPath}/resources/img/calendar.png",
	    	buttonImageOnly : true,
	    	dateFormat : "yy-mm-dd"
	    });
	  } );
	  </script>
<script>
function deleteView(idx){
	  $("#delete").click(function(){
			$.ajax({
				type: "post", 
				processData: false,
				contentType:'application/x-www-form-urlencoded; charset=UTF-8',
				url: "${pageContext.request.contextPath}/imgDelete", 
				data: 'idx='+idx, 
				dataType: 'html',
				success: function(data){
					alert("삭제 되었습니다..");
					location.href="${pageContext.request.contextPath}/achiveList"
				}
				,beforeSend : function(){
					$(".spinner").removeClass("displayLoding");
				},
				complete:function(){
					$(".spinner").addClass("displayLoding");	
				},
			    error:function(){
			    	$('#failModal').modal('show');
			    }
				
			})
		});
}
</script>
</body>
</html>