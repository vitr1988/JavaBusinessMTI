<%@page import="java.io.IOException"%>
<%@page import="java.io.Writer"%>
<%@page import="java.io.PrintWriter"%>
<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.text.DateFormat"%>
<%@page errorPage="error.jsp" language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE>
<html>
<head>
<title>Тестовая страница JSP</title>
</head>
<body>
<%-- fsdkjgfsfsfg --%>
<!-- fsdkjgfsfsfg -->
<%!
	int index = 1;
	public void print(Writer out, String str){
		try {
		 	out.append(str);
		}
		catch(IOException e){
		}
	}
	
	public void jspInit(){
		
	}
	
	public void jspDestroy(){
		
	}
%>
Текущее время: <%= new SimpleDateFormat("dd.MM.yyyy HH:mm:ss").format(new Date()) %>
<br/>
<%= 10 + 5 %>
<% String str = "Hello World";
   str += " 2016 year!";
   //response.getWriter().println(str);
   print(out, str);
%>
<% String param = request.getParameter("param");
   //if (param.equals("1")){
   //}
   
   String testPage = request.getRealPath("test.html");
%>
<%@include file="test.html" %>

<%--<jsp:include page="<%= testPage %>"> --%>

${5 < 5}

</body>
</html>