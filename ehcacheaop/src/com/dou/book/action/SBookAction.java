package com.dou.book.action;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.dou.book.data.pojo.Department;
import com.dou.book.data.pojo.Employer;
import com.dou.book.data.pojo.SBook;
import com.dou.book.data.services.DepService;
import com.dou.book.data.services.ISBookServices;
import com.dou.book.util.JsonUtil;

@SuppressWarnings("unchecked")
public class SBookAction extends BaseAction{
	@Autowired
	DepService depService;
	@Autowired
	ISBookServices bookServices;
	private SBook sbook;
	private String tips;
	private String bookId;
	private List bookList;
	private String Id;

	private Map<String,Object> resultMap=new HashMap<String,Object>();

	/**
	 * ���ͼ����Ϣ
	 * 
	 * @return ��������Ƿ�ɹ�
	 */
	public String pageViewSBook() {
		  int page =Integer.parseInt(getHttpServletRequest().getParameter("page"));
		  int row = Integer.parseInt(getHttpServletRequest().getParameter("rows"));//接受参数page和rows
		int  total=bookServices.getBookTotal();
		resultMap.put("total", total);
		Map map=new HashMap();
		map.put("start", (page-1)*row);
		map.put("page", row);
		try {
			List<Object> rows = bookServices.findPageBook(map);
			resultMap.put("rows", rows);
			 objectToJsonString(resultMap);
			 //objectToJsonString(total);
		} catch (Exception e) {
			e.printStackTrace();
			this.setTips("失败");
		}
		return null;
	}
	public String addSBook() {
		String result = "error";
		try {
//			 bookServices.saveBook(sbook);
			//bookServices.updateTrantion();
			Department department =	(Department) depService.getDptAndEmps("dept1");
			Employer employer =depService.getEmployerByEName("liu");
			//this.setTips("��ӳɹ�");
			result = "success";
		} catch (Exception e) {
			e.printStackTrace();
			this.setTips("ϵͳ��������");
		}
		return result;
	}

	/**
	 * �鿴����ͼ��
	 * 
	 * @return
	 */
	public String viewSBook() {
		String result = "error";
		try {
			bookList = bookServices.findAllBook();
			result = "success";
		} catch (Exception e) {
			e.printStackTrace();
			this.setTips("ϵͳ�������⣬���Ժ����");
		}
		return result;
	}

	/**
	 * �޸�ͼ����Ϣ
	 * 
	 * @return
	 */
	public String modifySBook() {
		String result = "error";
		System.out.println("bookID:" + bookId);
		try {
			sbook = bookServices
					.getBookById(Integer.parseInt(this.getBookId()));
			System.out.println("title:" + sbook.getTitle());
			result = "success";
		} catch (Exception e) {
			e.printStackTrace();
			this.setTips("ϵͳ��������");
		}
		return result;
	}

	public String updateSBook() {
		String result = "error";
		try {
			bookServices.updateBook(sbook);
			result = "success";
		} catch (Exception e) {
			e.printStackTrace();
			this.setTips("���²���ʧ��");
		}
		return result;
	}

	/**
	 * ɾ��ͼ��
	 * 
	 * @return
	 */
	public String removeSBook() {
		String result = "error";
		System.out.println("id:" + this.getBookId());
		try {
			bookServices.removeBook(Integer.parseInt(this.getBookId()));
			System.out.println("id:" + this.getBookId());
			result = "success";
		} catch (Exception e) {
			e.printStackTrace();
			this.setTips("ɾ�����ʧ��");
		}
		return result;
	}

	public SBook getSbook() {
		return sbook;
	}

	public void setSbook(SBook sbook) {
		this.sbook = sbook;
	}

	public List getBookList() {
		return bookList;
	}

	public void setBookList(List bookList) {
		this.bookList = bookList;
	}

	public String getTips() {
		return tips;
	}

	public void setTips(String tips) {
		this.tips = tips;
	}

	public String getBookId() {
		return bookId;
	}

	public void setBookId(String bookId) {
		this.bookId = bookId;
	}

	public String getId() {
		return Id;
	}

	public void setId(String id) {
		Id = id;
	}

	public Map<String, Object> getResultMap() {
		return resultMap;
	}
	public void setResultMap(Map<String, Object> resultMap) {
		this.resultMap = resultMap;
	}



}
