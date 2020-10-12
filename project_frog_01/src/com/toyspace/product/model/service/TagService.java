package com.toyspace.product.model.service;

import static com.toyspace.common.JDBCTemplate.*;

import java.sql.Connection;
import java.util.TreeSet;

import com.toyspace.product.model.dao.TagDao;
import com.toyspace.product.model.vo.Tags;

public class TagService {
	
	private TagDao dao=new TagDao();

//	태그 생성
	public int insertTag(Tags t) {
		Connection conn=getConnection();
		int result=dao.insertTag(conn,t);
		if(result>0) commit(conn);
		else rollback(conn);
		close(conn);
		return result;
		
	}
//	모든 태그 불러오는 메소드. 범용 가능
	public TreeSet<Tags> loadAllTags(){
		Connection conn = getConnection();
		TreeSet<Tags> tagsList = dao.loadAllTags(conn);
		close(conn);
		return tagsList;
	}

// 태그 삭제
	public int deleteTag(String tagName) {
		Connection conn=getConnection();
		int result=dao.deleteTag(conn,tagName);
		if(result>0) commit(conn);
		else rollback(conn);
		close(conn);
		
		return result;
	}
//키워드로 태그 찾기
	public TreeSet<Tags> searchTagList(String keyword) {
		Connection conn=getConnection();
		TreeSet<Tags> tagsList =dao.searchTagList(conn,keyword);
		close(conn);
		return tagsList;
	}
//태그수정
	public int editTag(Tags t) {
		Connection conn=getConnection();
		int result=dao.editTag(conn,t);
		if(result>0) commit(conn);
		else rollback(conn);
		close(conn);
		return result;
	}
//상품의 태그 가져오기
	public TreeSet<Tags> itemTags(String productId) {
		Connection conn=getConnection();
		TreeSet<Tags> tagsList =dao.itemTags(conn,productId);
		close(conn);
		return tagsList;
	}
}
