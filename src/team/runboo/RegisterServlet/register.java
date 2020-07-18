package team.runboo.RegisterServlet;

import java.io.IOException;
import java.io.PrintWriter;
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
import team.runboo.RegisterServlet.*;

@WebServlet("/register")
public class register extends HttpServlet{
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
		PrintWriter out=response.getWriter();
		
		//得到每个参数的值
		String nick_name = request.getParameter("nickname");
		String real_name = request.getParameter("real_name");
		String sex = request.getParameter("sex");
		String phone_number = request.getParameter("phone_number");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		
		System.out.println(nick_name);
		System.out.println(real_name);
		System.out.println(sex);
		System.out.println(phone_number);
		System.out.println(email);
		System.out.println(password);
		
		
		//发送给数据库
		databasefuntion register_C = new databasefuntion();
		String result =  register_C.register_in(nick_name, real_name, sex, phone_number, email, password, 0.0);
		register_state result_json = new register_state();
		if (result == "true")
			result_json.setResult(result);
		else
			result_json.setResult("false");
		
		String state = JSON.toJSONString(result_json);
		out.write(state);
			
		
				
				

		// 打印出檢查
		//System.out.println(info);
		// 返回給前端
		//out.write(info);
	}
 
}
