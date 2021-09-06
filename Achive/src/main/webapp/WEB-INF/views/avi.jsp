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
        <script src="https://cdn.ckeditor.com/ckeditor5/29.0.0/classic/ckeditor.js"></script>
     <link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
     <style>
     	#save {background-color:steelblue;color:#fff;border:none;cursor:pointer}
     	#list {cursor:pointer;border:none}
        .displayLoding {
				display:none;
		}  
     </style>

	  <script src="https://code.jquery.com/jquery-1.12.4.js"></script>
	  <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script> 
	
	  <!-- CSS Just for demo purpose, don't include it in your project -->

        <!-- jQuery (https://jquery.com/download/) -->

        <script>
            
            function go_url(){
            	window.location.href="${pageContext.request.contextPath}/insert";
            }
            
            function go_url2(){
            	window.location.href="${pageContext.request.contextPath}/achiveList";
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
                                <li class="nav-item ">
                                    <a class="nav-link" href="${pageContext.request.contextPath}/insert" data-no="1" onclick="go_url()">이미지 등록</a>
                                </li>                                
                                <li class="nav-item active selected">
                                   <a class="nav-link" href="${pageContext.request.contextPath}/avi" data-no="2" onclick="go_url2()">동영상 등록</a>
                                </li>
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
            <div style="height:140px">
            	
            </div>
                                   <div class="container">
									   <form name="dataForm" id="dataForm" onsubmit="return registerAction()" enctype="multipart/form-data">
									   	<input type="text" class="form-control" id="subject" name="subject" placeholder="앨범이름"><br>
									    <input type="hidden" name="gubun" value="media" />
									    <label for="uploadfile"><span style="color:red;">*</span>썸네일 이미지 등록<br>
									    </label>
										<input type="file" accept="image/*" name="uploadfile"  id="uploadfile" class="form-control" style="opacity:1;position:relative"><br>
										<p><span style="color:red">*</span>촬영일자<input type="text" id="datepicker" name="sdate" style="vertical-align:middle"></p><br>
										  	<button id="btn-upload" type="button" style="background-color:steelblue;color:#fff;width:200px;height:50px;border: 1px solid #ddd; outline: none;cursor:pointer">동영상 파일 추가</button>
										  	<input id="input_file" accept="video/*" multiple="multiple"  type="file" style="display:none;"><br>
										  	<span style="font-size:14px; color: red;">* 동영상 파일은 한번에 최대 2개까지 등록이 가능합니다.</span><br>
										  	<span style="font-size:14px; color: red;">* 동영상 파일 한개당 약2분 (약200MB) 이내 크기의 영상을 권장합니다.
										  	(스마트폰 카메라 촬영 기준)</span>
										  	<div class="data_file_txt" id="data_file_txt" style="margin:40px;">
												<div id="articlefileChange">
												</div>
											</div>									  	  
									  		  <input type="button"  id="list" value="목록" style="width:48%;height:50px">
									  		  <input type="submit"  id="save" value="등록" style="width:48%;height:50px">
										  </form>
										   
									 </div>
                     
                                </div>                                 

                    
        </div> <!-- .cd-hero -->
        
       
  		<span  style="position:fixed;top:30%;left:41%;" class="displayLoding spinner">
  		<img src="${pageContext.request.contextPath}/resources/img/Ellipsis-2.1s-118px.gif" /><br>
  		</span>
	

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
<!-- 파일 업로드 스크립트 -->
<script>
$(document).ready(function()
		// input file 파일 첨부시 fileCheck 함수 실행
		{
			$("#input_file").on("change", fileCheck);
		});

/**
 * 첨부파일로직
 */
$(function () {
    $('#btn-upload').click(function (e) {
        e.preventDefault();
        $('#input_file').click();
    });
});

// 파일 현재 필드 숫자 totalCount랑 비교값
var fileCount = 0;
// 해당 숫자를 수정하여 전체 업로드 갯수를 정한다.
var totalCount = 2;
// 파일 고유넘버
var fileNum = 0;
// 첨부파일 배열
var content_files = new Array();

function fileCheck(e) {
    var files = e.target.files;
    
    // 파일 배열 담기
    var filesArr = Array.prototype.slice.call(files);
    
    // 파일 개수 확인 및 제한
    if (fileCount + filesArr.length > totalCount) {
      alert('파일은 최대 '+totalCount+'개까지 업로드 할 수 있습니다.');
      return;
    } else {
    	 fileCount = fileCount + filesArr.length;
    }
    
    // 각각의 파일 배열담기 및 기타
    filesArr.forEach(function (f) {
      var reader = new FileReader();
      reader.onload = function (e) {
        content_files.push(f);
        $('#articlefileChange').append(
       		'<div id="file' + fileNum + '" onclick="fileDelete(\'file' + fileNum + '\')">'
       		+ '<font style="font-size:12px">' + f.name + '</font>'  
       		+ '&nbsp;<i class="fas fa-minus-circle" style="color:red;vertical-align:middle"></i>' 
       		+ '<div/>'
		);
        fileNum ++;
      };
      reader.readAsDataURL(f);
    });
    console.log(content_files);
    //초기화 한다.
    $("#input_file").val("");
  }

// 파일 부분 삭제 함수
function fileDelete(fileNum){
    var no = fileNum.replace(/[^0-9]/g, "");
    content_files[no].is_delete = true;
	$('#' + fileNum).remove();
	fileCount --;
    console.log(content_files);
}

/*
 * 폼 submit 로직
 */
	function registerAction(){
		
	var form = $("form")[0];        
 	var formData = new FormData(form);	
		for (var x = 0; x < content_files.length; x++) {
			// 삭제 안한것만 담아 준다. 
			if(!content_files[x].is_delete){
				 formData.append("article_file", content_files[x]);
			}
		}
   /*
   * 파일업로드 multiple ajax처리
   */    
	$.ajax({
   	      type: "POST",
   	   	  enctype: "multipart/form-data",
   	      url: "/avi-file-upload",
       	  data : formData,
       	  processData: false,
   	      contentType: false,
   	      success: function (data) {
   	    	if(JSON.parse(data)['result'] == "OK"){
   	    		//alert("파일업로드 성공");
   	    		location.href="./"
			} else
				alert("서버내 오류로 처리가 지연되고있습니다. 잠시 후 다시 시도해주세요");
   	      },beforeSend : function(){
				$(".spinner").removeClass("displayLoding");
			},
		   complete:function(){
				$(".spinner").addClass("displayLoding");	
		  },
   	      error: function (xhr, status, error) {
   	    	alert("서버오류로 지연되고있습니다. 잠시 후 다시 시도해주시기 바랍니다.");
   	     return false;
   	      }
   	    });
   	    return false;
	}
</script>
    <script>
$(document).ready(function(){

	$("#list").click(function(){
		location.href="./achiveList";
	})
	$("#save").click(function(){
		var subject = document.getElementById("subject");
		var input_file = document.getElementById("input_file");
		var datepicker = document.getElementById("datepicker");
		var uploadfile = document.getElementById("uploadfile");
		
	    if(subject.value.length==0){
	        alert("앨범 이름을 입력해 주세요.");
	        subject.focus();
	        return false;
	    }else  if(uploadfile.value.length==0){
	    	 alert("대표 썸네일을 입력해 주세요.");
	    	 uploadfile.focus();
	         return false;
	    }else  if(datepicker.value.length==0){
	    	 alert("촬영일자를 입력해 주세요.");
	    	 datepicker.focus();
	         return false;
	    }else {
			 var form = new FormData(document.getElementById('form'));
			 form.submit();
		}
			

	}) //save btn end

});
</script>
</body>
</html>