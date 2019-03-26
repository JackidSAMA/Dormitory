package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import vo.Come_back_info;
import vo.Express_info;

public class InsertCome extends HttpServlet {

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
		
		Come_back_info come_back_info=new Come_back_info();
		try {
			come_back_info.setStu_id(request.getParameter("stu_id"));
			come_back_info.setStu_name(request.getParameter("stu_name"));
			come_back_info.setSituation(Integer.parseInt(request.getParameter("situation")));
			
			java.sql.Date come_back_datetime = new java.sql.Date(
					new SimpleDateFormat("yyyy-MM-dd").parse(
							request.getParameter("come_back_datetime")).getTime());
			come_back_info.setCome_back_datetime(come_back_datetime);
//			 SimpleDateFormat sdf =   new SimpleDateFormat( "yyyy-MM-dd HH:mm:ss" ); 
//			 come_back_info.setCome_back_datetime((Date) sdf.parse(request.getParameter("come_back_datetime")));
			
		} catch (Exception e) {
			response.getWriter().write("非法输入！");
			return;
		}
		try {
			if (factory.DAOFactory.getICome_back_infoDAOInstance().insert(come_back_info.getStu_id(), come_back_info.getStu_name(), come_back_info.getSituation(), come_back_info.getCome_back_datetime())) {
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
