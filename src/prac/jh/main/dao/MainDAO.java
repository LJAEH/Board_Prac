package prac.jh.main.dao;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;

import prac.jh.member.vo.Member;

import static prac.jh.common.JDBCTemplate.*;

public class MainDAO {
	
	private Statement stmt = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;
	
	private Properties prop = null;
	
	
	public MainDAO() {
		
		try {
			prop = new Properties();
			
			prop.loadFromXML(new FileInputStream("mainQuery.xml"));
			
		}catch (Exception e) {
			e.printStackTrace();
		}
	}

	public int idDupCheck(Connection conn, String memberId) throws Exception{
		// TODO Auto-generated method stub
		
		int result = 0;
		
		
		try {
			String sql = prop.getProperty("idDupCheck");
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, memberId);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				result = rs.getInt(1);
			}
			
		} finally {
			close(rs);
			close(pstmt);	
		}
		
		return result;
	}

	public int signUp(Connection conn, Member member) throws Exception {
		// TODO Auto-generated method stub
		
		int result = 0;
		
		try {
			String sql = prop.getProperty("signUp");
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, member.getMemberId());
			pstmt.setString(2, member.getMemberPw());
			pstmt.setString(3, member.getMemberName());
			pstmt.setString(4, member.getMemberGender());
			
			result = pstmt.executeUpdate();
			
		} finally {
			close(rs);
			close(pstmt);
		}
		return result;
	}

	public Member login(Connection conn, String memberId, String memberPw) throws Exception {
		// TODO Auto-generated method stub
		
		Member loginMember = null;
		
		try {
			
			String sql = prop.getProperty("login");
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, memberId);
			pstmt.setString(2, memberPw);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				loginMember = new Member(rs.getInt("MEMBER_NO"),
						memberId,rs.getString("MEMBER_NM"),
						rs.getString("MEMBER_GENDER"),
						rs.getString("ENROLL_DATE"));
			}
			
		} finally {
			close(rs);
			close(pstmt);
			
		}
		
		
		return loginMember;
	}

}
