package cn.cart;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class PurcharseServlet
 */
public class PurcharseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//��������
		response.setContentType("text/html;charset=utf-8");
		//��ȡͼ����Ϣ
		String id=request.getParameter("id");
		//�ж�ͼ�����
		if(id==null)
		{
			//û�й���ͼ��
			response.sendRedirect("/SessionTest/book");
			return ;
		}
		HttpSession ssion=request.getSession();//��ȡsession
		List<Book> list=(List<Book>) ssion.getAttribute("cart");//��ȡssion����Ĺ��ﳵ
		//�Ƿ��״����ͼ��
		if(list==null)
		{
			//���״����ͼ�飬�������ﳵ
			list=new ArrayList<Book>();
			ssion.setAttribute("cart", list);//�����ﳵ����session
		}
		//���ͼ��
		list.add(BookDB.getBook(id));
		//��cookie���session
		Cookie cookie=new Cookie("JESSIONID", ssion.getId());
		cookie.setMaxAge(60*60*24);//����cookieʱ��
		cookie.setPath("/SessionTest");//cookie����ص�
		response.addCookie(cookie);//��cookie������һ��ҳ��
		response.sendRedirect("/SessionTest/cart");//���Թ��ﳵҳ��
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
