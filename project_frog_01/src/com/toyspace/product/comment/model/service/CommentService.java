package com.toyspace.product.comment.model.service;

import static com.toyspace.common.JDBCTemplate.close;
import static com.toyspace.common.JDBCTemplate.commit;
import static com.toyspace.common.JDBCTemplate.getConnection;
import static com.toyspace.common.JDBCTemplate.rollback;

import java.sql.Connection;

import com.toyspace.product.comment.model.dao.CommentDao;
import com.toyspace.product.comment.model.vo.Comment;
public class CommentService {
	
	private CommentDao dao=new CommentDao();

	public int insertComment(Comment c) {
		Connection conn=getConnection();
		int result=dao.insertComment(conn,c);
		if(result==1) commit(conn);
		else rollback(conn);
		close(conn);
		return result;
	}

}
