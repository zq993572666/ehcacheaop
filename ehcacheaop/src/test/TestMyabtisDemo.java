package test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import com.dou.book.data.mappers.DepartmentMapper;
import com.dou.book.data.mappers.EmployerMapper;
import com.dou.book.data.pojo.Department;
import com.dou.book.data.pojo.Employer;

public class TestMyabtisDemo {

	public static void main(String[] args) {
		TestMyabtisDemo tmbd = new TestMyabtisDemo();
		tmbd.getDptAndEmps();

	}

	// 测试1对多的关联方式
	public void getDptAndEmps() {
		ApplicationContext act = new ClassPathXmlApplicationContext(
				"classpath*:applicationContext-common.xml");
		DepartmentMapper departmentMapper = act.getBean(DepartmentMapper.class);
		Department department = departmentMapper.queryByDpName("部门1");
		System.out.println(department.getDp_id() + "- "
				+ department.getDp_name() + " - " + department.getCost_center()
				+ " 员工数量 " + department.getEmployerList().size());
		for (Employer emp : department.getEmployerList()) {
			System.out.println(emp.getName() + " - "
					+ emp.getDpt().getDp_name() + "-" + emp.getStation());
		}
	} // 测试1对1的关联方式

	public void getEmployerAndDpt() {
		ApplicationContext act = new FileSystemXmlApplicationContext(
				"classpath*:applicationContext.xml");
		EmployerMapper empm = act.getBean(EmployerMapper.class);
		Employer emp = empm.getEmpByName("刘江");
		System.out.println(emp.getName() + " - " + emp.getDpt() + " = "
				+ emp.getStation() + " - ");
	}
}