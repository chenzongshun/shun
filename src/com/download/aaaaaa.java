package com.download;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;


import org.junit.Test;

public class aaaaaa {
	
	@Test
	public  void number() {
		// 1��ע������ �쳣�׳�ȥ��Ҫ�������ط����ã������ڵ��÷�����˭���ã�˭����
		try {
			Class.forName("com.mysql.jdbc.Driver");
			// ���һ��Ҫ��סඣ�û����ʾ�ġ�
			// 2�� ��ȡ���� �ǵõ������import java.sql.�µ�connetion
			Connection conn = DriverManager
					.getConnection("jdbc:mysql://120.79.70.46:3306/shun?user=root&password=1234");
			// 3����дsql���
			String du = "SELECT * FROM VisitCount WHERE websitename='Ks-18-1-22'";
			// 5�����ò���
			// 6��ִ�в�ѯ����
			ResultSet rs = conn.prepareStatement(du).executeQuery();
			// 7���Խ�������д���
			while (rs.next()) {
				for (int i = 1; i <= rs.getMetaData().getColumnCount(); i++) {
					System.out.print(rs.getString(i)+"   ");
				}				
			} 
			// ��ʼ�ر�
			if (rs != null)
				rs.close();
			if (conn != null)
				conn.close();
		} catch (Exception e1) {
			System.out.println("����");
			e1.printStackTrace();
		}

	}
}
