<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Welcome page...</title>
  </head>
    <h2>Welcome!</h2>
    <p><s:property value="account.firstName" /></p>
    <p><a href="book.jsp">Book now</a>.</p>
    <p><a href="https://larga.hub.loginradius.com/auth.aspx?action=logout&return_url=http://localhost:8080/basic-struts/index" >Logout</a>.</p>
  </body>
</html>