package com.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JOptionPane;

public class FriendDAOImpl implements FriendDAO{
	
	String url,user,pwd;
	
	//생성자 -> DB연결
	public FriendDAOImpl() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			url = "jdbc:oracle:thin:@localhost:1521:xe";
			user = "scott";
			pwd = "1234";
			
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	@Override //친구등록
	public void friendInsert(Friend f) { 
		// TODO Auto-generated method stub
		Connection con = null;
		PreparedStatement ps = null;
		
		try {
			con = DriverManager.getConnection(url,user,pwd);
			String sql = "insert into friend values(friend_seq.nextval,?,?,?,?)";
			ps = con.prepareStatement(sql);
			
			ps.setString(1,f.getName());
			ps.setString(2, f.getBirth());
			ps.setString(3, f.getPhone());
			ps.setString(4, f.getAddr());
			ps.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			closeConnection(con, ps);
		}
		
	}


	@Override  //전체보기
	public ArrayList<Friend> friendView() {
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		ArrayList<Friend> arr = new ArrayList<Friend>();
		
		try {
			con = DriverManager.getConnection(url,user,pwd);
			String sql = "select * from friend order by num";
			st = con.createStatement();
			rs = st.executeQuery(sql);
			
			while(rs.next()) {
				Friend f = new Friend();
				f.setNum(Integer.parseInt(rs.getString("num")));
				f.setName(rs.getString("name"));
				f.setBirth(rs.getString("birth"));
				f.setPhone(rs.getString("phone"));
				f.setAddr(rs.getString("addr"));
				arr.add(f);
			}
			
			
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			closeStatement(con, st, rs);
		}
		return arr;
	}

	

	@Override //상세보기
	public Friend friendDetail(int num) {
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		Friend f = null;
		
		try {
			String sql = "select * from friend where num =" + num;
			con = DriverManager.getConnection(url,user,pwd);
			st = con.createStatement();
			rs = st.executeQuery(sql);
			
			if(rs.next()) {
				f = new Friend();
				f.setName(rs.getString("name"));
				f.setBirth(rs.getString("birth"));
				f.setPhone(rs.getString("phone"));
				f.setAddr(rs.getString("addr"));
				f.setNum(rs.getInt("num"));
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			closeStatement(con, st, rs);
		}
		return f;
	}
	

	@Override //수정하기
	public void friendUpdate(Friend f) {
		Connection con = null;
		PreparedStatement ps = null;
		
		try {
			String sql = "update friend set name =?, birth = ?, phone =?, addr = ? where num=?";
			con = DriverManager.getConnection(url,user, pwd);
			ps = con.prepareStatement(sql);
			
			ps.setString(1, f.getName());
			ps.setString(2, f.getBirth());
			ps.setString(3, f.getPhone());
			ps.setString(4, f.getAddr());
			ps.setInt(5, f.getNum());
			ps.executeUpdate();	
			
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			closeConnection(con, ps);
		}
		
	}

	@Override //삭제하기
	public void friendDelete(int num) {
		Connection con = null;
		Statement st = null;
		
		try {
			con = DriverManager.getConnection(url,user,pwd);
			String sql = "Delete from friend where num="+num;
			st = con.createStatement();
			st.executeQuery(sql);			
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			closeStatement(con, st, null);
		}
		
	}

	@Override //검색하기
	public ArrayList<Friend> friendSearch(String key, String word) {
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		ArrayList<Friend> arr = new ArrayList<Friend>();
		
		try {
			con = DriverManager.getConnection(url,user,pwd);
			st = con.createStatement();
			String sql = "select * from friend where " + key + " like '%" + word + "%'";  
			rs = st.executeQuery(sql);
			
			while(rs.next()) {
				Friend f = new Friend();
				f.setNum(rs.getInt("num"));
				f.setName(rs.getString("name"));
				f.setPhone(rs.getString("phone"));
				f.setAddr(rs.getString("addr"));
				f.setBirth(rs.getString("birth"));
				arr.add(f);
			}
			
			
		}catch(SQLException e) {
			e.printStackTrace();
			
		}finally {
			closeStatement(con, st, rs);
		}
		
		return arr;
		
	}
	
	private void closeConnection(Connection con, PreparedStatement ps) {
		try {
			if(con!=null) con.close();
			if(ps!=null) ps.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	private void closeStatement(Connection con, Statement st, ResultSet rs) {
		try {
			if(con!=null) con.close();
			if(st!=null) st.close();
			if(rs!=null) rs.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		
	}

}
