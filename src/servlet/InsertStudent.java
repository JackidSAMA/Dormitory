package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import vo.Night_back_info;
import vo.Student_info;

public class InsertStudent extends HttpServlet {

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
				
				Student_info student_info=new Student_info();
				try {
					student_info.setStu_id(request.getParameter("stu_id"));
					student_info.setStu_name(request.getParameter("stu_name"));
					student_info.setPassword(request.getParameter("firstpassword"));
					java.sql.Date birthday = new java.sql.Date(
							new SimpleDateFormat("yyyy-MM-dd").parse(
									request.getParameter("birthday")).getTime());
					student_info.setBirthday(birthday);
					student_info.setMajor(request.getParameter("major"));
					student_info.setGrade(request.getParameter("grade"));
					
				} catch (Exception e) {
					response.getWriter().write("非法输入！");
					return;
				}
				try {
					if (factory.DAOFactory.getIStudent_infoDAOInstance().insert(student_info.getStu_id(), student_info.getStu_name(), student_info.getPassword(), student_info.getBirthday(), student_info.getMajor(), student_info.getGrade())) {
						response.getWriter().write("成功！");
						return;
				} else {
					response.getWriter().write("非法输入！");
					return;
				}
					
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					response.getWriter().write("非法输入！");
					return;
				}
			
	}

}
