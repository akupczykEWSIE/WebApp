<%@page import="patterns.mvc.model.Student"%>
<%@page import="patterns.mvc.controller.StudentController"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Lista studentów</title>
</head>
<body>
<h1>Lista studentów</h1>
<%  
StudentController sc = StudentController.getInstance(); 
for (Student student : sc.getStudentListDB()) {
	out.println(student.toString() + "<br>");  
}
%> 
</body>
</html>