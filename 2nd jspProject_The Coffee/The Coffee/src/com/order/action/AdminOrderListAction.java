package com.order.action;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.order.model.OrderDAO;
import com.order.model.OrderDTO;

/**
 * Servlet implementation class UserOrderListAction
 */
@WebServlet("/order/adminOrderList.me")
public class AdminOrderListAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminOrderListAction() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String field_ = request.getParameter("f");//����
		String query_ = request.getParameter("q");//����
		String page_ = request.getParameter("p");//����
		//page_�� ���� ������
		
		String field = "product";//�ӽú���
		
		if(field_!=null && !field_.equals("")) {//����ڰ� ������ ���� ���� ��� �⺻ �ӽú����ǰ��� _�� ����
			field = field_;
		}
		String query = "";
		if(query_!=null && !query_.equals("")) {
			query=query_;
		}
		int page = 1;
		if(page_!=null && !page_.equals("")) {
			page=Integer.parseInt(page_);
		}
		
		request.setCharacterEncoding("utf-8");
		
		OrderDAO dao = OrderDAO.getInstance();
		ArrayList<OrderDTO> arr= dao.adminOrderList(field, query, page);
		
		request.setAttribute("order", arr);
		
		RequestDispatcher rd = request.getRequestDispatcher("adminOrderList.jsp");
		rd.forward(request, response);
		
		
	}
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
