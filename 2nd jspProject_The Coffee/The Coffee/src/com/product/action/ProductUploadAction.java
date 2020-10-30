package com.product.action;

import java.io.IOException;

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
 * Servlet implementation class ProductUploadAction
 */
@WebServlet("/product/fileUpload.me")
public class ProductUploadAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProductUploadAction() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		int uploadFileSizeLimit = 5*1024*1024;//5md ����
		
		String encType = "UTF-8";
		String savePath = "upload";
		ServletContext context = getServletContext();
		String uploadeFilePath = context.getRealPath(savePath);
		
		MultipartRequest multi = new MultipartRequest(
						request, //request��ü
						uploadeFilePath, //�������� ���� ���丮
						uploadFileSizeLimit, //�ִ� ���ε� ���� ũ��
						encType, //���ڵ����
						new DefaultFileRenamePolicy()); //���� ���� �� �̸� �ο�
		
		//���ε�� ���� �̸� ���ϱ�
		String fileName = multi.getFilesystemName("file");
		
		if(fileName==null) {//���ε�ȵ�
			System.out.println("���� ���ε� ����");			
		}else {
			ProductDTO product = new ProductDTO();			
			product.setFileName(fileName);
			product.setPdetail(multi.getParameter("pdetail"));
			product.setProduct(multi.getParameter("product"));
			product.setPtype(multi.getParameter("ptype"));
			ProductDAO dao = ProductDAO.getInstance();
			dao.productUpload(product);
			response.sendRedirect("adminProductList.me");
		}

		
	}

}
