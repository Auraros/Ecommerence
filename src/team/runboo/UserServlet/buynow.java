package team.runboo.UserServlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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


import team.runboo.DataBase.*;
import team.runboo.UserServlet.delete_state;


@WebServlet("/buynow")
public class buynow extends HttpServlet{
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
		String phone_number;
		System.out.println(userid);
		
		//获得电话号码
		databasefuntion shoppingCart_C = new databasefuntion();
		phone_number = shoppingCart_C.obtain_user_phone_number(userid);
		System.out.println(phone_number);
		
		//得到用户现有的余额
		String  ablance_str= shoppingCart_C.user_balance(phone_number);
		double   ablance =   Double.parseDouble(ablance_str); 
		
		
		//得到所有商品信息
		databasefuntion2 shoppingCart_C2 = new databasefuntion2();
		String[] shoppings = shoppingCart_C2.obtain_shoopingCatr(phone_number);
		
		double all_price = 0.0;
		for (int i=0; i<1000;i++) {   //得到用户要购买商品的所有余额
			if(shoppings[i] == null) {
				break;
			}
			String sum = shoppings[i+1];
			String single_price = shoppings[i+2];
			double num = Double.parseDouble(sum); 
			double price = Double.parseDouble(single_price);
			double one_price = num*price;
//			System.out.println(one_price);
			all_price = all_price + one_price;
			i = i+3;
		}
		
		System.out.println(all_price);
		System.out.println(ablance);
		
		
		
		String result = "";
		if (ablance> all_price) {
			for(int i=0; i<1000; i++) {
				if(shoppings[i] == null) {
					break;
				}
				String name = shoppings[i];
				String sum = shoppings[i+1];
				String single_price = shoppings[i+2];
				String books_id = shoppings[i+3];
				System.out.println(name);
				System.out.println(books_id);
				
				i = i+3;
				result = shoppingCart_C2.buy_books(phone_number, books_id);
				if (result == "true") {
					continue;
				}else {
					result ="false";
					break;
				}
			}
		}else {
			result = "false";
		}
		
		delete_state result_json = new delete_state();
		result_json.setResult(result);
		
		String state = JSON.toJSONString(result_json);
		out.write(state);
	}
}
