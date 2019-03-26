package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mchange.v2.c3p0.impl.NewProxyPreparedStatement;

import dbc.DatabaseConnection;

public class Login extends HttpServlet {

	/**
	 * The doGet method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

doPost(request, response);
	}

	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to post.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 请求信息的编码格式

		request.setCharacterEncoding("utf-8");

		// 响应信息的编码格式

		response.setCharacterEncoding("utf-8");

		// 浏览器的解码格式
		response.setContentType("text/html;charset=utf-8");
		
		Cookie safe=new Cookie("safe", "false");
		response.addCookie(safe);
		DatabaseConnection databaseConnection=new DatabaseConnection();
		Connection conn=databaseConnection.getConnection();
		 NewProxyPreparedStatement pstmt=null;
		try {
			String identity=request.getParameter("identity");
			String sql="";
			if (identity.equals("student")) {
				sql = "select * from student_info where stu_id=? and password=?";
			} else {
				sql = "select * from admin_info where adm_id=? and password=?";
			}

			pstmt = (NewProxyPreparedStatement) conn
					.prepareStatement(sql);
			pstmt.setString(1, request.getParameter("login_id"));
			pstmt.setString(2, request.getParameter("password"));
			System.out.println("登录事件的sql语句为："+pstmt.toString());
			
			ResultSet resultSet=pstmt.executeQuery();
			if (resultSet.next()) {
				Cookie identity_cookie=new Cookie("identity", identity);
				Cookie login_id_cookie=new Cookie("login_id", request.getParameter("login_id"));
				
				safe=new Cookie("safe", "true");
				
				identity_cookie.setMaxAge(60*60*24); 
				login_id_cookie.setMaxAge(60*60*24); 
				safe.setMaxAge(60*60*24); 
				
				response.addCookie(identity_cookie);
				response.addCookie(login_id_cookie);
				response.addCookie(safe);
				
		        response.getWriter().write("success");
		        
			}else {
				 response.getWriter().write("failed");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			 response.getWriter().write("failed");
		}

	}

}
