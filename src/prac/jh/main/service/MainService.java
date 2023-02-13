package prac.jh.main.service;

import java.sql.Connection;

import static prac.jh.common.JDBCTemplate.*;
import prac.jh.main.dao.MainDAO;
import prac.jh.member.vo.Member;

public class MainService {
	
	private MainDAO dao = new MainDAO();
	
	public int idDupCheck(String memberId) throws Exception {
		// TODO Auto-generated method stub
		
		Connection conn = getConnection();
		
		int result = dao.idDupCheck(conn,memberId);
		
		close(conn);
		
		return result;
	}

	public int signUp(Member member) throws Exception {
		// TODO Auto-generated method stub
		
		Connection conn = getConnection();
		
		int result = dao.signUp(conn, member);
		
		
		return result;
	}

	public Member login(String memberId, String memberPw) throws Exception{
		// TODO Auto-generated method stub
		
		Connection conn = getConnection();
		
		Member loginMember = dao.login(conn, memberId, memberPw);
		
		close(conn);
		
		
		return loginMember;
	}

}
