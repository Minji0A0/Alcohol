package kh.semi.alcohol.member.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kh.semi.alcohol.member.model.service.AlcoholPriceListService;

@WebServlet("/pricelist")
public class AlcoholPriceListController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private AlcoholPriceListService service = new AlcoholPriceListService();
       
    public AlcoholPriceListController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
		// 경고창 띄우기 - 2
		System.out.println("AlcoholPriceListController 결과");
		String msg = (String)request.getSession().getAttribute("msg");
		if(msg != null) {
			request.getSession().removeAttribute("msg");
			request.setAttribute("msg", msg);
		}
		
		request.setAttribute("singlemaltList", service.selectListAlcohol("싱글몰트"));
		
		request.getRequestDispatcher("/WEB-INF/view/alcoholPriceList.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}