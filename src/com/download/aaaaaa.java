package com.download;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;


import org.junit.Test;

public class aaaaaa {
	
	@Test
	public  void number() {
		// 1、注册驱动 异常抛出去，要在其它地方调用，所以在调用方处理，谁调用，谁处理
		try {
			Class.forName("com.mysql.jdbc.Driver");
			// 这个一定要记住喽！没有提示的。
			// 2、 获取连接 记得导入的是import java.sql.下的connetion
			Connection conn = DriverManager
					.getConnection("jdbc:mysql://120.79.70.46:3306/shun?user=root&password=1234");
			// 3、编写sql语句
			String du = "SELECT * FROM VisitCount WHERE websitename='Ks-18-1-22'";
			// 5、设置参数
			// 6、执行查询操作
			ResultSet rs = conn.prepareStatement(du).executeQuery();
			// 7、对结果集进行处理
			while (rs.next()) {
				for (int i = 1; i <= rs.getMetaData().getColumnCount(); i++) {
					System.out.print(rs.getString(i)+"   ");
				}				
			} 
			// 开始关闭
			if (rs != null)
				rs.close();
			if (conn != null)
				conn.close();
		} catch (Exception e1) {
			System.out.println("出错");
			e1.printStackTrace();
		}

	}
}
