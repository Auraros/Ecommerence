package team.runboo.LoginServlet;


import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Map;
import team.runboo.DataBase.*;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import team.runboo.LoginServlet.*;

@WebServlet("/login")
public class login extends HttpServlet{
	private static final long serialVersionUID = 1L;
	 
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/javascript");
		response.setCharacterEncoding("UTF-8");
		
		String Name = request.getParameter("phone/email_number");
		String PassWords = request.getParameter("password");
		String admin_0 = request.getParameter("admin");
		
		int admin = Integer.parseInt(admin_0);
		
		PrintWriter out=response.getWriter();
		System.out.println(Name);
		System.out.println(PassWords);
		System.out.println(admin);
		response.setStatus(200);  
		

		
		databasefuntion Login_C = new databasefuntion();
		String result = "";
		String nickname = "";
		if (admin == 0) {
			result =  Login_C.login_check(Name, PassWords);
			nickname = Login_C.obtain_nickname(Name);
			
			System.out.println(result);
		}else {
			result =  Login_C.adminlogin_check(Name, PassWords);
			nickname = Login_C.obtain_ad_nickname(Name);
		}
		login_state result_json = new login_state();
		result_json.setUser(nickname);
		result_json.setResult(result);
		result_json.setUserid(Name);
		result_json.setAdmin(admin_0);
		String state = JSON.toJSONString(result_json);
		
		
		out.write(state);
		
		
				
		
				

		// 打印出檢查
		//System.out.println(info);
		// 返回給前端
		//out.write(info);
	}
 
}

