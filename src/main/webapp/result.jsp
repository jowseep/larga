<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8" %> <%@ taglib prefix="s" uri="/struts-tags" %>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <link rel="stylesheet" href="./common/style.css">
    <title>Result | Larga!</title>
  </head>
  <body>
    <s:include value="./common/header.jsp" />

    <h3>Booking result:</h3>  
    <s:iterator value="travel">  
    <fieldset>
        <s:property value="departure_city"/><br/>   
        <s:property value="arrival_city"/><br/>
        <s:property value="bus_company"/><br/>
        <s:property value="price"/><br/>
        <s:property value="time"/><br/>
        <s:property value="date"/><br/>
        <s:url value="seats" var="seats">
          <s:param name="id" value="%{id}" />
          <s:param name="date" value="%{date}" />
        </s:url>
        <a href="${seats}">Select</a>
    </fieldset>  
    </s:iterator>
  
  </body>
</html>