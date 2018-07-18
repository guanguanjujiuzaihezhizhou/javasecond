package com.offcn.service;

import java.util.List;

import com.offcn.po.NewStudent;

public interface StuService {
	public List<NewStudent> getAllNewStudent();
	public void saveStu(NewStudent stu);
}
