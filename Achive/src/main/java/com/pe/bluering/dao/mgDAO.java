package com.pe.bluering.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.pe.bluering.vo.adminVO;
import com.pe.bluering.vo.mgVO;

@Repository
public class mgDAO {

	@Autowired
	SqlSessionTemplate sqlSessionTemplate;
	
	public int insert(mgVO mgvo) {
		return this.sqlSessionTemplate.insert("mg.insert",mgvo);
	}

	public List<mgVO> selectList(mgVO mgvo) {
		return this.sqlSessionTemplate.selectList("mg.selectAll",mgvo);
	}

	public mgVO selectDetail(int idx) {
		return sqlSessionTemplate.selectOne("mg.selectDetail",idx);
	}

	public int update(mgVO mgvo) {
		return sqlSessionTemplate.update("mg.update",mgvo);
	}

	public String getDeleteFileName(Integer idx) {
		return sqlSessionTemplate.selectOne("mg.getDeleteFileName",idx);
	}

	public int delete(int idx) {
		return sqlSessionTemplate.delete("mg.delete",idx);
	}

	public String getSaveFileName(Integer idx) {
		return sqlSessionTemplate.selectOne("mg.getSaveFileName",idx);
	}

	public String getOriginFileName(Integer idx) {
		return sqlSessionTemplate.selectOne("mg.getOriginFileName",idx);
	}

	public int count() {
		return  this.sqlSessionTemplate.selectOne("mg.count");
	}

	public int searchCount(String keyword) {
		System.out.println(" dao searchCount실행 :" +keyword);
		return  this.sqlSessionTemplate.selectOne("mg.searchCount",keyword);
	}

	public adminVO login(adminVO adminvo) {
		// TODO Auto-generated method stub
		return  this.sqlSessionTemplate.selectOne("adminLogin.login",adminvo);
	}

	public mgVO print(int idx) {
		return sqlSessionTemplate.selectOne("mg.print",idx);
	}



}
