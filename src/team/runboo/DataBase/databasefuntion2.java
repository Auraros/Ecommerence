package team.runboo.DataBase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Random;
public class databasefuntion2 {
	
	//JDBC驱动名及数据库URL
	static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://127.0.0.1:3306/ecommerence?useUnicode=true&characterEncoding=UTF-8&serverTimezone=UTC";
	
	//数据的用户名和密码
	static final String USER = "root";
	static final String PASS = "550909";
	
	//得到随机五个课本
	public String[] rand_book() {
		String[] result = new String[10];
		int i = 0;
		try {
		      Class.forName("com.mysql.jdbc.Driver");     //加载MYSQL JDBC驱动程序   
		      //Class.forName("org.gjt.mm.mysql.Driver");
		     System.out.println("Success loading Mysql Driver!");
		    }
		    catch (Exception e) {
		      System.out.print("Error loading Mysql Driver!");
		      e.printStackTrace();
		    }
		    try {
		      Connection connect = DriverManager.getConnection(
		        DB_URL,USER,PASS );
		           //连接URL为   jdbc:mysql//服务器地址/数据库名  ，后面的2个参数分别是登陆用户名和密码
		      System.out.println("Success connect Mysql server!");
		      Statement stmt = connect.createStatement();
		      ResultSet rs = stmt.executeQuery("select name,books_id from books order by rand() limit 5;");   //user 为你表的名称
		while (rs.next()) {
				result[i] = rs.getString("name");
				i = i+1;
				int book_id = rs.getInt("books_id");
				String book_id_char =  String.valueOf(book_id); 
				result[i] = book_id_char;
				i = i+1;
		        System.out.println(rs.getString("name"));
		        System.out.println(rs.getInt("books_id"));
		        //System.out.println(rs.getInt("books_id"));
		      }
		    }
		    catch (Exception e) {
		      System.out.print("get data error!");
		      e.printStackTrace();
		    } 
		return result;
	}
	
	//得到显示用户购物车信息
	public String[] obtain_shoopingCatr(String phone_numbers) {
		String[] result = new String[1000];
		int i = 0;
		try {
		      Class.forName("com.mysql.jdbc.Driver");     //加载MYSQL JDBC驱动程序   
		      //Class.forName("org.gjt.mm.mysql.Driver");
		     System.out.println("Success loading Mysql Driver!");
		    }
		    catch (Exception e) {
		      System.out.print("Error loading Mysql Driver!");
		      e.printStackTrace();
		    }
		    try {
		      Connection connect = DriverManager.getConnection(
		        DB_URL,USER,PASS );
		           //连接URL为   jdbc:mysql//服务器地址/数据库名  ，后面的2个参数分别是登陆用户名和密码
		      System.out.println("Success connect Mysql server!");
		      Statement stmt = connect.createStatement();
		      String sql = "select `name`,`sum`,single_price,add_time,books_id from shopping_cart_view where user_phone=\""+phone_numbers+"\";";
		      System.out.print(sql);
		      ResultSet rs = stmt.executeQuery(sql);   //user 为你表的名称
		while (rs.next()) {
				result[i] = rs.getString("name");
				i = i+1;
				
				result[i] = String.valueOf(rs.getInt("sum")); 
				i = i+1;
				
				result[i] = String.valueOf(rs.getBigDecimal("single_price")); 
				i = i+1;
				
				
				result[i] = String.valueOf(rs.getInt("books_id")); 
				i = i+1;
				
		        System.out.println(rs.getString("name"));
		        System.out.println(rs.getInt("books_id"));
		      }
		    }
		    catch (Exception e) {
		      System.out.print("get data error!");
		      e.printStackTrace();
		    } 
		return result;
	} 
	
	//得到商品购买信息
	public String[] obtain_userby(String phone_numbers) {
		String[] result = new String[1000];
		int i = 0;
		try {
		      Class.forName("com.mysql.jdbc.Driver");     //加载MYSQL JDBC驱动程序   
		      //Class.forName("org.gjt.mm.mysql.Driver");
		     System.out.println("Success loading Mysql Driver!");
		    }
		    catch (Exception e) {
		      System.out.print("Error loading Mysql Driver!");
		      e.printStackTrace();
		    }
		    try {
		      Connection connect = DriverManager.getConnection(
		        DB_URL,USER,PASS );
		           //连接URL为   jdbc:mysql//服务器地址/数据库名  ，后面的2个参数分别是登陆用户名和密码
		      System.out.println("Success connect Mysql server!");
		      Statement stmt = connect.createStatement();
		      String sql = "select `name`,`sum`,single_price,add_time,books_id from shopping_cart_view where user_phone=\""+phone_numbers+"\";";
		      System.out.print(sql);
		      ResultSet rs = stmt.executeQuery(sql);   //user 为你表的名称
		while (rs.next()) {
				result[i] = rs.getString("name");
				i = i+1;
				
				result[i] = String.valueOf(rs.getInt("sum")); 
				i = i+1;
				
				result[i] = String.valueOf(rs.getBigDecimal("single_price")); 
				i = i+1;
				
				
				result[i] = String.valueOf(rs.getInt("books_id")); 
				i = i+1;
				
		        System.out.println(rs.getString("name"));
		        System.out.println(rs.getInt("books_id"));
		      }
		    }
		    catch (Exception e) {
		      System.out.print("get data error!");
		      e.printStackTrace();
		    } 
		return result;
	} 
	
	public String[] obtain_userlike(String phone_numbers) {
		String[] result = new String[1000];
		int i = 0;
		try {
		      Class.forName("com.mysql.jdbc.Driver");     //加载MYSQL JDBC驱动程序   
		      //Class.forName("org.gjt.mm.mysql.Driver");
		     System.out.println("Success loading Mysql Driver!");
		    }
		    catch (Exception e) {
		      System.out.print("Error loading Mysql Driver!");
		      e.printStackTrace();
		    }
		    try {
		      Connection connect = DriverManager.getConnection(
		        DB_URL,USER,PASS );
		           //连接URL为   jdbc:mysql//服务器地址/数据库名  ，后面的2个参数分别是登陆用户名和密码
		      System.out.println("Success connect Mysql server!");
		      Statement stmt = connect.createStatement();
		      String sql = "select books_id,`name`,single_price,user_phone,favor_time,Author from favor_view where user_phone=\""+phone_numbers+"\";";
		      System.out.print(sql);
		      ResultSet rs = stmt.executeQuery(sql);   //user 为你表的名称
		while (rs.next()) {
				result[i] = rs.getString("Author");
				i = i+1;
				
				result[i] = rs.getString("name"); 
				i = i+1;
				
				result[i] = String.valueOf(rs.getBigDecimal("books_id")); 
				i = i+1;
				
				
		        System.out.println(rs.getString("name"));
		        System.out.println(rs.getInt("books_id"));
		      }
		    }
		    catch (Exception e) {
		      System.out.print("get data error!");
		      e.printStackTrace();
		    } 
		return result;
	} 
	
	
	public String[] obtain_user_phone() {
		String[] result = new String[1000];
		int i = 0;
		try {
		      Class.forName("com.mysql.jdbc.Driver");     //加载MYSQL JDBC驱动程序   
		      //Class.forName("org.gjt.mm.mysql.Driver");
		     System.out.println("Success loading Mysql Driver!");
		    }
		    catch (Exception e) {
		      System.out.print("Error loading Mysql Driver!");
		      e.printStackTrace();
		    }
		    try {
		      Connection connect = DriverManager.getConnection(
		        DB_URL,USER,PASS );
		           //连接URL为   jdbc:mysql//服务器地址/数据库名  ，后面的2个参数分别是登陆用户名和密码
		      System.out.println("Success connect Mysql server!");
		      Statement stmt = connect.createStatement();
		      String sql = "select phone_number from user;";
		      System.out.print(sql);
		      ResultSet rs = stmt.executeQuery(sql);   //user 为你表的名称
		while (rs.next()) {
				result[i] = rs.getString("phone_number");
				System.out.println(result[i]);
				i = i+1;
				
		      }
		    }
		    catch (Exception e) {
		      System.out.print("get data error!");
		      e.printStackTrace();
		    } 
		return result;
	} 
	
	public String[] obtain_order(String phone_numbers) {
		String[] result = new String[1000];
		int i = 0;
		try {
		      Class.forName("com.mysql.jdbc.Driver");     //加载MYSQL JDBC驱动程序   
		      //Class.forName("org.gjt.mm.mysql.Driver");
		     System.out.println("Success loading Mysql Driver!");
		    }
		    catch (Exception e) {
		      System.out.print("Error loading Mysql Driver!");
		      e.printStackTrace();
		    }
		    try {
		      Connection connect = DriverManager.getConnection(
		        DB_URL,USER,PASS );
		           //连接URL为   jdbc:mysql//服务器地址/数据库名  ，后面的2个参数分别是登陆用户名和密码
		      System.out.println("Success connect Mysql server!");
		      Statement stmt = connect.createStatement();
		      String sql = "select order_id,`name`,sum,single_price,user_phone,add_time from order_view where user_phone=\""+phone_numbers+"\";";
		      System.out.print(sql);
		      ResultSet rs = stmt.executeQuery(sql);   //user 为你表的名称
		while (rs.next()) {
				result[i] = rs.getString("order_id");
				System.out.println(result[i]);
				i = i+1;
				
				result[i] = rs.getString("name"); 
				i = i+1;
				
				result[i] = String.valueOf(rs.getBigDecimal("sum")); 
				i = i+1;
				
				result[i] = String.valueOf(rs.getBigDecimal("single_price")); 
				i = i+1;
				
				result[i] = rs.getString("add_time"); 
				i = i+1;
		      }
		    }
		    catch (Exception e) {
		      System.out.print("get data error!");
		      e.printStackTrace();
		    } 
		return result;
	} 
	
	public String[] insert_random_price(int books_id) {
		String[] result = new String[1000];
		int i = 0;
		try {
		      Class.forName("com.mysql.cj.jdbc.Driver");     //加载MYSQL JDBC驱动程序   
		      //Class.forName("org.gjt.mm.mysql.Driver");
		     System.out.println("Success loading Mysql Driver!");
		    }
		    catch (Exception e) {
		      System.out.print("Error loading Mysql Driver!");
		      e.printStackTrace();
		    }
		    try {
		      Connection connect = DriverManager.getConnection(
		    		  DB_URL,USER,PASS );
		           //连接URL为   jdbc:mysql//服务器地址/数据库名  ，后面的2个参数分别是登陆用户名和密码
		      System.out.println("Success connect Mysql server!");
		      Statement stmt = connect.createStatement();
		      
		      double price_01 = databasefuntion2.nextDouble(0.0, 200.0);
		      double price = (double)Math.round(price_01*100)/100;
		      String sql = "update books set books.price="+price+" where books_id="+books_id+";";
		      System.out.print(sql);
		      stmt.executeUpdate(sql);   //user 为你表的名称
		      
		      stmt.close();
		    }
		    catch (Exception e) {
		      System.out.print("get data error!");
		      e.printStackTrace();
		    } 
		return result;
	} 
	
	public static double nextDouble(final double min, final double max) {
		return min + ((max - min) * new Random().nextDouble());
	}

	
	public String insert_favor(String books_id, String phone_number, java.util.Date date) {
		String result;
		int a = 0;
		try {
		      Class.forName("com.mysql.cj.jdbc.Driver");     //加载MYSQL JDBC驱动程序   
		      //Class.forName("org.gjt.mm.mysql.Driver");
		     System.out.println("Success loading Mysql Driver!");
		    }
		    catch (Exception e) {
		      System.out.print("Error loading Mysql Driver!");
		      e.printStackTrace();
		    }
		    try {
		      Connection connect = DriverManager.getConnection(
		        DB_URL,USER,PASS );
		           //连接URL为   jdbc:mysql//服务器地址/数据库名  ，后面的2个参数分别是登陆用户名和密码
		      System.out.println("Success connect Mysql server!");
		      Statement stmt = connect.createStatement();
		      
		      DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	          String birthday = df.format(date);
		      
		      double price_01 = databasefuntion2.nextDouble(0.0, 200.0);
		      double price = (double)Math.round(price_01*100)/100;
		      String sql = "insert into favor(books_id,fav_user_phone,favor_date)values(\""+books_id+"\",\""+phone_number+"\",\""+birthday+"\");";
		      System.out.print(sql);
		      stmt.executeUpdate(sql);   //user 为你表的名称
		      
		      stmt.close();
		      a = 1;
		    }
		    catch (Exception e) {
		      System.out.print("get data error!");
		      e.printStackTrace();
		    } 
			if(a==0) {
				return "false";
			}else {
				return "true";
			}    
	} 
	
	
	public String adminregister_in(String birthday_date,String address,String nickname,String real_name,String sex,String ad_phone_number,String email,String  password,String id_card) {
		String result;
		int a = 0;
		try {
		      Class.forName("com.mysql.cj.jdbc.Driver");     //加载MYSQL JDBC驱动程序   
		      //Class.forName("org.gjt.mm.mysql.Driver");
		     System.out.println("Success loading Mysql Driver!");
		    }
		    catch (Exception e) {
		      System.out.print("Error loading Mysql Driver!");
		      e.printStackTrace();
		    }
		    try {
		      Connection connect = DriverManager.getConnection(
		        DB_URL,USER,PASS );
		           //连接URL为   jdbc:mysql//服务器地址/数据库名  ，后面的2个参数分别是登陆用户名和密码
		      System.out.println("Success connect Mysql server!");
		      Statement stmt = connect.createStatement();
		      
//		      DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//	          String birthday = df.format(date);
		      
		      String sql = "insert into administrator(birthday,address,nickname, real_name, sex, ad_phone_number, email, password,  id_card)values(\""+birthday_date+"\",\""+address+"\",\""+nickname+"\",\""+real_name+"\",\""+sex+"\",\""+ad_phone_number+"\",\""+email+"\",\""+password+"\",\""+id_card+"\");";
		      System.out.print(sql);
		      stmt.executeUpdate(sql);   //user 为你表的名称
		      
		      stmt.close();
		      a = 1;
		    }
		    catch (Exception e) {
		      System.out.print("get data error!");
		      e.printStackTrace();
		    } 
			if(a==0) {
				return "false";
			}else {
				return "true";
			}    
	} 
	
	
	public String insert_shoppingCart(String cart_user_phone,  String books_id, java.util.Date buy_date, String buy_sum) {
		String result;
		int a = 0;
		try {
		      Class.forName("com.mysql.cj.jdbc.Driver");     //加载MYSQL JDBC驱动程序   
		      //Class.forName("org.gjt.mm.mysql.Driver");
		     System.out.println("Success loading Mysql Driver!");
		    }
		    catch (Exception e) {
		      System.out.print("Error loading Mysql Driver!");
		      e.printStackTrace();
		    }
		    try {
		      Connection connect = DriverManager.getConnection(
		        DB_URL,USER,PASS );
		           //连接URL为   jdbc:mysql//服务器地址/数据库名  ，后面的2个参数分别是登陆用户名和密码
		      System.out.println("Success connect Mysql server!");
		      Statement stmt = connect.createStatement();
		      
		      DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	          String buy_date_0 = df.format(buy_date);
		      
		      double price_01 = databasefuntion2.nextDouble(0.0, 200.0);
		      double price = (double)Math.round(price_01*100)/100;
		      String sql = "insert into `add`(cart_user_phone,books_id,add_date,add_sum)values(\""+cart_user_phone+"\",\""+books_id+"\",\""+buy_date_0+"\",\""+buy_sum+"\");";
		      System.out.print(sql);
		      stmt.executeUpdate(sql);   //user 为你表的名称
		      
		      stmt.close();
		      a = 1;
		    }
		    catch (Exception e) {
		      System.out.print("get data error!");
		      e.printStackTrace();
		    } 
			if(a==0) {
				return "false";
			}else {
				return "true";
			}    
	} 
	
	
	public String update_user_imformation(String nicknames, String sex,String phone_numbers, String id_cards,  String passwords, String birthdays, String addresss) {
		int i = 0;
		try {
		      Class.forName("com.mysql.cj.jdbc.Driver");     //加载MYSQL JDBC驱动程序   
		      //Class.forName("org.gjt.mm.mysql.Driver");
		     System.out.println("Success loading Mysql Driver!");
		    }
		    catch (Exception e) {
		      System.out.print("Error loading Mysql Driver!");
		      e.printStackTrace();
		    }
		    try {
		      Connection connect = DriverManager.getConnection(
		        DB_URL,USER,PASS );
		           //连接URL为   jdbc:mysql//服务器地址/数据库名  ，后面的2个参数分别是登陆用户名和密码
		      System.out.println("Success connect Mysql server!");
		      Statement stmt = connect.createStatement();

		      String sql = "update user set nickname=\""+nicknames+"\",sex=\""+sex+"\",id_card=\""+id_cards+"\",`password`=\""+passwords+"\",birthday=\""+birthdays+"\",`address`=\""+addresss+"\" where phone_number=\""+phone_numbers+"\";";
		      System.out.print(sql);
		      stmt.executeUpdate(sql);   //user 为你表的名称
		      
		      stmt.close();
		      i=1;
		    }
		    catch (Exception e) {
		      System.out.print("get data error!");
		      e.printStackTrace();
		    } 
		    if(i==0) {
				return "false";
			}else {
				return "true";
			}    
	} 
	
	
	public String update_admin_imformation(String nicknames, String sex,String phone_numbers, String id_cards,  String passwords, String birthdays, String addresss, String real_name, String emails, String head_portraits) {
		int i = 0;
		try {
		      Class.forName("com.mysql.cj.jdbc.Driver");     //加载MYSQL JDBC驱动程序   
		      //Class.forName("org.gjt.mm.mysql.Driver");
		     System.out.println("Success loading Mysql Driver!");
		    }
		    catch (Exception e) {
		      System.out.print("Error loading Mysql Driver!");
		      e.printStackTrace();
		    }
		    try {
		      Connection connect = DriverManager.getConnection(
		        DB_URL,USER,PASS );
		           //连接URL为   jdbc:mysql//服务器地址/数据库名  ，后面的2个参数分别是登陆用户名和密码
		      System.out.println("Success connect Mysql server!");
		      Statement stmt = connect.createStatement();

		      String sql = "call buy_books(\""+phone_numbers+"\","+nicknames+"\","+real_name+"\","+sex+"\","+emails+"\","+passwords+"\","+head_portraits+"\","+id_cards+"\","+birthdays+"\","+addresss+");";
		      System.out.print(sql);
		      stmt.executeUpdate(sql);   //user 为你表的名称
		      
		      stmt.close();
		      i=1;
		    }
		    catch (Exception e) {
		      System.out.print("get data error!");
		      e.printStackTrace();
		    } 
		    if(i==0) {
				return "false";
			}else {
				return "true";
			}    
	} 
	
	public String delete_favor(String phone_number, String books_id) {
		int i = 0;
		try {
		      Class.forName("com.mysql.cj.jdbc.Driver");     //加载MYSQL JDBC驱动程序   
		      //Class.forName("org.gjt.mm.mysql.Driver");
		     System.out.println("Success loading Mysql Driver!");
		    }
		    catch (Exception e) {
		      System.out.print("Error loading Mysql Driver!");
		      e.printStackTrace();
		    }
		    try {
		      Connection connect = DriverManager.getConnection(
		        DB_URL,USER,PASS );
		           //连接URL为   jdbc:mysql//服务器地址/数据库名  ，后面的2个参数分别是登陆用户名和密码
		      System.out.println("Success connect Mysql server!");
		      Statement stmt = connect.createStatement();

		      String sql = "delete from favor where fav_user_phone=\""+phone_number+"\"and books_id=\""+books_id+"\";";
		      System.out.print(sql);
		      stmt.executeUpdate(sql);   //user 为你表的名称
		      
		      stmt.close();
		      i=1;
		    }
		    catch (Exception e) {
		      System.out.print("get data error!");
		      e.printStackTrace();
		    } 
		    if(i==0) {
				return "false";
			}else {
				return "true";
			}    
	} 
	
	public String delete_cart(String phone_number, String books_id) {
		int i = 0;
		try {
		      Class.forName("com.mysql.cj.jdbc.Driver");     //加载MYSQL JDBC驱动程序   
		      //Class.forName("org.gjt.mm.mysql.Driver");
		     System.out.println("Success loading Mysql Driver!");
		    }
		    catch (Exception e) {
		      System.out.print("Error loading Mysql Driver!");
		      e.printStackTrace();
		    }
		    try {
		      Connection connect = DriverManager.getConnection(
		        DB_URL,USER,PASS );
		           //连接URL为   jdbc:mysql//服务器地址/数据库名  ，后面的2个参数分别是登陆用户名和密码
		      System.out.println("Success connect Mysql server!");
		      Statement stmt = connect.createStatement();

		      String sql = "delete from `add` where cart_user_phone=\""+phone_number+"\"and books_id=\""+books_id+"\";";
		      System.out.print(sql);
		      stmt.executeUpdate(sql);   //user 为你表的名称
		      
		      stmt.close();
		      i=1;
		    }
		    catch (Exception e) {
		      System.out.print("get data error!");
		      e.printStackTrace();
		    } 
		    if(i==0) {
				return "false";
			}else {
				return "true";
			}    
	} 
	
	public String buy_books(String phone_number, String books_id) {
		String result;
		int a = 0;
		try {
		      Class.forName("com.mysql.cj.jdbc.Driver");     //加载MYSQL JDBC驱动程序   
		      //Class.forName("org.gjt.mm.mysql.Driver");
		     System.out.println("Success loading Mysql Driver!");
		    }
		    catch (Exception e) {
		      System.out.print("Error loading Mysql Driver!");
		      e.printStackTrace();
		    }
		    try {
		    	
		      int id = Integer.parseInt(books_id); 
		      Connection connect = DriverManager.getConnection(
		        DB_URL,USER,PASS );
		           //连接URL为   jdbc:mysql//服务器地址/数据库名  ，后面的2个参数分别是登陆用户名和密码
		      System.out.println("Success connect Mysql server!");
		      Statement stmt = connect.createStatement();
		      
//		      DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//	          String birthday = df.format(date);
		      
		      String sql = "call buy_books(\""+phone_number+"\","+id+");";	
		      System.out.print(sql);
		      stmt.execute(sql);   //user 为你表的名称
		      
		      stmt.close();
		      a = 1;
		    }
		    catch (Exception e) {
		      System.out.print("get data error!");
		      e.printStackTrace();
		    } 
			if(a==0) {
				return "false";
			}else {
				return "true";
			}    
	} 
	
	public String[] obtaion_book_detail(String books_id) {
		String[] result = new String[10000];
		int a = 0;
		try {
		      Class.forName("com.mysql.cj.jdbc.Driver");     //加载MYSQL JDBC驱动程序   
		      //Class.forName("org.gjt.mm.mysql.Driver");
		     System.out.println("Success loading Mysql Driver!");
		    }
		    catch (Exception e) {
		      System.out.print("Error loading Mysql Driver!");
		      e.printStackTrace();
		    }
		    try {
		    	
		      int id = Integer.parseInt(books_id); 
		      Connection connect = DriverManager.getConnection(
		        DB_URL,USER,PASS );
		           //连接URL为   jdbc:mysql//服务器地址/数据库名  ，后面的2个参数分别是登陆用户名和密码
		      System.out.println("Success connect Mysql server!");
		      Statement stmt = connect.createStatement();
		      
//		      DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//	          String birthday = df.format(date);
		      
		      String sql = "select Author,`name`,brief,press,price,kind,picture,merchant_id,press_date  from books where books_id="+books_id+";";	
		      System.out.print(sql);
		      ResultSet rs = stmt.executeQuery(sql);   //user 为你表的名称
		      int i = 0;
		while (rs.next()) {
				result[i] = rs.getString("name");
				System.out.println(result[i]);
				i = i+1;
				
				result[i] = rs.getString("Author"); 
				i = i+1;
				
				result[i] = rs.getString("kind"); 
				i = i+1;
				
				result[i] = rs.getString("press"); 
				i = i+1;
				
				result[i] = rs.getString("press_date"); 
				i = i+1;
				
				
				result[i] = String.valueOf(rs.getBigDecimal("price")); 
				i = i+1;
				
				result[i] = rs.getString("merchant_id"); 
				i = i+1;
		      }
		    }  catch (Exception e) {
			      System.out.print("get data error!");
			      e.printStackTrace();
			    } 
			return result;
		} 
	
	public String[] obtaion_book_detail_price_asc(String book_name, String kind, String author, String merchant_id, String press, String price_start, String price_end) {
		String[] result = new String[10000];
		int a = 0;
		try {
		      Class.forName("com.mysql.cj.jdbc.Driver");     //加载MYSQL JDBC驱动程序   
		      //Class.forName("org.gjt.mm.mysql.Driver");
		     System.out.println("Success loading Mysql Driver!");
		    }
		    catch (Exception e) {
		      System.out.print("Error loading Mysql Driver!");
		      e.printStackTrace();
		    }
		    try {
		      Connection connect = DriverManager.getConnection(
		        DB_URL,USER,PASS );
		           //连接URL为   jdbc:mysql//服务器地址/数据库名  ，后面的2个参数分别是登陆用户名和密码
		      System.out.println("Success connect Mysql server!");
		      Statement stmt = connect.createStatement();
		      
//		      DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//	          String birthday = df.format(date);
		      
		      String sql = "select books_id,`name`,Author,kind,press,press_date,price,merchant_id from books where name like \"%"+ book_name + "%\" and kind like \"%"+kind+"%\" and Author like \"%"+author+"%\" and merchant_id="+merchant_id+" and  press like \"%"+press+"%\" and price>"+price_start+" and price<"+price_end+" order by price asc;";
		      System.out.print(sql);
		      ResultSet rs = stmt.executeQuery(sql);   //user 为你表的名称
		      int i = 0;
		while (rs.next()) {
				result[i] = rs.getString("name");
				System.out.println(result[i]);
				i = i+1;
				
				result[i] = rs.getString("Author"); 
				i = i+1;
				
				result[i] = rs.getString("kind"); 
				i = i+1;
				
				result[i] = rs.getString("press"); 
				i = i+1;
				
				result[i] = rs.getString("press_date"); 
				i = i+1;
				
				result[i] = String.valueOf(rs.getBigDecimal("price")); 
				i = i+1;
				
				result[i] = rs.getString("merchant_id"); 
				i = i+1;
				
				result[i] = rs.getString("books_id"); 
				i = i+1;
		      }
		    }  catch (Exception e) {
			      System.out.print("get data error!");
			      e.printStackTrace();
			    } 
			return result;
		} 
	
	
	public String[] obtaion_book_detail_price_desc(String book_name, String kind, String author, String merchant_id, String press, String price_start, String price_end) {
		String[] result = new String[10000];
		int a = 0;
		try {
		      Class.forName("com.mysql.cj.jdbc.Driver");     //加载MYSQL JDBC驱动程序   
		      //Class.forName("org.gjt.mm.mysql.Driver");
		     System.out.println("Success loading Mysql Driver!");
		    }
		    catch (Exception e) {
		      System.out.print("Error loading Mysql Driver!");
		      e.printStackTrace();
		    }
		    try {
		      Connection connect = DriverManager.getConnection(
		        DB_URL,USER,PASS );
		           //连接URL为   jdbc:mysql//服务器地址/数据库名  ，后面的2个参数分别是登陆用户名和密码
		      System.out.println("Success connect Mysql server!");
		      Statement stmt = connect.createStatement();
		      
//		      DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//	          String birthday = df.format(date);
		      
		      String sql ="select books_id,`name`,Author,kind,press,press_date,price,merchant_id from books where name like \"%"+ book_name + "%\" and kind like \"%"+kind+"%\" and Author like \"%"+author+"%\" and merchant_id="+merchant_id+" and  press like \"%"+press+"%\" and price>"+price_start+" and price<"+price_end+" order by price desc;";
		      System.out.print(sql);
		      ResultSet rs = stmt.executeQuery(sql);   //user 为你表的名称
		      int i = 0;
		while (rs.next()) {
				result[i] = rs.getString("name");
				System.out.println(result[i]);
				i = i+1;
				
				result[i] = rs.getString("Author"); 
				i = i+1;
				
				result[i] = rs.getString("kind"); 
				i = i+1;
				
				result[i] = rs.getString("press"); 
				i = i+1;
				
				result[i] = rs.getString("press_date"); 
				i = i+1;
				
				result[i] = String.valueOf(rs.getBigDecimal("price")); 
				i = i+1;
				
				result[i] = rs.getString("merchant_id"); 
				i = i+1;
				
				result[i] = rs.getString("books_id"); 
				i = i+1;
		      }
		    }  catch (Exception e) {
			      System.out.print("get data error!");
			      e.printStackTrace();
			    } 
			return result;
		} 
	
	public String[] obtaion_book_detail_date_asc(String book_name, String kind, String author, String merchant_id, String press, String price_start, String price_end) {
		String[] result = new String[10000];
		int a = 0;
		try {
		      Class.forName("com.mysql.cj.jdbc.Driver");     //加载MYSQL JDBC驱动程序   
		      //Class.forName("org.gjt.mm.mysql.Driver");
		     System.out.println("Success loading Mysql Driver!");
		    }
		    catch (Exception e) {
		      System.out.print("Error loading Mysql Driver!");
		      e.printStackTrace();
		    }
		    try {
		      Connection connect = DriverManager.getConnection(
		        DB_URL,USER,PASS );
		           //连接URL为   jdbc:mysql//服务器地址/数据库名  ，后面的2个参数分别是登陆用户名和密码
		      System.out.println("Success connect Mysql server!");
		      Statement stmt = connect.createStatement();
		      
//		      DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//	          String birthday = df.format(date);
		      
		      String sql = "select books_id,`name`,Author,kind,press,press_date,price,merchant_id from books where name like \"%"+ book_name + "%\" and kind like \"%"+kind+"%\" and Author like \"%"+author+"%\" and merchant_id="+merchant_id+" and  press like \"%"+press+"%\" and price>"+price_start+" and price<"+price_end+" order by press_date asc;";
		      System.out.print(sql);
		      ResultSet rs = stmt.executeQuery(sql);   //user 为你表的名称
		      int i = 0;
		while (rs.next()) {
				result[i] = rs.getString("name");
				System.out.println(result[i]);
				i = i+1;
				
				result[i] = rs.getString("Author"); 
				i = i+1;
				
				result[i] = rs.getString("kind"); 
				i = i+1;
				
				result[i] = rs.getString("press"); 
				i = i+1;
				
				result[i] = rs.getString("press_date"); 
				i = i+1;
				
				result[i] = String.valueOf(rs.getBigDecimal("price")); 
				i = i+1;
				
				result[i] = rs.getString("merchant_id"); 
				i = i+1;
				
				result[i] = rs.getString("books_id"); 
				i = i+1;
		      }
		    }  catch (Exception e) {
			      System.out.print("get data error!");
			      e.printStackTrace();
			    } 
			return result;
		} 
	
	public String[] obtaion_book_detail_date_desc(String book_name, String kind, String author, String merchant_id, String press, String price_start, String price_end) {
		String[] result = new String[10000];
		int a = 0;
		try {
		      Class.forName("com.mysql.cj.jdbc.Driver");     //加载MYSQL JDBC驱动程序   
		      //Class.forName("org.gjt.mm.mysql.Driver");
		     System.out.println("Success loading Mysql Driver!");
		    }
		    catch (Exception e) {
		      System.out.print("Error loading Mysql Driver!");
		      e.printStackTrace();
		    }
		    try {
		      Connection connect = DriverManager.getConnection(
		        DB_URL,USER,PASS );
		           //连接URL为   jdbc:mysql//服务器地址/数据库名  ，后面的2个参数分别是登陆用户名和密码
		      System.out.println("Success connect Mysql server!");
		      Statement stmt = connect.createStatement();
		      
//		      DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//	          String birthday = df.format(date);
		      
		      String sql = "select books_id,`name`,Author,kind,press,press_date,price,merchant_id from books where name like \"%"+ book_name + "%\" and kind like \"%"+kind+"%\" and Author like \"%"+author+"%\" and merchant_id="+merchant_id+" and  press like \"%"+press+"%\" and price>"+price_start+" and price<"+price_end+" order by press_date desc;";
		      System.out.print(sql);
		      ResultSet rs = stmt.executeQuery(sql);   //user 为你表的名称
		      int i = 0;
		while (rs.next()) {
				result[i] = rs.getString("name");
				System.out.println(result[i]);
				i = i+1;
				
				result[i] = rs.getString("Author"); 
				i = i+1;
				
				result[i] = rs.getString("kind"); 
				i = i+1;
				
				result[i] = rs.getString("press"); 
				i = i+1;
				
				result[i] = rs.getString("press_date"); 
				i = i+1;
				
				result[i] = String.valueOf(rs.getBigDecimal("price")); 
				i = i+1;
				
				result[i] = rs.getString("merchant_id"); 
				i = i+1;
				
				result[i] = rs.getString("books_id"); 
				i = i+1;
		      }
		    }  catch (Exception e) {
			      System.out.print("get data error!");
			      e.printStackTrace();
			    } 
			return result;
		} 
	
	public String[] obtaion_book_detail_books_id_asc(String book_name, String kind, String author, String merchant_id, String press, String price_start, String price_end) {
		String[] result = new String[10000];
		int a = 0;
		try {
		      Class.forName("com.mysql.cj.jdbc.Driver");     //加载MYSQL JDBC驱动程序   
		      //Class.forName("org.gjt.mm.mysql.Driver");
		     System.out.println("Success loading Mysql Driver!");
		    }
		    catch (Exception e) {
		      System.out.print("Error loading Mysql Driver!");
		      e.printStackTrace();
		    }
		    try {
		      Connection connect = DriverManager.getConnection(
		        DB_URL,USER,PASS );
		           //连接URL为   jdbc:mysql//服务器地址/数据库名  ，后面的2个参数分别是登陆用户名和密码
		      System.out.println("Success connect Mysql server!");
		      Statement stmt = connect.createStatement();
		      
//		      DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//	          String birthday = df.format(date);
		      
		      String sql = "select books_id,`name`,Author,kind,press,press_date,price,merchant_id from books where name like \"%"+ book_name + "%\" and kind like \"%"+kind+"%\" and Author like \"%"+author+"%\" and merchant_id="+merchant_id+" and  press like \"%"+press+"%\" and price>"+price_start+" and price<"+price_end+" order by books_id asc;";
		      System.out.print(sql);
		      ResultSet rs = stmt.executeQuery(sql);   //user 为你表的名称
		      int i = 0;
		while (rs.next()) {
				result[i] = rs.getString("name");
				System.out.println(result[i]);
				i = i+1;
				
				result[i] = rs.getString("Author"); 
				i = i+1;
				
				result[i] = rs.getString("kind"); 
				i = i+1;
				
				result[i] = rs.getString("press"); 
				i = i+1;
				
				result[i] = rs.getString("press_date"); 
				i = i+1;
				
				result[i] = String.valueOf(rs.getBigDecimal("price")); 
				i = i+1;
				
				result[i] = rs.getString("merchant_id"); 
				i = i+1;
				
				result[i] = rs.getString("books_id"); 
				i = i+1;
		      }
		    }  catch (Exception e) {
			      System.out.print("get data error!");
			      e.printStackTrace();
			    } 
			return result;
		} 
	
	public String[] obtaion_book_detail_books_id_desc(String book_name, String kind, String author, String merchant_id, String press, String price_start, String price_end) {
		String[] result = new String[10000];
		int a = 0;
		try {
		      Class.forName("com.mysql.cj.jdbc.Driver");     //加载MYSQL JDBC驱动程序   
		      //Class.forName("org.gjt.mm.mysql.Driver");
		     System.out.println("Success loading Mysql Driver!");
		    }
		    catch (Exception e) {
		      System.out.print("Error loading Mysql Driver!");
		      e.printStackTrace();
		    }
		    try {
		      Connection connect = DriverManager.getConnection(
		        DB_URL,USER,PASS );
		           //连接URL为   jdbc:mysql//服务器地址/数据库名  ，后面的2个参数分别是登陆用户名和密码
		      System.out.println("Success connect Mysql server!");
		      Statement stmt = connect.createStatement();
		      
//		      DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//	          String birthday = df.format(date);
		      
		      String sql = "select books_id,`name`,Author,kind,press,press_date,price,merchant_id from books where name like \"%"+ book_name + "%\" and kind like \"%"+kind+"%\" and Author like \"%"+author+"%\" and merchant_id="+merchant_id+" and  press like \"%"+press+"%\" and price>"+price_start+" and price<"+price_end+" order by books_id desc;";
		      System.out.print(sql);
		      ResultSet rs = stmt.executeQuery(sql);   //user 为你表的名称
		      int i = 0;
		while (rs.next()) {
				result[i] = rs.getString("name");
				System.out.println(result[i]);
				i = i+1;
				
				result[i] = rs.getString("Author"); 
				i = i+1;
				
				result[i] = rs.getString("kind"); 
				i = i+1;
				
				result[i] = rs.getString("press"); 
				i = i+1;
				
				result[i] = rs.getString("press_date"); 
				i = i+1;
				
				result[i] = String.valueOf(rs.getBigDecimal("price")); 
				i = i+1;
				
				result[i] = rs.getString("merchant_id"); 
				i = i+1;
				
				result[i] = rs.getString("books_id"); 
				i = i+1;
		      }
		    }  catch (Exception e) {
			      System.out.print("get data error!");
			      e.printStackTrace();
			    } 
			return result;
		} 
	
	public String update_books(String books_ids,String names, String Authors, String presss, String kinds, String press_dates, String prices) {
		String result;
		int a = 0;
		try {
		      Class.forName("com.mysql.cj.jdbc.Driver");     //加载MYSQL JDBC驱动程序   
		      //Class.forName("org.gjt.mm.mysql.Driver");
		     System.out.println("Success loading Mysql Driver!");
		    }
		    catch (Exception e) {
		      System.out.print("Error loading Mysql Driver!");
		      e.printStackTrace();
		    }
		    try {
		    	
//		      int id = Integer.parseInt(books_id);
		      Connection connect = DriverManager.getConnection(
		        DB_URL,USER,PASS );
		           //连接URL为   jdbc:mysql//服务器地址/数据库名  ，后面的2个参数分别是登陆用户名和密码
		      System.out.println("Success connect Mysql server!");
		      Statement stmt = connect.createStatement();
		      
//		      DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//	          String birthday = df.format(date);
		      
		      String sql = "call update_books("+books_ids+",\""+names+"\",\""+Authors+"\",\""+presss+"\",\""+kinds+"\",\""+press_dates+"\","+prices+");";	
		      System.out.print(sql);
		      stmt.execute(sql);   //user 为你表的名称
		      
		      stmt.close();
		      a = 1;
		    }
		    catch (Exception e) {
		      System.out.print("get data error!");
		      e.printStackTrace();
		    } 
			if(a==0) {
				return "false";
			}else {
				return "true";
			}    
	} 
	
	
	public String delete_books(String books_ids) {
		String result;
		int a = 0;
		try {
		      Class.forName("com.mysql.cj.jdbc.Driver");     //加载MYSQL JDBC驱动程序   
		      //Class.forName("org.gjt.mm.mysql.Driver");
		     System.out.println("Success loading Mysql Driver!");
		    }
		    catch (Exception e) {
		      System.out.print("Error loading Mysql Driver!");
		      e.printStackTrace();
		    }
		    try {
		    	
//		      int id = Integer.parseInt(books_id);
		      Connection connect = DriverManager.getConnection(
		        DB_URL,USER,PASS );
		           //连接URL为   jdbc:mysql//服务器地址/数据库名  ，后面的2个参数分别是登陆用户名和密码
		      System.out.println("Success connect Mysql server!");
		      Statement stmt = connect.createStatement();
		      
//		      DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//	          String birthday = df.format(date);
		      
		      String sql = "call delete_books("+books_ids+");";	
		      System.out.print(sql);
		      stmt.execute(sql);   //user 为你表的名称
		      
		      stmt.close();
		      a = 1;
		    }
		    catch (Exception e) {
		      System.out.print("get data error!");
		      e.printStackTrace();
		    } 
			if(a==0) {
				return "false";
			}else {
				return "true";
			}    
	} 
	
	public String delete_user(String phone_number) {
		String result;
		int a = 0;
		try {
		      Class.forName("com.mysql.cj.jdbc.Driver");     //加载MYSQL JDBC驱动程序   
		      //Class.forName("org.gjt.mm.mysql.Driver");
		     System.out.println("Success loading Mysql Driver!");
		    }
		    catch (Exception e) {
		      System.out.print("Error loading Mysql Driver!");
		      e.printStackTrace();
		    }
		    try {
		    	
//		      int id = Integer.parseInt(books_id);
		      Connection connect = DriverManager.getConnection(
		        DB_URL,USER,PASS );
		           //连接URL为   jdbc:mysql//服务器地址/数据库名  ，后面的2个参数分别是登陆用户名和密码
		      System.out.println("Success connect Mysql server!");
		      Statement stmt = connect.createStatement();
		      
//		      DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//	          String birthday = df.format(date);
		      String sql = "call delete_user(\""+phone_number+"\");";	
		      System.out.print(sql);
		      stmt.execute(sql);   //user 为你表的名称
		      
		      stmt.close();
		      a = 1;
		    }
		    catch (Exception e) {
		      System.out.print("get data error!");
		      e.printStackTrace();
		    } 
			if(a==0) {
				return "false";
			}else {
				return "true";
			}    
	} 
	
	public String charge_money(String phone_number, String add_money) {
		String result;
		int a = 0;
		try {
		      Class.forName("com.mysql.cj.jdbc.Driver");     //加载MYSQL JDBC驱动程序   
		      //Class.forName("org.gjt.mm.mysql.Driver");
		     System.out.println("Success loading Mysql Driver!");
		    }
		    catch (Exception e) {
		      System.out.print("Error loading Mysql Driver!");
		      e.printStackTrace();
		    }
		    try {
		    	
//		      int id = Integer.parseInt(books_id);
		      Connection connect = DriverManager.getConnection(
		        DB_URL,USER,PASS );
		           //连接URL为   jdbc:mysql//服务器地址/数据库名  ，后面的2个参数分别是登陆用户名和密码
		      System.out.println("Success connect Mysql server!");
		      Statement stmt = connect.createStatement();
		      
//		      DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//	          String birthday = df.format(date);
		      String sql = "call charge_money(\""+phone_number+"\","+add_money+");";	
		      System.out.print(sql);
		      stmt.execute(sql);   //user 为你表的名称
		      
		      stmt.close();
		      a = 1;
		    }
		    catch (Exception e) {
		      System.out.print("get data error!");
		      e.printStackTrace();
		    } 
			if(a==0) {
				return "false";
			}else {
				return "true";
			}    
	} 
//因为数据库中没有价格。
//	public static void main(String[] args) {
//		int id;
//		for(id = 3; id <= 1003;id++){
//			databasefuntion2 fun = new databasefuntion2();
//			fun.insert_random_price(id);
//		}
//	}
	
	}