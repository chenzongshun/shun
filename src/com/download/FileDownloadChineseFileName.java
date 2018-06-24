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
 * �����webroot��Ŀ¼���ļ�����.html�ļ����޸������������ļ�����������
 * 
 * @author Administrator
 *
 */
public class FileDownloadChineseFileName extends HttpServlet {
	/**
	 * �ļ�����
	 */
	private static final long serialVersionUID = 1L;

	/* ������Ƶ���潲�ģ������д��󡣵�ʱ���ͷ�ֱ�Ӵ������ҵ� */
	/*
	 * public void doGet(HttpServletRequest request, HttpServletResponse
	 * response) throws ServletException, IOException { // ��������ļ������� String
	 * fileNameString = request.getParameter("filename"); //
	 * ������ص��ļ����������ĵ�ʱ������룬��Ȼ�����ӡ����ȷ�ĵġ� // ���������Ĳ������������� fileNameString = new
	 * String(fileNameString.getBytes("iso8859-1"), "utf-8");
	 * System.out.println("�ӷ������л�ȡ����Դ��" + fileNameString);
	 * 
	 * // �������ͷ�е�User-Agent String agent = request.getHeader("user-agent");
	 * System.out.println("agent������Ϊ��" + agent); // ���ݲ�ͬ����������в�ͬ�ı��� String
	 * filenameEncoding = ""; if (agent.contains("MSIE")) { // IE�����
	 * System.out.println("����IE�����"); filenameEncoding =
	 * URLEncoder.encode(fileNameString, "utf-8"); filenameEncoding =
	 * filenameEncoding.replace("+", " "); } else if (agent.contains("Firefox"))
	 * { // �������� System.out.println("���ǻ�������"); BASE64Encoder base64Encoder =
	 * new BASE64Encoder(); filenameEncoding = "=?utf-8?B?" +
	 * base64Encoder.encode(fileNameString.getBytes("utf-8")) + "?="; } else {
	 * // ��������� System.out.println("�������������"); filenameEncoding =
	 * URLEncoder.encode(fileNameString, "utf-8"); }
	 * 
	 * // Ҫ���ص�����ļ�������-----�ͻ���ͨ���ļ���MIME����ȥ��������
	 * response.setContentType(this.getServletContext().getMimeType(
	 * fileNameString));
	 * 
	 * // ���߿ͻ��˸��ļ�����ֱ�ӽ����������Ը�����ʽ�򿪣����أ� response.setHeader("Content-disposition",
	 * "attachment;filename=" + filenameEncoding);
	 * 
	 * // ��ȡ�ļ��ľ���·�� String path =
	 * this.getServletContext().getRealPath("download/" + fileNameString); //
	 * ��ø��ļ��������� System.out.println("·��" + path + " �����ļ�����" +
	 * request.getParameter("filename")); InputStream fileInputStream = new
	 * FileInputStream(path); // ��������---ͨ��response��������������ͻ���д����
	 * ServletOutputStream outputStream = response.getOutputStream(); //
	 * �ļ�������ģ����� int len = 0; byte[] buffer = new byte[1024]; while ((len =
	 * fileInputStream.read(buffer)) > 0) { outputStream.write(buffer, 0, len);
	 * } fileInputStream.close();// ����Լ�new��һ��Ҫclose outputStream.close();//
	 * �����ͨ��response��õģ����Բ���ȡ��ϵͳ���Զ��ص� }
	 */

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DownloadFile(request, response,
				new File(request.getServletContext().getRealPath("Examination/download/" + request.getParameter("filename"))));
	}

	/**
	 * @author Administrator ����˳ ע�⣺IE�����ӣ����п������س�����
	 * @see ����ʾ����Download(request, response, new
	 *      File(request.getServletContext().getRealPath("download/" +
	 *      request.getParameter("filename"))));
	 * @param request
	 *            ����doget����dopost������Ǹ��β�
	 * @param response
	 *            ����doget����dopost������Ǹ��β�
	 * @param DownloadFile
	 *            ��һ��new File(request.getServletContext().getRealPath("��Ե�ַ/" +
	 *            request.getParameter("filename")))
	 */
	private void DownloadFile(HttpServletRequest request, HttpServletResponse response, File DownloadFile)
			throws FileNotFoundException, UnsupportedEncodingException, IOException {
		response.addHeader("Content-Disposition", "attachment;filename=" + DownloadFile.getName());
		System.out.println("----------------------------�ӷ������л�ȡ����Դ��" + DownloadFile.getName()+"----------------------------");
		// System.out.println("�������ϢΪ��" + request.getHeader("User-agent"));
		File file = DownloadFile;// �õ�Ҫ���ص��ļ�
		FileInputStream inputStream = new FileInputStream(file);// ����һ��������
		String fileName = file.getName();// ��ȡ�ļ���
		// �������һЩ�̶����裬���ҳ�浯�����صĹ���
		response.setCharacterEncoding("GB2312");// ���ñ��뷢�͵��ͻ���
		String str = null;// �洢�����ʽ
		String browName = null;
		String clientInfo = request.getHeader("User-agent");

		// response.setContentType("application/vnd.android.package-archive;
		// charset=gb2312");//��׿

		if (clientInfo != null && clientInfo.indexOf("MSIE") > 0) { // �����IE�����
			// IE����URLEncoder��ʽ����
			if (clientInfo.indexOf("MSIE 6") > 0 || clientInfo.indexOf("MSIE 5") > 0) {// IE6����GBK���˴�ʵ���ɾ�����
				browName = new String(fileName.getBytes("GBK"), "ISO-8859-1");
			} else {// ie7+��URLEncoder��ʽ
				browName = java.net.URLEncoder.encode(fileName, "ISO-8859-1");
			}
		} else {// ���������
			browName = new String(fileName.getBytes("GBK"), "ISO-8859-1");
		}
		str = "attachment;filename=" + browName;
		response.setHeader("Content-Disposition", str);
		ServletOutputStream sos = response.getOutputStream();// ��response��������
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
