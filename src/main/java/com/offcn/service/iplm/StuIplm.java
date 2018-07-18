package com.offcn.service.iplm;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.offcn.dao.StuDao;
import com.offcn.po.NewStudent;
import com.offcn.service.StuService;



@Service
public class StuIplm implements StuService {
	
	@Autowired
	private StuDao stuDao;
	
	
	public List<NewStudent> getAllNewStudent() {
		
		List<NewStudent> allNewStudent = stuDao.getAllNewStudent();
		return allNewStudent;
	}


	@Override
	public void saveStu(NewStudent stu) {
		stuDao.saveStu(stu);
	}

}
