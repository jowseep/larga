<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8" %> <%@ taglib prefix="s" uri="/struts-tags" %>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <link rel="stylesheet" href="./common/style.css">
    <title>Confirmation | Larga!</title>
  </head>
  <body>
    <div class="containerst">
      <h1>Congrats, your booking is confirmed! </h1>
      <p>You should receive an email confirmation shortly. </p>

      <s:if test="%{#session.token == null}">
        <p><a href="<s:url action='book'/>">Book again</a></p>
      </s:if>
      <s:else>
        <p><a href="<s:url action='index'/>">Go to profile</a></p>
      </s:else>
    </div>
  </body>
</html>