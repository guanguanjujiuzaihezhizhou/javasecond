package com.offcn.controller;

import java.io.File;
import java.io.IOException;
import java.text.DecimalFormat;

import javax.servlet.http.HttpServletRequest;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.offcn.po.NewStudent;
import com.offcn.service.StuService;

@Controller
public class ExcelUploadController {
	@Autowired
	private StuService stuservice;
	
	@RequestMapping("/upload001")
	public String uploadExcel(@RequestParam("file") MultipartFile file,HttpServletRequest request,Model model){
		//获取Web服务器发布的真实目录并命名
		String realPath = request.getServletContext().getRealPath("upload");
		//获取上传文件的原始名称
		String originalFilename = file.getOriginalFilename();
		//创建目标文件，即路径加文件名
		File targetFile = new File(realPath+"\\"+originalFilename);
		
		//创建命名的目标目录
		File targetPath = new File(realPath);
		if(!targetPath.exists()){
			targetPath.mkdir();
		}
		
		//把上传的文件写入到目标目录下
		try {
			file.transferTo(targetFile);
		} catch (IllegalStateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		//遍历excel表格
		try {
			//创建目标文件的工作布对象
			Workbook workbook = WorkbookFactory.create(targetFile);
			//通过工作簿对象获取名为“***”的sheet对象
			Sheet sheet = workbook.getSheet("学生信息表");
			
			//判断该表有多少行
			int physicalNumberOfRows = sheet.getPhysicalNumberOfRows();
			//根据physicalNumberOfRows遍历每行
			for(int i = 0;i <physicalNumberOfRows;i++){
				//不需要第一行的标题
				if(i==0){
					continue;
				}
				//根据每一行的行标获得row对象
				Row row = sheet.getRow(i);
				//判断该行有几个单元格
				int physicalNumberOfCells = row.getPhysicalNumberOfCells();
				//创建一个缓冲区对象来存放每个格里的内容
				StringBuffer stringBuffer = new StringBuffer();
				//循环取出每个格子里的内容
				for(int j = 0;j <physicalNumberOfCells;j++){
					//根据每个格的格标j，通过行对象row来获取格对象cell
					Cell cell = row.getCell(j);
					//判断格的类型
					if(cell.getCellTypeEnum()==CellType.STRING){
						//将格的内容添加到缓冲区
						stringBuffer.append(cell.getStringCellValue()+"~");
					}else if(cell.getCellTypeEnum()==CellType.NUMERIC){
						//创建数字格式化工具
						DecimalFormat df = new DecimalFormat("####");
						
						//将格的内容添加到缓冲区
						stringBuffer.append(df.format(cell.getNumericCellValue())+"~");
					}
				}
				//分析一行的内容
				String hang = stringBuffer.toString();
				String [] rows = hang.split("~");
				NewStudent newStudent = new NewStudent();
				newStudent.setName(rows[1]);
				newStudent.setScore(Double.parseDouble(rows[2]));
				newStudent.setPhone(rows[3]);
				System.out.println(newStudent);
				//保存学生信息
				stuservice.saveStu(newStudent);
			}
			workbook.close();
			
		} catch (EncryptedDocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvalidFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		model.addAttribute("msg", originalFilename);
		return "success";
	}
	
}
