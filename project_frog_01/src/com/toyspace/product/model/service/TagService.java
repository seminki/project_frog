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
}
