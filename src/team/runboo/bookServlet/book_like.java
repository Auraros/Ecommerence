package team.runboo.bookServlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Map;
import java.util.Date;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import team.runboo.DataBase.databasefuntion;
import team.runboo.DataBase.databasefuntion2;
import team.runboo.LoginServlet.login_state;
import team.runboo.UserServlet.*;

@WebServlet("/book_like")
public class book_like extends HttpServlet{
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
		String book_id = request.getParameter("book_id");
		String user_id = request.getParameter("userid");
		
		System.out.println(user_id);

		
		
		//发送给数据库
		databasefuntion booklike_C = new databasefuntion();
		String user_phone = booklike_C.obtain_user_phone_number(user_id);
		System.out.println(user_phone);
		
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date date =new Date();
//		System.out.println(timestamp);
		
		databasefuntion2 booklike2 = new databasefuntion2();
		String result = booklike2.insert_favor(book_id, user_phone, date);
		
		
//		String result = booklike_C.create_favor(book_id, user_phone, date);
		
	
		book_like_state result_json = new book_like_state();
		result_json.setResult(result);
		String state = JSON.toJSONString(result_json);
		out.write(state);
					

		// 打印出檢查
		//System.out.println(info);
		// 返回給前端
		//out.write(info);
	}
 
}
