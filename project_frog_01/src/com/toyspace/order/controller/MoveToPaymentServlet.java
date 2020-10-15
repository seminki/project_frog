package com.toyspace.order.controller;

import java.io.IOException;
import java.util.TreeMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.toyspace.member.model.vo.Member;
import com.toyspace.order.history.model.service.OrderHistoryService;
import com.toyspace.product.model.service.ProductService;
import com.toyspace.product.model.vo.Product;

/**
 * Servlet implementation class MoveToPaymentServlet
 */
@WebServlet("/order/moveToPayment")
public class MoveToPaymentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MoveToPaymentServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		나중에 카트의 작업물을 옮기는 과정을 해야합니다.
//		프로덕트 서비스로 아임포트에 결제 과정 전 처리 -> 디비/결제 담기에 결제 준비중으로 담기
		HttpSession session = request.getSession();
		Member m = (Member)session.getAttribute("signedInMember");
		TreeMap<Integer, Integer> cartValues = (TreeMap<Integer, Integer>)session.getAttribute("cart");
		TreeMap<Integer, Product> productInfo = new ProductService().loadSelectedProductsWithMainPic(cartValues);
		
		String merchant_uid = new OrderHistoryService().createPaymentLog(m.getMemberKey(), cartValues);
		
		String path = "";
		
		if(merchant_uid==null) {
			path="/msg?loc="+request.getContextPath()+"/cart.do&msg=결제 정보 생성에 실패했습니다.";
			
		} else {
			path = "/views/cart/payment.jsp";
			request.setAttribute("merchant_uid", merchant_uid);
			request.setAttribute("productInfo", productInfo);
		}
		
//		지금은 카트가 완성되지 않았기 때문에 데모로 그냥 넘어가도록 함
		request.getRequestDispatcher(path).forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
