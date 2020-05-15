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
		//处理中文
		response.setContentType("text/html;charset=utf-8");
		//获取图书信息
		String id=request.getParameter("id");
		//判断图书存在
		if(id==null)
		{
			//没有购买图书
			response.sendRedirect("/SessionTest/book");
			return ;
		}
		HttpSession ssion=request.getSession();//获取session
		List<Book> list=(List<Book>) ssion.getAttribute("cart");//获取ssion里面的购物车
		//是否首次添加图书
		if(list==null)
		{
			//是首次添加图书，创建购物车
			list=new ArrayList<Book>();
			ssion.setAttribute("cart", list);//将购物车存入session
		}
		//添加图书
		list.add(BookDB.getBook(id));
		//用cookie完成session
		Cookie cookie=new Cookie("JESSIONID", ssion.getId());
		cookie.setMaxAge(60*60*24);//设置cookie时间
		cookie.setPath("/SessionTest");//cookie保存地点
		response.addCookie(cookie);//将cookie传给下一个页面
		response.sendRedirect("/SessionTest/cart");//回显购物车页面
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
