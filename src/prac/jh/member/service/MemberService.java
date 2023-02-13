package prac.jh.member.service;

import java.sql.Connection;
import java.util.List;

import static prac.jh.common.JDBCTemplate.*;
import prac.jh.member.dao.MemberDAO;
import prac.jh.member.vo.Member;

public class MemberService {

	public MemberDAO dao = new MemberDAO();
	
	public List<Member> selectAll() throws Exception {
		// TODO Auto-generated method stub
		
		List<Member> memberList = null;
		
		Connection conn = getConnection();
		
		memberList = dao.selectAll(conn);
		
		
		return memberList;
	}

	public int updateMember(Member member) throws Exception {
		// TODO Auto-generated method stub
		
		Connection conn = getConnection();
		
		int result = dao.updateMember(conn,member);
		
		if(result > 0 ) commit(conn);
		else rollback(conn);

		close(conn);
		
		
		return result;
	}

	public int updatePw(String currentPw, String newPw1, int memberNo) throws Exception {
		// TODO Auto-generated method stub
		
		Connection conn = getConnection();
		
		int result = dao.updatePw(conn, currentPw,newPw1,memberNo);
		
		if(result >0) commit(conn);
		else rollback(conn);
		
		close(conn);
		return result ;
	}

}
