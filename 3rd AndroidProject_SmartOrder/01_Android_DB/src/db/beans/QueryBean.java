package db.beans;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class QueryBean {
	
	Connection conn;
	Statement stmt;
	ResultSet rs;
	
	public QueryBean() {
		conn = null;
		stmt = null;
		rs = null;
	}
	
	public void getConnection() {
		try {
			conn = DBConnection.getConnection();
		}catch(Exception e1) {
			e1.printStackTrace();
		}
		
		try {
			stmt = conn.createStatement();
		}catch(Exception e2) {
			e2.printStackTrace();
		}		
	}
	
	public void closeConnection() { //연결 끊기
		if(stmt!=null) {
			try {
				stmt.close();
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
		
		if(conn!=null) {
			try {
				conn.close();
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	//가게 리스트
	public ArrayList shopList(String strShop) throws Exception {
		
		StringBuffer sb = new StringBuffer();
		sb.append("SELECT ");
		sb.append("NUM, NAME, TEL, ADDR, FILENAME ");
		sb.append("FROM ");
		sb.append("SHOP ");
		sb.append("WHERE ");
		sb.append("NAME like '%"+strShop+"%' ");
		
		rs = stmt.executeQuery(sb.toString());
		
		ArrayList res = new ArrayList();
		
		while(rs.next()) {
			res.add(rs.getInt("num"));
			res.add(rs.getString("name"));
			res.add(rs.getString("tel"));
			res.add(rs.getString("addr"));
			res.add(rs.getString("filename"));
		}
		System.out.println(sb.toString());
		
		return res;		
	}
	
	//메뉴 리스트
	public ArrayList menuList(String strType) throws Exception {
		
		StringBuffer sb = new StringBuffer();
		sb.append("SELECT ");
		sb.append("MENU, TYPE, COST, PICTURE ");
		sb.append("FROM ");
		sb.append("MENU ");
		sb.append("WHERE ");
		sb.append("TYPE='"+strType+"' ");
		
		rs = stmt.executeQuery(sb.toString());
		
		ArrayList res = new ArrayList();
		
		while(rs.next()) {
			res.add(rs.getString(1));
			res.add(rs.getString(2));
			res.add(rs.getString(3));
			res.add(rs.getString(4));
		}
		System.out.println(sb.toString());
		
		return res;
		
	}
	
	//메뉴 상세보기
	public ArrayList menuView(String strMenu) throws Exception{
		
		StringBuffer sb = new StringBuffer();
		sb.append("SELECT ");
		sb.append("MENU, TYPE, COST, PICTURE ");
		sb.append("FROM ");
		sb.append("MENU ");
		sb.append("WHERE ");
		sb.append("MENU LIKE '%"+strMenu+"%' ");
		
		rs= stmt.executeQuery(sb.toString());
		
		ArrayList res = new ArrayList();
		
		if(rs.next()) {
			res.add(rs.getString(1));
			res.add(rs.getString(2));
			res.add(rs.getString(3));
			res.add(rs.getString(4));
		}
		System.out.println(sb.toString());
		
		return res;		
	}

	
	//주문번호 불러오기
	public int getOrderNum() throws Exception{
		int ordernum=0;
		StringBuffer sb = new StringBuffer();
		sb.append("SELECT ");
		sb.append("ORDERNUM.NEXTVAL ");
		sb.append("SEQ_NUM ");
		sb.append("FROM dual");
		
			System.out.println(sb.toString());
		
		try {
			rs = stmt.executeQuery(sb.toString());
			
			if(rs.next()) {
				ordernum=rs.getInt(1);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}		
		return ordernum;		
	}
	
	//장바구니 추가
	public int addCart(String shop, String ordernum, String type, String menu, String cost, String count, String total, String temp ) {
		int result=0;
		
		StringBuffer sb = new StringBuffer();
		PreparedStatement pstmt = null;
		
		sb.append("INSERT INTO ");
		sb.append("CART ");
		sb.append("VALUES ");
		sb.append("(seq_cart.nextval, '"+shop+"', '"+ordernum+"', '"+type+"', '"+menu+"', '"+cost+"', '"+count+"', '"+total+"', sysdate, '"+temp+"')");
	
		System.out.println(sb.toString());
		
		try {
			pstmt=conn.prepareStatement(sb.toString());
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				if(pstmt!=null) {
					pstmt.close();
				}
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		return result;
	}
	
	//장바구니 리스트
	public ArrayList cartList(String strOnum) throws Exception {
		
		StringBuffer sb = new StringBuffer();
		sb.append("SELECT ");
		sb.append("NUM, SHOP, ORDERNUM, TYPE, MENU, COUNT, TOTAL, TEMP ");
		sb.append("FROM ");
		sb.append("CART ");
		sb.append("WHERE ");
		sb.append("ORDERNUM like '%"+strOnum+"%'");
		
		rs = stmt.executeQuery(sb.toString());
		
		ArrayList res = new ArrayList();
		
		while(rs.next()) {
			res.add(rs.getInt("num"));
			res.add(rs.getString("shop"));
			res.add(rs.getString("ordernum"));
			res.add(rs.getString("type"));
			res.add(rs.getString("menu"));
			res.add(rs.getInt("count"));
			res.add(rs.getInt("total"));
			res.add(rs.getString("temp"));
		}
		System.out.println(sb.toString());
		
		return res;		
	}
	
	//가격 총합
	public int getSum(String strOnum) throws Exception{
		int sum=0;
		
		StringBuffer sb = new StringBuffer();
		sb.append("SELECT SUM(TOTAL) ");
		sb.append("FROM CART");
		sb.append("WHERE ORDERNUM='"+strOnum+"'");
		
		String sql = "SELECT SUM(TOTAL) FROM CART WHERE ORDERNUM='"+strOnum+"'";
		
		try {
			rs = stmt.executeQuery(sql);
			
			if(rs.next()) {
				sum=rs.getInt(1);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}		
		
		return sum;
	}
	
	
	

	
	//장바구니 삭제
	public int deleteCart( int num) throws Exception{
		int result=0;
		//System.out.println("strONum:"+strONum);
		System.out.println("num:"+num);
		PreparedStatement pstmt = null;
		
		StringBuffer sb = new StringBuffer();
		
		sb.append("DELETE ");
		sb.append("FROM ");
		sb.append("CART ");
		sb.append("WHERE ");
		sb.append("NUM=?");
		
		System.out.println(sb.toString());
		
		try {
			pstmt=conn.prepareStatement(sb.toString());
			pstmt.clearParameters();
			//pstmt.setString(1, strONum);
			pstmt.setInt(1,  num);

			result = pstmt.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(pstmt!=null) {
					pstmt.close();
				}
			}catch(Exception e) {
				e.printStackTrace();
			}
		}		
		return result;
	}
	

}
