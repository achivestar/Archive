package com.pe.bluering;


import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.io.FileUtils;
import org.imgscalr.Scalr;
import org.omg.CORBA.Request;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.drew.imaging.ImageMetadataReader;
import com.drew.metadata.Directory;
import com.drew.metadata.Metadata;
import com.drew.metadata.exif.ExifIFD0Directory;
import com.drew.metadata.jpeg.JpegDirectory;
import com.pe.bluering.service.JsService;
import com.pe.bluering.vo.jsVO;



@Controller
public class JSController {
	@Autowired
	JsService jsService;


	@RequestMapping(value="/", method=RequestMethod.GET)
	public String indexG(jsVO jsvo,Model model,HttpSession session,HttpServletRequest req) {	
		
		List<jsVO> list = jsService.getAchive(jsvo);
		System.out.println(list);
		model.addAttribute("list",list);
		
		
		
		return "index";
	}
	
	@RequestMapping(value="/", method=RequestMethod.POST)
	public String indexP() {	
		return "index";
	}
	
	@RequestMapping(value="/detail", method=RequestMethod.GET)
	public String detail(jsVO jsvo, Model model,@RequestParam("idx") int idx) {	
		System.out.println("idx : "+idx);
		jsvo.setIdx(idx);

		 jsvo = jsService.getAchiveDetail(jsvo);
		System.out.println(jsvo);

		model.addAttribute("jsvo", jsvo);
		return "detail";
	}
	
	@RequestMapping(value="/regist", method=RequestMethod.GET)
	public String regist(jsVO jsvo, Model model) {	
		
		return "regist";
	}
	
	
	@RequestMapping(value="/insert", method=RequestMethod.GET)
	public String insert(jsVO jsvo, Model model) {	
		
		return "insert";
	}
	
	@RequestMapping(value="/insert2", method=RequestMethod.GET)
	public String insert2(jsVO jsvo, Model model) {	
		
		return "insert2";
	}
	
	@RequestMapping(value="/avi", method=RequestMethod.GET)
	public String avi(jsVO jsvo, Model model) {	
//		List<jsVO> list = jsService.getAchiveAvi(jsvo);
//		System.out.println(list);
//		model.addAttribute("list",list);
		return "avi";
	}

	@RequestMapping(value="/achiveList", method=RequestMethod.GET)
	public String achiveList(jsVO jsvo, Model model) {	
		List<jsVO> list = jsService.getAchive(jsvo);
		System.out.println(list);
		model.addAttribute("list",list);
		return "achiveList";
	}
	
	@RequestMapping(value="/aviList", method=RequestMethod.GET)
	public String aviList(jsVO jsvo, Model model) {	
		List<jsVO> list = jsService.getAchive(jsvo);
		System.out.println(list);
		model.addAttribute("list",list);
		return "aviList";
	}
	
	@RequestMapping(value="/explain", method=RequestMethod.GET)
	public String explain(jsVO jsvo, Model model) {	

		return "explain";
	}
	
	
	@RequestMapping(value="/imgDelete", method = RequestMethod.POST)
	public String imgDelete(@RequestParam("idx") int idx, HttpServletRequest request,HttpSession session,Model model,@RequestParam(value="num", defaultValue="1") int num) {
	 
	 System.out.println("delete mapping start idx : " + idx);
	 
	 deleteImgFile(idx,request);
	 String deleteThumbFileName = jsService.getDeleteThumbFileName(idx);
	 deleteImgThumbFile(idx,request,deleteThumbFileName);
	 
	 this.jsService.imgDelete(idx);

		return "redirect:/achiveList";
	}
	
	@RequestMapping(value="/aviDelete", method = RequestMethod.POST)
	public String aviDelete(@RequestParam("idx") int idx, HttpServletRequest request,HttpSession session,Model model,@RequestParam(value="num", defaultValue="1") int num) {
	 
	 System.out.println("delete mapping start idx : " + idx);
	 
	 deleteAviFile(idx,request);
	 String deleteThumbFileName = jsService.getDeleteThumbFileName(idx);
	 deleteImgThumbFile(idx,request,deleteThumbFileName);
	this.jsService.imgDelete(idx);

		return "redirect:/achiveList";
	}

	
	private void deleteImgThumbFile(int idx, HttpServletRequest request, String deleteThumbFileName) {
		  // 웹서비스 root 경로
	    String root_path = request.getSession().getServletContext().getRealPath("/");  

	    //썸네일 파일 삭제
	    String thumb_path = "resources/upload/"+idx;
	    String THUMB_UPLOAD_PATH = root_path+thumb_path;
	    System.out.println("원본 썸네일 파일 삭제 경로 : " + THUMB_UPLOAD_PATH);
	    
	    String m_thumb_path = "resources/upload/m-thumb";
	    String m_thumb_paths = root_path+m_thumb_path;
	    System.out.println("m 썸네일 파일 삭제 경로 : " + m_thumb_paths);
	    
	    String s_thumb_path = "resources/upload/s-thumb";
	    String s_thumb_paths = root_path+s_thumb_path;
	    System.out.println("s 썸네일 파일 삭제 경로 : " + s_thumb_paths);

	    File thumbDeleteFile = new File(THUMB_UPLOAD_PATH);
	    File mThumbDeleteFile = new File(m_thumb_paths+"/"+deleteThumbFileName);
	    File sThumbDeleteFile = new File(s_thumb_paths+"/"+deleteThumbFileName);
	    
	    if(mThumbDeleteFile.exists()) {
	    	if(mThumbDeleteFile.delete()){
	    		System.out.println("m 썸네일 파일삭제 성공");
	    	}else{ 
	    		System.out.println("m 썸네일 파일삭제 실패"); 
	    	}
	    }
	    
	    if(sThumbDeleteFile.exists()) {
	    	if(sThumbDeleteFile.delete()){
	    		System.out.println("s 썸네일 파일삭제 성공");
	    	}else{ 
	    		System.out.println("s 썸네일 파일삭제 실패"); 
	    	}
	    }

	    
	    System.out.println("thumbDeleteFile : " + thumbDeleteFile);

		
	    while(thumbDeleteFile.exists()) {
		 
		 File[] deleteFolderList = thumbDeleteFile.listFiles();
		 
		 for (int j = 0; j < deleteFolderList.length; j++) {
		
			 deleteFolderList[j].delete(); 
			 System.out.println("썸네일 이미지 파일을 삭제하였습니다.");
		 
		 }
		  
		  if(deleteFolderList.length == 0 && thumbDeleteFile.isDirectory()){
			  thumbDeleteFile.delete(); 
		  System.out.println("썸네일 폴더를 삭제하였습니다."); 
		  }
		  
		  
		 }
		 
		
	}

	
	private void deleteImgFile(int idx, HttpServletRequest request) {
		  // 웹서비스 root 경로
	    String root_path = request.getSession().getServletContext().getRealPath("/");  

	    //썸네일 파일 삭제
	    String thumb_path = "resources/image/"+idx;
	    String THUMB_UPLOAD_PATH = root_path+thumb_path;
	    System.out.println("썸네일 파일 삭제 경로 : " + THUMB_UPLOAD_PATH);

	    File thumbDeleteFile = new File(THUMB_UPLOAD_PATH);
	    
	    System.out.println("thumbDeleteFile : " + thumbDeleteFile);

		
	    while(thumbDeleteFile.exists()) {
		 
		 File[] deleteFolderList = thumbDeleteFile.listFiles();
		 
		 for (int j = 0; j < deleteFolderList.length; j++) {
		
			 deleteFolderList[j].delete(); 
			 System.out.println("썸네일 이미지 파일을 삭제하였습니다.");
		 
		 }
		  
		  if(deleteFolderList.length == 0 && thumbDeleteFile.isDirectory()){
			  thumbDeleteFile.delete(); 
		  System.out.println("썸네일 폴더를 삭제하였습니다."); 
		  }
		  
		  
		 }
		 
		
	}

	private void deleteAviFile(int idx, HttpServletRequest request) {
		  // 웹서비스 root 경로
	    String root_path = request.getSession().getServletContext().getRealPath("/");  

	    //썸네일 파일 삭제
	    String thumb_path = "resources/avi/"+idx;
	    String THUMB_UPLOAD_PATH = root_path+thumb_path;
	    System.out.println("동영상 파일 삭제 경로 : " + THUMB_UPLOAD_PATH);

	    File thumbDeleteFile = new File(THUMB_UPLOAD_PATH);
	    
	    System.out.println("thumbDeleteFile : " + thumbDeleteFile);

		
	    while(thumbDeleteFile.exists()) {
		 
		 File[] deleteFolderList = thumbDeleteFile.listFiles();
		 
		 for (int j = 0; j < deleteFolderList.length; j++) {
		
			 deleteFolderList[j].delete(); 
			 System.out.println("동영상 파일을 삭제하였습니다.");
		 
		 }
		  
		  if(deleteFolderList.length == 0 && thumbDeleteFile.isDirectory()){
			  thumbDeleteFile.delete(); 
		  System.out.println("동영상 폴더를 삭제하였습니다."); 
		  }
		  
		  
		 }
		 		
	}
	
	
	@RequestMapping(value="/imgModify", method=RequestMethod.GET)
	public String imgModify(jsVO jsvo, Model model,@RequestParam("idx") int idx) {	
		jsvo  = jsService.imgModify(idx);
		model.addAttribute("jsvo",jsvo);
		return "imgModify";
	}

	
	@RequestMapping(value="/imgUpdate", method=RequestMethod.POST)
	public String imgUpdate(jsVO jsvo, MultipartFile uploadfile, Model model, HttpSession session,HttpServletRequest request) {

		 
		System.out.println("update mapping start");
		
		String root_path = request.getSession().getServletContext().getRealPath("/");  
	    String attach_path = "resources/upload/";
	    String UPLOAD_PATH = root_path+attach_path;
	    System.out.println("파일경로 :" +UPLOAD_PATH);
		System.out.println("파일 이름: {}"+ uploadfile.getOriginalFilename());
		System.out.println("파일 크기: {}"+ uploadfile.getSize());
		
		System.out.println("파일 이름: {}"+ uploadfile.getOriginalFilename());
		System.out.println("파일 크기: {}"+ uploadfile.getSize());
		System.out.println("파일 이름 : {}" + uploadfile.getName());
		System.out.println("idx :"  + jsvo.getIdx());
		String delFileName = getDeleteFileName(jsvo.getIdx());
		System.out.println("getDeleteFileName : " + delFileName);
		
		if(uploadfile.getOriginalFilename().equals("")) {
			System.out.println("업로드할 파일이 없습니다.");
			String getSaveFileName = getSaveFileName(jsvo.getIdx());
			String getOriginFileName = getOriginFileName(jsvo.getIdx());
			System.out.println("존재하는 파일 이름 : "+getSaveFileName + ":"+getOriginFileName);
			jsvo.setSaveFileName(getSaveFileName);
			jsvo.setOriginalFileName(getOriginFileName);
			this.jsService.imgUpdate(jsvo);
		}else {
		
			System.out.println("업로드할 파일 있습니다.");
			String saveFile = saveUpdateFile(uploadfile,request,delFileName);
			
//				String oPath = UPLOAD_PATH+saveFile; // 원본 경로
//				System.out.println("oPath : " +oPath);
//				File oFile = new File(oPath);
//				System.out.println("oFile : "  + oFile);
//				int index = oPath.lastIndexOf(".");
//				String ext = oPath.substring(index + 1); // 파일 확장자
//
//				String tPath = oFile.getParent() + File.separator + "s-thumb/t-" + oFile.getName(); // 썸네일저장 경로
//				String tmPath = oFile.getParent() + File.separator + "m-thumb/t-" + oFile.getName(); // 썸네일저장 경로
//				System.out.println("tPath : " +tPath);
//				File tFile = new File(tPath);
//				File tmFile= new File(tmPath);
//
//				double ratio = 10; // 썸네일 s축소 비율
//				double ratio2 = 5; // 썸네일 m축소 비율
//				
//				BufferedImage oImage = ImageIO.read(oFile); // 원본이미지
//
//				int tWidth = (int) (oImage.getWidth() / ratio); // 생성할 썸네일이미지의 너비
//				int tHeight = (int) (oImage.getHeight() / ratio); // 생성할 썸네일이미지의 높이
//				System.out.println("너비, 높이 : "  +tWidth+","+tHeight);
//				
//				int tmWidth = (int) (oImage.getWidth() / ratio2); // 생성할 썸네일이미지의 너비
//				int tmHeight = (int) (oImage.getHeight() / ratio2); // 생성할 썸네일이미지의 높이
//				System.out.println("너비, 높이 : "  +tmWidth+","+tmHeight);
//				
//				BufferedImage tImage = new BufferedImage(tWidth, tHeight, BufferedImage.TYPE_3BYTE_BGR); // 썸네일이미지
//				Graphics2D graphic = tImage.createGraphics();
//				Image image = oImage.getScaledInstance(tWidth, tHeight, Image.SCALE_SMOOTH);
//				graphic.drawImage(image, 0, 0, tWidth, tHeight, null);
//				
//				BufferedImage tImage2 = new BufferedImage(tmWidth, tmHeight, BufferedImage.TYPE_3BYTE_BGR); // 썸네일이미지
//				Graphics2D graphic2 = tImage2.createGraphics();
//				Image image2 = oImage.getScaledInstance(tmWidth, tmHeight, Image.SCALE_SMOOTH);
//				graphic2.drawImage(image2, 0, 0, tmWidth, tmHeight, null);
//				
//				graphic.dispose(); // 리소스를 모두 해제
//				graphic2.dispose();
//	
//				ImageIO.write(tImage, ext, tFile);
//				ImageIO.write(tImage2, ext, tmFile);
//				
//				jsvo.setS_thumb("t-"+oFile.getName());
//				jsvo.setM_thumb("t-"+oFile.getName());
			jsvo.setSaveFileName(saveFile);
			jsvo.setOriginalFileName(uploadfile.getOriginalFilename());

			this.jsService.imgUpdate(jsvo);
	
		System.out.println("update mapping end");

	}
		return "redirect:/achiveList";
}
	
	
	

	private String saveUpdateFile(MultipartFile uploadfile, HttpServletRequest request, String delFileName) {
		  // 웹서비스 root 경로
	    String root_path = request.getSession().getServletContext().getRealPath("/");  
	    String attach_path = "resources/upload/";
	    String UPLOAD_PATH = root_path+attach_path;
	    System.out.println("파일경로 :" +UPLOAD_PATH);

	   
	    String deleteFileName = UPLOAD_PATH+delFileName;
	    System.out.println("DeleteFileName : " + deleteFileName);

	    File deleteFile = new File(deleteFileName);

	    
      // 파일이 존재하는지 체크 존재할경우 true, 존재하지않을경우 false
      if(deleteFile.exists()) {
          // 파일을 삭제합니다.
          deleteFile.delete(); 
          System.out.println("파일을 삭제하였습니다.");
      } else {
          System.out.println("파일이 존재하지 않습니다.");   
      }

	    
		// 파일 이름 변경
	    UUID uuid = UUID.randomUUID();
	    String saveName = uuid + "_" + uploadfile.getOriginalFilename();

	    System.out.println("saveName: {}"+saveName);

	    // 저장할 File 객체를 생성(껍데기 파일)
	    File saveFile = new File(UPLOAD_PATH,saveName); // 저장할 폴더 이름, 저장할 파일 이름

	    try {
	    	uploadfile.transferTo(saveFile); // 업로드 파일에 saveFile이라는 껍데기 입힘
	    } catch (IOException e) {
	        e.printStackTrace();
	        return null;
	    }

	    return saveName;
	}
	
	
	
	@RequestMapping(value = "/ckImgUpload", method = RequestMethod.POST)
	public void postCKEditorImgUpload2(HttpServletRequest req, Model model,
	          HttpServletResponse res, jsVO jsvo, HttpSession session,
	          @RequestParam MultipartFile upload) throws Exception {
		System.out.println("post CKEditor img popup upload");
		 // 랜덤 문자 생성
		 UUID uid = UUID.randomUUID();
		 System.out.println("uid : "+uid);
		 OutputStream out = null;
		 PrintWriter printWriter = null;
	
		 // 인코딩
		 res.setCharacterEncoding("utf-8");
		 res.setContentType("text/html;charset=utf-8");

			 
			 try {
				  
				  String fileName = upload.getOriginalFilename();  // 파일 이름 가져오기
				  byte[] bytes = upload.getBytes();
				  
				  // 업로드 경로
				    String root_path = req.getSession().getServletContext().getRealPath("/");  
				   int idx = jsService.getAlbumCount();
	
				 System.out.println("idx : " + jsvo.getIdx());
				   
				    String attach_path = "resources/ckUpload/"+idx+"/";
				    String UPLOAD_PATH = root_path+attach_path;

				    System.out.println("업로드파일경로 :" +UPLOAD_PATH);
				
					File Folder = new File(UPLOAD_PATH);


					// 해당 디렉토리가 없을경우 디렉토리를 생성합니다.
					if (!Folder.exists()) {
						try{
						    Folder.mkdir(); //폴더 생성합니다.
						    System.out.println("폴더가 생성되었습니다.");
					        } 
					        catch(Exception e){
						    e.getStackTrace();
						}        
				         }else {
						System.out.println("이미 폴더가 생성되어 있습니다.");
					}
					
				
				   String ckUploadPath = UPLOAD_PATH + uid + "_" + fileName;
				   
				  System.out.println("ckUploadPath : "  +ckUploadPath);
				  out = new FileOutputStream(new File(ckUploadPath));
				  out.write(bytes);
				 
				  out.flush();  // out에 저장된 데이터를 전송하고 초기화
			
				  String callback = req.getParameter("CKEditorFuncNum");
				  printWriter = res.getWriter();
				// String fileUrl = "http://bluering.pe.kr/resources/noticeCkUpload/"+idx+"/" + uid + "_" + fileName;  // 작성화면
				  String fileUrl = "http://localhost:8080/resources/ckUpload/"+idx+"/" + uid + "_" + fileName;  // 작성화면
				
				  // 업로드시 메시지 출력
				  printWriter.println("{\"filename\" : \""+fileName+"\", \"uploaded\" : 1, \"url\":\""+fileUrl+"\"}");
				  
				  printWriter.flush();
				  
				  
				  
				    String saveFile = uid + "_" + fileName;;
					
	
//					String oPath = UPLOAD_PATH+saveFile; // 원본 경로
//					System.out.println("oPath : " +oPath);
//					File oFile = new File(oPath);
//					System.out.println("oFile : "  + oFile);
//					int index = oPath.lastIndexOf(".");
//					String ext = oPath.substring(index + 1); // 파일 확장자
//
//					String tPath = oFile.getParent() + File.separator + "s-thumb/t-" + oFile.getName(); // 썸네일저장 경로
//					String tmPath = oFile.getParent() + File.separator + "m-thumb/t-" + oFile.getName(); // 썸네일저장 경로
//					System.out.println("tPath : " +tPath);
//					File tFile = new File(tPath);
//					File tmFile= new File(tmPath);
//
//					double ratio = 10; // 썸네일 s축소 비율
//					double ratio2 = 5; // 썸네일 m축소 비율
//					
//					BufferedImage oImage = ImageIO.read(oFile); // 원본이미지
//
//					int tWidth = (int) (oImage.getWidth() / ratio); // 생성할 썸네일이미지의 너비
//					int tHeight = (int) (oImage.getHeight() / ratio); // 생성할 썸네일이미지의 높이
//					System.out.println("너비, 높이 : "  +tWidth+","+tHeight);
//					
//					int tmWidth = (int) (oImage.getWidth() / ratio2); // 생성할 썸네일이미지의 너비
//					int tmHeight = (int) (oImage.getHeight() / ratio2); // 생성할 썸네일이미지의 높이
//					System.out.println("너비, 높이 : "  +tmWidth+","+tmHeight);
//					
//					BufferedImage tImage = new BufferedImage(tWidth, tHeight, BufferedImage.TYPE_3BYTE_BGR); // 썸네일이미지
//					Graphics2D graphic = tImage.createGraphics();
//					Image image = oImage.getScaledInstance(tWidth, tHeight, Image.SCALE_SMOOTH);
//					graphic.drawImage(image, 0, 0, tWidth, tHeight, null);
//					
//					BufferedImage tImage2 = new BufferedImage(tmWidth, tmHeight, BufferedImage.TYPE_3BYTE_BGR); // 썸네일이미지
//					Graphics2D graphic2 = tImage2.createGraphics();
//					Image image2 = oImage.getScaledInstance(tmWidth, tmHeight, Image.SCALE_SMOOTH);
//					graphic2.drawImage(image2, 0, 0, tmWidth, tmHeight, null);
//					
//					graphic.dispose(); // 리소스를 모두 해제
//					graphic2.dispose();
//
//					ImageIO.write(tImage, ext, tFile);
//					ImageIO.write(tImage2, ext, tmFile);
					
				  
				  
				  System.out.println("fileUrl : " + fileUrl);
				  
				 } catch (IOException e) { e.printStackTrace();
				 } finally {
				  try {
				   if(out != null) { out.close(); }
				   if(printWriter != null) { printWriter.close(); }
				  } catch(IOException e) { e.printStackTrace(); }
				 }


	
		return ; 
	}
	
	

	@RequestMapping(value = "/ckUpload", method = RequestMethod.POST)
	public void postCKEditorImgUpload(HttpServletRequest req, Model model,
	          HttpServletResponse res, jsVO jsvo, HttpSession session,
	          @RequestParam MultipartFile upload) throws Exception {
		System.out.println("post CKEditor img popup upload");
		 // 랜덤 문자 생성
		 UUID uid = UUID.randomUUID();
		 System.out.println("uid : "+uid);
		 OutputStream out = null;
		 PrintWriter printWriter = null;
	
		 // 인코딩
		 res.setCharacterEncoding("utf-8");
		 res.setContentType("text/html;charset=utf-8");

			 
			 try {
				  
				  String fileName = upload.getOriginalFilename();  // 파일 이름 가져오기
				  byte[] bytes = upload.getBytes();
				  
				  // 업로드 경로
				    String root_path = req.getSession().getServletContext().getRealPath("/");  

				    int idx = 0;
				    if(jsService.getAlbumCount()==0) {
				    	System.out.println(jsService.getAlbumCount());
				    	idx = 1;
				    	System.out.println("0일때 idx : " +idx);
				    }else {
				    	 idx = jsService.getAlbumIdx()+1;
				    	 System.out.println(jsService.getAlbumIdx());
				    	 System.out.println("0이 아닐때 idx : " +idx);
				    }
				   
				   
				    String attach_path = "resources/ckUpload/"+idx+"/";
				    String UPLOAD_PATH = root_path+attach_path;
//				    String mThumb_UPLOAD_PATH = root_path+attach_path+"/m-thumb";
//				    String sThumb_UPLOAD_PATH = root_path+attach_path+"/s-thumb";
				    System.out.println("업로드파일경로 :" +UPLOAD_PATH);
				
					File Folder = new File(UPLOAD_PATH);
//					File sThumbFolder = new File(mThumb_UPLOAD_PATH);
//					File mThumbFolder = new File(sThumb_UPLOAD_PATH);

					// 해당 디렉토리가 없을경우 디렉토리를 생성합니다.
					if (!Folder.exists()) {
						try{
						    Folder.mkdir(); //폴더 생성합니다.
						    System.out.println("폴더가 생성되었습니다.");
					        } 
					        catch(Exception e){
						    e.getStackTrace();
						}        
				         }else {
						System.out.println("이미 폴더가 생성되어 있습니다.");
					}
					
//					if (!sThumbFolder.exists()) {
//						try{
//							sThumbFolder.mkdir(); //폴더 생성합니다.
//						    System.out.println("폴더가 생성되었습니다.");
//					        } 
//					        catch(Exception e){
//						    e.getStackTrace();
//						}        
//				      }else {
//						System.out.println("이미 폴더가 생성되어 있습니다.");
//					}
//					
//					if (!mThumbFolder.exists()) {
//						try{
//							mThumbFolder.mkdir(); //폴더 생성합니다.
//						    System.out.println("폴더가 생성되었습니다.");
//					        } 
//					        catch(Exception e){
//						    e.getStackTrace();
//						}        
//				      }else {
//						System.out.println("이미 폴더가 생성되어 있습니다.");
//					}
				    
				    
				   String ckUploadPath = UPLOAD_PATH + uid + "_" + fileName;
				   
				  System.out.println("ckUploadPath : "  +ckUploadPath);
				  out = new FileOutputStream(new File(ckUploadPath));
				  out.write(bytes);
				 
				  out.flush();  // out에 저장된 데이터를 전송하고 초기화
			
				  String callback = req.getParameter("CKEditorFuncNum");
				  printWriter = res.getWriter();
				// String fileUrl = "http://bluering.pe.kr/resources/noticeCkUpload/"+idx+"/" + uid + "_" + fileName;  // 작성화면
				  String fileUrl = "http://archive.jnstay.net/resources/ckUpload/"+idx+"/" + uid + "_" + fileName;  // 작성화면
				 // String fileUrl = "http://localhost:8080/resources/ckUpload/"+idx+"/" + uid + "_" + fileName;  // 작성화면
				
				  // 업로드시 메시지 출력
				  printWriter.println("{\"filename\" : \""+fileName+"\", \"uploaded\" : 1, \"url\":\""+fileUrl+"\"}");
				  
				  printWriter.flush();
				  
				  
				  
				    String saveFile = uid + "_" + fileName;;
					
	
					String oPath = UPLOAD_PATH+saveFile; // 원본 경로
					System.out.println("oPath : " +oPath);
					File oFile = new File(oPath);
					System.out.println("oFile : "  + oFile);
					int index = oPath.lastIndexOf(".");
					String ext = oPath.substring(index + 1); // 파일 확장자

					String tPath = oFile.getParent() + File.separator + "s-thumb/t-" + oFile.getName(); // 썸네일저장 경로
					String tmPath = oFile.getParent() + File.separator + "m-thumb/t-" + oFile.getName(); // 썸네일저장 경로
					System.out.println("tPath : " +tPath);
					File tFile = new File(tPath);
					File tmFile= new File(tmPath);

					double ratio = 10; // 썸네일 s축소 비율
					double ratio2 = 5; // 썸네일 m축소 비율
					
					BufferedImage oImage = ImageIO.read(oFile); // 원본이미지

					int tWidth = (int) (oImage.getWidth() / ratio); // 생성할 썸네일이미지의 너비
					int tHeight = (int) (oImage.getHeight() / ratio); // 생성할 썸네일이미지의 높이
					System.out.println("너비, 높이 : "  +tWidth+","+tHeight);
					
					int tmWidth = (int) (oImage.getWidth() / ratio2); // 생성할 썸네일이미지의 너비
					int tmHeight = (int) (oImage.getHeight() / ratio2); // 생성할 썸네일이미지의 높이
					System.out.println("너비, 높이 : "  +tmWidth+","+tmHeight);
					
					BufferedImage tImage = new BufferedImage(tWidth, tHeight, BufferedImage.TYPE_3BYTE_BGR); // 썸네일이미지
					Graphics2D graphic = tImage.createGraphics();
					Image image = oImage.getScaledInstance(tWidth, tHeight, Image.SCALE_SMOOTH);
					graphic.drawImage(image, 0, 0, tWidth, tHeight, null);
					
					BufferedImage tImage2 = new BufferedImage(tmWidth, tmHeight, BufferedImage.TYPE_3BYTE_BGR); // 썸네일이미지
					Graphics2D graphic2 = tImage2.createGraphics();
					Image image2 = oImage.getScaledInstance(tmWidth, tmHeight, Image.SCALE_SMOOTH);
					graphic2.drawImage(image2, 0, 0, tmWidth, tmHeight, null);
					
					graphic.dispose(); // 리소스를 모두 해제
					graphic2.dispose();

					ImageIO.write(tImage, ext, tFile);
					ImageIO.write(tImage2, ext, tmFile);
					
				  
				  
				  System.out.println("fileUrl : " + fileUrl);
				  
				 } catch (IOException e) { e.printStackTrace();
				 } finally {
				  try {
				   if(out != null) { out.close(); }
				   if(printWriter != null) { printWriter.close(); }
				  } catch(IOException e) { e.printStackTrace(); }
				 }


	
		return ; 
	}
	
	
	@RequestMapping(value="/Regist", method=RequestMethod.POST)
	public String popupRegist(jsVO jsvo,Model model,MultipartFile uploadfile,HttpServletRequest request) throws IllegalStateException, IOException {
	
//		jsService.testInsert(jsvo);	
//		return "redirect:/";
		
		String root_path = request.getSession().getServletContext().getRealPath("/");  
	    String attach_path = "resources/upload/";
	    String UPLOAD_PATH = root_path+attach_path;
	    System.out.println("파일경로 :" +UPLOAD_PATH);
		System.out.println("파일 이름: {}"+ uploadfile.getOriginalFilename());
		System.out.println("파일 크기: {}"+ uploadfile.getSize());
		
		if(uploadfile.getOriginalFilename().equals("")) {
			System.out.println("업로드할 파일이 없습니다.");
			jsService.testInsert(jsvo);
		}else {
			
			
			
			
			int idx = 0;
		    if(jsService.getAlbumCount()==0) {
		    	System.out.println(jsService.getAlbumCount());
		    	idx = 1;
		    	System.out.println("0일때 idx : " +idx);
		    }else {
		    	 idx = jsService.getAlbumIdx()+1;
		    	 System.out.println(jsService.getAlbumIdx());
		    	 System.out.println("0이 아닐때 idx : " +idx);
		    }
		    
		  
		    
		    File Folder = new File(UPLOAD_PATH+"/"+idx);

			// 해당 디렉토리가 없을경우 디렉토리를 생성합니다.
			if (!Folder.exists()) {
				try{
				    Folder.mkdir(); //폴더 생성합니다.
				    System.out.println("폴더가 생성되었습니다.");
			        } 
			        catch(Exception e){
				    e.getStackTrace();
				}        
		     }else {
				System.out.println("이미 폴더가 생성되어 있습니다.");
		      }
			String saveFile = saveFile2(uploadfile,request,idx);
			
			
//				String oPath = UPLOAD_PATH+saveFile; // 원본 경로
//				System.out.println("oPath : " +oPath);
//				File oFile = new File(oPath);
//				System.out.println("oFile : "  + oFile);
//				int index = oPath.lastIndexOf(".");
//				String ext = oPath.substring(index + 1); // 파일 확장자
//
//				String tPath = oFile.getParent() + File.separator + "s-thumb/t-" + oFile.getName(); // 썸네일저장 경로
//				String tmPath = oFile.getParent() + File.separator + "m-thumb/t-" + oFile.getName(); // 썸네일저장 경로
//				System.out.println("tPath : " +tPath);
//				File tFile = new File(tPath);
//				File tmFile= new File(tmPath);
//
//				double ratio = 10; // 썸네일 s축소 비율
//				double ratio2 = 5; // 썸네일 m축소 비율
//				
//				BufferedImage oImage = ImageIO.read(oFile); // 원본이미지
//
//				int tWidth = (int) (oImage.getWidth() / ratio); // 생성할 썸네일이미지의 너비
//				int tHeight = (int) (oImage.getHeight() / ratio); // 생성할 썸네일이미지의 높이
//				System.out.println("너비, 높이 : "  +tWidth+","+tHeight);
//				
//				int tmWidth = (int) (oImage.getWidth() / ratio2); // 생성할 썸네일이미지의 너비
//				int tmHeight = (int) (oImage.getHeight() / ratio2); // 생성할 썸네일이미지의 높이
//				System.out.println("너비, 높이 : "  +tmWidth+","+tmHeight);
//				
//				BufferedImage tImage = new BufferedImage(tWidth, tHeight, BufferedImage.TYPE_3BYTE_BGR); // 썸네일이미지
//				Graphics2D graphic = tImage.createGraphics();
//				Image image = oImage.getScaledInstance(tWidth, tHeight, Image.SCALE_SMOOTH);
//				graphic.drawImage(image, 0, 0, tWidth, tHeight, null);
//				
//				BufferedImage tImage2 = new BufferedImage(tmWidth, tmHeight, BufferedImage.TYPE_3BYTE_BGR); // 썸네일이미지
//				Graphics2D graphic2 = tImage2.createGraphics();
//				Image image2 = oImage.getScaledInstance(tmWidth, tmHeight, Image.SCALE_SMOOTH);
//				graphic2.drawImage(image2, 0, 0, tmWidth, tmHeight, null);
//				
//				graphic.dispose(); // 리소스를 모두 해제
//				graphic2.dispose();
//	
//				ImageIO.write(tImage, ext, tFile);
//				ImageIO.write(tImage2, ext, tmFile);
//				
//				jsvo.setS_thumb("t-"+oFile.getName());
//				jsvo.setM_thumb("t-"+oFile.getName());
			jsvo.setSaveFileName(saveFile);
			jsvo.setOriginalFileName(uploadfile.getOriginalFilename());
			jsService.testInsert(jsvo);
			
		
		}
		
		return "redirect:/";
	}
	
	
	private String  saveFile(MultipartFile uploadfile,HttpServletRequest request) {
		
		  // 웹서비스 root 경로
	    String root_path = request.getSession().getServletContext().getRealPath("/");  
	    String attach_path = "resources/upload/";
	    String UPLOAD_PATH = root_path+attach_path;
	    System.out.println("파일경로 :" +UPLOAD_PATH);

	    
		// 파일 이름 변경
	    UUID uuid = UUID.randomUUID();
	    String saveName = uuid + "_" + uploadfile.getOriginalFilename();

	    System.out.println("saveName: {}"+saveName);

	    // 저장할 File 객체를 생성(껍데기 파일)
	    File saveFile = new File(UPLOAD_PATH,saveName); // 저장할 폴더 이름, 저장할 파일 이름

	    try {
	    	uploadfile.transferTo(saveFile); // 업로드 파일에 saveFile이라는 껍데기 입힘
	    } catch (IOException e) {
	        e.printStackTrace();
	        return null;
	    }

	    return saveName;
		
	}
	
	private String  saveFile2(MultipartFile uploadfile,HttpServletRequest request,int idx) {
		
		  // 웹서비스 root 경로
	    String root_path = request.getSession().getServletContext().getRealPath("/");  
	    String attach_path = "resources/upload/"+idx;
	    String UPLOAD_PATH = root_path+attach_path;
	    System.out.println("avi파일경로 :" +UPLOAD_PATH);

	    
		// 파일 이름 변경
	    UUID uuid = UUID.randomUUID();
	    String saveName = uuid + "_" + uploadfile.getOriginalFilename();

	    System.out.println("saveName: {}"+saveName);

	    // 저장할 File 객체를 생성(껍데기 파일)
	    File saveFile = new File(UPLOAD_PATH,saveName); // 저장할 폴더 이름, 저장할 파일 이름

	    try {
	    	uploadfile.transferTo(saveFile); // 업로드 파일에 saveFile이라는 껍데기 입힘
	    } catch (IOException e) {
	        e.printStackTrace();
	        return null;
	    }

	    return saveName;
		
	}
	
	
	private String getDeleteFileName(Integer idx) {
		return  jsService.getDeleteFileName(idx);
	}
	
	private String getOriginFileName(int idx) {
		return  jsService.getOriginFileName(idx);
	}

	private String getSaveFileName(int idx) {
		return  jsService.getSaveFileName(idx);
	}
	
	

	@ResponseBody
	@RequestMapping(value = "/img-file-upload", method = RequestMethod.POST)
	public String imgfileUpload(
			@RequestParam("input_file") List<MultipartFile> multipartFile
			, HttpServletRequest request,HttpServletResponse response, jsVO jsvo,Model model,MultipartFile uploadfile) throws IOException {
		
		
		
		
		String strResult = "{ \"result\":\"FAIL\" }";
		String contextRoot = new HttpServletRequestWrapper(request).getRealPath("/");
		String fileRoot;
		
	    
		String root_path = request.getSession().getServletContext().getRealPath("/");  
	    String attach_path = "resources/upload/";
	    String UPLOAD_PATH = root_path+attach_path;
	    System.out.println("파일경로 :" +UPLOAD_PATH);
		System.out.println("파일 이름: {}"+ uploadfile.getOriginalFilename());
		System.out.println("파일 크기: {}"+ uploadfile.getSize());
		
		int idx = 0;
	    if(jsService.getAlbumCount()==0) {
	    	System.out.println(jsService.getAlbumCount());
	    	idx = 1;
	    	System.out.println("0일때 idx : " +idx);
	    }else {
	    	 idx = jsService.getAlbumIdx()+1;
	    	 System.out.println(jsService.getAlbumIdx());
	    	 System.out.println("0이 아닐때 idx : " +idx);
	    }
	    
	    
	    
		if(uploadfile.getOriginalFilename().equals("")) {
			System.out.println("업로드할 파일이 없습니다.");
		}else {
			
		
			 File Folder = new File(UPLOAD_PATH+"/"+idx);

				// 해당 디렉토리가 없을경우 디렉토리를 생성합니다.
				if (!Folder.exists()) {
					try{
					    Folder.mkdir(); //폴더 생성합니다.
					    System.out.println("폴더가 생성되었습니다.");
				        } 
				        catch(Exception e){
					    e.getStackTrace();
					}        
			     }else {
					System.out.println("이미 폴더가 생성되어 있습니다.");
			      }
				
			
		    String saveFile = saveFile2(uploadfile,request,idx);
		    

		
			
			/* 썸네일 생성 */
			String oPath = UPLOAD_PATH+idx+"/"+saveFile; // 원본 경로
			System.out.println("oPath : " +oPath);
			File oFile = new File(oPath);
			System.out.println("oFile : "  + oFile);
			int index = oPath.lastIndexOf(".");
			String ext = oPath.substring(index + 1); // 파일 확장자

			
			String tPath = UPLOAD_PATH + File.separator + "s-thumb/t-"+idx + oFile.getName(); // 썸네일저장 경로
			String tmPath = UPLOAD_PATH + File.separator + "m-thumb/t-"+idx + oFile.getName(); // 썸네일저장 경로
			System.out.println("tPath : " +tPath);
			File tFile = new File(tPath);
			File tmFile= new File(tmPath);

			double ratio = 10; // 썸네일 s축소 비율
			double ratio2 = 5; // 썸네일 m축소 비율
			
			BufferedImage oImage = ImageIO.read(oFile); // 원본이미지
			
			
			/* 이미지 파일 회전을 막겠습니다 START*/
			//파일을 읽는다.
			File imageFile = new File(oPath);
			
			// 원본 파일의 Orientation 정보를 읽는다.
			int orientation = 1; // 회전정보, 1. 0도, 3. 180도, 6. 270도, 8. 90도 회전한 정보

		 
			Metadata metadata; // 이미지 메타 데이터 객체
			Directory directory; // 이미지의 Exif 데이터를 읽기 위한 객체
			JpegDirectory jpegDirectory; // JPG 이미지 정보를 읽기 위한 객체
		 
			try {
				metadata = ImageMetadataReader.readMetadata(imageFile);
				directory = metadata.getFirstDirectoryOfType(ExifIFD0Directory.class);
				jpegDirectory = metadata.getFirstDirectoryOfType(JpegDirectory.class);
				if(directory != null){
					orientation = directory.getInt(ExifIFD0Directory.TAG_ORIENTATION); // 회전정보
				}
		 
			}catch (Exception e) {
				orientation=1;
			}



			
			int tWidth = (int) (oImage.getWidth() / ratio); // 생성할 썸네일이미지의 너비
			int tHeight = (int) (oImage.getHeight() / ratio); // 생성할 썸네일이미지의 높이
			System.out.println("너비, 높이 : "  +tWidth+","+tHeight);
			
			int tmWidth = (int) (oImage.getWidth() / ratio2); // 생성할 썸네일이미지의 너비
			int tmHeight = (int) (oImage.getHeight() / ratio2); // 생성할 썸네일이미지의 높이
			System.out.println("너비, 높이 : "  +tmWidth+","+tmHeight);
			
			BufferedImage tImage = new BufferedImage(tWidth, tHeight, BufferedImage.TYPE_3BYTE_BGR); // 썸네일이미지
			Graphics2D graphic = tImage.createGraphics();
			Image image = oImage.getScaledInstance(tWidth, tHeight, Image.SCALE_SMOOTH);
			graphic.drawImage(image, 0, 0, tWidth, tHeight, null);
			
			BufferedImage tImage2 = new BufferedImage(tmWidth, tmHeight, BufferedImage.TYPE_3BYTE_BGR); // 썸네일이미지
			Graphics2D graphic2 = tImage2.createGraphics();
			Image image2 = oImage.getScaledInstance(tmWidth, tmHeight, Image.SCALE_SMOOTH);
			graphic2.drawImage(image2, 0, 0, tmWidth, tmHeight, null);
			
			graphic.dispose(); // 리소스를 모두 해제
			graphic2.dispose();

			
			/* 사파리 에서 파일 복사가 안되기 때문에*/
			response.setHeader("Pragma", "public");
			response.setHeader("Expires", "0");
			response.setHeader("Cache-Control", "must-revalidate, post-check=0, pre-check=0");
			response.setHeader("Content-type", "application-download");
			response.setHeader("Content-Disposition", "attachment; filename=" + multipartFile);
			response.setHeader("Content-Transfer-Encoding", "binary");
			/* 사파리 에서 파일 복사가 안되기 때문에*/
			
			

			// 회전 시킨다.
			switch (orientation) {
			case 6:
				tImage = 	Scalr.rotate(tImage, Scalr.Rotation.CW_90, null); 
				tImage2 = Scalr.rotate(tImage2, Scalr.Rotation.CW_90, null); 
				break;
			case 1:
		 
				break;
			case 3:
				tImage =  Scalr.rotate(tImage, Scalr.Rotation.CW_180, null);
				tImage2 = Scalr.rotate(tImage2, Scalr.Rotation.CW_180, null);
				break;
			case 8:
				tImage = Scalr.rotate(tImage, Scalr.Rotation.CW_270, null);
				tImage2 = Scalr.rotate(tImage2, Scalr.Rotation.CW_270, null);
				break;
		 
			default:
				orientation=1;
				break;
			}
			
			System.out.println("orientation : "  + orientation);
			
			/* 이미지 파일 회전 막기 종료 */
			
			ImageIO.write(tImage, ext, tFile);
			ImageIO.write(tImage2, ext, tmFile);
			
			jsvo.setS_thumb("t-"+idx+oFile.getName());
			jsvo.setM_thumb("t-"+idx+oFile.getName());
			/* 썸네일 종료 */
			
			
			
			jsvo.setSaveFileName(saveFile);
			jsvo.setOriginalFileName(uploadfile.getOriginalFilename());
		}
		

		
	    fileRoot = contextRoot + "resources/image/"+idx+"/";
	    System.out.println("fileRoot : " +fileRoot);
	    File Folder = new File(fileRoot);

		// 해당 디렉토리가 없을경우 디렉토리를 생성합니다.
		if (!Folder.exists()) {
			try{
			    Folder.mkdir(); //폴더 생성합니다.
			    System.out.println("image 폴더가 생성되었습니다.");
		        } 
		        catch(Exception e){
			    e.getStackTrace();
			}        
	     }else {
			System.out.println("image 이미 폴더가 생성되어 있습니다.");
	      }
	    
		
		
		try {
			// 파일이 있을때 탄다.
			if(multipartFile.size() > 0 && !multipartFile.get(0).getOriginalFilename().equals("")) {
				
				
				/* 사파리 에서 파일 복사가 안되기 때문에*/
				response.setHeader("Pragma", "public");
				response.setHeader("Expires", "0");
				response.setHeader("Cache-Control", "must-revalidate, post-check=0, pre-check=0");
				response.setHeader("Content-type", "application-download");
				response.setHeader("Content-Disposition", "attachment; filename=" + multipartFile);
				response.setHeader("Content-Transfer-Encoding", "binary");
				/* 사파리 에서 파일 복사가 안되기 때문에*/
				
				
				int i =1;
				for(MultipartFile file:multipartFile) {

					System.out.println(fileRoot);
					
					String originalFileName = file.getOriginalFilename();	//오리지날 파일명
					String extension = originalFileName.substring(originalFileName.lastIndexOf("."));	//파일 확장자
					String savedFileName = UUID.randomUUID() + extension;	//저장될 파일 명
					System.out.println("i = " + i);
					File targetFile = new File(fileRoot + savedFileName);	
					System.out.println("originalFileName : " +originalFileName);
					System.out.println("savedFileName : " +savedFileName);
					try {
						InputStream fileStream = file.getInputStream();
						FileUtils.copyInputStreamToFile(fileStream, targetFile); //파일 저장
						System.out.println("파일 저장 함");
					
					} catch (Exception e) {
						//파일삭제
						FileUtils.deleteQuietly(targetFile);	//저장된 현재 파일 삭제
						e.printStackTrace();
						break;
					}
					
					if(i==1) {
						jsvo.setAviOriginalFileName1(originalFileName);
						jsvo.setAviSaveFileName1(savedFileName);
					}else if(i==2) {
						jsvo.setAviOriginalFileName2(originalFileName);
						jsvo.setAviSaveFileName2(savedFileName);
					}else if(i==3) {
						jsvo.setAviOriginalFileName3(originalFileName);
						jsvo.setAviSaveFileName3(savedFileName);
					}else if(i==4) {
						jsvo.setAviOriginalFileName4(originalFileName);
						jsvo.setAviSaveFileName4(savedFileName);
					}else if(i==5) {
						jsvo.setAviOriginalFileName5(originalFileName);
						jsvo.setAviSaveFileName5(savedFileName);
					}else if(i==6) {
						jsvo.setAviOriginalFileName6(originalFileName);
						jsvo.setAviSaveFileName6(savedFileName);
					}else if(i==7) {
						jsvo.setAviOriginalFileName7(originalFileName);
						jsvo.setAviSaveFileName7(savedFileName);
					}else if(i==8) {
						jsvo.setAviOriginalFileName8(originalFileName);
						jsvo.setAviSaveFileName8(savedFileName);
					}else if(i==9) {
						jsvo.setAviOriginalFileName9(originalFileName);
						jsvo.setAviSaveFileName9(savedFileName);
					}else if(i==10) {
						jsvo.setAviOriginalFileName10(originalFileName);
						jsvo.setAviSaveFileName10(savedFileName);
					}
				
				
				
				
					
					i++;
				}

				jsService.testInsert(jsvo);
				strResult = "{ \"result\":\"OK\" }";
			}
			// 파일 아무것도 첨부 안했을때 탄다.(게시판일때, 업로드 없이 글을 등록하는경우)
			else
				jsService.testInsert(jsvo);
				strResult = "{ \"result\":\"OK\" }";
		}catch(Exception e){
			e.printStackTrace();
		}
		return strResult;
	}
	
	
	
}
