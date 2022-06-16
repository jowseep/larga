<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="sx" uri="/struts-dojo-tags" %>
<!DOCTYPE html>
<html>
  <head>
    <link rel="stylesheet" href="common/style.css">
  </head>
  <body>
    <s:include value="./common/header.jsp" />
    <h3>Account Search:</h3>
    <s:form action="userAccount">
        <sx:autocompleter
            label="Enter first name"
            list="firstNames"
            name="nameInput"
        />
        <s:submit/>
    </s:form>
    
    <h3>All User Records:</h3>  
    <s:iterator value="account">  
    <fieldset>  
        <s:property value="firstName"/><br/> 
        <s:property value="lastName"/><br/>
        <s:property value="username"/><br/>
        <s:property value="birthDate"/><br/>
        <s:property value="email"/><br/><hr>
    </fieldset>  
    </s:iterator>
  </body>
</html>
