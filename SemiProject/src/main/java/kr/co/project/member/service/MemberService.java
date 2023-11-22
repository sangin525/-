package kr.co.project.member.service;

import kr.co.project.member.dto.MemberDTO;

public interface MemberService {
	
	// 로그인
	public MemberDTO memberSignin(String id, String pwd);
	
	// 회원 정보 수정
	public int memberUpdate(MemberDTO member, String beforeEmail);
	
	// 비밀번호 수정
	public int pwdUpdate(MemberDTO member);

	// 회원탈퇴 비밀번호 일치 확인
	public MemberDTO selectPwd(String pwd);
	
	// 회원 탈퇴
	public int memberDelete(String id);
}
