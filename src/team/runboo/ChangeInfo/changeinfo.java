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

@WebServlet("/changeinfo")
public class changeinfo extends HttpServlet{
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

		String[] imformation; 
		
		//发送给数据库
		databasefuntion information_C = new databasefuntion();
		imformation = information_C.obtain_user_information(userid);
		
		
		String nickname = imformation[0];
		String real_name = imformation[1];
		String sex = imformation[2];
		String phone_number = imformation[3];
		String email = imformation[4];
		String password = imformation[5];
		String head_portrait = imformation[6];
		String id_card = imformation[7];
		String birthday = imformation[8];
		String address = imformation[9];
		String balance = imformation[10];

		
		
		System.out.println(email);
		user_state result_json = new user_state();
		result_json.setNickname(nickname);
		result_json.setReal_name(real_name);
		result_json.setId_card(id_card);
		result_json.setSex(sex);
		result_json.setPhone_number(phone_number);
		result_json.setEmail(email);
		result_json.setBirthday(birthday);
		result_json.setAddress(address);
		String state = JSON.toJSONString(result_json);
		out.write(state);
			
		
		// 打印出檢查
		//System.out.println(info);
		// 返回給前端
		//out.write(info);
	}
 
}
