<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <link rel="stylesheet" href="./common/style.css">
    <title>Register</title>
  </head>
  <body>
    <s:include value="./common/header.jsp" />

    <div class="login-whole">
      <h1 class="login-header">Pag register sa</h1>
      <div class="login-form">
        <s:form action="register">
            <s:textfield name="account.firstName" class="reg" placeholder="Firstname" /><br>
            <s:textfield name="account.lastName" class="reg" placeholder="Lastname" /><br>
            <s:textfield name="account.username" class="reg" placeholder="Username" /><br>
            <s:password name="account.password" class="reg" placeholder="Password"/><br>
            <s:textfield name="account.email" class="reg" placeholder="Email" /><br>
            <s:submit class="submit"/>
        </s:form>
      </div>
    </div>
  </body>
</html>