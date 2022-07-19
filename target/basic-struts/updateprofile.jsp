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
    <h1>Update your profile</h1>

    <s:form action="updateprofile">
      <p>Firstname: <s:textfield name="firstName" class="username" placeholder="%{firstName}"/></p>
      <p>Lastname: <s:textfield name="lastName" class="username" placeholder="%{lastName}"/></p>
      <p>Email address: <s:textfield name="email" class="username" placeholder="%{email}"/></p>
      <s:submit value="Select" class="submit"/>
    </s:form>

  </body>
</html>