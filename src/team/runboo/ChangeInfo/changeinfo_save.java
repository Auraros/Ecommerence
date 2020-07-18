package team.runboo.ChangeInfo;

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

import java.text.*;
 
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import team.runboo.DataBase.databasefuntion2;
import team.runboo.ChangeInfo.changeinfo_state;
import team.runboo.UserServlet.*;

@WebServlet("/changeinfo_save")
public class changeinfo_save extends HttpServlet{
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
		String nickname = request.getParameter("nickname");
		String real_name = request.getParameter("real_name");
		String id_card = request.getParameter("id_card");
		String sex = request.getParameter("sex");
		String phone_number = request.getParameter("phone_number");
		String email = request.getParameter("email");
		String birthday = request.getParameter("birthday");
		String address = request.getParameter("address");
		String password = request.getParameter("password");
		
		String str = nickname+sex+phone_number+id_card+password+birthday+address;
		System.out.println(str);
		

		String result; 
		
		
		//发送给数据库
		databasefuntion2 register_C = new databasefuntion2();
		result = register_C.update_user_imformation(nickname,sex, phone_number, id_card, password, birthday, address);
		
		
		
		System.out.println(email);
		changeinfo_state result_json = new changeinfo_state();
		result_json.setResult(result);
		String state = JSON.toJSONString(result_json);
		out.write(state);
			
		
				
				

		// 打印出檢查
		//System.out.println(info);
		// 返回給前端
		//out.write(info);
	}
 
}
