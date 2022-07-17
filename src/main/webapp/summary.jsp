<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8" %> <%@ taglib prefix="s" uri="/struts-tags" %>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <link rel="stylesheet" href="./common/style.css">
    <title>Summary | Larga!</title>
  </head>
  <body>
    <s:include value="./common/header.jsp" />
    
    <h1>Summary of your booking:</h1>
    <span>The date is: <s:property value="date"/></span><br>
    <span>Seat chosen is: <s:property value="seatchosen"/></span><br>
    <span>Arrival:  <s:property value="travel.arrival"/></span><br>
    <span>Departure:  <s:property value="travel.departure"/></span><br>
    <span>Bus company:  <s:property value="travel.bus_company"/></span><br>
    <span>Price:  <s:property value="travel.price"/></span><br>
    <span>Time:  <s:property value="travel.time"/></span><br>
    <s:if test="%{#session.token == null}">
      <s:form action="confirm">
        <s:textfield name="firstName" label="Firstname" class="username" placeholder="Firstname"/><br>
        <s:textfield name="lastName" label="Lastname" class="username" placeholder="Lastname"/><br>
        <s:textfield name="email" label="Email address" class="username" placeholder="Email"/><br>
        <s:hidden name="seatchosen" value="%{seatchosen}"/>
        <s:hidden name="date" value="%{date}"/>
        <s:hidden name="id" value="%{id}"/>
        <s:submit value="Select" class="submit"/>
      </s:form>
    </s:if>
    <s:else>
      <s:url value="confirm" var="confirm">
          <s:param name="id" value="%{id}" />
          <s:param name="date" value="%{date}" />
          <s:param name="seatchosen" value="%{seatchosen}" />
    </s:url>
    <a href="${confirm}">Confirm booking</a>
    </s:else>
  </body>
</html>

