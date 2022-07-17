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

    <h1 class="result">Booking result:</h1>
    <div class="head">
      <s:iterator value="travel">  
      <fieldset class="newst">
        <div class="news">
            <p>Departure City: <s:property value="departure_city"/></p><br/>   
            <p>Arrival City: <s:property value="arrival_city"/></p><br/>
            <p>Bus Company: <s:property value="bus_company"/></p><br/>
            <p>Price: </p><s:property value="price"/></p><br/>
            <p>Time: </p><s:property value="time"/></p><br/>
            <p>Date: </p><s:property value="date"/></p><br/>
            <s:url value="seats" var="seats">
              <s:param name="id" value="%{id}" />
              <s:param name="date" value="%{date}" />
            </s:url>
            <a href="${seats}">Select</a>
        </div>
      </fieldset>  
      </s:iterator>
    </div>  
  </body>
</html>