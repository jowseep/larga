<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8" %> <%@ taglib prefix="s" uri="/struts-tags" %>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <link rel="stylesheet" href="./common/style.css">
    <title>Book | Larga!</title>
  </head>
  <body>
    <s:include value="./common/header.jsp" />
    
    <div class="login-whole">
      <h1 class="login-header">Book na kaw</h1>
      <div class="login-form">
        <s:form action="login">
          <s:textfield name="username" label="Username" class="username" placeholder="Asa ka gikan"/><br>
          <s:textfield name="username" label="Username" class="username" placeholder="Asa ka diay moadto"/><br>
          <s:textfield name="username" label="Username" class="username" placeholder="Unsa nga adlaw pud"/><br>
          <s:submit value="Ibook na nako" class="submit"/>
        </s:form>
      </div>
    </div>
  </body>
</html>

