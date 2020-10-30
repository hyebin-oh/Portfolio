package com.product.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;


public class ProductDAO {
	
	//��񿬰�
	private static ProductDAO instance = new  ProductDAO();
	public static  ProductDAO  getInstance() {
		return instance;
	}
	private Connection getConnection() throws Exception{
		Context initCtx = new InitialContext();
		Context envCtx = (Context) initCtx.lookup("java:comp/env");
		DataSource ds = (DataSource) envCtx.lookup("jdbc/project");
		return ds.getConnection();
	}
	
	//��ǰ ���ε�(�߰�)
	public void productUpload (ProductDTO product) {
		Connection con = null;
		PreparedStatement ps = null;
		
		try {
			con=getConnection();
			String sql = "insert into product values(product_seq.nextval, ?,?,?,?)";
			ps=con.prepareStatement(sql);
			ps.setString(1, product.getProduct());
			ps.setString(2, product.getPdetail());
			ps.setString(3, product.getFileName());
			ps.setString(4, product.getPtype());
			ps.executeUpdate();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			closeConnection(con, ps);
		}
	}
	
	//��ü��ǰ����Ʈ
	public ArrayList<ProductDTO> adminProductList(){
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		ArrayList<ProductDTO> arr = new ArrayList<ProductDTO>();
		
		try {
			con = getConnection();
			String sql =  "select * from product order by pnum";
			st = con.createStatement();
			rs = st.executeQuery(sql);
			
			while(rs.next()) {
				ProductDTO product = new ProductDTO();
				product.setFileName(rs.getString("filename"));
				product.setPdetail(rs.getString("pdetail"));
				product.setPnum(rs.getInt("pnum"));
				product.setProduct(rs.getString("product"));
				product.setPtype(rs.getString("ptype"));
				arr.add(product);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return arr;		
	}
	
		
	// �̱ۿ����� ��ǰ ����Ʈ
	public ArrayList<ProductDTO> singleProductList(){
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		ArrayList<ProductDTO> arr = new ArrayList<ProductDTO>();
		
		try {
			con=getConnection();
			String sql = "select * from product where ptype='single'";
			st = con.createStatement();
			rs = st.executeQuery(sql);
			
			while(rs.next()) {
				ProductDTO product = new ProductDTO();
				product.setFileName(rs.getString("filename"));
				product.setPdetail(rs.getString("pdetail"));
				product.setPnum(rs.getInt("pnum"));
				product.setProduct(rs.getString("product"));
				product.setPtype(rs.getString("ptype"));
				arr.add(product);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			closeConnection(con, st, rs);
		}		
		return arr;		
	}
	
	// ��������� ��ǰ ����Ʈ
	public ArrayList<ProductDTO> blendProductList(){
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		ArrayList<ProductDTO> arr = new ArrayList<ProductDTO>();
		
		try {
			con=getConnection();
			String sql = "select * from product where ptype='blend'";
			st = con.createStatement();
			rs = st.executeQuery(sql);
		
		while(rs.next()) {
			ProductDTO product = new ProductDTO();
			product.setFileName(rs.getString("filename"));
			product.setPdetail(rs.getString("pdetail"));
			product.setPnum(rs.getInt("pnum"));
			product.setProduct(rs.getString("product"));
			product.setPtype(rs.getString("ptype"));
			arr.add(product);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			closeConnection(con, st, rs);
		}		
		return arr;		
	}
	
	
	//��ǰ �󼼺���
	public ProductDTO productView(long pnum) {
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		ProductDTO dto = null;
		
		try {
			con = getConnection();
			st = con.createStatement();
			String sql = "select * from product where pnum="+pnum;
			rs = st.executeQuery(sql);
			
			if(rs.next()) {
				dto = new ProductDTO();
				dto.setFileName(rs.getString("filename"));
				dto.setPdetail(rs.getString("pdetail"));
				dto.setPnum(rs.getInt("pnum"));
				dto.setProduct(rs.getString("product"));
				dto.setPtype(rs.getString("ptype"));
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			closeConnection(con, st, rs);
		}		
		return dto;
		
	}
		
	//��ǰ ����
	public void productUpdate(ProductDTO product) {
		Connection con = null;
		PreparedStatement ps = null;
		
		try {
			con=getConnection();
			String sql = "update product set product=?, pdetail=?, filename=?, ptype=? where pnum=?";
			ps=con.prepareStatement(sql);
			ps.setString(1, product.getProduct());
			ps.setString(2, product.getPdetail());
			ps.setString(3, product.getFileName());
			ps.setString(4, product.getPtype());
			ps.setLong(5, product.getPnum());
			ps.executeUpdate();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			closeConnection(con, ps);
		}
	}	
	
	//��ǰ ����
	public void productDelete(String product) {
		Connection con = null;
		Statement st = null;
		
		try {
			con=getConnection();
			String sql = "delete from product where product='"+product+"'";
			st=con.createStatement();
			st.execute(sql);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
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
