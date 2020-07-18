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
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import team.runboo.DataBase.databasefuntion;
import team.runboo.LoginServlet.login_state;
import team.runboo.UserServlet.*;

@WebServlet("/balance")
public class balance extends HttpServlet{
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
		
		System.out.println(userid);

		String phone_number; 
		
		//发送给数据库
		databasefuntion balance_C = new databasefuntion();
		phone_number = balance_C.obtain_user_phone_number(userid);
		
		String  balance_str= balance_C.user_balance(phone_number);
		
		balance_state result_json = new balance_state();
		result_json.setBalance(balance_str);
		String state = JSON.toJSONString(result_json);
		out.write(state);

		// 打印出檢查
		//System.out.println(info);
		// 返回給前端
		//out.write(info);
	}
 
}