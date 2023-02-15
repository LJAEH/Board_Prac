package prac.jh.board.view;

import java.util.List;
import java.util.Scanner;

import prac.jh.board.service.BoardService;
import prac.jh.board.service.CommentService;
import prac.jh.board.vo.Board;
import prac.jh.main.view.MainView;

public class BoardView {
	
	private Scanner sc = new Scanner(System.in);
	
	private BoardService bs = new BoardService();
	
	private CommentService cs = new CommentService();
	
	
	public void boardMenu() {
		// TODO Auto-generated method stub
		
		int input = -40;
		
		do {
			try {
				System.out.println("게시판");
				System.out.println("1. 게시글 목록 조회");
				System.out.println("2. 게시글 상세 조회(+ 댓글 기능)");
				System.out.println("3. 게시글 작성");
				System.out.println("4. 게시글 검색");
				System.out.println("0. 로그인 메뉴로 이동");
				System.out.print("메뉴 입력 : ");
				input = sc.nextInt();
				
				switch(input) {
				case 1 : selectAllBoard(); break;
				case 2 : selectBoard(); break;
				case 3 : insertBoard(); break;
				case 4 : searchBoard(); break;
				case 0 : System.out.println("메뉴이동"); break;
				default : System.out.println("제대로 입력해주세용");
				}
			} catch(Exception e) {
				e.printStackTrace();
			}
		} while (input != 0);
	
	}

	private void selectAllBoard() {
		// TODO Auto-generated method stub
		System.out.println("게시글 목록 조회");
		
		try {
			List<Board> boardList = bs.selectAllBoard();
			
			if(boardList.isEmpty()) {
				System.out.println("게시글이읍서용");
			} else {
				for ( Board b : boardList ) {
					System.out.printf("%d | %s[%d] | %s | %s | %d\n",
							b.getBoardNo(),
							b.getBoardTitle(),
							b.getCommentCount(),
							b.getMemberName(),
							b.getCreateDate(),
							b.getReadCount()
							);
				}
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	private void selectBoard() {
		// TODO Auto-generated method stub
		
		System.out.println("게시글 검색");
		try {
			System.out.print("게시글 번호 : ");
			int boardNo = sc.nextInt();
			sc.nextLine();
			
			Board board = bs.selectBoard(boardNo, MainView.loginMember.getMemberNo());

		} catch (Exception e) {
			e.printStackTrace();
		}
	}



	private void insertBoard() {
		// TODO Auto-generated method stub
		
	}



	private void searchBoard() {
		// TODO Auto-generated method stub
		
	}

}
