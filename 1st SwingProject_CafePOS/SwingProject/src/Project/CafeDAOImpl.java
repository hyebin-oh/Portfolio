package Project;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class CafeDAOImpl implements CafeDAO{
	
	String url,user,pwd;
	
	//생성자 -> DB연결
		public CafeDAOImpl() {
			try {
				Class.forName("oracle.jdbc.driver.OracleDriver");
				url = "jdbc:oracle:thin:@localhost:1521:xe";
				user = "scott";
				pwd = "1234";
				
			}catch(ClassNotFoundException e) {
				e.printStackTrace();
			}
		}
	

	


	@Override//카드결제 버튼
	public void OrderCard(Cafe f) {
		Connection con = null;
		PreparedStatement ps = null;
		
		try {
			con = DriverManager.getConnection(url,user,pwd);
			//sql 순서 : 넘버, 타임, 메뉴, 온도, 가격, 지불방법
			String sql = "insert into cafe values(cafe_sq.nextval,?,?,?,?,?)";
			ps = con.prepareStatement(sql);
			
			ps.setString(1, f.getTime());
			ps.setString(2, f.getMenu());
			ps.setString(3, f.getTemperture());
			ps.setInt(4, f.getPrice());
			ps.setString(5, f.getPay());
			
			ps.executeUpdate();
			
		}catch(SQLException e) {
			e.printStackTrace();
			
		}finally {
			closeConnection(con, ps);
		}
		
	}

	@Override //현금결제 버튼
	public void OrderCash(Cafe f) {
		Connection con = null;
		PreparedStatement ps = null;
		
		try {
			con = DriverManager.getConnection(url,user,pwd);
			//sql 순서 : 넘버, 타임, 메뉴, 온도, 가격, 지불방법
			String sql = "insert into cafe values(cafe_sq.nextval,?,?,?,?,?)";
			ps = con.prepareStatement(sql);
			
			ps.setString(1, f.getTime());
			ps.setString(2, f.getMenu());
			ps.setString(3, f.getTemperture());
			ps.setInt(4, f.getPrice());
			ps.setString(5, f.getPay());
			
			ps.executeUpdate();
			
		}catch(SQLException e) {
			e.printStackTrace();
			
		}finally {
			closeConnection(con, ps);
		}
		
	}

	@Override//오늘 판매량 버튼
	public ArrayList<Cafe> SellList() {
	
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		ArrayList<Cafe> ca = new ArrayList<Cafe>();
		
		try {
			con = DriverManager.getConnection(url, user, pwd);
			
			String sql = "select * from cafe";
			st = con.createStatement();
			rs = st.executeQuery(sql);
			
			while(rs.next()) {
				Cafe f = new Cafe();
				f.setNum(Integer.parseInt(rs.getString(1)));
				f.setTime(rs.getString(2));
				f.setMenu(rs.getString(3));
				f.setTemperture(rs.getString(4));
				f.setPrice(Integer.parseInt(rs.getString(5)));
				f.setPay(rs.getString(6));
				ca.add(f);
			}
		
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			closeStatement(con, st, rs);
		}
		
		return ca;
	}

	@Override //메뉴별 판매량 버튼
	public ArrayList<Cafe> SellMenu() {
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		ArrayList<Cafe> ca = new ArrayList<Cafe>();
		
		try {
			con = DriverManager.getConnection(url, user, pwd);
			String sql = "select menu,count(menu), temperture, sum(price), pay from cafe group by menu, temperture, pay";
			st = con.createStatement();
			rs = st.executeQuery(sql);
			
			while(rs.next()) {
				Cafe f = new Cafe();					
				f.setMenu(rs.getString(1));
				f.setCountMenu(rs.getInt(2));
				f.setTemperture(rs.getString(3));
				f.setSumPrice(rs.getInt(4));
				f.setPay(rs.getString(5));
				ca.add(f);
			}
		
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			closeStatement(con, st, rs);
		}	
		return ca;

	
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





