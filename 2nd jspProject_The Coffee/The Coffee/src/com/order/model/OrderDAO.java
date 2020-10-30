package com.order.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class OrderDAO {
	
	//��񿬰�
	private static OrderDAO instance = new OrderDAO();
	public static OrderDAO getInstance() {
		return instance;
	}
	private Connection getConnection() throws Exception{
		Context initCtx = new InitialContext();
		Context envCtx = (Context) initCtx.lookup("java:comp/env");
		DataSource ds = (DataSource) envCtx.lookup("jdbc/project");
		return ds.getConnection();
	}
	
//	//�ֹ��� ���� �ҷ�����
//	public OrderDTO orderCheck(String userid) {
//		Connection con = null;
//		Statement st = null;
//		ResultSet rs = null;
//		OrderDTO order = new OrderDTO();
//		
//		try {
//			con = getConnection();
//			st = con.createStatement();
//			
//			   /*
//		        * sql���� homeuser ���̺��� userid(�ֹ��ھ��̵�), name(�ֹ��ڸ�), phone(����ó), addr(�ּ�)��
//		 	    * cart ���̺��� product(��ǰ��), count(����)��
//		        * userid�� �������� ���ν����ش�
//		        */
//			
//			String sql = "select homeuser.userid, homeuser.name, homeuser.phone, homeuser.addr, "
//					+ "cart.product, cart.count from homeuser inner join cart "
//					+ "on homeuser.userid=cart.userid "
//					+ "where homeuser.userid='"+userid+"'";			
//			
//			rs=st.executeQuery(sql);
//			
//			while(rs.next()) {
//				order.setUserid(rs.getString("userid"));
//				order.setName(rs.getString("name"));
//				order.setPhone(rs.getString("phone"));
//				order.setAddr(rs.getString("addr"));
//				order.setProduct(rs.getString("product"));
//				order.setCount(rs.getInt("count"));
//			}
//			
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} finally {
//			closeConnection(con, st, rs);
//		}
//		return order;		
//	}
	
	
	//�ֹ���ȣ �ҷ�����
	public int ordernumCheck() {
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		int  ordernum = 0;
		
		try {
			con=getConnection();
			st=con.createStatement();
			String sql = "select nvl(max(ordernum),1)+1 from ordershop";
			rs=st.executeQuery(sql);
			
			if(rs.next()) {
				ordernum = rs.getInt(1) ;
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return ordernum;
	}
	
	//�ֹ� �Է�
	public void orderInsert(OrderDTO order) {
		Connection con = null;
		PreparedStatement ps = null;
		String sql = "";
		
		try {
			con=getConnection();
			
			sql = "insert into ordershop values(ordershop_seq.nextval,?,?,?,?,?,sysdate,?,'�ֹ��Ϸ�',?)";
			ps=con.prepareStatement(sql);
			ps.setString(1, order.getUserid());
			ps.setString(2, order.getName());
			ps.setString(3, order.getPhone());
			ps.setString(4, order.getProduct());
			ps.setInt(5, order.getCount());
			ps.setString(6, order.getAddr());
			ps.setLong(7, order.getOrdernum());
			ps.executeUpdate();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			closeConnection(con, ps);
		}
	}
	
	//���� �ֹ� ����
	public ArrayList<OrderDTO> userOrderList(String userid, int page){
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		ArrayList<OrderDTO> arr = new ArrayList<OrderDTO>();
		
		try {
			con=getConnection();
			
			String sql = "select * from ("
						+ "select rownum num, n.* from ("
						+ "select ordernum, orderdate, count(*) count, orderstate from ordershop where userid='"+userid+"' "
						+ "group by ordernum, orderdate, orderstate order by ordernum desc) n) where num between ? and ?";
			
			ps=con.prepareStatement(sql);
			ps.setInt(1, 1+(page-1)*10);
			ps.setInt(2, page*10);
			rs=ps.executeQuery();
			
			while(rs.next()) {
				OrderDTO order = new OrderDTO();
				order.setOrdernum(rs.getLong("ordernum"));
				order.setOrderDate(rs.getString("orderdate"));
				order.setCount(rs.getInt("count"));
				order.setOrderState(rs.getString("orderstate"));
				arr.add(order);
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			closeConnection(con, ps, rs);
		}
		return arr;
	}	
		
	
	//������ �ֹ� ��ü����
	public ArrayList<OrderDTO> adminOrderList(String field, String query, int page){
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		ArrayList<OrderDTO> arr = new ArrayList<OrderDTO>();
		String sql="";
		
		try {
			con=getConnection();
			
			if(query.equals("")) {//�˻�����
				sql="select * from (" + 
						"select rownum num, n.* " + 
						"from (  select name, userid, ordernum, orderdate, count(*) count from ordershop "
						+ "group by name, userid, ordernum, orderdate order by ordernum desc) n)" +
						"where num between ? and ?";
			}else {
				sql="select * from (" + 
						"select rownum num, n.* " + 
						"from (select name, userid, ordernum, orderdate, count(*) count from ordershop "
						+"where "+field+" like '%"+ query+"%' group by name, userid, ordernum, orderdate"
						+" order by ordernum desc) n) where num between ? and ?";
			}
			
			ps=con.prepareStatement(sql);
			ps.setInt(1, 1+(page-1)*10);
			ps.setInt(2, page*10);
			rs=ps.executeQuery();
			
			while(rs.next()) {
				OrderDTO order = new OrderDTO();
				order.setCount(rs.getInt("count"));
				order.setName(rs.getString("name"));
				order.setOrdernum(rs.getLong("ordernum"));
				order.setOrderDate(rs.getString("orderdate"));
				order.setUserid(rs.getString("userid"));
				arr.add(order);
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			closeConnection(con, ps, rs);
		}
		return arr;
	}	
	
	//�ֹ��� ���� �󼼺���
	public OrderDTO orderViewInfo(Long ordernum) {
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		OrderDTO order = null;
		
		try {
			con=getConnection();
			String sql = "select * from ordershop where ordernum="+ordernum;
			st=con.createStatement();
			rs=st.executeQuery(sql);
			
			if(rs.next()) {
				order = new OrderDTO();
				order.setAddr(rs.getString("addr"));
				order.setName(rs.getString("name"));
				order.setPhone(rs.getString("phone"));
				order.setUserid(rs.getString("userid"));
				order.setOrdernum(rs.getLong("ordernum"));
				order.setOrderDate(rs.getString("orderdate"));
				order.setOrderState(rs.getString("orderstate"));
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			closeConnection(con,st,rs);
		}
		return order;
		
	}
	
	
	//���� �ֹ� ����Ʈ �󼼺���
	public ArrayList<OrderDTO> orderView(Long ordernum) {
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		ArrayList<OrderDTO> arr =new ArrayList<OrderDTO>();
		
		
		try {
			con=getConnection();
			st=con.createStatement();
			String sql="select * from ordershop where ordernum="+ordernum;
			rs=st.executeQuery(sql);
			
				while(rs.next()) {
					OrderDTO order = new OrderDTO();
					order.setCount(rs.getInt("count"));
					order.setOrderState(rs.getString("orderstate"));
					order.setProduct(rs.getString("product"));
					order.setOrdernum(rs.getLong("ordernum"));
					arr.add(order);
				}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			closeConnection(con, st, rs);
		}		
		return arr;
		
	}
	
	
	//�ֹ� ���� �����ϱ�
	public void orderUpdate(OrderDTO order) {
		Connection con = null;
		PreparedStatement ps = null;
		
		try {
			con=getConnection();
			String sql = "update ordershop set name=?, phone=?, addr=?, orderstate=? where ordernum=?";
			ps=con.prepareStatement(sql);
			ps.setString(1, order.getName());
			ps.setString(2, order.getPhone());
			ps.setString(3, order.getAddr());
			ps.setString(4, order.getOrderState());
			ps.setLong(5, order.getOrdernum());
			ps.executeUpdate();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			closeConnection(con, ps);
		}
	}
	
	
	//�ֹ� �����ϱ�
	public void orderDelete(long ordernum) {
		Connection con = null;
		Statement st = null;
		
		try {
			con=getConnection();
			String sql = "delete from ordershop where ordernum="+ordernum;
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
