package com.member.model;

import java.util.ArrayList;

public interface MemberDAO {

	//ȸ������ �߰�
	public void memberJoin(MemberDTO member);
	
	//ȸ�� ��ü����
	public ArrayList<MemberDTO> memberList(String field, String word, int startRow, int endRow);
	
	//ȸ�� �󼼺���
	public MemberDTO memberView(int num);
	
	//���� �����ϱ�
	public void memberUpdate(MemberDTO member);
	
	//ȸ�� �����ϱ�
	public int memberDelete(int num);
	
	//��ü ȸ����
	public int memberCount(String field, String word);
}
