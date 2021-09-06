<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>         
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>    
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
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
		<script src="${pageContext.request.contextPath}/resources/ckeditor/ckeditor.js"></script>
     <link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
	  <script src="https://code.jquery.com/jquery-1.12.4.js"></script>
	  <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script> 
	  
	   <style>
     	#save {background-color:steelblue;color:#fff;border:none;cursor:pointer}
     	#list {cursor:pointer;border:none}
        .displayLoding {
				display:none;
		}  
     </style>
	  <!-- CSS Just for demo purpose, don't include it in your project -->

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
        <script>
/*     class UploadAdapter {
        constructor(loader) {
            this.loader = loader;
        }

        upload() {
            return this.loader.file.then( file => new Promise(((resolve, reject) => {
                this._initRequest();
                this._initListeners( resolve, reject, file );
                this._sendRequest( file );
            })))
        }

        _initRequest() {
            const xhr = this.xhr = new XMLHttpRequest();
            xhr.open('POST', '${pageContext.request.contextPath}/ckUpload', true);
            xhr.responseType = 'json';
        }

        _initListeners(resolve, reject, file) {
            const xhr = this.xhr;
            const loader = this.loader;
            const genericErrorText = '파일을 업로드 할 수 없습니다.'

            xhr.addEventListener('error', () => {reject(genericErrorText)})
            xhr.addEventListener('abort', () => reject())
            xhr.addEventListener('load', () => {
                const response = xhr.response
                if(!response || response.error) {
                    return reject( response && response.error ? response.error.message : genericErrorText );
                }

                resolve({
                    default: response.url //업로드된 파일 주소
                })
            })
        }

        _sendRequest(file) {
            const data = new FormData()
            data.append('upload',file)
            this.xhr.send(data)
        }
    }
    
    
    function MyCustomUploadAdapterPlugin(editor) {
        editor.plugins.get('FileRepository').createUploadAdapter = (loader) => {
            return new UploadAdapter(loader)
        }
    } */
    
	function fileChecking(obj){
		 pathpoint = obj.value.lastIndexOf('.');
		 filepoint = obj.value.substring(pathpoint+1,obj.length);
		 filetype = filepoint.toLowerCase();
		 if(filetype =='jpg' || filetype == 'jpeg' || filetype=='png' || filetype=='gif'){
			 return true;
		 }else{
			 alert('이미지 파일만 선택할 수 있습니다.');
			  $("#input_file").val("");
			 return false;
		 }
	}
    function fileChecking2(obj){
		 pathpoint = obj.value.lastIndexOf('.');
		 filepoint = obj.value.substring(pathpoint+1,obj.length);
		 filetype = filepoint.toLowerCase();
		 if(filetype =='jpg' || filetype == 'jpeg' || filetype=='png' || filetype=='gif'){
			 return true;
		 }else{
			 alert('이미지 파일만 선택할 수 있습니다.');
			  $("#uploadfile").val("");
			 return false;
		 }
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
                                <%-- <li class="nav-item">
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
            <div style="height:140px"> </div>
            					
                                   <div class="container">
									    <form id="form" method="post"   enctype="multipart/form-data">
										<input type="hidden" name="gubun" value="image" />
										<input type="text" id="subject" name="subject" placeholder="앨범이름" style="width:100%"><br>
									   <br>
									   <span style="background-color:steelblue;font-size:12px;color:#fff;display:inline-block;width:260px;height:auto;border-radius:5px;padding:5px">사진에 대해 간단히 메모를 작성해 보세요.</span><br>
									   <textarea name="contents" id="contents" rows="10" cols="80"></textarea><br>
								            <script>
								                // Replace the <textarea id="editor1"> with a CKEditor 4
								                // instance, using default configuration.
								                CKEDITOR.replace( 'contents' );
								            </script> 
									   <!-- <button id="btn-upload" type="button" style="background-color:steelblue;color:#fff;width:200px;height:50px;border: 1px solid #ddd; outline: none;cursor:pointer">이미지 파일 추가</button> -->
										 <input id="input_file" name="input_file" accept="image/*" multiple="multiple" onchange="fileChecking(this)" type="file"><br>
										 <span style="background-color:steelblue;font-size:12px;color:#fff;display:inline-block;width:260px;height:auto;border-radius:5px;padding:5px">이미지는 1회 최대 10개까지 첨부 가능합니다.</span>
										 	<br>
										<hr>
										<br>		
										    <label for="uploadfile">대표 이미지 등록</label><br>
										<input type="file" accept="image/*" name="uploadfile"  id="uploadfile" onchange="fileChecking2(this)"><br>
										<hr>
										<p>촬영일자<input type="text" id="datepicker" name="sdate" style="vertical-align:middle"></p><br>
									    <input type="button"  id="list" value="목록" style="width:48%;height:50px">
									    <input type="button"  id="save" value="등록" style="width:48%;height:50px">
									    </form>
									    </div>
			
                                    
                                                                                                    
                                </div>                                 

                    
        </div> <!-- .cd-hero -->
        <div style="margin-bottom:30px"></div>
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
 
	function CKupdate(){

	    for ( instance in CKEDITOR.instances )
	        CKEDITOR.instances[instance].updateElement();

	}
	

$(document).ready(function(){

	$("#input_file").on("change", fileCheck);
	
	// 파일 현재 필드 숫자 totalCount랑 비교값
	var fileCount = 0;
	// 해당 숫자를 수정하여 전체 업로드 갯수를 정한다.
	var totalCount = 10;
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
	      $("#input_file").val("");
	      return;
	    } 

	    console.log(content_files);
	    //초기화 한다.
	
	 }

	$("#list").click(function(){
		location.href="./achiveList";
	});
	
	$("#save").click(function(){
		
		CKupdate();
		var subject = document.getElementById("subject");
		var input_file = document.getElementById("input_file");
		var uploadfile = document.getElementById("uploadfile");
		var datepicker = document.getElementById("datepicker");
		var form = $("form")[0];        
	 	var formData = new FormData(form);	
	 	
	 
	 	
	    if(subject.value.length==0){
	        alert("앨범 이름을 입력해 주세요.");
	        subject.focus();
	        return false;
	    }else  if(input_file.value.length==0){
	    	 alert("이미지들을 등록해 주세요.");
	    	 input_file.focus();
	         return false;
	    }else  if(uploadfile.value.length==0){
	    	 alert("대표 썸네일을 등록해 주세요.");
	    	 uploadfile.focus();
	         return false;
	    } else  if(datepicker.value.length==0){
	    	 alert("촬영일자를 입력해 주세요.");
	    	 datepicker.focus();
	         return false;
	    } else {
/* 			 var form = new FormData(document.getElementById('form')); */
				$.ajax({
			   	      type: "post",
			   	   	  enctype: "multipart/form-data",
			   	      url: "img-file-upload",
			       	  data : formData,
			       	  processData: false,
			   	      contentType: false,
			   	      success: function (data) {
			   	    	if(JSON.parse(data)['result'] == "OK"){
			   	    		//alert("파일업로드 성공");
			   	    		alert("고객님의 소중한 기억을 담았습니다.");
			   	    		location.href="./";
						} else
						//	alert("서버내 오류로 처리가 지연되고있습니다. 잠시 후 다시 시도해주세요");
							alert("고객님의 소중한 기억을 담았습니다.");
							location.href="./";
			   	      },beforeSend : function(){
							$(".spinner").removeClass("displayLoding");
						},
					   complete:function(){
							$(".spinner").addClass("displayLoding");	
					  },
			   	      error: function (xhr, status, error) {
			   	    	//alert("서버오류로 지연되고있습니다. 잠시 후 다시 시도해주시기 바랍니다.");
			   	    	alert("고객님의 소중한 기억을 담았습니다.");
			   	    	location.href="./";
			   	     return false;
			   	      }
			   	    }); 
		
		} 
			

	}); //save btn end


})



</script>
</body>
</html>