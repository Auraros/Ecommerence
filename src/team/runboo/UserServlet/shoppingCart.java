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

import team.runboo.DataBase.*;
import team.runboo.UserServlet.shoppingCart_state;
import team.runboo.UserServlet.*;

@WebServlet("/shoppingCart")
public class shoppingCart extends HttpServlet{
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
		String SCpage = request.getParameter("SCpage");
		String phone_number;
		System.out.println(userid);
		
		
		databasefuntion shoppingCart_C = new databasefuntion();
		phone_number = shoppingCart_C.obtain_user_phone_number(userid);
		System.out.println(phone_number);
		
		databasefuntion2 shoppingCart_C2 = new databasefuntion2();
		String[] result = shoppingCart_C2.obtain_shoopingCatr(phone_number);
		
		int page = Integer.parseInt(SCpage);
		int end_total = page*8*5;
		int start_total = (page-1)*8*4;
		
		String SC_book_1 = result[start_total];
		String SC_book_2 = result[start_total+4];
		String SC_book_3= result[start_total+8];
		String SC_book_4= result[start_total+12];
		String SC_book_5= result[start_total+16];
		String SC_book_6= result[start_total+20];
		String SC_book_7= result[start_total+24];
		String SC_book_8= result[start_total+28];
		
		String SC_num_1 = result[start_total+1];
		String SC_num_2 = result[start_total+5];;
		String SC_num_3= result[start_total+9];
		String SC_num_4= result[start_total+13];
		String SC_num_5= result[start_total+17];
		String SC_num_6= result[start_total+21];
		String SC_num_7= result[start_total+25];
		String SC_num_8= result[start_total+29];
		
		String[] SC_num_list = {SC_num_1, SC_num_2, SC_num_3, SC_num_4, SC_num_5, SC_num_6, SC_num_7, SC_num_8};
		
		String SC_price_1 = result[start_total+2];
		String SC_price_2 = result[start_total+6];;
		String SC_price_3= result[start_total+10];
		String SC_price_4= result[start_total+14];
		String SC_price_5= result[start_total+18];
		String SC_price_6= result[start_total+22];
		String SC_price_7= result[start_total+26];
		String SC_price_8= result[start_total+30];
		
		String[] SC_price_list = {SC_price_1, SC_price_2, SC_price_3, SC_price_4, SC_price_5, SC_price_6, SC_price_7, SC_price_8};

		String SC_book_id_1 = result[start_total+3];
		String SC_book_id_2 = result[start_total+7];;
		String SC_book_id_3= result[start_total+11];
		String SC_book_id_4= result[start_total+15];
		String SC_book_id_5= result[start_total+19];
		String SC_book_id_6= result[start_total+23];
		String SC_book_id_7= result[start_total+27];
		String SC_book_id_8= result[start_total+31];	
		
		String SC_priceALL_1 = "0";
		String SC_priceALL_2 = "0";
		String SC_priceALL_3 = "0";
		String SC_priceALL_4 = "0";
		String SC_priceALL_5 = "0";
		String SC_priceALL_6 = "0";
		String SC_priceALL_7 = "0";
		String SC_priceALL_8 = "0";
		
		String[] SC_priceALL_list = {SC_priceALL_1, SC_priceALL_2, SC_priceALL_3, SC_priceALL_4, SC_priceALL_5, SC_priceALL_6, SC_priceALL_7, SC_priceALL_8};
		
		for(int i=0; i<8; i++) {
			try {
				double  num  =   Double.parseDouble(SC_num_list[i]); 
				double  price   =   Double.parseDouble(SC_price_list[i]);
				double all_price = num*price;
				BigDecimal b = new BigDecimal(all_price);
				SC_priceALL_list[i] = b.setScale(2,BigDecimal.ROUND_HALF_UP).doubleValue()+"";
			}catch(Exception e){
				SC_priceALL_list[i]=null;
			}
		}
		

		shoppingCart_state result_json = new shoppingCart_state();
		result_json.setSC_book_1(SC_book_1);
		result_json.setSC_book_2(SC_book_2);
		result_json.setSC_book_3(SC_book_3);
		result_json.setSC_book_4(SC_book_4);
		result_json.setSC_book_5(SC_book_5);
		result_json.setSC_book_6(SC_book_6);
		result_json.setSC_book_7(SC_book_7);
		result_json.setSC_book_8(SC_book_8);
		
		result_json.setSC_book_id_1(SC_book_id_1);
		result_json.setSC_book_id_2(SC_book_id_2);
		result_json.setSC_book_id_3(SC_book_id_3);
		result_json.setSC_book_id_4(SC_book_id_4);
		result_json.setSC_book_id_5(SC_book_id_5);
		result_json.setSC_book_id_6(SC_book_id_6);
		result_json.setSC_book_id_7(SC_book_id_7);
		result_json.setSC_book_id_8(SC_book_id_8);
		
		result_json.setSC_num_1(SC_num_1);
		result_json.setSC_num_2(SC_num_2);
		result_json.setSC_num_3(SC_num_3);
		result_json.setSC_num_4(SC_num_4);
		result_json.setSC_num_5(SC_num_5);
		result_json.setSC_num_6(SC_num_6);
		result_json.setSC_num_7(SC_num_7);
		result_json.setSC_num_8(SC_num_8);
		
		result_json.setSC_price_1(SC_price_1);
		result_json.setSC_price_2(SC_price_2);
		result_json.setSC_price_3(SC_price_3);
		result_json.setSC_price_4(SC_price_4);
		result_json.setSC_price_5(SC_price_5);
		result_json.setSC_price_6(SC_price_6);
		result_json.setSC_price_7(SC_price_7);
		result_json.setSC_price_8(SC_price_8);
		
		result_json.setSC_priceALL_1(SC_priceALL_list[0]);
		result_json.setSC_priceALL_2(SC_priceALL_list[1]);
		result_json.setSC_priceALL_3(SC_priceALL_list[2]);
		result_json.setSC_priceALL_4(SC_priceALL_list[3]);
		result_json.setSC_priceALL_5(SC_priceALL_list[4]);
		result_json.setSC_priceALL_6(SC_priceALL_list[5]);
		result_json.setSC_priceALL_7(SC_priceALL_list[6]);
		result_json.setSC_priceALL_8(SC_priceALL_list[7]);
		
		String state = JSON.toJSONString(result_json);
		out.write(state);
			
		
				
				

		// 打印出檢查
		//System.out.println(info);
		// 返回給前端
		//out.write(info);
	}
 
}
