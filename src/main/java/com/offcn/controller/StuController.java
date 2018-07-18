package com.offcn.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.offcn.po.NewStudent;
import com.offcn.po.ScoreResult;
import com.offcn.service.StuService;

@Controller
public class StuController {
	@Autowired
	private StuService stuservice;
	
	//ssh修改00000001
	
	/*
	 * 返回学生信息：支持柱状图、折线图
	 * 
	 * */
	@RequestMapping("/getallstu")
	@ResponseBody
	public List<NewStudent>  getAllStu(){
		List<NewStudent> allNewStudent = stuservice.getAllNewStudent();
		System.out.println("学生有"+allNewStudent.size()+"名");
		return allNewStudent;
	}
	
	
	/*
	 * 返回数据支持：饼状图
	 * 
	 * */
	@RequestMapping("/getallstupie")
	@ResponseBody
	public List<ScoreResult> getAllStuforPie(){
		List<ScoreResult> list2 = new ArrayList<ScoreResult>();
		List<NewStudent> allNewStudent = stuservice.getAllNewStudent();
		for (NewStudent s : allNewStudent) {
			ScoreResult scoreResult = new ScoreResult();
			scoreResult.setName(s.getName());
			scoreResult.setValue(s.getScore());
			list2.add(scoreResult);
		}
		return list2;
	}
}
