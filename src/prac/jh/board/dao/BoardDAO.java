package prac.jh.board.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import prac.jh.board.vo.Board;

import static prac.jh.common.JDBCTemplate.*;

public class BoardDAO {
	
	private Statement stmt = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;
	
	private Properties prop = null;
	
	public List<Board> selectAllBoard(Connection conn) throws Exception {
		// TODO Auto-generated method stub
		
		List<Board> boardList = new ArrayList<Board>();
		
		try {
			String sql = prop.getProperty("selectAllBoard");
			
			stmt = conn.createStatement();
			
			rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				int boardNo = rs.getInt("BOARD_NO");
				String boardTitle = rs.getString("BOARD_TITLE");
				String memberName = rs.getString("MEMBER_NM");
				int readCount = rs.getInt("READ_COUNT");
				String createDate = rs.getString("CREATE_DT");
				int commentCount = rs.getInt("COMMENT_COUNT");
				
				Board board = new Board();
				board.setBoardNo(boardNo);
				board.setBoardTitle(boardTitle);
				board.setMemberName(memberName);
				board.setReadCount(readCount);
				board.setCreateDate(createDate);
				board.setCommentCount(commentCount);
				
				boardList.add(board);
			}
			
		} finally {
			close(rs);
			close(stmt);
		}
		
		return boardList;
	}

	public Board selectBoard(Connection conn, int boardNo, int memberNo) {
		// TODO Auto-generated method stub
		return null;
	}

}
