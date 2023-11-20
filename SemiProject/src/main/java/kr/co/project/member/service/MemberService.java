package kr.co.project.member.service;

import kr.co.project.member.dto.MemberDTO;

public interface MemberService {
	
	// 로그인
	public MemberDTO memberSignin(String id, String pwd);
}
