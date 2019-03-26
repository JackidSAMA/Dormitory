package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import factory.DAOFactory;

public class Express_infoControl extends HttpServlet {

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
					response.getWriter().write(factory.DAOFactory.getIExpress_infoDAOInstance().selectall());
				} catch (Exception e) {
					e.printStackTrace();
				}
			} else if (request.getParameter("way").equals("single")) {
				try {
					response.getWriter().write(DAOFactory.getIExpress_infoDAOInstance().selectsingle(request.getParameter("classname"), request.getParameter("major"), request.getParameter("grade")));
				} catch (Exception e) {
					e.printStackTrace();
				}
			}else if (request.getParameter("way").equals("byid")) {
				try {
					response.getWriter().write(DAOFactory.getIExpress_infoDAOInstance().selectbyid(Integer.parseInt(request.getParameter("id"))));
				} catch (Exception e) {
					e.printStackTrace();
				}
			}else if (request.getParameter("way").equals("update")) {
				try {
					java.sql.Date arrival_datetime = new java.sql.Date(
							new SimpleDateFormat("yyyy-MM-dd").parse(
									request.getParameter("arrival_datetime")).getTime());
					
					if (DAOFactory.getIExpress_infoDAOInstance().update(Integer.parseInt(request.getParameter("id")), request.getParameter("stu_id"), request.getParameter("stu_name"), request.getParameter("phone_number"), arrival_datetime, Integer.parseInt(request.getParameter("is_get")))) {
						response.getWriter().write("success");
					} else {
						response.getWriter().write("failed");
					}
					
				} catch (Exception e) {
					e.printStackTrace();
					response.getWriter().write("failed");
				}
			}else if (request.getParameter("way").equals("delete")) {
				try {
					if (DAOFactory.getIExpress_infoDAOInstance().delete(Integer.parseInt(request.getParameter("id")))) {
						response.getWriter().write("success");
					} else {
						response.getWriter().write("failed");
					}

				} catch (Exception e) {
					e.printStackTrace();
					response.getWriter().write("failed");
				}
			}else if (request.getParameter("way").equals("byname")) {
				try {
					response.getWriter().write(DAOFactory.getIExpress_infoDAOInstance().selectbyname(request.getParameter("name")));
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
