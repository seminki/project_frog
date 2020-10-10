package com.toyspace.admin.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import com.toyspace.product.model.service.ProductService;
import com.toyspace.product.model.vo.Product;

/**
 * Servlet implementation class InsertProductEndServlet
 */
@WebServlet("/admin/insertProductEnd")
public class InsertProductEndServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsertProductEndServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		if(!ServletFileUpload.isMultipartContent(request)) {
			request.setAttribute("msg", "상품 등록 오류!");
			request.setAttribute("loc", "/msg");
			request.getRequestDispatcher("/views/common/msg.jsp").forward(request, response);
			return;
		}
		
		String path = getServletContext().getRealPath("/upload/product");
		
		int maxSize=1024*1024*10;
		
		String encode="UTF-8";
		DefaultFileRenamePolicy rename = new DefaultFileRenamePolicy();
		MultipartRequest mr = new MultipartRequest(request, path, maxSize, encode, rename);
		
		int categoryNo = Integer.parseInt(mr.getParameter("category"));
		String productName = mr.getParameter("item_name");
		double productPrice = Double.parseDouble(mr.getParameter("item_price"));
		int productStock = Integer.parseInt(mr.getParameter("item_qt"));
		String productDescription = mr.getParameter("product-description");
		String manufacturer = mr.getParameter("manufacturer");
		String manufacturedCountry = mr.getParameter("manufactured-country");
		int recommendedAge = Integer.parseInt(mr.getParameter("recommended-age"));
		String caution = mr.getParameter("caution");
		
		
		List<String> productImageFilePaths = new ArrayList<String>();
		
//		파일은 5개이기 때문
		for(int i =1; i<6 ;i++) {
			String file = mr.getFilesystemName("upload-file"+i);
			if(file!=null) productImageFilePaths.add(file);
			else break;
		}
		
		List<Integer> tagsList = new ArrayList<Integer>();
		String[] tagsString = mr.getParameterValues("item_tag");
		
		for(String s : tagsString) {
			tagsList.add(Integer.parseInt(s));
		}
		
		Product p = new Product(-1, categoryNo, null, 
				productName, productPrice, productStock, 
				productDescription, manufacturer, manufacturedCountry, 
				recommendedAge, caution, productImageFilePaths, -1);
		
		System.out.println(tagsList);
		boolean result = new ProductService().insertProduct(p,tagsList);
		
		String msg ="";
		if(result) {
			msg = "상품 등록에 성공하였습니다.";
		} else {
			msg = "상품 등록에 실패하였습니다.";
		}
		request.setAttribute("msg", msg);
		request.setAttribute("loc", request.getContextPath()+"/admin/mainPage");
		request.getRequestDispatcher("/views/common/msg.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
