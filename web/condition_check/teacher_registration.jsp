<%-- 
    Document   : teacher_registration
    Created on : Sep 4, 2018, 9:24:56 PM
    Author     : DELL
--%>




<%@page import="org.apache.tomcat.util.http.fileupload.FileItem"%>
<%@page import="java.util.List"%>

<%--<%@page import=%>--%>
<%--<%@page import=%>--%>
<%--<%@page import=%>--%>
<%--<%@page import=%>--%>

                <!--org.apache.commons.fileupload.FileItem,-->
                <!--org.apache.commons.fileupload.servlet.ServletFileUpload,-->
                <!--org.apache.commons.fileupload.disk.DiskFileItemFactory,-->
<%@page import="org.apache.tomcat.util.http.fileupload.disk.DiskFileItemFactory"%>
<%@page import="org.apache.tomcat.util.http.fileupload.FileItemFactory"%>
<%@page import="org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload"%>
<%@page import="org.apache.tomcat.util.http.fileupload.FileUpload"%>
<%@page import="com.bean.Teacher"%>
<%@page import="java.io.FileOutputStream"%>
<%@page import="java.io.File"%>
<%@page import="javax.servlet.annotation.MultipartConfig"%>
<%@page import="java.io.DataInputStream"%>
<%@page import="com.dao.TeacherDatabaseManager"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>


<jsp:useBean  class="com.bean.Teacher" id="teacher"></jsp:useBean>
<jsp:setProperty name="teacher" property="*"></jsp:setProperty>

    <!DOCTYPE html>

<%

    String saveFile = "";
    String contentType = request.getContentType();
    if ((contentType != null) && (contentType.indexOf("multipart/form-data") >= 0)) {
        teacher.setName(request.getParameter("name"));
        DataInputStream in = new DataInputStream(request.getInputStream());

        int formDataLength = request.getContentLength();
        byte databytes[] = new byte[formDataLength];
        int byteRead = 0;
        int totalBytesRead = 0;
        while (totalBytesRead < formDataLength) {
            byteRead = in.read(databytes, totalBytesRead, formDataLength);
            totalBytesRead += byteRead;
        }
        String file = new String(databytes);
        saveFile = file.substring(file.indexOf("filename=\"") + 10);
        saveFile = saveFile.substring(0, saveFile.indexOf("\n"));
        saveFile = saveFile.substring(saveFile.lastIndexOf("\\") + 1, saveFile.indexOf("\""));
        int lastIndex = contentType.lastIndexOf("=");
        String boundary = contentType.substring(lastIndex + 1, contentType.length());
        int pos;
        pos = file.indexOf("filename=\"");
        pos = file.indexOf("\n", pos) + 1;
        pos = file.indexOf("\n", pos) + 1;
        pos = file.indexOf("\n", pos) + 1;
        int boundaryLocation = file.indexOf(boundary, pos) - 4;
        int startPos = ((file.substring(0, pos)).getBytes()).length;
        int endPoint = ((file.substring(0, boundaryLocation)).getBytes()).length;
        File ff = new File("F:\\Project\\Java Web\\New Folder\\DIU Routine Planner\\web\\images\\teacher\\" + saveFile);
        FileOutputStream fileOut = new FileOutputStream(ff);
        fileOut.write(databytes, startPos, (endPoint - startPos));
        fileOut.flush();
        fileOut.close();
    }
    

//boolean isMultipart = ServletFileUpload.isMultipartContent(request);
//      FileItemFactory factory = new DiskFileItemFactory();
//      ServletFileUpload upload = new ServletFileUpload(factory);
//       
//      /* CHECK FORM = MULTIPART */
//      if(isMultipart) {
//          List<FileItem> uploadItems = upload.parseRequest(request);
//          for(FileItem uploadItem : uploadItems)
//          {
//            if(uploadItem.isFormField())
//            {
//              String fieldName = uploadItem.getFieldName();
//              desc = uploadItem.getString();
//            }
//          }
//      }


%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title><%=teacher.getName()%></title>
        <% int status = TeacherDatabaseManager.registrationTeacher(teacher);%>
    </head>
    <body>
        <h1>Registration Success <em style="color: #cc0033"><%=teacher.getName()%></em></h1>
    </body>
</html>
