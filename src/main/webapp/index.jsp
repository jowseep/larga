<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8" %> <%@ taglib prefix="s" uri="/struts-tags" %>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <link rel="stylesheet" href="./common/style.css">
    <title>Home | Larga!</title>
  </head>
  <body>
    <s:include value="./common/header.jsp" />
    
    <div class="login-whole">
      <h1 class="login-header">Pag log-in sa</h1>
      <div class="login-form">
        <s:form action="unauthlogin">
          <s:textfield name="username" label="Username" class="username" placeholder="Username"/><br>
          <s:password name="password" label="Password" class="username" placeholder="Password"/><br>
          <s:submit value="Login" class="submit"><s:param name="token">${token}</s:param></s:submit>
        </s:form>
      </div>
      <div class="options">
        <p><a href="register.jsp">Register</a></p>
        <p><a href="<s:url action='list'/>">List of users</a></p>
        <p><a href="https://larga.hub.loginradius.com/auth.aspx?action=login&return_url=http://localhost:8080/basic-struts/login">Login with LoginRadius</a></p>
      </div>
    </div>
  </body>
</html>

