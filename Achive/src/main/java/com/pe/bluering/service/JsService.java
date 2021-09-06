package com.pe.bluering.service;

import java.util.List;

import com.pe.bluering.vo.adminVO;
import com.pe.bluering.vo.jsVO;
import com.pe.bluering.vo.surveyVO;


public interface JsService {

	adminVO login(adminVO adminvo);
	
	/* 공지사항 관련 */
	void noticeInsert(jsVO jsvo);
	List<jsVO> getNoticeList(jsVO jsvo);
	jsVO noticeModify(int idx);
	void noticeUpdate(jsVO jsvo);
	void noticeDelete(int idx);

	/*갤러리 관련*/
	void galleryInsert(jsVO jsvo);
	List<jsVO> getGalleryList(jsVO jsvo);
	List<jsVO> getGalleryDetailList(String division);
	jsVO galleryModify(int idx);
	void galleryUpdate(jsVO jsvo);
	String getOriginFileName(Integer idx);
	String getSaveFileName(Integer idx);
	String getDeleteFileName(Integer idx);

	String getThumbNailFileName(int idx);
	void galleryDelete(int idx);
	

	/*Contact Us 관련 */
	void contactRegist(jsVO jsvo);
	List<jsVO> getContactList(jsVO jsvo);
	void updateContact(jsVO jsvo);
	String isSecretMember(jsVO jsvo);
	jsVO getContactDetail(int idx);
	void contactUpdate(jsVO jsvo);
	void contactDelete(jsVO jsvo);
	int contactCount();
	String getDeleteThumbFileName(int idx);


	/*Faq 관련 */
	List<jsVO> getFaqList(jsVO jsvo);
	List<jsVO> getFaqViewList(jsVO jsvo);
	void faqUpdate(jsVO jsvo);

	/* reserve 등록 관련 */
	List<jsVO> getReserveList(jsVO jsvo);
	void reserveUpdate(jsVO jsvo);

	/* 카운트 관련 */
	int getNoticeCount();
	int getGelleryCount();
	int getUserCount();
	int getFaqCount();

	/* 상단롤링이미지 관련*/
	List<jsVO> getRollingList(jsVO jsvo);
	void rollingImgInsert(jsVO jsvo);
	jsVO rollingImgModify(int idx);
	void rollingImgUpdate(jsVO jsvo);
	String getDeleteFileRollingName(int idx);
	String getOriginRollingFileName(int idx);
	String getSaveFileRollingName(int idx);
	void rollingDelete(int idx);

	/*팝업관련메소드*/
	void popupInsert(jsVO jsvo);
	List<jsVO> getPopupList(jsVO jsvo);
	jsVO popupModify(int idx);
	int getPopupsCount();
	int getPopupsIdx();
	void popupUpdate(jsVO jsvo);
	void popupDelete(int idx);

	/*설문조사결과 가지고 오기*/
	List<surveyVO> getSurvey(surveyVO surveyvo);
	surveyVO getSurveyDetail(int idx);
	int countSurvey();

	/* 방문자 수 */
	String getMaxvisitDate();
	void updateHit(String dbDate);
	void insertHit(String now);
	int getVisitCount(String now);

	int getVisitTotalCount();

	List<jsVO> getGraph();

	
	/*Test*/
	void testInsert(jsVO jsvo);
	int getAlbumCount();
	int getAlbumIdx();
	List<jsVO> getAchive(jsVO jsvo);
	jsVO imgModify(int idx);
	void imgUpdate(jsVO jsvo);
	void imgDelete(int idx);
	jsVO getAchiveDetail(jsVO jsvo);

	String getNext(int idx);
	String getPrev(int idx);

}
