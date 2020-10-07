package com.toyspace.product.model.service;

import static com.toyspace.common.JDBCTemplate.getConnection;
import static com.toyspace.common.JDBCTemplate.rollback;

import java.sql.Connection;

import static com.toyspace.common.JDBCTemplate.close;
import static com.toyspace.common.JDBCTemplate.commit;

import com.toyspace.product.model.dao.TagDao;
import com.toyspace.product.model.vo.Tags;

public class TagService {
	
	private TagDao dao=new TagDao();

	public int insertTag(Tags t) {
		Connection conn=getConnection();
		int result=dao.insertTag(conn,t);
		if(result>0) commit(conn);
		else rollback(conn);
		close(conn);
		return result;
		
	}

}
