<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
   
    
    <title>My JSP 'Bar.jsp' starting page</title>
    <!-- 引入echarts的js脚本 -->
	<script type="text/javascript" src="js/echarts.min.js"></script>
	<script type="text/javascript" src="js/jquery-1.7.2.js"></script>

  </head>
  
  <body>
  <!-- 创建一个盒子放柱状图 -->
  <div id="box" style="width:900px;height:600px;"></div>

	<!-- 初始化柱状图 -->
	<script type="text/javascript">
	//初始化Echarts实例对象，将初始化的图表捆绑在box盒子上
	var mychart = echarts.init(document.getElementById("box"));
	
	
	//配置图表的属性
	var option = {
		title:{
			text:"学生的饼状图演示"
		},
		
		series:[{
			name:"成绩",
			type:"pie",
			data:[]
		}]
	
	};
	mychart.setOption(option);
	
	//显示加载动画
	mychart.showLoading();
	var names = [];
	var scores = [];
	//发出ajax请求
	$.ajax({
		type:'post',
		async:"true",
		url:"getallstupie",
		data:{},
		dataType:'json',
		success:function(result){
			if(result){
			//隐藏加载动画
			mychart.hideLoading();
			//设置echart的配置项
			mychart.setOption({
				series:[{
					data:result
				}]
			 });
			 
			}
		},
		error:function(){
			alert("图表数据请求异常");
		}
	})
	
	
	
	
	</script>
  </body>
</html>
