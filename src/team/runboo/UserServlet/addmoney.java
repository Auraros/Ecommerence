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
import team.runboo.DataBase.databasefuntion2;
import team.runboo.LoginServlet.login_state;
import team.runboo.UserServlet.*;

@WebServlet("/addmoney")
public class addmoney extends HttpServlet{
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
		String addmoney = request.getParameter("addmoney");
		System.out.println(userid);
		
		
		//发送给数据库
		databasefuntion register_C = new databasefuntion();
		String phone_number = register_C.obtain_user_phone_number(userid);
		
		//发送给数据库
		databasefuntion2 addmoney_C = new databasefuntion2();
		String result = addmoney_C.charge_money(phone_number, addmoney);

		
		delete_state result_json = new delete_state();
		result_json.setResult(result);;
		String state = JSON.toJSONString(result_json);
		out.write(state);

		// 打印出檢查
		//System.out.println(info);
		// 返回給前端
		//out.write(info);
	}
 
}
