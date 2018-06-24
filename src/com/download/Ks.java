package com.download;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@SuppressWarnings("serial")
/**
 * 考试下载有关的servlet
 * @author 疙瘩陈
 *
 */
public class Ks extends HttpServlet {

	/**
	 * 记录访问的次数
	 * 
	 * @param request
	 */
	public static void number(HttpServletRequest request) {
		// 1、注册驱动 异常抛出去，要在其它地方调用，所以在调用方处理，谁调用，谁处理
		try {
			Class.forName("com.mysql.jdbc.Driver");
			// 这个一定要记住喽！没有提示的。
			// 2、 获取连接 记得导入的是import java.sql.下的connetion
			Connection conn = DriverManager
					.getConnection("jdbc:mysql://120.79.70.46:3306/shun?user=root&password=@sS19980713");
			// 3、编写sql语句
			String du = "SELECT * FROM VisitCount WHERE websitename='Ks-18-1-22'";
			// 4、创建预处理对象 Prepared：事先准备好的 Statement：申明 PreparedStatement 预处理语句
			PreparedStatement pstmt = conn.prepareStatement(du);

			HttpSession session = request.getSession();
			// 5、设置参数
			
			if (session.isNew()) {
				conn.prepareStatement("UPDATE VisitCount SET num=num+1 WHERE websitename='Ks-18-1-22' ").executeUpdate();// 为数据库执行加一操作
			}		
			
			// 6、执行查询操作
			ResultSet rs = pstmt.executeQuery();
			// 7、对结果集进行处理
			while (rs.next()) {
				request.setAttribute("num", (String) rs.getString("num"));//获得网站访问总次数
			}
			
			// 开始关闭
			if (rs != null)
				rs.close();
			if (pstmt != null)
				pstmt.close();
			if (conn != null)
				conn.close();
		} catch (Exception e1) {
			e1.printStackTrace();
		}
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userAgent = request.getHeader("user-agent");
		String sj = "/Examination/sj.jsp";//定义手机访问界面
		String ip = request.getRemoteAddr();
		number(request);//记录来访次数

		if (userAgent.indexOf("Android") != -1) {
			request.getRequestDispatcher(sj).forward(request, response);
		}
		if (userAgent.indexOf("iPhone") != -1 || userAgent.indexOf("iPad") != -1) {
			request.getRequestDispatcher(sj).forward(request, response);
		} else {
			request.setAttribute("ip", ip);
			request.getRequestDispatcher("/Examination/ksdownload.jsp").forward(request, response);
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
