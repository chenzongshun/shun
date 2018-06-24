package com.download;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 配合了webroot根目录的文件下载.html文件，修复了下载中文文件名乱码问题
 * 
 * @author Administrator
 *
 */
public class FileDownloadChineseFileName extends HttpServlet {
	/**
	 * 文件下载
	 */
	private static final long serialVersionUID = 1L;

	/* 这是视频上面讲的，但是有错误。当时不耐烦直接从网上找的 */
	/*
	 * public void doGet(HttpServletRequest request, HttpServletResponse
	 * response) throws ServletException, IOException { // 获得下载文件的名称 String
	 * fileNameString = request.getParameter("filename"); //
	 * 如果下载的文件名称是中文的时候会乱码，虽然下面打印是正确的的。 // 解决获得中文参数的乱码问题 fileNameString = new
	 * String(fileNameString.getBytes("iso8859-1"), "utf-8");
	 * System.out.println("从服务器中获取了资源：" + fileNameString);
	 * 
	 * // 获得请求头中的User-Agent String agent = request.getHeader("user-agent");
	 * System.out.println("agent的内容为：" + agent); // 根据不同的浏览器进行不同的编码 String
	 * filenameEncoding = ""; if (agent.contains("MSIE")) { // IE浏览器
	 * System.out.println("我是IE浏览器"); filenameEncoding =
	 * URLEncoder.encode(fileNameString, "utf-8"); filenameEncoding =
	 * filenameEncoding.replace("+", " "); } else if (agent.contains("Firefox"))
	 * { // 火狐浏览器 System.out.println("我是火狐浏览器"); BASE64Encoder base64Encoder =
	 * new BASE64Encoder(); filenameEncoding = "=?utf-8?B?" +
	 * base64Encoder.encode(fileNameString.getBytes("utf-8")) + "?="; } else {
	 * // 其它浏览器 System.out.println("我是其它浏览器"); filenameEncoding =
	 * URLEncoder.encode(fileNameString, "utf-8"); }
	 * 
	 * // 要下载的这个文件的类型-----客户端通过文件的MIME类型去区分类型
	 * response.setContentType(this.getServletContext().getMimeType(
	 * fileNameString));
	 * 
	 * // 告诉客户端该文件不是直接解析，而是以附件形式打开（下载） response.setHeader("Content-disposition",
	 * "attachment;filename=" + filenameEncoding);
	 * 
	 * // 获取文件的绝对路径 String path =
	 * this.getServletContext().getRealPath("download/" + fileNameString); //
	 * 获得该文件的输入流 System.out.println("路径" + path + " 下载文件名：" +
	 * request.getParameter("filename")); InputStream fileInputStream = new
	 * FileInputStream(path); // 获得输出流---通过response获得输出流用于向客户端写内容
	 * ServletOutputStream outputStream = response.getOutputStream(); //
	 * 文件拷贝的模板代码 int len = 0; byte[] buffer = new byte[1024]; while ((len =
	 * fileInputStream.read(buffer)) > 0) { outputStream.write(buffer, 0, len);
	 * } fileInputStream.close();// 这个自己new的一定要close outputStream.close();//
	 * 这个是通过response获得的，可以不获取，系统会自动关掉 }
	 */

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DownloadFile(request, response,
				new File(request.getServletContext().getRealPath("Examination/download/" + request.getParameter("filename"))));
	}

	/**
	 * @author Administrator 陈宗顺 注意：IE很讨嫌，很有可能下载出问题
	 * @see 传参示例：Download(request, response, new
	 *      File(request.getServletContext().getRealPath("download/" +
	 *      request.getParameter("filename"))));
	 * @param request
	 *            就是doget或者dopost里面的那个形参
	 * @param response
	 *            就是doget或者dopost里面的那个形参
	 * @param DownloadFile
	 *            传一个new File(request.getServletContext().getRealPath("相对地址/" +
	 *            request.getParameter("filename")))
	 */
	private void DownloadFile(HttpServletRequest request, HttpServletResponse response, File DownloadFile)
			throws FileNotFoundException, UnsupportedEncodingException, IOException {
		response.addHeader("Content-Disposition", "attachment;filename=" + DownloadFile.getName());
		System.out.println("----------------------------从服务器中获取了资源：" + DownloadFile.getName()+"----------------------------");
		// System.out.println("浏览器信息为：" + request.getHeader("User-agent"));
		File file = DownloadFile;// 得到要下载的文件
		FileInputStream inputStream = new FileInputStream(file);// 创建一个输入流
		String fileName = file.getName();// 获取文件名
		// 下面就是一些固定步骤，完成页面弹框下载的功能
		response.setCharacterEncoding("GB2312");// 设置编码发送到客户端
		String str = null;// 存储解码格式
		String browName = null;
		String clientInfo = request.getHeader("User-agent");

		// response.setContentType("application/vnd.android.package-archive;
		// charset=gb2312");//安卓

		if (clientInfo != null && clientInfo.indexOf("MSIE") > 0) { // 如果是IE浏览器
			// IE采用URLEncoder方式处理
			if (clientInfo.indexOf("MSIE 6") > 0 || clientInfo.indexOf("MSIE 5") > 0) {// IE6，用GBK，此处实现由局限性
				browName = new String(fileName.getBytes("GBK"), "ISO-8859-1");
			} else {// ie7+用URLEncoder方式
				browName = java.net.URLEncoder.encode(fileName, "ISO-8859-1");
			}
		} else {// 其他浏览器
			browName = new String(fileName.getBytes("GBK"), "ISO-8859-1");
		}
		str = "attachment;filename=" + browName;
		response.setHeader("Content-Disposition", str);
		ServletOutputStream sos = response.getOutputStream();// 从response获得输出流
		byte[] data = new byte[2048];
		int len = 0;
		while ((len = inputStream.read(data)) > 0) {
			sos.write(data, 0, len);
		}
		inputStream.close();
		sos.close();
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
