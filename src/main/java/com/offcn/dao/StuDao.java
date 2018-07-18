package com.offcn.dao;

import java.util.List;

import com.offcn.po.NewStudent;

public interface StuDao {
	public List<NewStudent> getAllNewStudent();
	public void saveStu(NewStudent stu);
}
