package team.runboo.Index;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Map;
import team.runboo.DataBase.*;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import team.runboo.LoginServlet.*;

@WebServlet("/rank")
public class rank extends HttpServlet{
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
		response.setCharacterEncoding("UTF-8");
		
//		String Name = request.getParameter("phone/email_number");
//		String PassWords = request.getParameter("password");
//		String admin_0 = request.getParameter("admin");
		
//		int admin = Integer.parseInt(admin_0);
		
		PrintWriter out=response.getWriter();
		response.setStatus(200);  
		
		
//		databasefuntion2 Login_C = new databasefuntion2();
//		System.out.println("运行到rank这");
//		String[] books = Login_C.rand_book();
//		System.out.println(books);
		
		
		String result = "";
		String nickname = "";
		
		String Ranking_List1 = "瓦尔登湖"; 
		String Ranking_List2 = "十七岁";
		String Ranking_List3 = "变形记";
		String Ranking_List4 = "野火";
		String Ranking_List5 = "舞者";
		
		String list1_id = "526";
		String list2_id = "528";
		String list3_id = "534";
		String list4_id = "563";
		String list5_id = "566";
		
		String free1 = "安妮日记";
		String free2 = "十年";
		String free3 = "人生若只如初见 （增订版）";
		String free4 ="子夜";
		String free5 = "雷雨";
		
		String free1_id = "571";
		String free2_id = "573";
		String free3_id = "582";
		String free4_id = "584";
		String free5_id = "586";
		
		
		rank_state result_json = new rank_state();
		result_json.setFree1(free1);
		result_json.setFree2(free2);
		result_json.setFree3(free3);
		result_json.setFree4(free4);
		result_json.setFree5(free5);
		
		result_json.setFree1_id(free1_id);
		result_json.setFree2_id(free2_id);
		result_json.setFree3_id(free3_id);
		result_json.setFree4_id(free4_id);
		result_json.setFree5_id(free5_id);
		
		result_json.setList1_id(list1_id);
		result_json.setList2_id(list2_id);
		result_json.setList3_id(list3_id);
		result_json.setList4_id(list4_id);
		result_json.setList5_id(list5_id);
		
		
		result_json.setRanking_List1(Ranking_List1);
		result_json.setRanking_List2(Ranking_List2);
		result_json.setRanking_List3(Ranking_List3);
		result_json.setRanking_List4(Ranking_List4);
		result_json.setRanking_List5(Ranking_List5);
		String state = JSON.toJSONString(result_json);
		
		
		out.write(state);
		
		
				
		
				

		// 打印出檢查
		//System.out.println(info);
		// 返回給前端
		//out.write(info);
	}
 
}