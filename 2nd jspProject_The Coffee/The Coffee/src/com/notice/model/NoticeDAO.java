package com.notice.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.member.model.MemberDTO;

public class NoticeDAO {
	//��񿬰�
	private static NoticeDAO instance = new  NoticeDAO();
	public static  NoticeDAO  getInstance() {
		return instance;
	}
	private Connection getConnection() throws Exception{
		Context initCtx = new InitialContext();
		Context envCtx = (Context) initCtx.lookup("java:comp/env");
		DataSource ds = (DataSource) envCtx.lookup("jdbc/project");
		return ds.getConnection();
	}
	
	//�������� ���
	public void noticeInsert(NoticeDTO notice) {
		Connection con = null;
		PreparedStatement ps = null;
		try {
			con=getConnection();
			String sql = "insert into notice values(notice_seq.nextval,?,?,sysdate,0)";
			ps=con.prepareStatement(sql);
			ps.setString(1, notice.getNsubject());
			ps.setString(2, notice.getNcontent());
			ps.executeUpdate();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			closeConnection(con, ps);
		}		
	}
	
	
	//�������� �� ��
	public int noticeCount(String field, String query) {
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		int count=0;	
		String sql ="";
		
		try {
			con=getConnection();
			st=con.createStatement();
			
			if(query.equals("")) {
				sql="select count(*) from notice";
			}else {
				sql="select count(*) from notice where "+field+" like '%"+query+"%'";
			}			
			rs=st.executeQuery(sql);
			
			if(rs.next()) {
				count=rs.getInt(1);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			closeConnection(con, st, rs);
		}
		return count;
	}

	
	//��ü���� 
	public ArrayList<NoticeDTO> noticeList(String field, String query, int page){
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		ArrayList<NoticeDTO> arr = new ArrayList<>();
		String sql="";
		try {
			con=getConnection();
			
			if(query.equals("")) {//�˻�����
				sql="select * from (" + 
						"select rownum num, n.* " + 
						"from (select * from notice order by nnum desc) n)" +
						"where num between ? and ?";
				
			}else {//�˻�
				sql="select * from (" + 
						"select rownum num, n.* " + 
						"from (select * from notice where "+field+" like '%"+ query+"%'"
						+" order by nnum) n)" + 
						"where num between ? and ?";
			}
				
			ps=con.prepareStatement(sql);
			ps.setInt(1, 1+(page-1)*10);
			ps.setInt(2, page*10);
			rs=ps.executeQuery();
			
			while(rs.next()) {
				NoticeDTO notice = new NoticeDTO();
				notice.setNcontent(rs.getString("ncontent"));
				notice.setNdate(rs.getString("ndate"));
				notice.setNnum(rs.getLong("nnum"));
				notice.setNsubject(rs.getString("nsubject"));
				notice.setNview(rs.getString("nview"));
				arr.add(notice);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			closeConnection(con, ps, rs);
		}		
		return arr;
	}

	
	//�������� �󼼺���
	public NoticeDTO noticeView(long nnum) {
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		NoticeDTO notice = null;
		
		try {
			con=getConnection();
			st = con.createStatement();
			
			//��ȸ�� ����
			st.execute("update notice set nview=nview+1 where nnum="+nnum);
			
			//�󼼺���
			String sql = "select * from notice where nnum='"+nnum+"'";
			rs=st.executeQuery(sql);
			
			if(rs.next()) {
				notice = new NoticeDTO();
				notice.setNcontent(rs.getString("ncontent"));
				notice.setNdate(rs.getString("ndate"));
				notice.setNnum(rs.getLong("nnum"));
				notice.setNsubject(rs.getString("nsubject"));
				notice.setNview(rs.getString("nview"));
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			closeConnection(con, st, rs);
		}
		return notice;
	}
	
	
	//�������� �����ϱ�
	public void noticeUpdate(NoticeDTO notice) {
		Connection con = null;
		PreparedStatement ps = null;
		
		try {
			con=getConnection();
			String sql = "update notice set nsubject=?, ncontent=? where nnum=?";
			ps=con.prepareStatement(sql);
			ps.setString(1, notice.getNsubject());
			ps.setString(2, notice.getNcontent());
			ps.setLong(3, notice.getNnum());

			ps.executeUpdate();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			closeConnection(con, ps);
		}
	}
	
	
	//�������� �����ϱ�
	public void notiecDelete(String nsubject) {
		Connection con = null;
		Statement st = null;

		try {
			con=getConnection();
			String sql = "delete from notice where nsubject='"+nsubject+"'";
			st=con.createStatement();
			st.execute(sql);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			closeConnection(con, st, null);
		}
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
