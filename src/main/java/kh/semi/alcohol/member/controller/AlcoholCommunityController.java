package kh.semi.alcohol.member.controller;

import java.io.IOException;
import java.sql.Connection;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kh.semi.alcohol.common.JDBCTemp;
import kh.semi.alcohol.member.model.dao.AlcoholPriceListDAO;
import kh.semi.alcohol.member.model.dto.AlcoholPriceListDTO;

@WebServlet("/community")
public class AlcoholCommunityController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public AlcoholCommunityController() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String searchWord = "";
        request.getRequestDispatcher("/WEB-INF/view/alcoholPriceList.jsp").forward(request, response);
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
