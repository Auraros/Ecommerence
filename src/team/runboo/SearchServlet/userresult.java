package team.runboo.SearchServlet;

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


import team.runboo.DataBase.*;
import team.runboo.UserServlet.userlikes_state;


@WebServlet("/userresult")
public class userresult extends HttpServlet{
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
		
//		String userid = request.getParameter("userid");
		String userresultpage = request.getParameter("bookreslutpage");
		int page = Integer.parseInt(userresultpage);
		int start_all_bookid = 0;
		int start_userkid = start_all_bookid + (page-1)*8;
		
		
//		String[] book_id_list = {books_id_1, books_id_2, books_id_3, books_id_4, books_id_5, books_id_6, books_id_7, books_id_8};
//		String[] name_list = {name_1,name_2,name_3,name_4,name_5,name_6,name_7,name_8};
//		String[] author_list = {author_1, author_2, author_3, author_4, author_5, author_6, author_7, author_8};
//		String[] kind_list = {kind_1,kind_2,kind_3,kind_4,kind_5,kind_6,kind_7,kind_8};
//		String[] press_list = {press_1, press_2, press_3, press_4, press_5,press_6, press_7,press_8};
//		String[] press_date_list = {press_date_1, press_date_2, press_date_3, press_date_4, press_date_5, press_date_6, press_date_7, press_date_8};
//		String[] price_list = {price_1, price_2, price_3, price_4, price_5, price_6,price_7, price_8};
//		String[] merchant_list = {merchant_1, merchant_2, merchant_3,merchant_4, merchant_5, merchant_6, merchant_7, merchant_8};
		
		
		String[] users_id_list = new String[8];
		String[] nickname_list = new String[8];
		String[] real_name_list = new String[8];
		String[] id_card_list =  new String[8];
		String[] phone_number_list = new String[8];
		String[] email_list = new String[8];
		String[] birthday_list = new String[8];
		String[] sex_list = new String[8];
		String[] address_list = new String[8];
		String[] price_list = new String[8];
		
		databasefuntion2  user_date = new databasefuntion2 ();
		databasefuntion  user_imfo = new databasefuntion();
		String[] phones = user_date.obtain_user_phone();
		
		
		
		for(int i=0; i<8; i++) {
			int user_id_int = start_userkid + i;
			if(phones[user_id_int] == null) {
				break;
			}else {
				String[] imformation = user_imfo.obtain_user_information(phones[user_id_int]);
				users_id_list[i] = user_id_int+"";
				nickname_list[i] = imformation[0];
				real_name_list[i] = imformation[1];
				sex_list[i] = imformation[2];
				phone_number_list[i] = imformation[3];
				email_list[i] = imformation[4];
				id_card_list[i] = imformation[7];
				birthday_list[i] = imformation[8];
				address_list[i] = imformation[9];
				price_list[i] = imformation[10];

				
				
			}
		}
		
		
		

		
		userresult_state result_json = new userresult_state();
		result_json.setAddress_1(address_list[0]);
		result_json.setAddress_2(address_list[1]);
		result_json.setAddress_3(address_list[2]);
		result_json.setAddress_4(address_list[3]);
		result_json.setAddress_5(address_list[4]);
		result_json.setAddress_6(address_list[5]);
		result_json.setAddress_7(address_list[6]);
		result_json.setAddress_8(address_list[7]);

		
		result_json.setBirthday_1(birthday_list[0]);
		result_json.setBirthday_2(birthday_list[1]);
		result_json.setBirthday_3(birthday_list[2]);
		result_json.setBirthday_4(birthday_list[3]);
		result_json.setBirthday_5(birthday_list[4]);
		result_json.setBirthday_6(birthday_list[5]);
		result_json.setBirthday_7(birthday_list[6]);
		result_json.setBirthday_8(birthday_list[7]);
		
		result_json.setEmail_1(email_list[0]);
		result_json.setEmail_2(email_list[1]);
		result_json.setEmail_3(email_list[2]);
		result_json.setEmail_4(email_list[3]);
		result_json.setEmail_5(email_list[4]);
		result_json.setEmail_6(email_list[5]);
		result_json.setEmail_7(email_list[6]);
		result_json.setEmail_8(email_list[7]);
		
		result_json.setId_card_1(id_card_list[0]);
		result_json.setId_card_2(id_card_list[1]);
		result_json.setId_card_3(id_card_list[2]);
		result_json.setId_card_4(id_card_list[3]);
		result_json.setId_card_5(id_card_list[4]);
		result_json.setId_card_6(id_card_list[5]);
		result_json.setId_card_7(id_card_list[6]);
		result_json.setId_card_8(id_card_list[7]);
		
		result_json.setNickname_1(nickname_list[0]);
		result_json.setNickname_2(nickname_list[1]);
		result_json.setNickname_3(nickname_list[2]);
		result_json.setNickname_4(nickname_list[3]);
		result_json.setNickname_5(nickname_list[4]);
		result_json.setNickname_6(nickname_list[5]);
		result_json.setNickname_7(nickname_list[6]);
		result_json.setNickname_8(nickname_list[7]);
		
		result_json.setPhone_number_1(phone_number_list[0]);
		result_json.setPhone_number_2(phone_number_list[1]);
		result_json.setPhone_number_3(phone_number_list[2]);
		result_json.setPhone_number_4(phone_number_list[3]);
		result_json.setPhone_number_5(phone_number_list[4]);
		result_json.setPhone_number_6(phone_number_list[5]);
		result_json.setPhone_number_7(phone_number_list[6]);
		result_json.setPhone_number_8(phone_number_list[7]);
		

		result_json.setPrice_1(price_list[0]);
		result_json.setPrice_2(price_list[1]);
		result_json.setPrice_3(price_list[2]);
		result_json.setPrice_4(price_list[3]);
		result_json.setPrice_5(price_list[4]);
		result_json.setPrice_6(price_list[5]);
		result_json.setPrice_7(price_list[6]);
		result_json.setPrice_8(price_list[7]);
		
		result_json.setReal_name_1(real_name_list[0]);
		result_json.setReal_name_2(real_name_list[1]);
		result_json.setReal_name_3(real_name_list[2]);
		result_json.setReal_name_4(real_name_list[3]);
		result_json.setReal_name_5(real_name_list[4]);
		result_json.setReal_name_6(real_name_list[5]);
		result_json.setReal_name_7(real_name_list[6]);
		result_json.setReal_name_8(real_name_list[7]);
		
		result_json.setSex_1(sex_list[0]);
		result_json.setSex_2(sex_list[1]);
		result_json.setSex_3(sex_list[2]);
		result_json.setSex_4(sex_list[3]);
		result_json.setSex_5(sex_list[4]);
		result_json.setSex_6(sex_list[5]);
		result_json.setSex_7(sex_list[6]);
		result_json.setSex_8(sex_list[7]);
		
		result_json.setUsers_id_1(users_id_list[0]);
		result_json.setUsers_id_2(users_id_list[1]);
		result_json.setUsers_id_3(users_id_list[2]);
		result_json.setUsers_id_4(users_id_list[3]);
		result_json.setUsers_id_5(users_id_list[4]);
		result_json.setUsers_id_6(users_id_list[5]);
		result_json.setUsers_id_7(users_id_list[6]);
		result_json.setUsers_id_8(users_id_list[7]);
		
		
		String state = JSON.toJSONString(result_json);
		out.write(state);
	}
}