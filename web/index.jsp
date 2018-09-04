<%-- 
    Document   : index
    Created on : Sep 4, 2018, 11:50:23 AM
    Author     : DELL
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1><hr>

    <center>

        <form action="registration-teacher" method="POST" >
            <input type="text" placeholder="ID Number" name="teacherID"><br>
            <input type="text" placeholder="Name" name="name"><br>
            <input type="text" placeholder="Designation" name="designation"><br>
            <input type="text" placeholder="Phone Number" name="phoneNumber"><br>
            <input type="file"  name="image_location"><br>
            <input type="submit"  value="save"><br>
            


        </form>
    </center>
</body>
</html>
