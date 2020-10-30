package com.member.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class MemberDAOImpl{
	
	//��񿬰�
	private static MemberDAOImpl instance = new MemberDAOImpl();
	public static MemberDAOImpl getInstance() {
		return instance;
	}
	private Connection getConnection() throws Exception{
		Context initCtx = new InitialContext();
		Context envCtx = (Context) initCtx.lookup("java:comp/env");
		DataSource ds = (DataSource) envCtx.lookup("jdbc/project");
		return ds.getConnection();
	}
	

	//ȸ������
	public void memberJoin(MemberDTO member) {
		Connection con = null;
		PreparedStatement ps = null;
		
		try {
			con=getConnection();
			String sql = "insert into homeuser(unum,userid, pwd, name, birth, addr, phone, email, signupdate) values(homeuser_seq.nextval,?,?,?,?,?,?,?,sysdate)";
			ps=con.prepareStatement(sql);
			ps.setString(1, member.getUserid());
			ps.setString(2, member.getPwd());
			ps.setString(3, member.getName());
			ps.setString(4, member.getBirth());
			ps.setString(5, member.getAddr());
			ps.setString(6, member.getPhone());
			ps.setString(7, member.getEmail());
			ps.executeUpdate();			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			closeConnection(con, ps);
		}
		
		
	}

	//ȸ�� ��ü����
	public ArrayList<MemberDTO> memberList(String field, String word, int startRow, int endRow) {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		ArrayList<MemberDTO> arr = new ArrayList<>();
		StringBuilder sb = new StringBuilder();
		try {
			con = getConnection();
			if(word.equals("")) {
				sb.append("select * from");
				sb.append(" (select aa.*,rownum rn from");
				sb.append(" (select * from homeuser order by unum desc)aa");
				sb.append(" where rownum<=?) where rn >=?");
				
				
			}else {//�˻�����
				sb.append("select * from");
				sb.append(" (select aa.*,rownum rn from");
				sb.append(" (select * from homeuser where "+field +" like '%"+word+"%'");
				sb.append(" order by unum desc)aa");
				sb.append(" where rownum<=?) where rn >=?");	
			}
			ps = con.prepareStatement(sb.toString());
			ps.setInt(1, endRow);
			ps.setInt(2, startRow);
		
			rs = ps.executeQuery();
			while(rs.next()) {
				MemberDTO member = new MemberDTO();
				member.setUserid(rs.getString("userid"));
				member.setName(rs.getString("name"));
				member.setBirth(rs.getString("birth"));
				member.setAddr(rs.getString("addr"));
				member.setPhone(rs.getString("phone"));
				member.setEmail(rs.getString("email"));
				member.setSignupdate(rs.getString("signupdate"));
				arr.add(member);
				
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			closeConnection(con, ps, rs);
		}
		
		return arr;
	}

	//ȸ�� �󼼺���
	public MemberDTO memberView(String userid) {
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		MemberDTO member = null;
		
		try {
			con=getConnection();
			st = con.createStatement();
			String sql = "select * from homeuser where userid='"+userid+"'";
			rs=st.executeQuery(sql);
			
			if(rs.next()) {
				member=new MemberDTO();
				member.setName(rs.getString("name"));
				member.setPwd(rs.getString("pwd"));
				member.setUserid(rs.getString("userid"));
				member.setBirth(rs.getString("birth"));
				member.setAddr(rs.getString("addr"));
				member.setPhone(rs.getString("phone"));
				member.setEmail(rs.getString("email"));
				
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return member;
	}

	//ȸ������ �����ϱ�
	public void memberUpdate(MemberDTO member) {
		Connection con = null;
		PreparedStatement ps = null;
		
		try {
			con=getConnection();
			String sql = "update homeuser set pwd=?, name=?, birth=?, addr=?, phone=?, email=? where userid=?";
			ps=con.prepareStatement(sql);
			ps.setString(1, member.getPwd());
			ps.setString(2, member.getName());
			ps.setString(3, member.getBirth());
			ps.setString(4, member.getAddr());
			ps.setString(5, member.getPhone());
			ps.setString(6, member.getEmail());
			ps.setString(7, member.getUserid());
			ps.executeUpdate();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			closeConnection(con, ps);
		}
		
		
		
	}

	//Ż���ϱ�, �����ϱ�
	public void memberDelete(String userid) {
		Connection con = null;
		Statement st = null;
		
		try {
			con=getConnection();
			String sql = "delete from homeuser where userid='"+userid+"'";
		//	System.out.println(sql);
			st=con.createStatement();
			st.execute(sql);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			closeConnection(con, st, null);
		}
	}

	//ȸ�� ��
	public int memberCount(String field, String word) {
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		int count = 0;
		String sql = "";
		
		try {
			con=getConnection();
			st = con.createStatement();			
			
			if(word.equals("")) {//�˻�����
				sql = "select count(*) from homeuser";
			}else {
				sql="select count(*) from homeuser where "+field+" like '%"+word+"%'";
			}
			
			rs=st.executeQuery(sql);
			if(rs.next()) {
				count=rs.getInt(1);
			}	
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			closeConnection(con, st, rs);
		}
		
		return count;
	}
	
	//���̵� �ߺ�üũ
	public String idCheck(String userid) {
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		String flag="yes"; //��밡��
		
		try {
			con=getConnection();
			String sql = "select * from homeuser where userid='"+userid+"'";
			st = con.createStatement();
			rs=st.executeQuery(sql);
			
			if(rs.next()) {
				flag = "no"; //���Ұ���	
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			closeConnection(con, st, rs);
		}		
		return flag;
	}
	
	//�α���üũ
	public int loginCheck(String userid, String pwd) {
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		int flag=-1;//ȸ���ƴ�
		
		try {
			con=getConnection();
			String sql = "select * from homeuser where userid='"+userid+"'";
			st=con.createStatement();
			rs=st.executeQuery(sql);
			
			//0�̸� �Ϲ�ȸ��, 1�̸� ������, 2�� ��� ����
			if(rs.next()) {
				if(rs.getString("pwd").equals(pwd)) {//�����ġ
					flag=rs.getInt("admin");
				}else {
					flag = 2;
				}
			}	
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			closeConnection(con, st, rs);
		}
		return flag;
	}
	

	//�ݱ�
	private void closeConnection(Connection con, PreparedStatement ps) {
		try {
			if(ps!=null) ps.close();
			if(con!=null) con.close();
		} catch(SQLException e) {
			e.printStackTrace();
		}
	}
	private void closeConnection(Connection con, Statement st, ResultSet rs) {
		try {
			if(rs!=null) rs.close();
			if(st!=null) st.close();
			if(con!=null) con.close();
		} catch(SQLException e) {
			e.printStackTrace();
		}		
	}	
}
