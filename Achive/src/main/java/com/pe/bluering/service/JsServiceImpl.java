package com.pe.bluering.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pe.bluering.dao.jsDAO;
import com.pe.bluering.vo.adminVO;
import com.pe.bluering.vo.jsVO;
import com.pe.bluering.vo.surveyVO;

@Service
public class JsServiceImpl implements JsService {

	@Autowired
	jsDAO jsdao;
	
	@Override
	public adminVO login(adminVO adminvo) {
		return jsdao.login(adminvo);
	}

	/*공지사항 관련 메서드*/

	@Override
	public void noticeInsert(jsVO jsvo) {
		this.jsdao.noticeInsert(jsvo);
	}
	@Override
	public List<jsVO> getNoticeList(jsVO jsvo) {
		return jsdao.getNoticeList(jsvo);
	}
	@Override
	public jsVO noticeModify(int idx) {
		return jsdao.noticeModify(idx);
	}

	@Override
	public void noticeUpdate(jsVO jsvo) {
		jsdao.noticeUpdate(jsvo);
	}
	@Override
	public void noticeDelete(int idx) {
		jsdao.noticeDelete(idx);
	}


	/*gallery 관련 메소드 */
	

	@Override
	public void galleryInsert(jsVO jsvo) {
		this.jsdao.galleryInsert(jsvo);
	}

	@Override
	public List<jsVO> getGalleryList(jsVO jsvo) {
		return jsdao.getGalleryList(jsvo);
	}
	
	@Override
	public List<jsVO> getGalleryDetailList(String division) {
		return jsdao.getGalleryDetailList(division);
	}


	@Override
	public jsVO galleryModify(int idx) {
		return jsdao.galleryModify(idx);
	}

	@Override
	public void galleryUpdate(jsVO jsvo) {
		jsdao.galleryUpdate(jsvo);
	}
	
	@Override
	public String getThumbNailFileName(int idx) {
		return jsdao.getThumbNailFileName(idx);
	}


	@Override
	public String getOriginFileName(Integer idx) {
		return jsdao.getOriginFileName(idx);
	}
	@Override
	public String getSaveFileName(Integer idx) {
		return jsdao.getSaveFileName(idx);
	}

	@Override
	public String getDeleteFileName(Integer idx) {
		return jsdao.getDeleteFileName(idx);
	}
	
	@Override
	public String getDeleteThumbFileName(int idx) {
		return jsdao.getDeleteThumbFileName(idx);
	}


	@Override
	public void galleryDelete(int idx) {
		jsdao.galleryDelete(idx);
	}

	@Override
	public void contactRegist(jsVO jsvo) {
		jsdao.contactRegist(jsvo);
	}

	@Override
	public List<jsVO> getContactList(jsVO jsvo) {
		return jsdao.getContactList(jsvo);
	}

	@Override
	public void updateContact(jsVO jsvo) {
		jsdao.contactUpdate(jsvo);
	}
	
	@Override
	public int contactCount() {
		return jsdao.contactCount();
	}

	
	@Override
	public jsVO getContactDetail(int idx) {
		return jsdao.getContactDetail(idx);
	}

	@Override
	public void contactUpdate(jsVO jsvo) {
		 jsdao.updateContact(jsvo);
	}

	@Override
	public void contactDelete(jsVO jsvo) {
		 jsdao.contactDelete(jsvo);
		
	}

	@Override
	public List<jsVO> getFaqList(jsVO jsvo) {
		return jsdao.getFaqList(jsvo);
	}
	
	@Override
	public String isSecretMember(jsVO jsvo) {
		return jsdao.isSecretMember(jsvo);
	}


	
	@Override
	public List<jsVO> getFaqViewList(jsVO jsvo) {
		return jsdao.getFaqViewList(jsvo);
	}
	

	@Override
	public void faqUpdate(jsVO jsvo) {
		jsdao.faqUpdate(jsvo);
	}

	@Override
	public List<jsVO> getReserveList(jsVO jsvo) {
		return jsdao.getReserveList(jsvo);
	}

	@Override
	public void reserveUpdate(jsVO jsvo) {
		jsdao.reserveUpdate(jsvo);
	}


	/*카운트 관련 */
	@Override
	public int getNoticeCount() {
		return jsdao.getNoticeCount();
	}

	@Override
	public int getGelleryCount() {
		return jsdao.getGelleryCount();
	}

	@Override
	public int getUserCount() {
		return jsdao.getUserCount();
	}

	@Override
	public int getFaqCount() {
		return jsdao.getFaqCount();
	}

	
	/* 상단 롤링 이미지 관련 */
	@Override
	public List<jsVO> getRollingList(jsVO jsvo) {
		return jsdao.getRollingList(jsvo);
	}

	@Override
	public void rollingImgInsert(jsVO jsvo) {
		this.jsdao.rollingImgInsert(jsvo);
	}

	@Override
	public jsVO rollingImgModify(int idx) {
		return jsdao.rollingImgModify(idx);
	}

	@Override
	public void rollingImgUpdate(jsVO jsvo) {
		jsdao.rollingImgUpdate(jsvo);
	}

	@Override
	public String getDeleteFileRollingName(int idx) {
		return jsdao.getDeleteFileRollingName(idx);
	}

	@Override
	public String getOriginRollingFileName(int idx) {
		return jsdao.getOriginRollingFileName(idx);
	}

	@Override
	public String getSaveFileRollingName(int idx) {
		return jsdao.getSaveFileRollingName(idx);
	}

	@Override
	public void rollingDelete(int idx) {
		jsdao.rollingDelete(idx);
	}

	@Override
	public void popupInsert(jsVO jsvo) {
		this.jsdao.popupInsert(jsvo);
		
	}

	@Override
	public List<jsVO> getPopupList(jsVO jsvo) {
		return jsdao.getPopupList(jsvo);
	}

	@Override
	public jsVO popupModify(int idx) {
		return jsdao.popupModify(idx);
	}

	@Override
	public int getPopupsCount() {
		return jsdao.getPopupsCount();
	}

	@Override
	public int getPopupsIdx() {
		return jsdao.getPopupsIdx();
	}

	@Override
	public void popupUpdate(jsVO jsvo) {
		jsdao.popupUpdate(jsvo);
	}

	@Override
	public void popupDelete(int idx) {
		jsdao.popupDelete(idx);
	}

	
	/* 설문조사 결과 가지고 오기*/
	@Override
	public List<surveyVO> getSurvey(surveyVO surveyvo) {
		return jsdao.getSurvey(surveyvo);
	}

	@Override
	public surveyVO getSurveyDetail(int idx) {
		return jsdao.getSurveyDetail(idx);
	}

	@Override
	public int countSurvey() {
		return jsdao.countSurvey();
	}

	
	/* 방문자 수 */
	@Override
	public String getMaxvisitDate() {
		return jsdao.getMaxvisitDate();
	}

	@Override
	public void updateHit(String dbDate) {
		 jsdao.updateHit(dbDate);
	}


	@Override
	public void insertHit(String now) {
		jsdao.insertHit(now);
	}

	@Override
	public int getVisitCount(String now) {
		return jsdao.getVisitCount(now);
	}

	@Override
	public int getVisitTotalCount() {
		return jsdao.getVisitTotalCount();
	}

	@Override
	public List<jsVO> getGraph() {
		return jsdao.getGraph();
	}

	@Override
	public void testInsert(jsVO jsvo) {
		jsdao.testInsert(jsvo);
	}

	@Override
	public int getAlbumCount() {
		return jsdao.getAlbumCount();
	}

	@Override
	public int getAlbumIdx() {
		return  jsdao.getAlbumIdx();
	}

	@Override
	public List<jsVO> getAchive(jsVO jsvo) {
		return  jsdao.getAchive(jsvo);
	}

	@Override
	public jsVO imgModify(int idx) {
		return jsdao.imgModify(idx);
	}

	@Override
	public void imgUpdate(jsVO jsvo) {
		jsdao.imgUpdate(jsvo);
	}

	@Override
	public void imgDelete(int idx) {
		jsdao.imgDelete(idx);
	}

	@Override
	public jsVO getAchiveDetail(jsVO jsvo) {
		return jsdao.getAchiveDetail(jsvo);
	}

	@Override
	public String getNext(int idx) {
		return jsdao.getNext(idx);
	}

	@Override
	public String getPrev(int idx) {
		return jsdao.getPrev(idx);
	}
		

}
