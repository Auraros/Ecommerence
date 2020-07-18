package team.runboo.DataBase;

import java.math.BigDecimal;
import java.sql.*;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import oracle.jdbc.internal.OracleTypes;  
import oracle.jdbc.oracore.OracleType;  


public class databasefuntion {

	//JDBC驱动名及数据库URL
	static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://localhost:3306/ecommerence?useSSL=false&serverTimezone=UTC";
	
	//数据的用户名和密码
	static final String USER = "root";
	static final String PASS = "550909";
	
	//登录检查函数，用于检查用户登录账号密码是否错误
	//返回：true / false
	public String login_check(String Name, String PassWords) {
		Connection conn = null;
		Statement stmt = null;
		
		CallableStatement  ps = null;
		int insertResult = 2;
		try {
			// 注册JDBC驱动
			Class.forName(JDBC_DRIVER);
			
			//打开链接
			System.out.println("链接数据库...");
			conn = DriverManager.getConnection(DB_URL, USER, PASS);
			
			//执行查询
			System.out.println("实例化Statement对象...");
			stmt = conn.createStatement();
			conn.setAutoCommit(false);
			ps = conn.prepareCall("call judge_password(?,?,?);");
			
			ps.setString(1, Name);
			ps.setString(2, PassWords);
			
			ps.registerOutParameter(3, Types.INTEGER);
//			System.out.println("zhe2");
			
		    ps.execute() ;
//		    System.out.println("zhe");
		    insertResult = ps.getInt(3);
		    System.out.println(insertResult);
		    stmt.close();
            conn.close();
		}catch(SQLException se){
			// 处理 JDBC 错误
			se.printStackTrace();
			System.out.println(4);
		}catch(Exception e){
			// 处理 Class.forName 错误
			e.printStackTrace();
			System.out.println(5);
		}finally{
			// 关闭资源
			try{
				if(stmt!=null) stmt.close();
			}catch(SQLException se2){
			}// 什么都不做
			try{
				if(conn!=null) conn.close();
			}catch(SQLException se){
				se.printStackTrace();
			}
			System.out.println(6);
		}
		if (insertResult == 0) {
			return "false";
			}
		else {
			return "true";}
		}
	
	//登录检查函数，用于检查用户登录账号密码是否错误
	//返回：true / false
	public String adminlogin_check(String Name, String PassWords) {
			Connection conn = null;
			Statement stmt = null;
			
			CallableStatement  ps = null;
			int insertResult = 2;
			try {
				// 注册JDBC驱动
				Class.forName(JDBC_DRIVER);
				
				//打开链接
				System.out.println("链接数据库...");
				conn = DriverManager.getConnection(DB_URL, USER, PASS);
				
				//执行查询
				System.out.println("实例化Statement对象...");
				stmt = conn.createStatement();
				conn.setAutoCommit(false);
				ps = conn.prepareCall("call  judge_ad_password(?,?,?);");
				
				ps.setString(1, Name);
				ps.setString(2, PassWords);
				
				ps.registerOutParameter(3, Types.INTEGER);
//				System.out.println("zhe2");
				
			    ps.execute() ;
//			    System.out.println("zhe");
			    insertResult = ps.getInt(3);
			    System.out.println(insertResult);
			    stmt.close();
	            conn.close();
			}catch(SQLException se){
				// 处理 JDBC 错误
				se.printStackTrace();
				System.out.println(4);
			}catch(Exception e){
				// 处理 Class.forName 错误
				e.printStackTrace();
				System.out.println(5);
			}finally{
				// 关闭资源
				try{
					if(stmt!=null) stmt.close();
				}catch(SQLException se2){
				}// 什么都不做
				try{
					if(conn!=null) conn.close();
				}catch(SQLException se){
					se.printStackTrace();
				}
				System.out.println(6);
			}
			if (insertResult == 0) {
				return "false";
				}
			else {
				return "true";}
			}
	

	//普通用户注册函数，用于对普通用户信息
	//返回 true / false
	public String register_in(String nickname,String real_name,String sex,String phone_number,String email,String password,double balance) {
		Connection conn = null;
		Statement stmt = null;
		
		CallableStatement  ps = null;
		int insertResult = 2;
		try {
			// 注册JDBC驱动
			Class.forName(JDBC_DRIVER);
			
			//打开链接
			System.out.println("链接数据库...");
			conn = DriverManager.getConnection(DB_URL, USER, PASS);
			
			//执行查询
			System.out.println("实例化Statement对象...");
			stmt = conn.createStatement();
			conn.setAutoCommit(false);
			ps = conn.prepareCall("call create_user_cart_favorite(?,?,?,?,?,?,?);");
			ps.setString(1, nickname);
			ps.setString(2, real_name);
			ps.setString(3, sex);
			ps.setString(4, phone_number);
			ps.setString(5, email);
			ps.setString(6, password);
			ps.setDouble(7, balance);
			
//			System.out.println("zhe2");
		    ps.execute();
//		    System.out.println("zhe");
		    stmt.close();
            conn.close();
            System.out.println("注册成功");
            return "true";
		}catch(SQLException se){
			// 处理 JDBC 错误
			se.printStackTrace();
			System.out.println(4);
		}catch(Exception e){
			// 处理 Class.forName 错误
			e.printStackTrace();
			System.out.println(5);
		}finally{
			// 关闭资源
			try{
				if(stmt!=null) stmt.close();
			}catch(SQLException se2){
			}// 什么都不做
			try{
				if(conn!=null) conn.close();
			}catch(SQLException se){
				se.printStackTrace();
			}
			System.out.println(6);
		}
		if (insertResult == 0) {
			return "false";}
		else
			return "true";
	}
	
	//管理员用户注册函数
	public String adminregister_in(String birthday_date,String address,String nickname,String real_name,String sex,String ad_phone_number,String email,String  password,String  head_portraid,String id_card) {
		Connection conn = null;
		Statement stmt = null;
		
		CallableStatement  ps = null;
		int insertResult = 2;
		try {
			// 注册JDBC驱动
			Class.forName(JDBC_DRIVER);
			
			//打开链接
			System.out.println("链接数据库...");
			conn = DriverManager.getConnection(DB_URL, USER, PASS);
			

	        SimpleDateFormat dateFormatHiddenHour = new SimpleDateFormat("yyyy-MM-dd");   
	        java.sql.Date date = null;
	        try {       
	            String s = dateFormatHiddenHour.format(dateFormatHiddenHour.parse(birthday_date));    
	            date = java.sql.Date.valueOf(s);   
	        } catch (ParseException e) {  
	            // TODO Auto-generated catch block    
	            e.printStackTrace();    

	        }   
			//执行查询
			System.out.println("实例化Statement对象...");
			stmt = conn.createStatement();
			conn.setAutoCommit(false);
			ps = conn.prepareCall("call create_user_cart_favorite(?,?,?,?,?,?,?,?,?,?);");
			ps.setDate(1,date); 
			ps.setString(2, address);
			ps.setString(3, nickname);
			ps.setString(4, real_name);
			ps.setString(5, sex);
			ps.setString(6, ad_phone_number);
			ps.setString(7, email);
			ps.setString(8, password);
			ps.setString(9, head_portraid);
			ps.setString(10, id_card);
			
//			System.out.println("zhe2");
		    ps.execute() ;
//		    System.out.println("zhe");
		    stmt.close();
            conn.close();
            System.out.println("注册成功");
            return "true";
		}catch(SQLException se){
			// 处理 JDBC 错误
			se.printStackTrace();
			System.out.println(4);
		}catch(Exception e){
			// 处理 Class.forName 错误
			e.printStackTrace();
			System.out.println(5);
		}finally{
			// 关闭资源
			try{
				if(stmt!=null) stmt.close();
			}catch(SQLException se2){
			}// 什么都不做
			try{
				if(conn!=null) conn.close();
			}catch(SQLException se){
				se.printStackTrace();
			}
			System.out.println(6);
		}
		if (insertResult == 0) {
			return "false";}
		else
			return "true";
	}
	
	//得到用户名函数，输入手机号码或者邮箱，得到用户昵称
	public String obtain_nickname(String phone_or_email) {
		Connection conn = null;
		Statement stmt = null;
		String nickname = "";
		CallableStatement  ps = null;
		try {
			// 注册JDBC驱动
			Class.forName(JDBC_DRIVER);
			
			//打开链接
			System.out.println("链接数据库...");
			conn = DriverManager.getConnection(DB_URL, USER, PASS);
			
			//执行查询
			System.out.println("实例化Statement对象...");
			stmt = conn.createStatement();
			conn.setAutoCommit(false);
			ps = conn.prepareCall("call obtain_nickname(?,?);");
			ps.setString(1, phone_or_email);
			ps.setString(2,  nickname);
		    ps.execute() ;
		    nickname = ps.getString(2);
		    System.out.println(nickname);
		    stmt.close();
            conn.close();
		}catch(SQLException se){
			// 处理 JDBC 错误
			se.printStackTrace();
			System.out.println(4);
		}catch(Exception e){
			// 处理 Class.forName 错误
			e.printStackTrace();
			System.out.println(5);
		}finally{
			// 关闭资源
			try{
				if(stmt!=null) stmt.close();
			}catch(SQLException se2){
			}// 什么都不做
			try{
				if(conn!=null) conn.close();
			}catch(SQLException se){
				se.printStackTrace();
			}
			System.out.println(6);
		}
		return nickname;
	}
	
	//得到用户名函数，输入手机号码或者邮箱，得到用户昵称
		public String obtain_ad_nickname(String phone_or_email) {
			Connection conn = null;
			Statement stmt = null;
			String nickname = "";
			CallableStatement  ps = null;
			try {
				// 注册JDBC驱动
				Class.forName(JDBC_DRIVER);
				
				//打开链接
				System.out.println("链接数据库...");
				conn = DriverManager.getConnection(DB_URL, USER, PASS);
				
				//执行查询
				System.out.println("实例化Statement对象...");
				stmt = conn.createStatement();
				conn.setAutoCommit(false);
				ps = conn.prepareCall("call obtain_ad_nickname(?,?);");
				ps.setString(1, phone_or_email);
				ps.setString(2,  nickname);
			    ps.execute() ;
			    nickname = ps.getString(2);
			    System.out.println(nickname);
			    stmt.close();
	            conn.close();
			}catch(SQLException se){
				// 处理 JDBC 错误
				se.printStackTrace();
				System.out.println(4);
			}catch(Exception e){
				// 处理 Class.forName 错误
				e.printStackTrace();
				System.out.println(5);
			}finally{
				// 关闭资源
				try{
					if(stmt!=null) stmt.close();
				}catch(SQLException se2){
				}// 什么都不做
				try{
					if(conn!=null) conn.close();
				}catch(SQLException se){
					se.printStackTrace();
				}
				System.out.println(6);
			}
			return nickname;
		}
	
	//根据用户的手机号码或者邮箱得到用户的所有信息
	public String[] obtain_user_information(String phone_or_email) {
		Connection conn = null;
		Statement stmt = null;
		String OutString = "";
		String nickname = "";
		String real_name = "";
		String sex = "";
		String phone_number = "";
		String email = "";
		String password = "";
		String date = "";
		String head_portrait = "";
		String id_card = "";
//		String birthday = "";
		String address = "";
		BigDecimal aDouble =new BigDecimal(1.22);
		BigDecimal balance = new BigDecimal("1.22");
		CallableStatement  ps = null;
		
		SimpleDateFormat dateFormatHiddenHour = new SimpleDateFormat("yyyy-MM-dd");   
        java.sql.Date birthday  = null;
        try {       
            String s = dateFormatHiddenHour.format(dateFormatHiddenHour.parse("0000-00-00"));    
            birthday = java.sql.Date.valueOf(s);   
        } catch (ParseException e) {  
            // TODO Auto-generated catch block    
            e.printStackTrace();    

        }   
		try {
			// 注册JDBC驱动
			Class.forName(JDBC_DRIVER);
			
			//打开链接
			System.out.println("链接数据库...");
			conn = DriverManager.getConnection(DB_URL, USER, PASS);
			
			//执行查询
			System.out.println("实例化Statement对象...");
			stmt = conn.createStatement();
			conn.setAutoCommit(false);
			ps = conn.prepareCall("call obtain_user_information(?,?,?,?,?,?,?,?,?,?,?,?);");
			ps.setString(1, phone_or_email);
			ps.setString(2,  nickname);
			ps.setString(3,  real_name);
			ps.setString(4,  sex);
			ps.setString(5,  phone_number);
			ps.setString(6,  email);
			ps.setString(7,  password);
			ps.setString(8,  head_portrait);
			ps.setString(9,  id_card);
			ps.setDate(10,  birthday);
			ps.setString(11,  address);
			ps.setBigDecimal(12,  balance);

		    ps.execute();
//		    System.out.println("zhe");
		    nickname = ps.getString(2);
		    real_name = ps.getString(3);
		    sex = ps.getString(4);
		    phone_number = ps.getString(5);
		    email = ps.getString(6);
		    password = ps.getString(7);
		    head_portrait = ps.getString(8);
		    id_card = ps.getString(9);
		    birthday = ps.getDate(10);
		    address = ps.getString(11);
		    balance = ps.getBigDecimal(12);
		    
		    //将Date格式转为string格式
		    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
		    date = simpleDateFormat.format(birthday);
		    
		    //将
		    OutString=balance.toString(); 
		    
		    stmt.close();
            conn.close();
		}catch(SQLException se){
			// 处理 JDBC 错误
			se.printStackTrace();
			System.out.println(4);
		}catch(Exception e){
			// 处理 Class.forName 错误
			e.printStackTrace();
			System.out.println(5);
		}finally{
			// 关闭资源
			try{
				if(stmt!=null) stmt.close();
			}catch(SQLException se2){
			}// 什么都不做
			try{
				if(conn!=null) conn.close();
			}catch(SQLException se){
				se.printStackTrace();
			}
			System.out.println(6);
		}
		String[] arr = {nickname, real_name, sex, phone_number, email, password, head_portrait, id_card, date, address, OutString};
		return arr;
	}
	
	//根据用户的手机号码或者邮箱得到用户的所有信息
	public String[] obtain_admin_information(String phone_or_email) {
		Connection conn = null;
		Statement stmt = null;
		String OutString = "";
		String nickname = "";
		String real_name = "";
		String sex = "";
		String phone_number = "";
		String email = "";
		String password = "";
		String date = "";
		String head_portrait = "";
		String id_card = "";
//			String birthday = "";
		String address = "";
		BigDecimal aDouble =new BigDecimal(1.22);
		BigDecimal balance = new BigDecimal("1.22");
		CallableStatement  ps = null;
		
		SimpleDateFormat dateFormatHiddenHour = new SimpleDateFormat("yyyy-MM-dd");   
        java.sql.Date birthday  = null;
        try {       
            String s = dateFormatHiddenHour.format(dateFormatHiddenHour.parse("0000-00-00"));    
            birthday = java.sql.Date.valueOf(s);   
        } catch (ParseException e) {  
            // TODO Auto-generated catch block    
            e.printStackTrace();    

        }   
		try {
			// 注册JDBC驱动
			Class.forName(JDBC_DRIVER);
			
			//打开链接
			System.out.println("链接数据库...");
			conn = DriverManager.getConnection(DB_URL, USER, PASS);
			
			//执行查询
			System.out.println("实例化Statement对象...");
			stmt = conn.createStatement();
			conn.setAutoCommit(false);
			ps = conn.prepareCall("call obtain_admin_information(?,?,?,?,?,?,?,?,?,?,?);");
			ps.setString(1, phone_or_email);
			ps.setString(2,  nickname);
			ps.setString(3,  real_name);
			ps.setString(4,  sex);
			ps.setString(5,  phone_number);
			ps.setString(6,  email);
			ps.setString(7,  password);
			ps.setString(8,  head_portrait);
			ps.setString(9,  id_card);
			ps.setDate(10,  birthday);
			ps.setString(11,  address);
//			ps.setBigDecimal(12,  balance);

		    ps.execute();
//			    System.out.println("zhe");
		    nickname = ps.getString(2);
		    real_name = ps.getString(3);
		    sex = ps.getString(4);
		    phone_number = ps.getString(5);
		    email = ps.getString(6);
		    password = ps.getString(7);
		    head_portrait = ps.getString(8);
		    id_card = ps.getString(9);
		    birthday = ps.getDate(10);
		    address = ps.getString(11);
//		    balance = ps.getBigDecimal(12);
		    
		    //将Date格式转为string格式
		    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
		    date = simpleDateFormat.format(birthday);
		    
		    //将
		    OutString=balance.toString(); 
		    
		    stmt.close();
            conn.close();
		}catch(SQLException se){
			// 处理 JDBC 错误
			se.printStackTrace();
			System.out.println(4);
		}catch(Exception e){
			// 处理 Class.forName 错误
			e.printStackTrace();
			System.out.println(5);
		}finally{
			// 关闭资源
			try{
				if(stmt!=null) stmt.close();
			}catch(SQLException se2){
			}// 什么都不做
			try{
				if(conn!=null) conn.close();
			}catch(SQLException se){
				se.printStackTrace();
			}
			System.out.println(6);
		}
		String[] arr = {nickname, real_name, sex, phone_number, email, password, head_portrait, id_card, date, address, OutString};
		return arr;
	}
	
	
	//创建商家
	public String create_merchant(String origin) {
		Connection conn = null;
		Statement stmt = null;
		int a = 0;
		CallableStatement  ps = null;
		try {
			// 注册JDBC驱动
			Class.forName(JDBC_DRIVER);
			
			//打开链接
			System.out.println("链接数据库...");
			conn = DriverManager.getConnection(DB_URL, USER, PASS);
			
			//执行查询
			System.out.println("实例化Statement对象...");
			stmt = conn.createStatement();
			conn.setAutoCommit(false);
			ps = conn.prepareCall("call  create_merchant(?);");
			
			ps.setString(1, origin);

		    ps.execute() ;
		    stmt.close();
            conn.close();
            a = 1;
            
		}catch(SQLException se){
			// 处理 JDBC 错误
			se.printStackTrace();
			System.out.println(4);
		}catch(Exception e){
			// 处理 Class.forName 错误
			e.printStackTrace();
			System.out.println(5);
		}finally{
			// 关闭资源
			try{
				if(stmt!=null) stmt.close();
			}catch(SQLException se2){
			}// 什么都不做
			try{
				if(conn!=null) conn.close();
			}catch(SQLException se){
				se.printStackTrace();
			}
			System.out.println(6);
		}
		if (a == 0) {
			return "false";
		}else {
			return "true";
		}
	}
	
	//创建订单
	public String create_order(String merchant_id, String phone_number, String change_date) {
		Connection conn = null;
		Statement stmt = null;
		int a = 0;
		CallableStatement  ps = null;
		
		//String day = "2020-02-01 00:00:00";
		
		
		SimpleDateFormat dateFormatHiddenHour = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");   
        java.sql.Date day  = null;
        try {       
            String s = dateFormatHiddenHour.format(dateFormatHiddenHour.parse("0000-00-00 00:00:00"));    
            day = java.sql.Date.valueOf(s);   
        } catch (ParseException e) {  
            // TODO Auto-generated catch block    
            e.printStackTrace();    
        }  
		try {
			// 注册JDBC驱动
			Class.forName(JDBC_DRIVER);
			
			//打开链接
			System.out.println("链接数据库...");
			conn = DriverManager.getConnection(DB_URL, USER, PASS);
			
			//执行查询
			System.out.println("实例化Statement对象...");
			stmt = conn.createStatement();
			conn.setAutoCommit(false);
			

			ps = conn.prepareCall("call  create_order(?,?,?);");
			
			ps.setString(1, merchant_id);
			ps.setString(2, phone_number);
			ps.setDate(1, day);

		    ps.execute() ;
		    stmt.close();
            conn.close();
            a = 1;
            
		}catch(SQLException se){
			// 处理 JDBC 错误
			se.printStackTrace();
			System.out.println(4);
		}catch(Exception e){
			// 处理 Class.forName 错误
			e.printStackTrace();
			System.out.println(5);
		}finally{
			// 关闭资源
			try{
				if(stmt!=null) stmt.close();
			}catch(SQLException se2){
			}// 什么都不做
			try{
				if(conn!=null) conn.close();
			}catch(SQLException se){
				se.printStackTrace();
			}
			System.out.println(6);
		}
		if (a == 0) {
			return "false";
		}else {
			return "true";
		}
	}
	
	public String obtain_user_phone_number(String userid){
		Connection conn = null;
		Statement stmt = null;
		String phone_numbers = "";
		int a = 0;
		CallableStatement  ps = null;
		try {
			// 注册JDBC驱动
			Class.forName(JDBC_DRIVER);
			
			//打开链接
			System.out.println("链接数据库...");
			conn = DriverManager.getConnection(DB_URL, USER, PASS);
			
			//执行查询
			System.out.println("实例化Statement对象...");
			stmt = conn.createStatement();
			conn.setAutoCommit(false);

			ps = conn.prepareCall("call obtain_user_phone_number(?,?);");
			ps.setString(1, userid);
			ps.setString(2, phone_numbers);
			
				
		    ps.execute() ;
		  
		    phone_numbers = ps.getString(2);
		  
		    stmt.close();
            conn.close();
            
            
		}catch(SQLException se){
			// 处理 JDBC 错误
			se.printStackTrace();
			System.out.println(4);
		}catch(Exception e){
			// 处理 Class.forName 错误
			e.printStackTrace();
			System.out.println(5);
		}finally{
			// 关闭资源
			try{
				if(stmt!=null) stmt.close();
			}catch(SQLException se2){
			}// 什么都不做
			try{
				if(conn!=null) conn.close();
			}catch(SQLException se){
				se.printStackTrace();
			}
			System.out.println(6);
		}
	return phone_numbers;
	}
	
	public String[] obtain_books(int books_id){
		String[] result = new String[11];
		Connection conn = null;
		Statement stmt = null;
		String Authors = "";
		String names = "";
		String briefs  ="";
		String presss = "";
		String kind = "";
		String merchant_id = "";
		String picture = "";
		BigDecimal aDouble =new BigDecimal(1.22);
		BigDecimal prices = new BigDecimal("1.22");
		
		
		int a = 0;
		CallableStatement  ps = null;
		try {
			// 注册JDBC驱动
			Class.forName(JDBC_DRIVER);
			
			//打开链接
			System.out.println("链接数据库...");
			conn = DriverManager.getConnection(DB_URL, USER, PASS);
			
			//执行查询
			System.out.println("实例化Statement对象...");
			stmt = conn.createStatement();
			conn.setAutoCommit(false);
			
			int i=0;
//			
//			long time = System.currentTimeMillis();
//			java.sql.Date date = new java.sql.Date(time);
			String date = "";
			
			ps = conn.prepareCall("call obtain_books(?,?,?,?,?,?,?,?,?,?);");
			ps.setInt(1, books_id);
			ps.setString(2, Authors);
			ps.setString(3, names);
			ps.setString(4, briefs);
			ps.setString(5, presss);
			ps.setBigDecimal(6, prices);
			ps.setString(7, picture);
			ps.setString(8, kind);
			ps.setInt(9, i);
			ps.setString(10, date);
		    ps.execute();
		  
		    Authors = ps.getString(2);
		    names = ps.getString(3);
		    briefs = ps.getString(4);
		    presss = ps.getString(5);
		    prices = ps.getBigDecimal(6);
		    picture = ps.getString(7);
		    kind = ps.getString(8);
		    i = ps.getInt(9);
		    date = ps.getString(10);
		    
		    stmt.close();
            conn.close();
            
            String date_str = date +"";
            merchant_id = i +"";
            String price_str = prices +"";
            result[0]=Authors;
            result[1]=names;
            result[2]=briefs;
            result[3]=presss;
            result[4]=price_str;
            result[5] = picture;
            result[6] = date_str;
            result[7] = kind ;
            result[8] = merchant_id;
            
		}catch(SQLException se){
			// 处理 JDBC 错误
			se.printStackTrace();
			System.out.println(4);
		}catch(Exception e){
			// 处理 Class.forName 错误
			e.printStackTrace();
			System.out.println(5);
		}finally{
			// 关闭资源
			try{
				if(stmt!=null) stmt.close();
			}catch(SQLException se2){
			}// 什么都不做
			try{
				if(conn!=null) conn.close();
			}catch(SQLException se){
				se.printStackTrace();
			}
			System.out.println(6);
		}
	return result;
	}
	
	public String user_balance(String phone_number){
		String result = "";
		Connection conn = null;
		Statement stmt = null;
		BigDecimal aDouble =new BigDecimal(1.22);
		BigDecimal balance = new BigDecimal("1.22");
		
		
		int a = 0;
		CallableStatement  ps = null;
		try {
			// 注册JDBC驱动
			Class.forName(JDBC_DRIVER);
			
			//打开链接
			System.out.println("链接数据库...");
			conn = DriverManager.getConnection(DB_URL, USER, PASS);
			
			//执行查询
			System.out.println("实例化Statement对象...");
			stmt = conn.createStatement();
			conn.setAutoCommit(false);
			
			ps = conn.prepareCall("call user_balance(?,?);");
			ps.setString(1, phone_number);
			ps.setBigDecimal(2, balance);

				
		    ps.execute() ;
		  
		    balance = ps.getBigDecimal(2);

		    
		    stmt.close();
            conn.close();
            
            result = balance +"";
            
           
            
		}catch(SQLException se){
			// 处理 JDBC 错误
			se.printStackTrace();
			System.out.println(4);
		}catch(Exception e){
			// 处理 Class.forName 错误
			e.printStackTrace();
			System.out.println(5);
		}finally{
			// 关闭资源
			try{
				if(stmt!=null) stmt.close();
			}catch(SQLException se2){
			}// 什么都不做
			try{
				if(conn!=null) conn.close();
			}catch(SQLException se){
				se.printStackTrace();
			}
			System.out.println(6);
		}
	return result;
	}
	

}
