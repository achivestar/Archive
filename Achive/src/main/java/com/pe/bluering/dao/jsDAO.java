package com.pe.bluering.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.pe.bluering.vo.adminVO;
import com.pe.bluering.vo.jsVO;
import com.pe.bluering.vo.surveyVO;


@Repository
public class jsDAO {

	@Autowired
	SqlSessionTemplate sqlSessionTemplate;
	
	public adminVO login(adminVO adminvo) {
		return  this.sqlSessionTemplate.selectOne("adminLogin.login",adminvo);
	}
		
	
	/* 공지사항 관련 메서드 */
	public void noticeInsert(jsVO jsvo) {
		 this.sqlSessionTemplate.insert("js.noticeInsert",jsvo);
	}

	public List<jsVO> getNoticeList(jsVO jsvo) {
		return this.sqlSessionTemplate.selectList("js.noticeSelect",jsvo);
	}

	public jsVO noticeModify(int idx) {
		return sqlSessionTemplate.selectOne("js.noticeDetail",idx);
	}

	public void noticeUpdate(jsVO jsvo) {
		 sqlSessionTemplate.update("js.noticeUpdate",jsvo);
	}

	public void noticeDelete(int idx) {
		 sqlSessionTemplate.delete("js.noticeDelete",idx);
	}

	
	/* 갤러리 관련 메서드 */
	public void galleryInsert(jsVO jsvo) {
		 this.sqlSessionTemplate.insert("js.galleryInsert",jsvo);
	}


	public List<jsVO> getGalleryList(jsVO jsvo) {
		return this.sqlSessionTemplate.selectList("js.gallerySelect",jsvo);
	}


	public List<jsVO> getGalleryDetailList(String division) {
		return this.sqlSessionTemplate.selectList("js.galleryDetailSelect",division);
	}



	public jsVO galleryModify(int idx) {
		return sqlSessionTemplate.selectOne("js.galleryDetail",idx);
	}


	public void galleryUpdate(jsVO jsvo) {
		sqlSessionTemplate.update("js.galleryUpdate",jsvo);
	}

	public String getThumbNailFileName(int idx) {
		return sqlSessionTemplate.selectOne("js.getThumbNailFileName",idx);
	}



	public String getOriginFileName(Integer idx) {
		return sqlSessionTemplate.selectOne("js.getOriginFileName",idx);
	}


	public String getSaveFileName(Integer idx) {
		return sqlSessionTemplate.selectOne("js.getSaveFileName",idx);
	}


	public String getDeleteFileName(Integer idx) {
		return sqlSessionTemplate.selectOne("js.getDeleteFileName",idx);
	}

	public String getDeleteThumbFileName(int idx) {
		return sqlSessionTemplate.selectOne("js.getDeleteThumbFileName",idx);
	}



	public void galleryDelete(int idx) {
		 sqlSessionTemplate.delete("js.galleryDelete",idx);
	}


	public void contactRegist(jsVO jsvo) {
		 this.sqlSessionTemplate.insert("js.contactRegist",jsvo);
	}


	public List<jsVO> getContactList(jsVO jsvo) {
		return this.sqlSessionTemplate.selectList("js.contactSelect",jsvo);
	}


	public String isSecretMember(jsVO jsvo) {
		return this.sqlSessionTemplate.selectOne("js.isSecretMember",jsvo);
	}


	public jsVO getContactDetail(int idx) {
		return this.sqlSessionTemplate.selectOne("js.getContactDetail",idx);
	}

	
	public void contactUpdate(jsVO jsvo) {
		sqlSessionTemplate.update("js.contactUpdate",jsvo);
	}

	public void updateContact(jsVO jsvo) {
		sqlSessionTemplate.update("js.updateContact",jsvo);
	}
	
	public void contactDelete(jsVO jsvo) {
		sqlSessionTemplate.update("js.contactDelete",jsvo);
	}
	
	public int contactCount() {
		return sqlSessionTemplate.selectOne("js.contactCount");
	}


	public List<jsVO> getFaqList(jsVO jsvo) {
		return this.sqlSessionTemplate.selectList("js.getFaqList",jsvo);
	}
	
	public List<jsVO> getFaqViewList(jsVO jsvo) {
		return this.sqlSessionTemplate.selectList("js.getFaqViewList",jsvo);
	}


	public void faqUpdate(jsVO jsvo) {
		sqlSessionTemplate.update("js.faqUpdate",jsvo);
	}


	public List<jsVO> getReserveList(jsVO jsvo) {
		return this.sqlSessionTemplate.selectList("js.getReserveList",jsvo);
	}


	public void reserveUpdate(jsVO jsvo) {
		sqlSessionTemplate.update("js.reserveUpdate",jsvo);
	}


	public int getNoticeCount() {
		return sqlSessionTemplate.selectOne("js.getNoticeCount");
	}


	public int getGelleryCount() {
		return sqlSessionTemplate.selectOne("js.getGelleryCount");
	}


	public int getUserCount() {
		return sqlSessionTemplate.selectOne("js.getUserCount");
	}


	public int getFaqCount() {
		return sqlSessionTemplate.selectOne("js.getFaqCount");
	}


	public List<jsVO> getRollingList(jsVO jsvo) {
		return this.sqlSessionTemplate.selectList("js.getRollingList",jsvo);
	}


	public void rollingImgInsert(jsVO jsvo) {
		 this.sqlSessionTemplate.insert("js.rollingImgInsert",jsvo);
		
	}


	public jsVO rollingImgModify(int idx) {
		return sqlSessionTemplate.selectOne("js.rollingImgModify",idx);
	}


	public void rollingImgUpdate(jsVO jsvo) {
		sqlSessionTemplate.update("js.rollingImgUpdate",jsvo);
	}


	public String getDeleteFileRollingName(int idx) {
		return sqlSessionTemplate.selectOne("js.getDeleteFileRollingName",idx);
	}


	public String getOriginRollingFileName(int idx) {
		return sqlSessionTemplate.selectOne("js.getOriginRollingFileName",idx);
	}


	public String getSaveFileRollingName(int idx) {
		return sqlSessionTemplate.selectOne("js.getSaveFileRollingName",idx);
	}


	public void rollingDelete(int idx) {
		sqlSessionTemplate.delete("js.rollingDelete",idx);
	}


	public void popupInsert(jsVO jsvo) {
		 this.sqlSessionTemplate.insert("js.popupInsert",jsvo);
	}


	public List<jsVO> getPopupList(jsVO jsvo) {
		return this.sqlSessionTemplate.selectList("js.getPopupList",jsvo);
	}


	public jsVO popupModify(int idx) {
		return sqlSessionTemplate.selectOne("js.popupModify",idx);
	}


	public int getPopupsCount() {
		return sqlSessionTemplate.selectOne("js.getPopupsCount");
	}


	public int getPopupsIdx() {
		return sqlSessionTemplate.selectOne("js.getPopupsIdx");
	}


	public void popupUpdate(jsVO jsvo) {
		sqlSessionTemplate.update("js.popupUpdate",jsvo);
	}


	public void popupDelete(int idx) {
		sqlSessionTemplate.delete("js.popupDelete",idx);	
	}


	/* 설문조사 결과 가지고 오기 */
	public List<surveyVO> getSurvey(surveyVO surveyvo) {
		return  this.sqlSessionTemplate.selectList("js.getSurvey",surveyvo);
	}


	public surveyVO getSurveyDetail(int idx) {
		return  this.sqlSessionTemplate.selectOne("js.getSurveyDetail",idx);
	}


	public int countSurvey() {
		return  this.sqlSessionTemplate.selectOne("js.countSurvey");
	}


	public String getMaxvisitDate() {
		return this.sqlSessionTemplate.selectOne("js.getMaxvisitDate");
	}

	public void updateHit(String dbDate) {
		 this.sqlSessionTemplate.update("js.updateHit",dbDate);
	}
	public void insertHit(String now) {
		this.sqlSessionTemplate.insert("js.insertHit",now);
	}


	public int getVisitCount(String now) {
		return this.sqlSessionTemplate.selectOne("js.getVisitCount",now);
	}


	public int getVisitTotalCount() {
		return this.sqlSessionTemplate.selectOne("js.getVisitTotalCount");
	}


	public List<jsVO> getGraph() {
		return this.sqlSessionTemplate.selectList("js.getGraph");
	}


	public void testInsert(jsVO jsvo) {
		this.sqlSessionTemplate.insert("js.testInsert",jsvo);
	}


	public int getAlbumCount() {
		return this.sqlSessionTemplate.selectOne("js.getAlbumCount");
	}


	public int getAlbumIdx() {
		return this.sqlSessionTemplate.selectOne("js.getAlbumIdx");
	}


	public List<jsVO> getAchive(jsVO jsvo) {
		return this.sqlSessionTemplate.selectList("js.getAchive",jsvo);
	}


	public jsVO imgModify(int idx) {
		return this.sqlSessionTemplate.selectOne("js.imgModify",idx);
	}


	public void imgUpdate(jsVO jsvo) {
		this.sqlSessionTemplate.update("js.imgUpdate",jsvo);
	}


	public void imgDelete(int idx) {
		this.sqlSessionTemplate.update("js.imgDelete",idx);
	}


	public jsVO getAchiveDetail(jsVO jsvo) {
		return this.sqlSessionTemplate.selectOne("js.getAchiveDetail",jsvo);
	}


	public String getNext(int idx) {
		return this.sqlSessionTemplate.selectOne("js.getNext",idx);
	}


	public String getPrev(int idx) {
		return this.sqlSessionTemplate.selectOne("js.getPrev",idx);
	}


}
