<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8" %> <%@ taglib prefix="s" uri="/struts-tags" %>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <link rel="stylesheet" href="./common/style.css">
    <title>Booking Options | Larga!</title>
  </head>
  <body>
    <s:include value="./common/header.jsp" />

    <h1>Oops! You're not logged in yet.</h1>
    <h2>Would you like to log in to keep track of your bookings?</h2>

    <p><a href="<s:url action='seatchosen'/>">Book as guest</a></p>
    <p><a href="<s:url action='index'/>">Sign in</a></p>
    
  </body>
</html>

