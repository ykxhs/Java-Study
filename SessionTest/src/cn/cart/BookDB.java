package cn.cart;

import java.util.Collection;
import java.util.HashMap;


public class BookDB {
	private static HashMap<String, Book> map=new HashMap<String, Book>();
	static {
		map.put("1",new Book(1, "JAVAEE"));
		map.put("2",new Book(2, "JAVAWEB"));
		map.put("3",new Book(3, "JAVA"));
	}
	//�õ�����ͼ��
	public static Collection<Book> getAllBook()
	{
		return map.values();
	}
	//����map��key,�õ�ͼ��
	public static Book getBook(String id)
	{
		return map.get(id);
	}
}
