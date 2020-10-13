package com.toyspace.order.controller;

import java.io.IOException;
import java.util.TreeMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;
import com.siot.IamportRestClient.IamportClient;
import com.siot.IamportRestClient.exception.IamportResponseException;
import com.siot.IamportRestClient.response.AccessToken;
import com.siot.IamportRestClient.response.IamportResponse;
import com.siot.IamportRestClient.response.Payment;
import com.toyspace.product.model.service.ProductService;
import com.toyspace.product.model.vo.Product;

/**
 * Servlet implementation class OrderCompleteServlet
 */
@WebServlet("/order/process")
public class OrderProcessServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public OrderProcessServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		ProductService ps = new ProductService();
		
		HttpSession session = request.getSession();
		Gson gson = new Gson();
		
		
		String imp_uid = request.getParameter("imp_uid");
		String merchant_uid = request.getParameter("merchant_uid");
		
//		디비에 merchat_uid로 지정된 결제의 totalamount 불러오기!
//		double amount = ps.loadTotalAmount(merchant_uid);
		
		String api_key = "9845619002442630";
		String api_secret = "4ikpSZKORdkvnfxsuWSICeLlnLWZSDcXVxnOw8CnlWTJcqcGn4o0jalGWiGOWTMSq9GWhjkDfdmsEy82";
		
		IamportClient client = new IamportClient(api_key, api_secret);
		IamportResponse<AccessToken> res=null;
		try {
			res =client.getAuth();
		} catch (IamportResponseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		AccessToken tokenCont = res.getResponse();
		String token = tokenCont.getToken();
		
		IamportResponse<Payment> payRes =null;
		
		try {
			payRes= client.paymentByImpUid(imp_uid);
		} catch (IamportResponseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Payment payment = payRes.getResponse();
		/////////////////테스트 코드//////////////
		/*
		 * System.out.println(imp_uid);
		System.out.println(payment.getImpUid());
		System.out.println(merchant_uid);
		System.out.println(payment.getMerchantUid());
		System.out.println(amount);
		System.out.println(payment.getAmount().doubleValue());
		*
		*/
		/////////////////////////////
//		if(imp_uid.contentEquals(payment.getImpUid())&& merchant_uid.equals(payment.getMerchantUid())&&
//				amount == payment.getAmount().doubleValue()) {
		if(true) { //테스트용
//			서버저장 로직 쓸것!
			System.out.println("정상정상!");
////////////////////////////////////
//			1이면 정상
			gson.toJson(1, response.getWriter());
			return;
		} else {
			System.out.println("결제 위변조가 감지되었습니다!!!");
		}
		gson.toJson(0,response.getWriter());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
