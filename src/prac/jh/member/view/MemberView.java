package prac.jh.member.view;

import java.util.List;
import java.util.Scanner;

import prac.jh.member.service.MemberService;
import prac.jh.member.vo.Member;

public class MemberView {
	
	private Scanner sc = new Scanner(System.in);
	
	Member loginMember = null;
	
	private MemberService ms = new MemberService();
	
	
	private int input = -10;
	
	public void memberMenu(Member loginMember) {
		// TODO Auto-generated method stub
		
		this.loginMember = loginMember;
		
		do {
			try {
				System.out.println("회원기능");
				System.out.println("1. 내 정보 조회");
				System.out.println("2. 회원 목록 조회(아이디 이름 성별)");
				System.out.println("3. 내 정보 수정(이름 성별)");
				System.out.println("4. 비밀번호 변경(현재비밀번호 입력, 새비번입력)");
				System.out.println("5. 회원 탈퇴");
				
				System.out.println("0. 메인메뉴로 이동");
				System.out.print("메뉴 선택: ");
				input = sc.nextInt();
				sc.nextLine();
				
				switch(input) {
				case 1 : selectMyInfo(); break;
				case 2 : selectAll(); break;
				case 3 : updateMember(); break;
				case 4 : updatePw(); break;
				case 5 : secession(); break;
				case 0 : System.out.println("메인 메뉴로"); break;
				default : System.out.println("다시");
				}
				
			} catch(Exception e) {
				e.printStackTrace();
			}
		}while(input != 0);
	}

	private void selectMyInfo() {
		// TODO Auto-generated method stub
		
		System.out.println("내 정보 조회");
		System.out.println("회원 번호 : " + loginMember.getMemberNo());
		System.out.println("회원 이름 : " + loginMember.getMemberName());
		System.out.print("성별 : ");
		if(loginMember.getMemberGender().equals("M")) {
			System.out.println("남");
		} else {
			System.out.println("여");
		}
		System.out.println("가입일 : " + loginMember.getEnrollDate());
	}

	private void selectAll() {
		// TODO Auto-generated method stub
		
		System.out.println("회원 목록 조회");
		
		try {
			List<Member> memberList = ms.selectAll();
			
			if(memberList.isEmpty()) {
				System.out.println("조회 결과 없음");
			} else {
				System.out.println(" 아이디      이름  성별");
				System.out.println("=======================");
				for(Member member : memberList) {
					System.out.printf("%10s %5s %3s\n", member.getMemberId(),
							member.getMemberName(),member.getMemberGender());
				}
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		
	}

	private void updateMember() {
		// TODO Auto-generated method stub
		try {
			System.out.println("회원 정보를 수정 합니다");
			System.out.print("회원정보 수정: ");
			String memberName = sc.next();
			
			String memberGender = null;
			
			while(true) {
				
				System.out.print("성별수정 ㄷㄷ.. :");
				memberGender = sc.next().toUpperCase();
				
				if(memberGender.equals("M") || memberGender.equals("W")) {
					break;
				} else {
					System.out.println("제대로 입력");
				}
				
				Member member = new Member();
				
				member.setMemberNo(loginMember.getMemberNo());
				member.setMemberName(memberName);
				member.setMemberGender(memberGender);
				
				int result = ms.updateMember(member);
				
				if(result > 0 ) {
					
					loginMember.setMemberName(memberName);
					loginMember.setMemberGender(memberGender);
					
					System.out.println("변경 성공");
				} else {
					System.out.println("변경 실패");
				}
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	private void updatePw() {
		// TODO Auto-generated method stub
		
		System.out.println("비밀번호 변경");
		
		try {
			System.out.print("비밀번호 확인:");
			String currentPw = sc.next();
			
			String newPw1 = null;
			String newPw2 = null;
			
			while(true) {
				System.out.print("변경할 비밀 번호 :");
				newPw1 = sc.next();
				System.out.print("변경할 비밀 번호 확인 :");
				newPw2 = sc.next();
				
				if(newPw1.equals(newPw2)) {
					
					break;
					
				} else {
					System.out.println("비밀번호가 일치 하지 않습니다.");
				}
				
				int result = ms.updatePw(currentPw, newPw1, loginMember.getMemberNo());
			
				if(result > 0 ) {
					System.out.println("비밀번호 변경");
				} else {
					System.out.println("비밀번호 불일치");
				}
			}
			
			
		} catch ( Exception e) {
			e.printStackTrace();
		}
		
	}

	private void secession() {
		// TODO Auto-generated method stub
		
	}

}
