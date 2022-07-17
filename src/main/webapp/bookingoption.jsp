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
    <h2>Would you like to log in to keep track of all your bookings?</h2>

    <s:url value="bookguest" var="bookguest">
          <s:param name="id" value="%{id}" />
          <s:param name="date" value="%{date}" />
          <s:param name="seatchosen" value="%{seatchosen}" />
    </s:url>
    <s:url value="index" var="index">
          <s:param name="id" value="%{id}" />
          <s:param name="date" value="%{date}" />
          <s:param name="seatchosen" value="%{seatchosen}" />
    </s:url>
    <p><a href="${bookguest}">Book as guest</a></p>
    <p></p><a href="${index}">Login or Sign up</a></p>
    
  </body>
</html>