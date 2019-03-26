package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import factory.DAOFactory;


public class Student_infoControl extends HttpServlet {

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
			if (request.getParameter("way").equals("all")) {
				try {
					response.getWriter().write(factory.DAOFactory.getIStudent_infoDAOInstance().selectall());
				} catch (Exception e) {
					e.printStackTrace();
				}
			} else if (request.getParameter("way").equals("single")) {
				try {
					response.getWriter().write(DAOFactory.getIStudent_infoDAOInstance().selectsingle(request.getParameter("classname"), request.getParameter("major"), request.getParameter("grade")));
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

}
