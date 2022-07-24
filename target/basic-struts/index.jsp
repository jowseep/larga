<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8" %> <%@ taglib prefix="s" uri="/struts-tags" %>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <link rel="stylesheet" href="./common/style.css">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <title>Home | Larga!</title>
  </head>
  <body>
    <header>
      <nav>
        <ul class="nav-list">
          <li class="nav-list">
            <p><a href="<s:url action='book'/>" class="btn btn-success">Book Now</a></p>
          </li>
        </ul>
      </nav>
    </header>
    <!-- <nav class="navbar">
      <div class="container-fluid">
        <a class="navbar-brand">Larga</a>
        <form class="d-flex" role="search">
          <button class="btn btn-outline-success" type="submit">Search</button>
        </form>
      </div>
    </nav> -->
    
    <div class="login-whole">
      <h1 class="login-header">Login</h1>
      <div class="login-form">
        <s:form action="regularlogin">
          <s:textfield name="username" label="Username" class="username" placeholder="Username"/><br>
          <s:password name="password" label="Password" class="username" placeholder="Password"/><br>
          <s:submit value="Login" class="submit btn-success"/>
        </s:form>
      </div>
      <div class="options">
        <p><a href="register.jsp">Not yet a member?</a></p>
        <!-- <p><a href="<s:url action='list'/>">List of users</a></p> -->
        <!-- <p><a href="https://accounts.google.com/o/oauth2/v2/auth?scope=https://mail.google.com/&access_type=offline&include_granted_scopes=true&response_type=code&state=state_parameter_passthrough_value&redirect_uri=http://localhost:8080/basic-struts/welcome.jsp&client_id=34650846950-84j231ogscd1ucsa5dsu67em97lustuq.apps.googleusercontent.com">Login with Google</a></p> -->
      </div>
    </div>

  </body>
</html>

