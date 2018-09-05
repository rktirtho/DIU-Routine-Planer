<%-- 
    Document   : teacher_registration
    Created on : Sep 4, 2018, 9:24:56 PM
    Author     : DELL
--%>

<%@page import="com.dao.TeacherDatabaseManager"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:useBean  class="com.bean.Teacher" id="teacher"></jsp:useBean>
<jsp:setProperty name="teacher" property="*"></jsp:setProperty>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title><%=teacher.getName()%></title>
    <% int status=TeacherDatabaseManager.registrationTeacher(teacher); %>
    </head>
    <body>
        <h1>Registration Success <em style="color: #cc0033"><%=teacher.getName() %></em></h1>
    </body>
</html>
