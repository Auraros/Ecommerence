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


@WebServlet("/bookresult")
public class bookresult extends HttpServlet{
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
		

		String bookreslutpage = request.getParameter("bookreslutpage");
		String book = request.getParameter("book");
		String author = request.getParameter("author");
		String merchant_id = request.getParameter("merchant_id");
		String kind = request.getParameter("kind");
		String press = request.getParameter("press");
		String press_date_start = request.getParameter("press_date_start");
		String press_date_end = request.getParameter("press_date_end");
		String price_start = request.getParameter("price_start");
		String price_end = request.getParameter("price_end");
		String result_method = request.getParameter("result_method");
		String result_sort = request.getParameter("result_sort");
		
//		String[] book_id_list = {books_id_1, books_id_2, books_id_3, books_id_4, books_id_5, books_id_6, books_id_7, books_id_8};
//		String[] name_list = {name_1,name_2,name_3,name_4,name_5,name_6,name_7,name_8};
//		String[] author_list = {author_1, author_2, author_3, author_4, author_5, author_6, author_7, author_8};
//		String[] kind_list = {kind_1,kind_2,kind_3,kind_4,kind_5,kind_6,kind_7,kind_8};
//		String[] press_list = {press_1, press_2, press_3, press_4, press_5,press_6, press_7,press_8};
//		String[] press_date_list = {press_date_1, press_date_2, press_date_3, press_date_4, press_date_5, press_date_6, press_date_7, press_date_8};
//		String[] price_list = {price_1, price_2, price_3, price_4, price_5, price_6,price_7, price_8};
//		String[] merchant_list = {merchant_1, merchant_2, merchant_3,merchant_4, merchant_5, merchant_6, merchant_7, merchant_8};
		
		
		
		String[] book_id_list = new String[8];
		String[] name_list = new String[8];
		String[] kind_list = new String[8];
		String[] author_list =  new String[8];
		String[] press_list = new String[8];
		String[] press_date_list = new String[8];
		String[] price_list = new String[8];
		String[] merchant_list = new String[8];
		
		
		int page = Integer.parseInt(bookreslutpage);
		int start_all_bookid = 418;
		int start_bookid = start_all_bookid + page*8;
		databasefuntion2 shoppingCart_C2 = new databasefuntion2();
		
		if(author == null || "".equals(author)) {author = "";}
		if(kind == null || "".equals(kind)) {kind = "";}
		if(press == null || "".equals(press)) {press = "";}
		if(price_start == null || "".equals(price_start)) {price_start = "0";}
		if(price_end == null || "".equals(price_end)) {price_end = "1000";}
		if(book == null || "".equals(book)) {book = "";}
		
		System.out.println(result_method.equals("price"));
		System.out.println(book);
		
		String[] result = new String[10000];
		
		merchant_id = "1";
		
		System.out.println(result_method.equals("book null"));	
		
		if(result_method.equals("books_id") && result_sort.equals("ASC")) {
			result = shoppingCart_C2.obtaion_book_detail_books_id_asc(book, kind, author, merchant_id, press_date_end, price_start, price_end);
			
		}else if(result_method.equals("price") && result_sort.equals("ASC")) {
			System.out.println("price, asc");
			result = shoppingCart_C2.obtaion_book_detail_price_asc(book, kind, author, merchant_id, press_date_end, price_start, price_end);
		}else if(result_method.equals("price") && result_sort.equals("DESC")) {
			result = shoppingCart_C2.obtaion_book_detail_price_desc(book, kind, author, merchant_id, press_date_end, price_start, price_end);
		}else if(result_method.equals("press_date") && result_sort.equals("ASC")) {
			result = shoppingCart_C2.obtaion_book_detail_date_asc(book, kind, author, merchant_id, press_date_end, price_start, price_end);
		}else if (result_method.equals("press_date") && result_sort.equals("DESC")) {
			result = shoppingCart_C2.obtaion_book_detail_date_desc(book, kind, author, merchant_id, press_date_end, price_start, price_end);
		}else if (result_method.equals("books_id") && result_sort.equals("DESC")) {
			result = shoppingCart_C2.obtaion_book_detail_books_id_desc(book, kind, author, merchant_id, press_date_end, price_start, price_end);
		}

		
		int start_index = (page-1)*64;
		for(int i=0; i<8; i++){
			name_list[i] = result[start_index+i];
			author_list[i] = result[start_index+i+1];
			kind_list[i] = result[start_index+i+2];
			press_list[i] = result[start_index+i+3];
			press_date_list[i] = result[start_index+i+4];
			price_list[i] = result[start_index+i+5];
			merchant_list[i] = result[start_index+i+6];
			book_id_list[i] = result[start_index+i+7];
			start_index = start_index + 7;
		}
		
		
//		databasefuntion shoppingCart_C = new databasefuntion();
//		phone_number = shoppingCart_C.obtain_user_phone_number(userid);
//		System.out.println(phone_number);
		
		
		
		
		bookresult_state result_json = new bookresult_state();
		result_json.setAuthor_1(author_list[0]);
		result_json.setAuthor_2(author_list[1]);
		result_json.setAuthor_3(author_list[2]);
		result_json.setAuthor_4(author_list[3]);
		result_json.setAuthor_5(author_list[4]);
		result_json.setAuthor_6(author_list[5]);
		result_json.setAuthor_7(author_list[6]);
		result_json.setAuthor_8(author_list[7]);

		
	
		result_json.setBooks_id_1(book_id_list[0]);
		result_json.setBooks_id_2(book_id_list[1]);
		result_json.setBooks_id_3(book_id_list[2]);
		result_json.setBooks_id_4(book_id_list[3]);
		result_json.setBooks_id_5(book_id_list[4]);
		result_json.setBooks_id_6(book_id_list[5]);
		result_json.setBooks_id_7(book_id_list[6]);
		result_json.setBooks_id_8(book_id_list[7]);
		
		result_json.setKind_1(kind_list[0]);
		result_json.setKind_2(kind_list[1]);
		result_json.setKind_3(kind_list[2]);
		result_json.setKind_4(kind_list[3]);
		result_json.setKind_5(kind_list[4]);
		result_json.setKind_6(kind_list[5]);
		result_json.setKind_7(kind_list[6]);
		result_json.setKind_8(kind_list[7]);

		result_json.setMerchant_1(merchant_list[0]);
		result_json.setMerchant_2(merchant_list[1]);
		result_json.setMerchant_3(merchant_list[2]);
		result_json.setMerchant_4(merchant_list[3]);
		result_json.setMerchant_5(merchant_list[4]);
		result_json.setMerchant_6(merchant_list[5]);
		result_json.setMerchant_7(merchant_list[6]);
		result_json.setMerchant_8(merchant_list[7]);
		
		result_json.setName_1(name_list[0]);
		result_json.setName_2(name_list[1]);
		result_json.setName_3(name_list[2]);
		result_json.setName_4(name_list[3]);
		result_json.setName_5(name_list[4]);
		result_json.setName_6(name_list[5]);
		result_json.setName_7(name_list[6]);
		result_json.setName_8(name_list[7]);
		
		result_json.setPress_1(press_list[0]);
		result_json.setPress_2(press_list[1]);
		result_json.setPress_3(press_list[2]);
		result_json.setPress_4(press_list[3]);
		result_json.setPress_5(press_list[4]);
		result_json.setPress_6(press_list[5]);
		result_json.setPress_7(press_list[6]);
		result_json.setPress_8(press_list[7]);
		
		result_json.setPress_date_1(press_date_list[0]);
		result_json.setPress_date_2(press_date_list[1]);
		result_json.setPress_date_3(press_date_list[2]);
		result_json.setPress_date_4(press_date_list[3]);
		result_json.setPress_date_5(press_date_list[4]);
		result_json.setPress_date_6(press_date_list[5]);
		result_json.setPress_date_7(press_date_list[6]);
		result_json.setPress_date_8(press_date_list[7]);

		result_json.setPrice_1(price_list[0]);
		result_json.setPrice_2(price_list[1]);
		result_json.setPrice_3(price_list[2]);
		result_json.setPrice_4(price_list[3]);
		result_json.setPrice_5(price_list[4]);
		result_json.setPrice_6(price_list[5]);
		result_json.setPrice_7(price_list[6]);
		result_json.setPrice_8(price_list[7]);
		
		String state = JSON.toJSONString(result_json);
		out.write(state);
	}
}