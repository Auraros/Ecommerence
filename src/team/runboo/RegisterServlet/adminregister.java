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
import team.runboo.DataBase.*;

@WebServlet("/adminregister")
public class adminregister extends HttpServlet{
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
		PrintWriter out=response.getWriter();
		
				
		String id_card = request.getParameter("id_card");
		String nickname = request.getParameter("nickname");
		String address = request.getParameter("address");
		String birthday = request.getParameter("birthday");
		String real_name = request.getParameter("real_name");
		String sex = request.getParameter("sex");
		String phone_number = request.getParameter("phone_number");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		
		System.out.println(nickname);
		System.out.println(real_name);
		System.out.println(sex);
		System.out.println(phone_number);
		System.out.println(email);
		System.out.println(password);
		
		
		response.setStatus(200);  
		response.setContentType("application/json; charset=utf-8");
		
		databasefuntion2 admin_re = new databasefuntion2();
		String result = admin_re.adminregister_in(birthday, address, nickname, real_name, sex, phone_number, email, password,  id_card);
		
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