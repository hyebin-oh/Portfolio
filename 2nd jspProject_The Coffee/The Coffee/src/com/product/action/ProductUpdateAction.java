package com.product.action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import com.product.model.ProductDAO;
import com.product.model.ProductDTO;

/**
 * Servlet implementation class ProductUpdateAction
 */
@WebServlet("/product/productUpdate.me")
public class ProductUpdateAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ProductUpdateAction() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		long pnum = Long.parseLong(request.getParameter("pnum"));
		ProductDAO dao = ProductDAO.getInstance();
		ProductDTO product = dao.productView(pnum);
		request.setAttribute("product", product);
		
		RequestDispatcher rd = request.getRequestDispatcher("productUpdate.jsp");
		rd.forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");

		int uploadFileSizeLimit = 5 * 1024 * 1024;// 5md ����

		String encType = "UTF-8";
		String savePath = "upload";
		ServletContext context = getServletContext();
		String uploadeFilePath = context.getRealPath(savePath);

		MultipartRequest multi = new MultipartRequest(request, // request��ü
				uploadeFilePath, // �������� ���� ���丮
				uploadFileSizeLimit, // �ִ� ���ε� ���� ũ��
				encType, // ���ڵ����
				new DefaultFileRenamePolicy()); // ���� ���� �� �̸� �ο�

		// ���ε�� ���� �̸� ���ϱ�
		String fileName = multi.getFilesystemName("file");
		if(fileName==null) fileName = multi.getParameter("fileName");

		ProductDTO product = new ProductDTO();
		product.setFileName(fileName);
		product.setPdetail(multi.getParameter("pdetail"));
		product.setProduct(multi.getParameter("product"));
		product.setPtype(multi.getParameter("ptype"));
		product.setPnum(Long.parseLong(multi.getParameter("pnum")));
		ProductDAO dao = ProductDAO.getInstance();
		dao.productUpdate(product);

		long pnum = Long.parseLong(multi.getParameter("pnum"));
		response.sendRedirect("productView.me?pnum="+pnum);


	}

}
