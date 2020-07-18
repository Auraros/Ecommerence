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
import team.runboo.UserServlet.userlikes_state;


@WebServlet("/userlikes")
public class userlikes extends HttpServlet{
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
		String userid = request.getParameter("userid");
		String likespage = request.getParameter("likespage");
		String phone_number;
		System.out.println(userid);
		
		
		databasefuntion shoppingCart_C = new databasefuntion();
		phone_number = shoppingCart_C.obtain_user_phone_number(userid);
		System.out.println(phone_number);
		
		
		databasefuntion2 shoppingCart_C2 = new databasefuntion2();
		String[] result = shoppingCart_C2.obtain_userlike(phone_number);
		
		int page = Integer.parseInt(likespage);
		int end_total = page*8*5;
		int start_total = (page-1)*8*3;
		
		
		String like_Au_1 = result[start_total];;
		String like_Au_2 = result[start_total+3];
		String like_Au_3= result[start_total+6];
		String like_Au_4= result[start_total+9];
		String like_Au_5= result[start_total+12];
		String like_Au_6= result[start_total+15];
		String like_Au_7= result[start_total+18];
		String like_Au_8= result[start_total+21];
		
		String like_book_1 = result[start_total+1];
		String like_book_2 = result[start_total+4];;
		String like_book_3= result[start_total+7];
		String like_book_4= result[start_total+10];
		String like_book_5= result[start_total+13];
		String like_book_6= result[start_total+16];
		String like_book_7= result[start_total+19];
		String like_book_8= result[start_total+22];
		
		
		String like_book_id_1 = result[start_total+2];
		String like_book_id_2 = result[start_total+5];;
		String like_book_id_3= result[start_total+8];
		String like_book_id_4= result[start_total+11];
		String like_book_id_5= result[start_total+14];
		String like_book_id_6= result[start_total+17];
		String like_book_id_7= result[start_total+20];
		String like_book_id_8= result[start_total+23];
		
		
		
		userlikes_state result_json = new userlikes_state();
		result_json.setLike_Au_1(like_Au_1);
		result_json.setLike_Au_2(like_Au_2);
		result_json.setLike_Au_3(like_Au_3);
		result_json.setLike_Au_4(like_Au_4);
		result_json.setLike_Au_5(like_Au_5);
		result_json.setLike_Au_6(like_Au_6);
		result_json.setLike_Au_7(like_Au_7);
		result_json.setLike_Au_8(like_Au_8);
		
		result_json.setLike_book_1(like_book_1);
		result_json.setLike_book_2(like_book_2);
		result_json.setLike_book_3(like_book_3);
		result_json.setLike_book_4(like_book_4);
		result_json.setLike_book_5(like_book_5);
		result_json.setLike_book_6(like_book_6);
		result_json.setLike_book_7(like_book_7);
		result_json.setLike_book_8(like_book_8);
		
		result_json.setLike_book_id_1(like_book_id_1);
		result_json.setLike_book_id_2(like_book_id_2);
		result_json.setLike_book_id_3(like_book_id_3);
		result_json.setLike_book_id_4(like_book_id_4);
		result_json.setLike_book_id_5(like_book_id_5);
		result_json.setLike_book_id_6(like_book_id_6);
		result_json.setLike_book_id_7(like_book_id_7);
		result_json.setLike_book_id_8(like_book_id_8);
		
		String state = JSON.toJSONString(result_json);
		out.write(state);
	}
}
