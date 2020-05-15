package cn.cart;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class CartServlet
 */
public class CartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//处理乱码
		response.setContentType("text/html;charset=utf-8");
		PrintWriter pw=response.getWriter();
		HttpSession ssion=request.getSession();
		List<Book> cart=null;
		boolean flag=true;
		if(ssion==null)
		{
			flag=false;
		}
		else
		{
			cart=(List<Book>) ssion.getAttribute("cart");
		}
		if(!flag)
			pw.print("你没有图书，亲购买哦"+"<br/>");
		else
		{
			pw.print("你的购物车"+"<br/>");
			for(Book bk:cart)
			{
				pw.print(bk.getName()+"<br/>");
			}
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
