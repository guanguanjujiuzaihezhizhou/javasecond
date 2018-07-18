package day002_echarts_ajax;

import java.util.List;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.offcn.po.NewStudent;
import com.offcn.service.StuService;

public class TestService {
	
	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath:spring-dao.xml","classpath:spring-service.xml");
			StuService service = context.getBean(StuService.class);
			List<NewStudent> allNewStudent = service.getAllNewStudent();
			for (NewStudent s : allNewStudent) {
				System.out.println(s);
			}
	}
}
