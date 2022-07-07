<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8" %> <%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="sx" uri="/struts-dojo-tags" %>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <link rel="stylesheet" href="./common/style.css">
    <title>Book | Larga!</title>
    <sx:head />
  </head>
  <body>
    <s:include value="./common/header.jsp" />
    
    <div class="login-whole">
      <h1 class="login-header">Book Now</h1>
      <div class="login-form">
        <s:form action="result">
          <s:select label="What's your favor search engine" 
            headerKey="-1" headerValue="Departure City"
            list="cities" 
            name="departure_city" 
            class="username" /><br>
            <s:select label="What's your favor search engine" 
            headerKey="-1" headerValue="Arrival City"
            list="cities" 
            name="arrival_city" 
            class="username" /><br>
            <sx:datetimepicker name="date" 
            displayFormat="dd-MMM-yyyy" value="%{'today'}"/><br>
          <s:submit value="Ibook na nako" class="submit"/>
        </s:form>
      </div>
    </div>
  </body>
</html>

