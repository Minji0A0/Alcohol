package kh.semi.alcohol.member.controller;

import java.io.IOException;
import java.sql.Connection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kh.semi.alcohol.member.model.dto.AlcoholDTO;
import kh.semi.alcohol.member.model.dto.AlcoholPriceListDTO;
import kh.semi.alcohol.member.model.service.AlcoholPriceListService;
import kh.semi.alcohol.member.model.service.AlcoholService;

@WebServlet("/get")
public class AlcoholGetController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	public AlcoholGetController() {
		
		super();
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		
		System.out.println("AlcoholGetController 진입!");
		String priceBorderNo = request.getParameter("bno");
		System.out.println("AlcoholGetController : "+ priceBorderNo);

		AlcoholPriceListService service = new AlcoholPriceListService();
		AlcoholPriceListDTO vo = service.selectOneAlcohol(priceBorderNo);
		request.setAttribute("bno", vo);
		request.getRequestDispatcher("/WEB-INF/view/alcoholGet.jsp").forward(request, response);
	}
}