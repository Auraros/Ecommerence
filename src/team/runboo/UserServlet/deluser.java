package team.runboo.UserServlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;


import team.runboo.DataBase.*;
import team.runboo.bookServlet.book_state;


@WebServlet("/deluser")
public class deluser extends HttpServlet{
	private static final long serialVersionUID = 1L;
	 
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		//设置状态
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/javascript");
		response.setCharacterEncoding("UTF-8");
		PrintWriter out=response.getWriter();
		
		//得到每个参数的值
		String phone_number = request.getParameter("userid");
//		int books_id = Integer.parseInt(books_id_str);
		System.out.println(phone_number);
		
		databasefuntion2 book_C = new databasefuntion2();
		String result = book_C.delete_user(phone_number);

		
	
		
		book_state result_json = new book_state();

		result_json.setResult(result);

		
		
		String state = JSON.toJSONString(result_json);
		out.write(state);
	}
}