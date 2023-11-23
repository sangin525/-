package kr.co.project.member.service;

import kr.co.project.member.model.dto.MemberDTO;

public interface MemberService {
	// 회원가입
	public int memberEnroll(MemberDTO memberDTO);

	// 아이디 중복 검사
	public boolean duplicateId(String id);

	// 이메일 중복 검사
	public boolean duplicateEmail(String eamil);

}
