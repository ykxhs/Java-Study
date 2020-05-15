package cn.cart;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collection;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ListBookServlet
 */
public class ListBookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//��������
		response.setContentType("text/html;charset=utf-8");
		PrintWriter pw=response.getWriter();
		//�õ�����ͼ��
		Collection<Book> books=BookDB.getAllBook();
		pw.print("����վ����ͼ��"+"<br/>");
		System.out.println(books.toString());
		for(Book bk:books)
		{
			int id=bk.getId();
			String url="<a href='/SessionTest/purcharse?id="+id+"'>��������</a>";
			pw.print(bk.getName()+"     "+url+"<br/><br/>");
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
