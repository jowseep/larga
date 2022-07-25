<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8" %> <%@ taglib prefix="s" uri="/struts-tags" %>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <link rel="stylesheet" href="./common/style.css">
    <title>Confirmation | Larga!</title>
  </head>
  <body>
    <div class="container mt-5">
      <div class="row">
        <div class="col-md-12">
          <h1>Congrats, your booking is confirmed! </h1>
          <p>You should receive an email confirmation shortly. </p>
          <s:if test="%{#session.token == null}">
            <p><a href="<s:url action='book'/>" class="btn btn-primary btn-md">Book again</a></p>
          </s:if>
          <s:else>
            <p><a href="<s:url action='index'/>" class="btn btn-primary btn-md">Check your bookings here.</a></p>
          </s:else>
      </div>
      </div>
    </div>
  </body>
</html>