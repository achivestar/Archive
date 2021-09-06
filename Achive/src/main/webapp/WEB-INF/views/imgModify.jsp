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

    <title>Fluid Gallery HTML5 CSS3 Template</title>
<!--
Fluid Gallery Template
http://www.templatemo.com/tm-500-fluid-gallery
-->
    <!-- load stylesheets -->
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Open+Sans:300,400,600">  
    <!-- Google web font "Open Sans" -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/Font-Awesome-4.7/css/font-awesome.min.css">                
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
	  <script src="https://code.jquery.com/jquery-1.12.4.js"></script>
	  <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script> 
	  <!-- CSS Just for demo purpose, don't include it in your project -->

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
            	window.location.href="http://localhost:8080/insert";
            }
            
            function go_url2(){
            	window.location.href="http://localhost:8080/avi";
            }
        </script>
        <script>
    class UploadAdapter {
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
            xhr.open('POST', 'http://localhost:8080/ckImgUpload', true);
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
                        
                        <a class="navbar-brand text-uppercase" href="#"><i class="fa fa-picture-o tm-brand-icon"></i>Fluid Gallery</a>

                        <button class="navbar-toggler hidden-lg-up" type="button" data-toggle="collapse" data-target="#tmNavbar">
                            &#9776;
                        </button>
                         <div class="collapse navbar-toggleable-md text-xs-center text-uppercase tm-navbar" id="tmNavbar">
                            <ul class="nav navbar-nav">
                                <li class="nav-item active selected">
                                    <a class="nav-link" href="${pageContext.request.contextPath}/insert" data-no="1" onclick="go_url()">이미지 등록</a>
                                </li>                                
                                <li class="nav-item">
                                    <a class="nav-link" href="${pageContext.request.contextPath}/insert" data-no="2" onclick="go_url2()">동영상 등록</a>
                                </li>
                               
                            </ul>
                        </div>                         
                    </div>

                </nav>
            </div> 
            <div style="height:140px">
            	
            </div>
                                   <div class="container">
									    <form id="form" method="post" action="${pageContext.request.contextPath}/imgUpdate"  enctype="multipart/form-data">
										 <input type="hidden"  name="idx" value="${jsvo.idx }">
										<input type="text" class="form-control" id="subject" name="subject" value="${jsvo.subject }"><br><br>
									    <textarea name="contents" id="contents" cols="50" rows="100">${jsvo.contents }
									    </textarea><br><br>
									    <label for="uploadfile">대표 이미지 등록</label><br>
									    <img src="${pageContext.request.contextPath}/resources/upload/${jsvo.saveFileName }"  style="width:20%;"/><br><br>
										<input type="file" name="uploadfile"  id="uploadfile" value="${jsvo.saveFileName }" class="form-control" style="opacity:1;position:relative"><br><br>
										<p>촬영일자<input type="text" id="datepicker" name="sdate" value="${jsvo.sdate}" style="vertical-align:middle"></p><br>
									    <input type="submit"  id="save" value="수정">
									    <a href="${pageContext.request.contextPath}/achiveList" class="btn btn-secondary">목록보기</a></p>
									    </form>
									    </div>
									    <script>
									        ClassicEditor
									            .create( document.querySelector( '#contents' ),{
									            	 extraPlugins: [MyCustomUploadAdapterPlugin]
									            })
									            .catch( error => {
									                console.error( error );
									            } );
									        
									    </script>
                                    
                                                                                                    
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

            	
            	var userAgent = window.navigator.userAgent.toLowerCase(); //크롬일 경우 isChrome에는 Chrome이라는 문잘의 위치 값이 반환되고 크롬이 아닐경우는 //-1이 반환된다. 나머지도 동일
            	var isChrome = userAgent.indexOf('chrome'); 
            	var isEdge = userAgent.indexOf('edge'); 
            	var isIE = userAgent.indexOf('trident'); 
            	if(isChrome > -1){ 
            		if(isEdge > -1){ //Edge는 Chrome과 Edge 모두의 값을 가지고 있기 때문에
            		//alert("Edge 브라우저"); 
            	}else {
            		
            		//alert("Chrome 브라우저");
            	} 
            	} else { 
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
	    
	    
	    $(document).ready(function(){
	   	
	    	$("#save").click(function(){
	    		var subject = document.getElementById("subject");
	    		var contents = document.getElementById("contents");
	    		
	    	    if(subject.value.length==0){
	    	        alert("제목을 입력해 주세요.");
	    	        subject.focus();
	    	        return false;
	    	    }else  if(CKEDITOR.instances.contents.getData()==""){
	    	    	 alert("내용을 입력해 주세요.");
	    	         contents.focus();
	    	         return false;
	    	    } else {
	    			 var form = new FormData(document.getElementById('form'));
	    			 form.submit();
	    		}
	    			

	    	}) //save btn end

	    });
	    
	    
	    
	  } );
	  </script>

</body>
</html>