package prac.jh.board.service;

import java.sql.Connection;
import java.util.List;

import prac.jh.board.dao.BoardDAO;
import prac.jh.board.dao.CommentDAO;
import prac.jh.board.vo.Board;
import static prac.jh.common.JDBCTemplate.*;

public class BoardService {
	
	private BoardDAO dao = new BoardDAO();
	
	private CommentDAO cDao = new CommentDAO();
	
	

	public List<Board> selectAllBoard() throws Exception {
		// TODO Auto-generated method stub
		
		Connection conn = getConnection();
		
		List<Board> boardList = dao.selectAllBoard(conn);
		
		close(conn);
		
		
		return boardList;
	}



	public Board selectBoard(int boardNo, int memberNo) {
		// TODO Auto-generated method stub
		
		Connection conn = getConnection();
		
		Board board = dao.selectBoard(conn, boardNo, memberNo);
		
		close(conn);
		
		
		return board;
	}

}
