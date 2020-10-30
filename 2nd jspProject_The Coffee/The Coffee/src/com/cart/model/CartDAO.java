package com.cart.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;


public class CartDAO {
	//��񿬰�
	private static CartDAO instance = new CartDAO();
	public static CartDAO getInstance() {
		return instance;
	}
	private Connection getConnection() throws Exception{
		Context initCtx = new InitialContext();
		Context envCtx = (Context) initCtx.lookup("java:comp/env");
		DataSource ds = (DataSource) envCtx.lookup("jdbc/project");
		return ds.getConnection();
	}
	
	//��ٱ��� �߰�
	public void cartAdd(CartDTO cart) {
		Connection con = null;
		PreparedStatement ps = null;
		
		try {
			con=getConnection();
			String sql = "insert into cart values(cart_seq.nextval,?,?,?,?)";
			ps=con.prepareStatement(sql);
			ps.setString(1, cart.getUserid());
			ps.setString(2, cart.getProduct());
			ps.setInt(3, cart.getCount());
			ps.setString(4, cart.getPtype());
			ps.executeUpdate();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			closeConnection(con, ps);
		}
	}
	
	//��ٱ��� ����Ʈ
	public ArrayList<CartDTO> cartList(String userid){
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		ArrayList<CartDTO> arr = new ArrayList<CartDTO>();
		
		try {
			con=getConnection();
			String sql = "select * from cart where userid='"+userid+"'";
			st=con.createStatement();
			rs=st.executeQuery(sql);
			
			while(rs.next()) {
				CartDTO cart = new CartDTO();
				cart.setCnum(rs.getLong("cnum"));
				cart.setCount(rs.getInt("count"));
				cart.setProduct(rs.getString("product"));
				cart.setUserid(rs.getString("userid"));
				cart.setPtype(rs.getString("ptype"));
				arr.add(cart);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			closeConnection(con, st, rs);
		}
		return arr;
	}
	
	//user ��ٱ���  ����
	public int cartCount(String userid) {
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		int count=0;
		
		try {
			con=getConnection();
			String sql = "select count(*) from cart where userid='"+userid+"'";
			st=con.createStatement();
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
	
	
	//��ٱ��� ����
	public void cartDelete(long cnum) {
		Connection con = null;
		Statement st = null;
		
		try {
			con=getConnection();
			String sql ="delete from cart where cnum="+cnum;
			st=con.createStatement();
			st.execute(sql);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			closeConnection(con, st, null);
		}
	}	
	
	//�ֹ� �Ϸ� �� ��ٱ��� ����
	public void orderToDelete(String userid) {
		Connection con = null;
		Statement st = null;
		
		try {
			con=getConnection();
			String sql = "delete from cart where userid='"+userid+"'";
			st=con.createStatement();
			st.execute(sql);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			closeConnection(con, st, null);
		}
		
	}
	
	//��ٱ��� �ߺ� üũ
	public String cartCheck(String userid, String product) {
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		String flag="yes";//��ٱ��Ͽ� ��ǰ ����
		
		try {
			con=getConnection();
			String sql = "select * from cart where userid='"+userid+"' and product='"+product+"'";
			st=con.createStatement();
			rs=st.executeQuery(sql);
			
			if(rs.next()) {
				flag="no";//��ٱ��Ͽ� ��ǰ ����
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
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
