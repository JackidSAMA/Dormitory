package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import factory.DAOFactory;

public class Changepassword extends HttpServlet {

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
		try {
			if (request.getParameter("target").equals("admin")) {
				if (DAOFactory.getIAdmin_infoDAODAOInstance().change_password(request.getParameter("originpassword"), request.getParameter("firstpassword"), request.getParameter("login_id"))) {
					response.getWriter().write("已成功修改！");
				} else {
					response.getWriter().write("修改失败！原密码错误！");
				}
			
			
			} else if(request.getParameter("target").equals("student")) {
				if (DAOFactory.getIStudent_infoDAOInstance().change_password(request.getParameter("originpassword"), request.getParameter("firstpassword"), request.getParameter("login_id"))) {
					response.getWriter().write("已成功修改！");
				} else {
					response.getWriter().write("修改失败！原密码错误！");
				}
			}
		} catch (Exception e) {
			response.getWriter().write("修改失败！");
		}
		

	}

}
