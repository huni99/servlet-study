package com.gn.service;

import com.gn.dao.MemberDao;
import com.gn.dto.Member;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MemberService {
	private MemberDao dao = new MemberDao();
	public int insertMember(String id , String pw) {
		
		Member param = new Member(id,pw);
		int result = dao.insertMember(param);
		return result;
	}
}
