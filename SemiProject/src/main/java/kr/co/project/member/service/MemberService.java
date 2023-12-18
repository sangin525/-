package kr.co.project.member.service;

import kr.co.project.member.dto.MemberDTO;

public interface MemberService {
	// 회원가입
	public int memberEnroll(MemberDTO memberDTO);

	// 아이디 중복 검사
	public boolean duplicateId(String id);

	// 이메일 중복 검사
	public boolean duplicateEmail(String eamil);

	// 로그인
	public MemberDTO memberSignin(String id);

	// 회원 정보 수정
	public int memberUpdate(MemberDTO member, String beforeEmail);

	// 비밀번호 수정
	public int pwdUpdate(MemberDTO member);

	// 회원탈퇴 비밀번호 일치 확인
	public MemberDTO selectPwd(String pwd);

	// 회원 탈퇴
	public int memberDelete(String id);

	// 마일리지 조회
	public MemberDTO selectMlg(int no);

	// 아이디 찾기
	public void findId(MemberDTO member);

	// 비밀번호 찾기
	public boolean findPwd(MemberDTO member);

	public void updatePassword(String email, String hashedPassword);

}
