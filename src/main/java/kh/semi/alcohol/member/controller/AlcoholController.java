package kh.semi.alcohol.member.controller;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kh.semi.alcohol.member.model.dto.AlcoholDTO;
import kh.semi.alcohol.member.model.dto.AlcoholPriceListDTO;
import kh.semi.alcohol.member.model.dto.MemberDTO;
import kh.semi.alcohol.member.model.service.AlcoholService;

@WebServlet("/alcohollist")
public class AlcoholController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public AlcoholController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("/alcohollist doGet() alcoholList가 진입 했습니다");
		String searchWord = request.getParameter("searchWord");
		String pageNoStr = request.getParameter("pageNo");
		int currentPage = 1;
		int pageSize = 10;
		if(pageNoStr != null ) {
			try {
				currentPage = Integer.parseInt(pageNoStr); 
			}catch (NumberFormatException e) {
				e.printStackTrace();
			}
		}
		AlcoholService service = new AlcoholService();
		List<AlcoholPriceListDTO> result =null;
		Map<String, Object> map = null;
		//TODO
//		if(searchWord !=null) {
//			map = service.selectListAlcohol(currentPage, pageSize, searchWord);
//		}else {
//			map = service.selectOneAlcohol(currentPage, 10);
//		}
		request.setAttribute("alcoholList", map.get("alcohollList"));
		int pageBlockSize = 5;
		int totalCnt = (Integer)map.get("totalCnt");
		int totalPageNum = totalCnt/pageSize + (totalCnt%pageSize == 0 ? 0 : 1);
		int startPageNum = 1;
		if((currentPage%pageBlockSize) == 0 ) {
			startPageNum = ((currentPage/pageBlockSize) - 1) * pageBlockSize +1 ;
		} else {
			startPageNum = ((currentPage / pageBlockSize))*pageBlockSize + 1;
		}
		int endPageNum = (startPageNum + pageBlockSize > totalPageNum ) ? totalPageNum : startPageNum + pageBlockSize;
		request.setAttribute("totalPageNum", totalPageNum);
		request.setAttribute("startPageNum", startPageNum);
		request.setAttribute("endPageNum", endPageNum);
		if(searchWord != null) {
			request.setAttribute("searchWord", searchWord);
		}
		request.getRequestDispatcher("/WEB-INF/view/alcoholPricelList.jsp").forward(request, response);
	}

}
