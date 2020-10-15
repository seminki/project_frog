package com.toyspace.product.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.toyspace.product.model.service.ProductService;
import com.toyspace.product.model.vo.Product;

/**
 * Servlet implementation class ProductList
 */
@WebServlet("/productlist.do")
public class ProductListPage extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProductListPage() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int cPage;
		try {
			cPage=Integer.parseInt(request.getParameter("cPage"));
		} catch (NumberFormatException e) {
			// TODO: handle exception
			cPage=1;
		}
		int numPerPage=3;
		
		ArrayList<Product> productsList=new ProductService().loadAllProductsWithMainPic(cPage,numPerPage);
		int totalData=new ProductService().selectProductCount();
		int totalPage=(int)Math.ceil((double)totalData/numPerPage);
		int pageBarSize=5;
		
		int pageNo=((cPage-1)/pageBarSize)*pageBarSize+1;
		int pageEnd=pageNo+pageBarSize-1;
		
		String pageBar="";
		
		if(pageNo==1) {
			pageBar+="<button>\r\n" + 
					"<span\r\n" + 
					"aria-hidden=\"true\">PREV</span> <span\r\n" + 
					"aria-hidden=\"true\"><i\r\n" + 
					"class=\"fas fa-chevron-left\"></i></span>\r\n" + 
					"</button>";
		}else {
			pageBar+="<a href='"+request.getContextPath()+"/productlist.do?cPage="
					+(pageNo-1)+"'><button>\r\n"+ 
							"					<span\r\n" + 
							"					aria-hidden=\"true\">PREV</span> <span\r\n" + 
							"					aria-hidden=\"true\"><i\r\n" + 
							"					class=\"fas fa-chevron-left\"></i></span>\r\n" + 
							"					</button></a>";	
		}
		
		while(!(pageNo>pageEnd||pageNo>totalPage)) {
			if(cPage==pageNo) {
				pageBar+=" "+"<button>"+pageNo+"</button>"+" ";
			}else {
				pageBar+=" "+"<a href='"+request.getContextPath()
				+"/productlist.do?cPage="+pageNo+"'><button>"+pageNo+"</button></a>"+" ";	
			}
			pageNo++;
		}
		
		if(pageNo>totalPage) {
			pageBar+="<button>" + 
					"<span\r\n" + "aria-hidden=\"true\">NEXT</span> <span\r\n" + 
					"aria-hidden=\"true\"><i\r\n" + 
					"class=\"fas fa-chevron-right\"></i></span>\r\n" + 
					"</button>";
		}else {
			pageBar+="<a href='"+request.getContextPath()
			+"/productlist.do?cPage="+pageNo+"'><button>" + 
					"					<span\r\n" + "aria-hidden=\"true\">NEXT</span> <span\r\n" +
					"					aria-hidden=\"true\"><i\r\n" + 
					"					class=\"fas fa-chevron-right\"></i></span>\r\n" + 
					"					</button></a>";
		}
		
		request.setAttribute("productsList", productsList);
		request.setAttribute("pageBar", pageBar);
					
		
		
		
		
		request.getRequestDispatcher("/views/product/productList.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
