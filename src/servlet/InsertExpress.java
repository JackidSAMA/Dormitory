package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.text.SimpleDateFormat;

import javax.print.attribute.standard.DateTimeAtCompleted;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import vo.Express_info;


public class InsertExpress extends HttpServlet {

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
		
		Express_info express_info=new Express_info();
		try {
			express_info.setStu_id(request.getParameter("stu_id"));
			express_info.setStu_name(request.getParameter("stu_name"));
			express_info.setPhone_number(request.getParameter("phone_number"));
			express_info.setIs_get(Integer.parseInt(request.getParameter("is_get")));
				java.sql.Date arrival_datetime = new java.sql.Date(
						new SimpleDateFormat("yyyy-MM-dd").parse(
								request.getParameter("arrival_datetime")).getTime());
				express_info.setArrival_datetime(arrival_datetime);
			
		} catch (Exception e) {
			response.getWriter().write("非法输入！");
			return;
		}
		try {
			if (factory.DAOFactory.getIExpress_infoDAOInstance().insert(express_info.getStu_id(), express_info.getStu_name(), express_info.getPhone_number(), express_info.getArrival_datetime(), express_info.getIs_get())) {
				response.getWriter().write("成功！");
				return;
		} else {
			response.getWriter().write("servlet非法输入！");
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
