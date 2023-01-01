package com.cos.blog.test;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//localhost:8080/blog/test (Get,Post)
@WebServlet("/test")
public class ApiServerTest extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
    public ApiServerTest() {
        super();
    
    }

	//톰켓이 response request 객체를 만들어서 주입한 파라미터
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String food = request.getParameter("food");
		String method = request.getParameter("method");
		
		//DB에 insert(저장) 하고 끝
		
		int result = 1; // 정상
		//JSON 형태로 응답
		PrintWriter out = response.getWriter();
		if(result==1) {
			out.println("{\"food\": "+food+" , \"method\" : "+method+" }");
		}
		else {
			out.println("{\"error\":\"200\"} ");
		}
		
	}

}
