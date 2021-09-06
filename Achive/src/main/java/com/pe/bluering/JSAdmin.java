package com.pe.bluering;


import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Properties;
import java.util.UUID;

import javax.imageio.ImageIO;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.pe.bluering.service.JsService;
import com.pe.bluering.vo.adminVO;
import com.pe.bluering.vo.jsVO;
import com.pe.bluering.vo.surveyVO;




@Controller
public class JSAdmin {
	@Autowired
	JsService jsService;


	@RequestMapping(value="/admin", method=RequestMethod.GET)
	public String index() {	
		return "/admin/index";
	}
	
	@RequestMapping(value="/admin/dashboard", method=RequestMethod.GET)
	public String dashboard(jsVO jsvo,Model model,HttpSession session) {	

		Object loginInfo = session.getAttribute("member");
		 if(loginInfo != null) {
			 model.addAttribute("msg",true);
			 
			 int noticeCount = jsService.getNoticeCount();
			 model.addAttribute("noticeCount", noticeCount);
			 
			 int galleryCount = jsService.getGelleryCount();
			 model.addAttribute("galleryCount", galleryCount);
			 
			 int userCount = jsService.getUserCount();
			 model.addAttribute("userCount", userCount);
			 
			 
			 int faqCount = jsService.getFaqCount();
			 model.addAttribute("faqCount", faqCount);
			 
			 SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd");
			Date time = new Date();
			String now = format1.format(time);
			
			 System.out.println("now : " +now);
			 model.addAttribute("now",now);
			 
			 int todayCount = jsService.getVisitCount(now);
			 System.out.println(todayCount);
			 model.addAttribute("todayCount",todayCount);
			 
			 int totalCount = jsService.getVisitTotalCount();
			 model.addAttribute("totalCount",totalCount);
			 
			 List<jsVO> listGraph = jsService.getGraph();
			 model.addAttribute("listGraph",listGraph);
			 
		 }else {
			 model.addAttribute("msg",false); 
		 }
		
		

		
		
		return "/admin/dashboard";
	}
	
	
	/* 공지글 관련 메소드 시작 */
	@RequestMapping(value="/admin/sub/notice", method=RequestMethod.GET)
	public String notice(jsVO jsvo,Model model,HttpSession session) {	
		
		Object loginInfo = session.getAttribute("member");
		 if(loginInfo != null) {
			 model.addAttribute("msg",true);
			 
			 int noticeCount = jsService.getNoticeCount();
			 model.addAttribute("noticeCount", noticeCount);
			 
			 int galleryCount = jsService.getGelleryCount();
			 model.addAttribute("galleryCount", galleryCount);
			 
			 int userCount = jsService.getUserCount();
			 model.addAttribute("userCount", userCount);
			 
			 int faqCount = jsService.getFaqCount();
			 model.addAttribute("faqCount", faqCount);
			 
			
			List<jsVO> list = jsService.getNoticeList(jsvo);
			System.out.println(list);
			
			
			model.addAttribute("list",list);
			
		 }else {
			 model.addAttribute("msg",false); 
		 }
	
		return "/admin/sub/notice";
	}
	
	@RequestMapping(value="/admin/sub/noticeWrite", method=RequestMethod.GET)
	public String noticeWrite(jsVO jsvo,Model model,HttpSession session) {	
		
		Object loginInfo = session.getAttribute("member");
		 if(loginInfo != null) {
			 model.addAttribute("msg",true);
			 int noticeCount = jsService.getNoticeCount();
			 model.addAttribute("noticeCount", noticeCount);
			 
			 int galleryCount = jsService.getGelleryCount();
			 model.addAttribute("galleryCount", galleryCount);
			 
			 int userCount = jsService.getUserCount();
			 model.addAttribute("userCount", userCount);
			 
			 int faqCount = jsService.getFaqCount();
			 model.addAttribute("faqCount", faqCount);
			 
			 
		 }else {
			 model.addAttribute("msg",false);
		 }
		
		 
		return "/admin/sub/noticeWrite";
	}
	
	@RequestMapping(value="/admin/sub/noticeRegist", method=RequestMethod.POST)
	public String noticeRegist(jsVO jsvo,Model model,HttpSession session) {	
		
		Object loginInfo = session.getAttribute("member");
		 if(loginInfo != null) {
			 model.addAttribute("msg",true);
			 
			 int noticeCount = jsService.getNoticeCount();
			 model.addAttribute("noticeCount", noticeCount);
			 
			 int galleryCount = jsService.getGelleryCount();
			 model.addAttribute("galleryCount", galleryCount);
			 
			 int userCount = jsService.getUserCount();
			 model.addAttribute("userCount", userCount);
			 
			 int faqCount = jsService.getFaqCount();
			 model.addAttribute("faqCount", faqCount);
			 
			 
			 
			jsService.noticeInsert(jsvo);	
			 
		 }else {
			 model.addAttribute("msg",false);
		 }
		
		return "redirect:/admin/sub/notice";

	}
	
	@RequestMapping(value="/admin/sub/noticeModify", method=RequestMethod.GET)
	public String noticeModify(jsVO jsvo, @RequestParam("idx") int idx,Model model,HttpSession session) {	
		
		Object loginInfo = session.getAttribute("member");
		 if(loginInfo != null) {
			 model.addAttribute("msg",true);
			 jsvo  = jsService.noticeModify(idx);
				model.addAttribute("jsvo",jsvo);
				
				 int noticeCount = jsService.getNoticeCount();
				 model.addAttribute("noticeCount", noticeCount);
				 
				 int galleryCount = jsService.getGelleryCount();
				 model.addAttribute("galleryCount", galleryCount);
				 
				 int userCount = jsService.getUserCount();
				 model.addAttribute("userCount", userCount);
				 
				 int faqCount = jsService.getFaqCount();
				 model.addAttribute("faqCount", faqCount);
				 
			 
		 }else {
			 model.addAttribute("msg",false);
		 }
		
		
		return "/admin/sub/noticeModify";

	}
	
	@RequestMapping(value="/admin/sub/noticeUpdate", method=RequestMethod.POST)
	public String noticeUpdate(jsVO jsvo, Model model, HttpSession session,HttpServletRequest request) {
		
		Object loginInfo = session.getAttribute("member");
		 if(loginInfo != null) {
			 model.addAttribute("msg",true);
			 System.out.println("update start");
				System.out.println(jsvo);
				
				 int noticeCount = jsService.getNoticeCount();
				 model.addAttribute("noticeCount", noticeCount);
				 
				 int galleryCount = jsService.getGelleryCount();
				 model.addAttribute("galleryCount", galleryCount);
				 
				 int userCount = jsService.getUserCount();
				 model.addAttribute("userCount", userCount);
				 
				 int faqCount = jsService.getFaqCount();
				 model.addAttribute("faqCount", faqCount);
				 
				 
				this.jsService.noticeUpdate(jsvo);
				System.out.println("update end");
			 
		 }else {
			 
			 model.addAttribute("msg",false);
		 }

		

		return "redirect:/admin/sub/notice";
	}

	@RequestMapping(value="/admin/sub/noticeDelete", method = RequestMethod.POST)
	public String noticeDelete(Model model, jsVO jsvo ,HttpSession session,@RequestParam("idx") int idx, HttpServletRequest request,@RequestParam(value="num", defaultValue="1") int num) {

		jsService.noticeDelete(idx);
		return "redirect:/admin/sub/notice";

	}
	
	/* 공지글 관련 메소드 끝 */
	
	
	@RequestMapping(value="/admin/sub/user", method=RequestMethod.GET)
	public String user(jsVO jsvo,Model model, HttpSession session, @RequestParam(value="num", defaultValue="1") int num) {	
		
		
		Object loginInfo = session.getAttribute("member");
		 if(loginInfo != null) {
			 model.addAttribute("msg",true);
			 int noticeCount = jsService.getNoticeCount();
			 model.addAttribute("noticeCount", noticeCount);
			 
			 int galleryCount = jsService.getGelleryCount();
			 model.addAttribute("galleryCount", galleryCount);
			 
			 int userCount = jsService.getUserCount();
			 model.addAttribute("userCount", userCount);
			 
			 int faqCount = jsService.getFaqCount();
			 model.addAttribute("faqCount", faqCount);
			 
			 
			 
			 int count = jsService.contactCount();
				System.out.println("count : " +count);
				 // 한 페이지에 출력할 게시물 갯수
				 int postNum = 10;
				  
				 // 하단 페이징 번호 ([ 게시물 총 갯수 ÷ 한 페이지에 출력할 갯수 ]의 올림)
				 int pageNum = (int)Math.ceil((double)count/postNum);
				  
				 // 출력할 게시물
				 int displayPost = (num - 1) * postNum;
				 jsvo.setDisplayPost(displayPost);
				// 한번에 표시할 페이징 번호의 갯수
				int pageNum_cnt = 10;
				jsvo.setPostNum(postNum);
				

				// 표시되는 페이지 번호 중 마지막 번호
				int endPageNum = (int)(Math.ceil((double)num / (double)pageNum_cnt) * pageNum_cnt);

				// 표시되는 페이지 번호 중 첫번째 번호
				int startPageNum = endPageNum - (pageNum_cnt - 1);
				
				// 마지막 번호 재계산
				int endPageNum_tmp = (int)(Math.ceil((double)count / (double)pageNum_cnt));
				 
				if(endPageNum > endPageNum_tmp) {
				 endPageNum = endPageNum_tmp;
				}
				
				boolean prev = startPageNum == 1 ? false : true;
				boolean next = endPageNum * pageNum_cnt >= count ? false : true;
				
				// 시작 및 끝 번호
				model.addAttribute("startPageNum", startPageNum);
				model.addAttribute("endPageNum", endPageNum);

				// 이전 및 다음 
				model.addAttribute("prev", prev);
				model.addAttribute("next", next);
				
				// 현재 페이지
				model.addAttribute("select", num);
				model.addAttribute("pageNum", pageNum);
			 
				List<jsVO> list = jsService.getContactList(jsvo);
				System.out.println(list);
			
			
			
			
			model.addAttribute("list",list);
			
		 }else {
			 
			 model.addAttribute("msg",false);
		 }
		
		return "/admin/sub/user";
	}
	
	/* 롤링 상단 사진 관련 메소드 시작 */
	@RequestMapping(value="/admin/sub/rollingImg", method=RequestMethod.GET)
	public String rollingImg(jsVO jsvo,Model model,HttpSession session) {	
		
		Object loginInfo = session.getAttribute("member");
		 if(loginInfo != null) {
			 model.addAttribute("msg",true);
			 int noticeCount = jsService.getNoticeCount();
			 model.addAttribute("noticeCount", noticeCount);
			 
			 int galleryCount = jsService.getGelleryCount();
			 model.addAttribute("galleryCount", galleryCount);
			 
			 int userCount = jsService.getUserCount();
			 model.addAttribute("userCount", userCount);
			 
			 int faqCount = jsService.getFaqCount();
			 model.addAttribute("faqCount", faqCount);
			 
			 
			List<jsVO> list = jsService.getRollingList(jsvo);
			System.out.println(list);
			
			
			model.addAttribute("list",list);
			 
		 }else {
			 model.addAttribute("msg",false);
		 }
		
		
		
		return "/admin/sub/rollingImg";
	}
	
	
	@RequestMapping(value="/admin/sub/rollingWrite", method=RequestMethod.GET)
	public String rollingWrite(jsVO jsvo,Model model,HttpSession session) {	
		
		Object loginInfo = session.getAttribute("member");
		 if(loginInfo != null) {
			 model.addAttribute("msg",true);
			 
			 int noticeCount = jsService.getNoticeCount();
			 model.addAttribute("noticeCount", noticeCount);
			 
			 int galleryCount = jsService.getGelleryCount();
			 model.addAttribute("galleryCount", galleryCount);
			 
			 int userCount = jsService.getUserCount();
			 model.addAttribute("userCount", userCount);
			 
			 int faqCount = jsService.getFaqCount();
			 model.addAttribute("faqCount", faqCount);
			 
		 }else {
			 model.addAttribute("msg",false);
		 }
		 
		 
		 
		 
		return "/admin/sub/rollingWrite";
	}
	
	
	@RequestMapping(value="/admin/sub/rollingImgRegist", method=RequestMethod.POST)
	public String rollingImgRegist(jsVO jsvo,Model model,MultipartFile uploadfile,HttpServletRequest request) throws IllegalStateException, IOException {
		
		System.out.println("파일 이름: {}"+ uploadfile.getOriginalFilename());
		System.out.println("파일 크기: {}"+ uploadfile.getSize());
		
		if(uploadfile.getOriginalFilename().equals("")) {
			System.out.println("업로드할 파일이 없습니다.");
			jsService.rollingImgInsert(jsvo);	
		}else {
			String saveFile = saveRollingFile(uploadfile,request);
			jsvo.setSaveFileName(saveFile);
			jsvo.setOriginalFileName(uploadfile.getOriginalFilename());
			jsService.rollingImgInsert(jsvo);	
		}

		return "redirect:/admin/sub/rollingImg";
	}
	


	@RequestMapping(value="/admin/sub/rollingImgModify", method=RequestMethod.GET)
	public String rollingImgModify(jsVO jsvo, @RequestParam("idx") int idx,Model model,HttpSession session) {	
		
		Object loginInfo = session.getAttribute("member");
		 if(loginInfo != null) {
			 model.addAttribute("msg",true);
				jsvo  = jsService.rollingImgModify(idx);
				
				 int noticeCount = jsService.getNoticeCount();
				 model.addAttribute("noticeCount", noticeCount);
				 
				 int galleryCount = jsService.getGelleryCount();
				 model.addAttribute("galleryCount", galleryCount);
				 
				 int userCount = jsService.getUserCount();
				 model.addAttribute("userCount", userCount);
				 
				 int faqCount = jsService.getFaqCount();
				 model.addAttribute("faqCount", faqCount);
				 
				 
				model.addAttribute("jsvo",jsvo);
			 
		 }else {
			 model.addAttribute("msg",false);
		 }
	
		
		return "/admin/sub/rollingImgModify";

	}
	
	@RequestMapping(value="/admin/sub/rollingImgUpdate", method = RequestMethod.POST)
	public String rollingImgUpdate(jsVO jsvo,Model model,MultipartFile uploadfile,HttpServletRequest request) {
		
		System.out.println("update mapping start");
		System.out.println("파일 이름: {}"+ uploadfile.getOriginalFilename());
		System.out.println("파일 크기: {}"+ uploadfile.getSize());
		System.out.println("파일 이름 : {}" + uploadfile.getName());
		System.out.println("idx :"  + jsvo.getIdx());
		String delFileName = getDeleteFileRollingName(jsvo.getIdx());
		System.out.println("getDeleteFileName : " + delFileName);
		
		if(uploadfile.getOriginalFilename().equals("")) {
			System.out.println("업로드할 파일이 없습니다.");
			String getSaveFileName = getSaveFileRollingName(jsvo.getIdx());
			String getOriginFileName = getOriginRollingFileName(jsvo.getIdx());
			System.out.println("존재하는 파일 이름 : "+getSaveFileName + ":"+getOriginFileName);
			jsvo.setSaveFileName(getSaveFileName);
			jsvo.setOriginalFileName(getOriginFileName);
			this.jsService.rollingImgUpdate(jsvo);
		}else {
			System.out.println("업로드할 파일 있습니다.");
			String saveFile = saveUpdateRollingFile(uploadfile,request,delFileName);
			jsvo.setSaveFileName(saveFile);
			jsvo.setOriginalFileName(uploadfile.getOriginalFilename());
			this.jsService.rollingImgUpdate(jsvo);
		}
	
		System.out.println("update mapping end");
		
		return "redirect:/admin/sub/rollingImg?num="+jsvo.getIdx();
	}
	

	@RequestMapping(value="/admin/sub/rollingDelete", method = RequestMethod.POST)
	public String rollingDelete(@RequestParam("idx") int idx, HttpServletRequest request,@RequestParam(value="num", defaultValue="1") int num) {
		System.out.println("delete mapping start");
		deleteRollingFile(idx,request);
		this.jsService.rollingDelete(idx);
		System.out.println("delete mapping end");
		return "redirect:/admin/sub/rollingImg";
	}

	
	/* 팝업 관련 메소드 시작 */
	@RequestMapping(value="/admin/sub/popup", method=RequestMethod.GET)
	public String popup(jsVO jsvo,@RequestParam(defaultValue = "room") String division, Model model,HttpServletRequest request,HttpSession session) {	
		
		Object loginInfo = session.getAttribute("member");
		 if(loginInfo != null) {
			 model.addAttribute("msg",true);
			 
			 int noticeCount = jsService.getNoticeCount();
			 model.addAttribute("noticeCount", noticeCount);
			 
			 int galleryCount = jsService.getGelleryCount();
			 model.addAttribute("galleryCount", galleryCount);
			 
			 int userCount = jsService.getUserCount();
			 model.addAttribute("userCount", userCount);
			 
			 int faqCount = jsService.getFaqCount();
			 model.addAttribute("faqCount", faqCount);
			 
			 
			//List<jsVO> list = jsService.getGalleryList(jsvo);
			 List<jsVO> list = jsService.getPopupList(jsvo);
			System.out.println(list);
			
			
			model.addAttribute("list",list);
			 
		 }else {
			 model.addAttribute("msg",false);
		 }
		
		
		return "/admin/sub/popup";
	}
	
	
	@RequestMapping(value="/admin/sub/popupWrite", method=RequestMethod.GET)
	public String popupWrite(jsVO jsvo,Model model,HttpSession session) {	
		
		Object loginInfo = session.getAttribute("member");
		 if(loginInfo != null) {
			 model.addAttribute("msg",true);
			 
			 int noticeCount = jsService.getNoticeCount();
			 model.addAttribute("noticeCount", noticeCount);
			 
			 int galleryCount = jsService.getGelleryCount();
			 model.addAttribute("galleryCount", galleryCount);
			 
			 int userCount = jsService.getUserCount();
			 model.addAttribute("userCount", userCount);
			 
			 int faqCount = jsService.getFaqCount();
			 model.addAttribute("faqCount", faqCount);
		 }else {
			 model.addAttribute("msg",false);
		 }
		
		 
		return "/admin/sub/popupWrite";
	}
	

	
	@RequestMapping(value="/admin/sub/popupRegist", method=RequestMethod.POST)
	public String popupRegist(jsVO jsvo,Model model,MultipartFile uploadfile,HttpServletRequest request) throws IllegalStateException, IOException {

		jsService.popupInsert(jsvo);	
		return "redirect:/admin/sub/popup";
	}
	
	
	@RequestMapping(value="/admin/sub/popupModify", method=RequestMethod.GET)
	public String popupModify(jsVO jsvo, @RequestParam("idx") int idx,Model model,HttpSession session) {
		
		Object loginInfo = session.getAttribute("member");
		 if(loginInfo != null) {
			 model.addAttribute("msg",true);
				jsvo  = jsService.popupModify(idx);
				
				 int noticeCount = jsService.getNoticeCount();
				 model.addAttribute("noticeCount", noticeCount);
				 
				 int galleryCount = jsService.getGelleryCount();
				 model.addAttribute("galleryCount", galleryCount);
				 
				 int userCount = jsService.getUserCount();
				 model.addAttribute("userCount", userCount);
				 
				 int faqCount = jsService.getFaqCount();
				 model.addAttribute("faqCount", faqCount);
				 
				 
				model.addAttribute("jsvo",jsvo);
				
			 
		 }else {
			 model.addAttribute("msg",false);
		 }
	
		return "/admin/sub/popupModify";

	}
	
	@RequestMapping(value="/admin/sub/popupUpdate", method = RequestMethod.POST)
	public String popupUpdate(jsVO jsvo,Model model,MultipartFile uploadfile,HttpServletRequest request,HttpSession session) {
		
		Object loginInfo = session.getAttribute("member");
		 if(loginInfo != null) {
			 model.addAttribute("msg",true);
			 jsService.popupUpdate(jsvo);	
		 }else {
			 model.addAttribute("msg",false);
		 }
		return "redirect:/admin/sub/popup";
	}
	
	@RequestMapping(value="/admin/sub/popupDelete", method = RequestMethod.POST)
	public String popupDelete(@RequestParam("idx") int idx, HttpServletRequest request,HttpSession session,Model model,@RequestParam(value="num", defaultValue="1") int num) {
		Object loginInfo = session.getAttribute("member");
		System.out.println("loginInfo : "+loginInfo);
		
		 if(loginInfo != null) {
			 model.addAttribute("msg",true);
			 
			 System.out.println("delete mapping start");
				deletePopupFile(idx,request);
				this.jsService.popupDelete(idx);
				System.out.println("delete mapping end");
				
		 }else { 
			 model.addAttribute("msg",false); 
		 }
		
		
		return "redirect:/admin/sub/popup";
	}

	
	

	/* 현장사진 관련 메소드 시작 */
	@RequestMapping(value="/admin/sub/gallery", method=RequestMethod.GET)
	public String gallery(jsVO jsvo,@RequestParam(defaultValue = "room") String division, Model model,HttpServletRequest request,HttpSession session) {	
		
		Object loginInfo = session.getAttribute("member");
		 if(loginInfo != null) {
			 model.addAttribute("msg",true);
			 
			 int noticeCount = jsService.getNoticeCount();
			 model.addAttribute("noticeCount", noticeCount);
			 
			 int galleryCount = jsService.getGelleryCount();
			 model.addAttribute("galleryCount", galleryCount);
			 
			 int userCount = jsService.getUserCount();
			 model.addAttribute("userCount", userCount);
			 
			 int faqCount = jsService.getFaqCount();
			 model.addAttribute("faqCount", faqCount);
			 
			 
			//List<jsVO> list = jsService.getGalleryList(jsvo);
			 List<jsVO> list = jsService.getGalleryDetailList(division);
			System.out.println(list);
			
			
			model.addAttribute("list",list);
			 
		 }else {
			 model.addAttribute("msg",false);
		 }
		
		
		return "/admin/sub/gallery";
	}
	
	@RequestMapping(value="/admin/sub/galleryWrite", method=RequestMethod.GET)
	public String galleryWrite(jsVO jsvo,Model model,HttpSession session) {	
		
		Object loginInfo = session.getAttribute("member");
		 if(loginInfo != null) {
			 model.addAttribute("msg",true);
			 
			 int noticeCount = jsService.getNoticeCount();
			 model.addAttribute("noticeCount", noticeCount);
			 
			 int galleryCount = jsService.getGelleryCount();
			 model.addAttribute("galleryCount", galleryCount);
			 
			 int userCount = jsService.getUserCount();
			 model.addAttribute("userCount", userCount);
			 
			 int faqCount = jsService.getFaqCount();
			 model.addAttribute("faqCount", faqCount);
		 }else {
			 model.addAttribute("msg",false);
		 }
		
		
		 
		 
		 
		return "/admin/sub/galleryWrite";
	}
	
	@RequestMapping(value="/admin/sub/galleryRegist", method=RequestMethod.POST)
	public String insert(jsVO jsvo,Model model,MultipartFile uploadfile,HttpServletRequest request) throws IllegalStateException, IOException {
		  // 웹서비스 root 경로
	    String root_path = request.getSession().getServletContext().getRealPath("/");  
	    String attach_path = "resources/upload/";
	    String UPLOAD_PATH = root_path+attach_path;
	    System.out.println("파일경로 :" +UPLOAD_PATH);
		System.out.println("파일 이름: {}"+ uploadfile.getOriginalFilename());
		System.out.println("파일 크기: {}"+ uploadfile.getSize());
		
		if(uploadfile.getOriginalFilename().equals("")) {
			System.out.println("업로드할 파일이 없습니다.");
			jsService.galleryInsert(jsvo);	
		}else {
			
			
			//썸네일 생성
			try {
				String saveFile = saveFile(uploadfile,request);
				
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
				
				jsvo.setS_thumb("t-"+oFile.getName());
				jsvo.setM_thumb("t-"+oFile.getName());
				jsvo.setSaveFileName(saveFile);
				jsvo.setOriginalFileName(uploadfile.getOriginalFilename());
				jsService.galleryInsert(jsvo);	
				
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		
		}

		return "redirect:/admin/sub/gallery";
	}
	
	
	@RequestMapping(value="/admin/sub/galleryModify", method=RequestMethod.GET)
	public String galleryModify(jsVO jsvo, @RequestParam("idx") int idx,Model model,HttpSession session) {
		
		Object loginInfo = session.getAttribute("member");
		 if(loginInfo != null) {
			 model.addAttribute("msg",true);
				jsvo  = jsService.galleryModify(idx);
				
				 int noticeCount = jsService.getNoticeCount();
				 model.addAttribute("noticeCount", noticeCount);
				 
				 int galleryCount = jsService.getGelleryCount();
				 model.addAttribute("galleryCount", galleryCount);
				 
				 int userCount = jsService.getUserCount();
				 model.addAttribute("userCount", userCount);
				 
				 int faqCount = jsService.getFaqCount();
				 model.addAttribute("faqCount", faqCount);
				 
				 
				model.addAttribute("jsvo",jsvo);
				
			 
		 }else {
			 model.addAttribute("msg",false);
		 }
	
		return "/admin/sub/galleryModify";

	}
	
	@RequestMapping(value="/admin/sub/galleryUpdate", method = RequestMethod.POST)
	public String galleryUpdate(jsVO jsvo,Model model,MultipartFile uploadfile,HttpServletRequest request) throws IOException {
		
		  // 웹서비스 root 경로
	    String root_path = request.getSession().getServletContext().getRealPath("/");  
	    String attach_path = "resources/upload/";
	    String UPLOAD_PATH = root_path+attach_path;
	    
	    
		System.out.println("update mapping start");
		System.out.println("파일 이름: {}"+ uploadfile.getOriginalFilename());
		System.out.println("파일 크기: {}"+ uploadfile.getSize());
		System.out.println("파일 이름 : {}" + uploadfile.getName());
		System.out.println("idx :"  + jsvo.getIdx());
		String delFileName = getDeleteFileName(jsvo.getIdx());
		String delThumbNailName = getDeleteThumbFileName(jsvo.getIdx());
		System.out.println("getDeleteFileName : " + delFileName);
		System.out.println("delThumbNailName : " + delThumbNailName);
		
		if(uploadfile.getOriginalFilename().equals("")) {
			System.out.println("업로드할 파일이 없습니다.");
			String getSaveFileName = getSaveFileName(jsvo.getIdx());
			String getOriginFileName = getOriginFileName(jsvo.getIdx());
			String getThumbNailFileName = getThumbNailFileName(jsvo.getIdx());
			System.out.println("존재하는 파일 이름 : "+getSaveFileName + ":"+getOriginFileName+ ":"+getThumbNailFileName);
			jsvo.setM_thumb(getThumbNailFileName);
			jsvo.setS_thumb(getThumbNailFileName);
			jsvo.setSaveFileName(getSaveFileName);
			jsvo.setOriginalFileName(getOriginFileName);
			this.jsService.galleryUpdate(jsvo);
		}else {
			
			System.out.println("업로드할 파일 있습니다.");
			String saveFile = saveUpdateFile(uploadfile,request,delFileName,delThumbNailName);
			
			/*썸네일 생성 */
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
			
			
			ImageIO.write(tImage, ext, tFile);
			ImageIO.write(tImage2, ext, tmFile);
			
			graphic.dispose(); // 리소스를 모두 해제
			graphic2.dispose();
			
			
			jsvo.setM_thumb("t-"+saveFile);
			jsvo.setS_thumb("t-"+saveFile);
			jsvo.setSaveFileName(saveFile);
			jsvo.setOriginalFileName(uploadfile.getOriginalFilename());
			this.jsService.galleryUpdate(jsvo);
		}
	
		System.out.println("update mapping end");
		
		return "redirect:/admin/sub/gallery?num="+jsvo.getIdx();
	}
	
	
	

	private String getThumbNailFileName(int idx) {
		return  jsService.getThumbNailFileName(idx);
	}

	private String getOriginFileName(Integer idx) {
		return  jsService.getOriginFileName(idx);
	}

	private String getSaveFileName(Integer idx) {
		return  jsService.getSaveFileName(idx);
	}
	
	@RequestMapping(value="/admin/sub/galleryDelete", method = RequestMethod.POST)
	public String delete(@RequestParam("idx") int idx, HttpServletRequest request,@RequestParam(value="num", defaultValue="1") int num) {
		System.out.println("delete mapping start");
		deleteFile(idx,request);
		this.jsService.galleryDelete(idx);
		System.out.println("delete mapping end");
		return "redirect:/admin/sub/gallery";
	}
	
	/* 현장사진 관련 메소드 끝 */
	

	/* 이메일 답변 메소드 */
	@RequestMapping(value="/admin/sub/mailSend", method=RequestMethod.POST)
	public void mailSend(jsVO jsvo,Model model,MultipartFile uploadfile,HttpServletRequest request,HttpServletResponse response_email) throws IllegalStateException, IOException {
		
		Properties props = System.getProperties();
		props.put("mail.smtp.host", "smtp.naver.com");
		props.put("mail.smtp.port", "587");
		props.put("defaultEncoding", "utf-8");
		props.put("mail.smtp.auth", "true");
		PrintWriter out = response_email.getWriter();			
		try {
			String sender = "kkameun@naver.com"; 
			String subject = "[J&Stay] 문의사항에 대해 답변 드립니다. "; 
			String body = jsvo.getResponse();
						
			Session session = Session.getDefaultInstance(props, new javax.mail.Authenticator() {
				protected javax.mail.PasswordAuthentication getPasswordAuthentication() {
					return new javax.mail.PasswordAuthentication(sender, "qkagksmf12@#");
				}
			});
						
			this.jsService.updateContact(jsvo);
			session.setDebug(false); //Debug 모드 설정.
			Message mimeMessage = new MimeMessage(session);
			mimeMessage.setFrom(new InternetAddress(sender)); 
			mimeMessage.setRecipient(Message.RecipientType.TO, new InternetAddress(jsvo.getEmail())); //수신자 셋팅
			mimeMessage.setSubject(subject); //제목 세팅
			mimeMessage.setText(body); //본문 세팅
			Transport.send(mimeMessage);
			out.println("success");
		} catch (Exception e) {
			System.out.println("메일보내기 오류 : "+ e.getMessage());
		}


	}
	
	@RequestMapping(value="/admin/sub/faq", method=RequestMethod.GET)
	public String faq(jsVO jsvo,Model model,HttpSession session) {	
		
		Object loginInfo = session.getAttribute("member");
		 if(loginInfo != null) {
			 model.addAttribute("msg",true);
			 int noticeCount = jsService.getNoticeCount();
			 model.addAttribute("noticeCount", noticeCount);
			 
			 int galleryCount = jsService.getGelleryCount();
			 model.addAttribute("galleryCount", galleryCount);
			 
			 int userCount = jsService.getUserCount();
			 model.addAttribute("userCount", userCount);
			 
			 int faqCount = jsService.getFaqCount();
			 model.addAttribute("faqCount", faqCount);

			List<jsVO> list = jsService.getFaqList(jsvo);
			System.out.println(list);	
			model.addAttribute("list",list);
		 }else {
			 model.addAttribute("msg",false);
		 }
	
	
		return "/admin/sub/faq";
	}
	
	@RequestMapping(value="/admin/sub/faqUpdate", method=RequestMethod.POST)
	public String faqUpdate(jsVO jsvo, @RequestParam("idx") int idx,Model model) {	
	
		 int noticeCount = jsService.getNoticeCount();
		 model.addAttribute("noticeCount", noticeCount);
		 
		 int galleryCount = jsService.getGelleryCount();
		 model.addAttribute("galleryCount", galleryCount);
		 
		 int userCount = jsService.getUserCount();
		 model.addAttribute("userCount", userCount);
		 
		 int faqCount = jsService.getFaqCount();
		 model.addAttribute("faqCount", faqCount);
		 
		 
		jsService.faqUpdate(jsvo);
		
		
		return "redirect:/admin/sub/faq";

	}
	
	
	
	@RequestMapping(value="/admin/sub/reserve", method=RequestMethod.GET)
	public String reserve(jsVO jsvo,Model model,HttpSession session) {	
		
		Object loginInfo = session.getAttribute("member");
		 if(loginInfo != null) {
			 model.addAttribute("msg",true);
			 
			 int noticeCount = jsService.getNoticeCount();
			 model.addAttribute("noticeCount", noticeCount);
			 
			 int galleryCount = jsService.getGelleryCount();
			 model.addAttribute("galleryCount", galleryCount);
			 
			 int userCount = jsService.getUserCount();
			 model.addAttribute("userCount", userCount);
			 
			 int faqCount = jsService.getFaqCount();
			 model.addAttribute("faqCount", faqCount);
			 
			 
			List<jsVO> list = jsService.getReserveList(jsvo);
			System.out.println(list);	
			model.addAttribute("list",list);
		 }else {
			 model.addAttribute("msg",false);
		 }
		
	
		return "/admin/sub/reserve";
	}
	
	@RequestMapping(value="/admin/sub/reserveUpdate", method=RequestMethod.POST)
	public String reserveUpdate(jsVO jsvo, @RequestParam("idx") int idx,Model model) {	
		
		 int noticeCount = jsService.getNoticeCount();
		 model.addAttribute("noticeCount", noticeCount);
		 
		 int galleryCount = jsService.getGelleryCount();
		 model.addAttribute("galleryCount", galleryCount);
		 
		 int userCount = jsService.getUserCount();
		 model.addAttribute("userCount", userCount);
		 
		 int faqCount = jsService.getFaqCount();
		 model.addAttribute("faqCount", faqCount);
		 
		 
		 
		jsService.reserveUpdate(jsvo);
		
		return "redirect:/admin/sub/reserve";

	}
	
	
	
	
	@RequestMapping(value="/admin/login", method=RequestMethod.POST)
	public String login(Model model, adminVO adminvo, HttpServletRequest req, RedirectAttributes rttr) {	
	
		System.out.println(adminvo.getId()+","+adminvo.getPassword());
		
		 HttpSession session = req.getSession();
		 
		 adminVO login = jsService.login(adminvo);
		// System.out.println("DB로부터 가지고온 값 : " + login.getPassword());
		 
		 if(login!=null){
			 System.out.println("로그인 성공");
			 session.setAttribute("member", login);
			 model.addAttribute("msg",true);
			 return "redirect:/admin/dashboard";
			
		 }else {
			 System.out.println("로그인 실패");
			 session.setAttribute("member", null);
			 model.addAttribute("msg",false);
			 return "redirect:/admin";
		 }

		
	}
	
	@RequestMapping(value="/admin/logout", method = RequestMethod.GET)
	public String logout(HttpSession session) throws Exception {
		System.out.println(" 로그아웃");
		session.invalidate();
		return "redirect:/admin";
	}
	

	
	
	
	private void deleteFile(int idx, HttpServletRequest request) {
		  // 웹서비스 root 경로
	    String root_path = request.getSession().getServletContext().getRealPath("/");  
	    String attach_path = "resources/upload/";
	    
	    String UPLOAD_PATH = root_path+attach_path;
	    System.out.println("파일경로 :" +UPLOAD_PATH);
	    String delFileName = getDeleteFileName(idx);
	    String delThumbNailName = getDeleteThumbFileName(idx);
	    String deleteFileName = UPLOAD_PATH+delFileName;
	    String deleteThumbFileName1 = UPLOAD_PATH+"s-thumb/"+delThumbNailName;
	    String deleteThumbFileName2 = UPLOAD_PATH+"m-thumb/"+delThumbNailName;
	    
	    System.out.println("DeleteFileName : " + deleteFileName);
	    System.out.println("deleteThumbFileName1 : " + deleteThumbFileName1);
	    System.out.println("deleteThumbFileName2 : " + deleteThumbFileName2);
	    File deleteFile = new File(deleteFileName);
	    File deleteThumbFile1 = new File(deleteThumbFileName1);
	    File deleteThumbFile2 = new File(deleteThumbFileName2);
	    
      // 파일이 존재하는지 체크 존재할경우 true, 존재하지않을경우 false
      if(deleteFile.exists()) {
          
          // 파일을 삭제합니다.
          deleteFile.delete(); 
          deleteThumbFile1.delete();
          deleteThumbFile2.delete();
          
          System.out.println("파일을 삭제하였습니다.");
          
      } else {
          System.out.println("파일이 존재하지 않습니다.");
          
      }
		
	}
	


	private String getDeleteThumbFileName(int idx) {
		return  jsService.getDeleteThumbFileName(idx);
	}

	private String getDeleteFileName(Integer idx) {
		return  jsService.getDeleteFileName(idx);
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
	

	private String saveUpdateFile(MultipartFile uploadfile, HttpServletRequest request, String delFileName, String delThumbNailName) {
		  // 웹서비스 root 경로
	    String root_path = request.getSession().getServletContext().getRealPath("/");  
	    String attach_path = "resources/upload/";
	    String UPLOAD_PATH = root_path+attach_path;
	    System.out.println("파일경로 :" +UPLOAD_PATH);
	    
	    String deleteFileName = UPLOAD_PATH+delFileName;
	    String deleteThumbNailName1 = UPLOAD_PATH+"s-thumb/"+delThumbNailName;
	    String deleteThumbNailName2 = UPLOAD_PATH+"m-thumb/"+delThumbNailName;
	    System.out.println("DeleteFileName : " + deleteFileName);
	    System.out.println("deleteThumbNailName1 : " + deleteThumbNailName1);
	    System.out.println("deleteThumbNailName2 : " + deleteThumbNailName2);
	    File deleteFile = new File(deleteFileName);
	    File deleteThumbNailsName1 = new File(deleteThumbNailName1);
	    File deleteThumbNailmName2 = new File(deleteThumbNailName2);
	    
      // 파일이 존재하는지 체크 존재할경우 true, 존재하지않을경우 false
      if(deleteFile.exists()) {
          
          // 파일을 삭제합니다.
          deleteFile.delete(); 
          deleteThumbNailsName1.delete();
          deleteThumbNailmName2.delete();
          
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
	
	

	
	
	private String getDeleteFileRollingName(int idx) {
		return  jsService.getDeleteFileRollingName(idx);
	}
	
	
	private String getOriginRollingFileName(int idx) {
		return  jsService.getOriginRollingFileName(idx);
	}

	private String getSaveFileRollingName(int idx) {
		return  jsService.getSaveFileRollingName(idx);
	}
	
	
	private String saveRollingFile(MultipartFile uploadfile, HttpServletRequest request) {
		 // 웹서비스 root 경로
	    String root_path = request.getSession().getServletContext().getRealPath("/");  
	    String attach_path = "resources/uploadRolling/";
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
	
	
	
	private String saveUpdateRollingFile(MultipartFile uploadfile, HttpServletRequest request, String delFileName) {
		 // 웹서비스 root 경로
	    String root_path = request.getSession().getServletContext().getRealPath("/");  
	    String attach_path = "resources/uploadRolling/";
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

	
	

	


	private void deleteRollingFile(int idx, HttpServletRequest request) {
		  // 웹서비스 root 경로
	    String root_path = request.getSession().getServletContext().getRealPath("/");  
	    String attach_path = "resources/uploadRolling/";
	    String UPLOAD_PATH = root_path+attach_path;
	    System.out.println("파일경로 :" +UPLOAD_PATH);
	    String delFileName = getDeleteFileRollingName(idx);
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
		
	}
	
	
	
	
	@RequestMapping(value = "/admin/ckUpload", method = RequestMethod.POST)
	public void postCKEditorImgUpload(HttpServletRequest req, Model model,
	          HttpServletResponse res, jsVO jsvo, HttpSession session,
	          @RequestParam MultipartFile upload) throws Exception {
		System.out.println("post CKEditor img popup upload");
		 // 랜덤 문자 생성
		 UUID uid = UUID.randomUUID();

		 OutputStream out = null;
		 PrintWriter printWriter = null;
	
		 // 인코딩
		 res.setCharacterEncoding("utf-8");
		 res.setContentType("text/html;charset=utf-8");
		 
		 Object loginInfo = session.getAttribute("member");
		 if(loginInfo != null) {
			 model.addAttribute("msg",true);
			 
			 try {
				  
				  String fileName = upload.getOriginalFilename();  // 파일 이름 가져오기
				  byte[] bytes = upload.getBytes();
				  
				  // 업로드 경로
				    String root_path = req.getSession().getServletContext().getRealPath("/");  

				    int idx = 0;
				    if(jsService.getPopupsCount()==0) {
				    	idx = 1;
				    	System.out.println("0일때 idx : " +idx);
				    }else {
				    	 idx = jsService.getPopupsIdx()+1;
				    	 System.out.println("0이 아닐때 idx : " +idx);
				    }
				   
				   
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
				  String fileUrl = "http://jnstay.net/resources/ckUpload/"+idx+"/" + uid + "_" + fileName;  // 작성화면
				
				  // 업로드시 메시지 출력
				  printWriter.println("{\"filename\" : \""+fileName+"\", \"uploaded\" : 1, \"url\":\""+fileUrl+"\"}");
				  
				  printWriter.flush();
				  System.out.println("fileUrl : " + fileUrl);
				  
				 } catch (IOException e) { e.printStackTrace();
				 } finally {
				  try {
				   if(out != null) { out.close(); }
				   if(printWriter != null) { printWriter.close(); }
				  } catch(IOException e) { e.printStackTrace(); }
				 }
				
			 
		 }else {
			 model.addAttribute("msg",false);
		 }
	
		
	
		return ; 
	}
	
	@RequestMapping(value = "/admin/ckUpdateUpload", method = RequestMethod.POST)
	public void ckUpdateUpload(HttpServletRequest req,
	          HttpServletResponse res,jsVO jsvo,
	          @RequestParam MultipartFile upload) throws Exception {
			System.out.println("post CKEditor img upload");
			 // 랜덤 문자 생성
			 UUID uid = UUID.randomUUID();
			 
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
			    int idx = jsService.getPopupsIdx();
			    System.out.println("썸네일 update" + idx);
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
			  String fileUrl = "http://jnstay.net/resources/ckUpload/"+idx+"/" + uid + "_" + fileName;  // 작성화면
			
			  // 업로드시 메시지 출력
			  printWriter.println("{\"filename\" : \""+fileName+"\", \"uploaded\" : 1, \"url\":\""+fileUrl+"\"}");
			  
			  printWriter.flush();
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
	
	
	
	private void deletePopupFile(int idx, HttpServletRequest request) {
		  // 웹서비스 root 경로
	    String root_path = request.getSession().getServletContext().getRealPath("/");  

	    //썸네일 파일 삭제
	    String thumb_path = "resources/ckUpload/"+idx;
	    String THUMB_UPLOAD_PATH = root_path+thumb_path;
	    System.out.println("썸네일 파일 삭제 경로 : " + THUMB_UPLOAD_PATH);

	    File thumbDeleteFile = new File(THUMB_UPLOAD_PATH);
	    
	    

  while(thumbDeleteFile.exists()) {
      
      // 파일을 삭제합니다.
	  File[] deleteFolderList = thumbDeleteFile.listFiles();
			
			for (int j = 0; j < deleteFolderList.length; j++) {
				  deleteFolderList[j].delete(); 
		          System.out.println("썸네일 파일을 삭제하였습니다.");
			}
			
			if(deleteFolderList.length == 0 && thumbDeleteFile.isDirectory()){
				thumbDeleteFile.delete();
				System.out.println("썸네일 폴더를 삭제하였습니다.");
			}
     
      
	  } 
			
		
	}

	
	
	/* 설문조사 관련 메소드 시작 */
	@RequestMapping(value="/admin/sub/surveyResult", method=RequestMethod.GET)
	public String surveyResult(jsVO jsvo, surveyVO surveyvo, Model model,HttpSession session, @RequestParam(value="num", defaultValue="1") int num) {	
		
		Object loginInfo = session.getAttribute("member");
		 if(loginInfo != null) {
			 model.addAttribute("msg",true);
			 
			 int noticeCount = jsService.getNoticeCount();
			 model.addAttribute("noticeCount", noticeCount);
			 
			 int galleryCount = jsService.getGelleryCount();
			 model.addAttribute("galleryCount", galleryCount);
			 
			 int userCount = jsService.getUserCount();
			 model.addAttribute("userCount", userCount);
			 
			 int faqCount = jsService.getFaqCount();
			 model.addAttribute("faqCount", faqCount);
			 
				int count = jsService.countSurvey();
				System.out.println("count : " +count);
				 // 한 페이지에 출력할 게시물 갯수
				 int postNum = 10;
				  
				 // 하단 페이징 번호 ([ 게시물 총 갯수 ÷ 한 페이지에 출력할 갯수 ]의 올림)
				 int pageNum = (int)Math.ceil((double)count/postNum);
				  
				 // 출력할 게시물
				 int displayPost = (num - 1) * postNum;
				 jsvo.setDisplayPost(displayPost);
				// 한번에 표시할 페이징 번호의 갯수
				int pageNum_cnt = 10;
				jsvo.setPostNum(postNum);
				

				// 표시되는 페이지 번호 중 마지막 번호
				int endPageNum = (int)(Math.ceil((double)num / (double)pageNum_cnt) * pageNum_cnt);

				// 표시되는 페이지 번호 중 첫번째 번호
				int startPageNum = endPageNum - (pageNum_cnt - 1);
				
				// 마지막 번호 재계산
				int endPageNum_tmp = (int)(Math.ceil((double)count / (double)pageNum_cnt));
				 
				if(endPageNum > endPageNum_tmp) {
				 endPageNum = endPageNum_tmp;
				}
				
				boolean prev = startPageNum == 1 ? false : true;
				boolean next = endPageNum * pageNum_cnt >= count ? false : true;
				
				// 시작 및 끝 번호
				model.addAttribute("startPageNum", startPageNum);
				model.addAttribute("endPageNum", endPageNum);

				// 이전 및 다음 
				model.addAttribute("prev", prev);
				model.addAttribute("next", next);
				
				// 현재 페이지
				model.addAttribute("select", num);
				model.addAttribute("pageNum", pageNum);
				
			
			List<surveyVO> list = jsService.getSurvey(surveyvo);
			System.out.println(list);
			
			
			model.addAttribute("list",list);
			
		 }else {
			 model.addAttribute("msg",false); 
		 }
	
		return "/admin/sub/surveyResult";
	}
	
	
	@RequestMapping(value="/admin/sub/surveyResultDetail", method=RequestMethod.GET)
	public String surveyResultDetail(jsVO jsvo, surveyVO surveyvo, Model model,HttpSession session,@RequestParam(defaultValue = "1") int idx ) {	
		
		Object loginInfo = session.getAttribute("member");
		 if(loginInfo != null) {
			 model.addAttribute("msg",true);
			 
			 int noticeCount = jsService.getNoticeCount();
			 model.addAttribute("noticeCount", noticeCount);
			 
			 int galleryCount = jsService.getGelleryCount();
			 model.addAttribute("galleryCount", galleryCount);
			 
			 int userCount = jsService.getUserCount();
			 model.addAttribute("userCount", userCount);
			 
			 int faqCount = jsService.getFaqCount();
			 model.addAttribute("faqCount", faqCount);
			 
			
			surveyVO surveyDetail = jsService.getSurveyDetail(idx);
			System.out.println(surveyDetail);
			
			
			model.addAttribute("surveyDetail",surveyDetail);
			
		 }else {
			 model.addAttribute("msg",false); 
		 }
	
		return "/admin/sub/surveyResultDetail";
	}
	
}
