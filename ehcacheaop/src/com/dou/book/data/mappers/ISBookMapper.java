package com.dou.book.data.mappers;

import java.util.List;
import java.util.Map;

import com.dou.book.data.pojo.SBook;

 
public interface ISBookMapper {
	/**
	 * ���һ��ͼ������ݿ���
	 * 
	 * @param book
	 *            ͼ�����
	 * @throws RuntimeException
	 */
	public void saveBook(SBook book) ;

	/**
	 * ɾ��ͼ����Ϣ
	 * 
	 * @param id
	 *            ID����
	 * @throws RuntimeException
	 */
	public void deleteBook(int id) throws RuntimeException;

	/**
	 * ͨ���������Ҵ˳�������������ͼ���б�
	 * 
	 * @param publisher
	 *            ���������
	 * @return �����ض��������µ�����ͼ���б�
	 * @throws RuntimeException
	 */
	//public List<SBook> findBooksByPublisher(String publisher)
	//		throws RuntimeException;

	/**
	 * ͨ��ͼ���Ӧ��Ψһ��ISBN�Ų���ͼ��
	 * 
	 * @param isbn
	 *            ͼ��Ψһ��ISBN����
	 * @return ���ش�ISBN�Ŷ�Ӧ��ͼ��
	 * @throws RuntimeException
	 */
	//public SBook findBookByISBN(String isbn) throws RuntimeException;

	/**
	 * ����һ��ͼ�����Ϣ
	 * 
	 * @param book
	 *            ͼ�����
	 * @throws RuntimeException
	 */
	public void updateBook(SBook book) throws RuntimeException;

	/**
	 * ���ҿ������е�ͼ��
	 * 
	 * @return ����ͼ���б�
	 * @throws RuntimeException
	 */
	public List<SBook> findAllBook() ;

	/**
	 * ͨ��ID�����ض���ͼ��
	 * 
	 * @param id
	 *            ͼ���ID��
	 * @return ���ش�ID��Ӧ��ͼ����Ϣ
	 * @throws RuntimeException
	 */
	public SBook findBookById(int id) throws RuntimeException;
	//public boolean deleteBook(int book) throws RuntimeException;
	public int getBookTotal();
	public List<SBook> findPageBook(Map map);
}
