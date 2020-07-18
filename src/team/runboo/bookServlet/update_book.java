package team.runboo.bookServlet;

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
import team.runboo.bookServlet.book_state;


@WebServlet("/update_book")
public class update_book extends HttpServlet{
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
		String books_id_str = request.getParameter("book_id");
		int books_id = Integer.parseInt(books_id_str);
		
		
		databasefuntion book_C = new databasefuntion();
		String[] result = book_C.obtain_books(books_id);

		
		int start_total = 0;
		
		String author = result[start_total];
		String bookname = result[start_total+1];
		String brief= result[start_total+2];
		String press= result[start_total+3];
		String price= result[start_total+4];
		String picture = result[start_total+5];
		String press_date = result[start_total+6];
		
		book_state result_json = new book_state();
		result_json.setAuthor(author);
		result_json.setBookname(bookname);
		result_json.setBrief(brief);
		result_json.setPress(press);
		result_json.setPrice(price);
		result_json.setResult("true");
		result_json.setPicture(picture);
		result_json.setPress_date(press_date);
	}
}
