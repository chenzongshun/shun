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
 * ���������йص�servlet
 * @author ����
 *
 */
public class Ks extends HttpServlet {

	/**
	 * ��¼���ʵĴ���
	 * 
	 * @param request
	 */
	public static void number(HttpServletRequest request) {
		// 1��ע������ �쳣�׳�ȥ��Ҫ�������ط����ã������ڵ��÷�����˭���ã�˭����
		try {
			Class.forName("com.mysql.jdbc.Driver");
			// ���һ��Ҫ��סඣ�û����ʾ�ġ�
			// 2�� ��ȡ���� �ǵõ������import java.sql.�µ�connetion
			Connection conn = DriverManager
					.getConnection("jdbc:mysql://120.79.70.46:3306/shun?user=root&password=@sS19980713");
			// 3����дsql���
			String du = "SELECT * FROM VisitCount WHERE websitename='Ks-18-1-22'";
			// 4������Ԥ������� Prepared������׼���õ� Statement������ PreparedStatement Ԥ�������
			PreparedStatement pstmt = conn.prepareStatement(du);

			HttpSession session = request.getSession();
			// 5�����ò���
			
			if (session.isNew()) {
				conn.prepareStatement("UPDATE VisitCount SET num=num+1 WHERE websitename='Ks-18-1-22' ").executeUpdate();// Ϊ���ݿ�ִ�м�һ����
			}		
			
			// 6��ִ�в�ѯ����
			ResultSet rs = pstmt.executeQuery();
			// 7���Խ�������д���
			while (rs.next()) {
				request.setAttribute("num", (String) rs.getString("num"));//�����վ�����ܴ���
			}
			
			// ��ʼ�ر�
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
		String sj = "/Examination/sj.jsp";//�����ֻ����ʽ���
		String ip = request.getRemoteAddr();
		number(request);//��¼���ô���

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
