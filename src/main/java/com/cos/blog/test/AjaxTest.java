package com.cos.blog.test;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// http://localhost:8080/blog/ajax (GET, POST)
@WebServlet("/ajax")
public class AjaxTest extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public AjaxTest() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("ajax실행");
		// 데이터 응답
		PrintWriter out = response.getWriter();
		out.print("ok");
		out.flush();
		//response.sendRedirect("index.jsp");
	}

}
