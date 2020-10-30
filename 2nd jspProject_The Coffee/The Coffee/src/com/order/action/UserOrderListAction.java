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
@WebServlet("/order/userOrderList.me")
public class UserOrderListAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserOrderListAction() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//����¡
		String page_ = request.getParameter("p");//����
		//page_�� ���� ������

		int page = 1;
		if(page_!=null && !page_.equals("")) {
			page=Integer.parseInt(page_);
		}
		
		//����Ʈ �ҷ�����
		request.setCharacterEncoding("utf-8");
		HttpSession session = request.getSession();
		String userid=(String) session.getAttribute("userid");
		
		OrderDAO dao = OrderDAO.getInstance();
		ArrayList<OrderDTO> arr= dao.userOrderList(userid, page);
		
		request.setAttribute("order", arr);
		
		RequestDispatcher rd = request.getRequestDispatcher("userOrderList.jsp");
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
