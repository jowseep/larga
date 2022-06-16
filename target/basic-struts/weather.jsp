<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
  <head>
    <link rel="stylesheet" href="./common/style.css" type="text/css">
    <title>Weather | Larga!</title>
  </head>
    <body>
        <s:include value="./common/header.jsp" />

        <h3>Weather for today's video:</h3>
        <s:form action="weather">
            <s:textfield name="city" label="Enter city"/>
        <s:submit value="Search"/>
    </s:form>
        <s:iterator value="dataResponse.data">  
        <fieldset>  
            <s:property value="city_name"/><br/> 
            <s:property value="timezone"/><br/>
            <s:property value="temp"/><br/>
            <s:property value="country_code"/><br/>
        </fieldset>  
    </s:iterator>
    </body>
</html>