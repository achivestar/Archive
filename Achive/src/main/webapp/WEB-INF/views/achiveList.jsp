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
                              <%--   <li class="nav-item">
                                    <a class="nav-link" href="${pageContext.request.contextPath}/avi" data-no="2" onclick="go_url2()">동영상 등록</a>
                                </li> --%>
                                  <li class="nav-item active selected">
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
            <div style="height:140px">
            	
            </div>
                  <div class="container">
						<table class="table">
							<thead style="background-color:steelblue;color:#fff">
								<tr style="text-align:center">
									<td width="5%">No</td>
									<td width="40%">앨범명</td>
									<td width="25%">썸네일</td>
									<td width="15%">촬영일</td>
									<td width="15%" >삭제</td>
								</tr>
							</thead>
							<tbody  style="background-color:#fff;color:#000">
								<c:if test="${empty list}">
							    	<tr style="text-align:center">
							    		<td colspan="6" style="vertical-align:middle">등록된 데이터가 없습니다..</td>
							    	</tr>
							    </c:if>
							  <c:forEach items="${list}" var="list" varStatus="status">
							    
							  <c:set var="TextValue" value="${list.sdate}"/>
							   
								<tr style="text-align:center">
									<td style="vertical-align:middle">${status.count }</td>
									<td  style="vertical-align:middle">${list.subject }</td>
                                    <td  style="vertical-align:middle"><img src="${pageContext.request.contextPath}/resources/upload/s-thumb/${list.s_thumb }"  style="width:80%;"/></td>      	    
									<td  style="vertical-align:middle">${fn:substring(TextValue,0,10)}</td>
									<td  style="vertical-align:middle"><%-- <a href="${pageContext.request.contextPath}/imgModify?idx=${list.idx}" class="btn btn-warning">수정</a>&nbsp; --%>
						        <a href='#deleteModal' data-toggle='modal'  data-id='${list.idx}' class='btn btn-danger btn-lg open-deleteDialog' onclick='deleteView(${list.idx},"${list.gubun}")'>삭제</a></td>
								</tr>
								</c:forEach>
							</tbody>
						</table>		   
                </div>                                 

                    
        </div> <!-- .cd-hero -->
        


<!--  Delete Modal -->
  <div class="modal fade" id="deleteModal"  tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
  <div class="modal-dialog  modal-sm">
    <div class="modal-content">
      <div class="modal-header">
          <h5 class="modal-title" id="exampleModalLabel"></h5>
	      <button type="button" class="close" data-dismiss="modal" aria-label="Close" onclick='location.reload()'>
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="modal-body">	
	    <p style="font-size:14px">삭제 후에도 새로 등록하실 수 있습니다.<br>삭제 하시겠습니까?</p>
      </div>
       <div class="modal-footer">
        <button type="button" class="btn btn-secondary btn-lg" data-dismiss="modal">Close</button>
        <button type="button" class="btn btn-primary btn-lg"  id="delete">Delete</button>
      </div>
    </div>
  </div>
</div>

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
function deleteView(idx,gubun){
	
	if(gubun == "image"){
		console.log('image');
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
	}else{
		console.log("media");
		  $("#delete").click(function(){
				$.ajax({
					type: "post", 
					processData: false,
					contentType:'application/x-www-form-urlencoded; charset=UTF-8',
					url: "${pageContext.request.contextPath}/aviDelete", 
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
	
}
</script>
</body>
</html>