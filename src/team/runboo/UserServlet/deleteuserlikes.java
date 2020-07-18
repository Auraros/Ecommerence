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
import team.runboo.UserServlet.delete_state;


@WebServlet("/deleteuserlikes")
public class deleteuserlikes extends HttpServlet{
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
		String books_id = request.getParameter("like_book_id");
		String userid = request.getParameter("userid");
		String phone_number;
		System.out.println(userid);
		
		
		databasefuntion shoppingCart_C = new databasefuntion();
		phone_number = shoppingCart_C.obtain_user_phone_number(userid);
		System.out.println(phone_number);
		
		
		databasefuntion2 deleteuserlike_C2 = new databasefuntion2();
		String result = deleteuserlike_C2.delete_favor(phone_number, books_id);
		
	
		
		delete_state result_json = new delete_state();
		result_json.setResult(result);
		
		String state = JSON.toJSONString(result_json);
		out.write(state);
	}
}
