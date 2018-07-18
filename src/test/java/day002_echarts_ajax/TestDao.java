package day002_echarts_ajax;

import java.util.List;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.offcn.dao.StuDao;
import com.offcn.po.NewStudent;

public class TestDao {

	public static void main(String[] args) {
		//获取上下文对象，可获得Spring中定义的Bean实例(对象)
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath:spring-dao.xml");
		StuDao dao = context.getBean(StuDao.class);
		/* List<NewStudent> list = dao.getAllNewStudent();
		for (NewStudent s : list) {
			System.out.println(s.getId()+"--"+s.getName());
		}*/
		 
//		 System.out.println(list);
		NewStudent student = new NewStudent();
		student.setName("awefrwe");
		student.setScore(55);
		student.setPhone("12345678");
		dao.saveStu(student);
	}

}
