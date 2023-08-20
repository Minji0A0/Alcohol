package kh.semi.alcohol.member.controller;

import java.io.IOException;
import java.util.Map;

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
		System.out.println("/pricelist doGet()");

		// 경고창 띄우기 - 2
		String msg = (String)request.getSession().getAttribute("msg");
		if(msg != null) {
			System.out.println("경고창 띄우기 step 2 msg: "+msg);
			request.getSession().removeAttribute("msg");
			request.setAttribute("msg", msg);
		}
		
		
		String searchWord = request.getParameter("searchWord");
		String pageNoStr = request.getParameter("pageNo");
		System.out.println("[param] searchWord: "+searchWord);
		System.out.println("[param] pageNoStr: "+pageNoStr);
		
		int currentPage = 1;
		int pageSize = 10;
		if(pageNoStr != null ) {
			try {
				currentPage = Integer.parseInt(pageNoStr); 
			}catch (NumberFormatException e) {
				e.printStackTrace();
			}
		}
		System.out.println("[param] currentPage: "+currentPage);
		
		Map<String, Object> map = null;
		if(searchWord !=null) {
			map = service.selectListAlcohol(currentPage, pageSize, searchWord);
		}else {
			map = service.selectListAlcohol(currentPage, pageSize);
		}
		// jsp에서 보여줄 페이질 계산
		int pageBlockSize = 5;
		int totalCnt = (Integer)map.get("totalCnt");
		int totalPageNum = totalCnt/pageSize + (totalCnt%pageSize == 0 ? 0 : 1);
		int startPageNum = 1;
		if((currentPage%pageBlockSize) == 0 ) {
			startPageNum = ((currentPage/pageBlockSize) - 1) * pageBlockSize +1 ;
		} else {
			startPageNum = ((currentPage / pageBlockSize))*pageBlockSize + 1;
		}
		int endPageNum = (startPageNum + pageBlockSize-1 > totalPageNum ) ? totalPageNum : startPageNum + pageBlockSize-1;
		
		request.setAttribute("totalPageNum", totalPageNum);
		request.setAttribute("startPageNum", startPageNum);
		request.setAttribute("endPageNum", endPageNum);
		if(searchWord != null) {
			request.setAttribute("searchWord", searchWord);
		}
		
		request.setAttribute("totalCnt", map.get("totalCnt"));
		
		// 진짜 중요한 데이터
		request.setAttribute("alcoholList", map.get("alcoholList"));
		
		request.getRequestDispatcher("/WEB-INF/view/alcoholPriceList.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}