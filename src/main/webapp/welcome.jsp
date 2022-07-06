<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="stylesheet" href="common/style.css">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <title>Welcome | Larga</title>
  </head>
    <s:include value="./common/header.jsp" />
    <h2 class="maayo">Maayong pag-abot</h2>
    <p class="maayo"><a href="https://larga.hub.loginradius.com/auth.aspx?action=logout&return_url=http://localhost:8080/basic-struts/index" >I-logout gamit ang LoginRadius</a></p>
    <p class="maayo"><a href="<s:url action='list'/>">I logout ang account</a></p>
    <p class="maayo"><a href="https://larga.hub.loginradius.com/auth.aspx?action=forgotpassword&return_url=http://localhost:8080/basic-struts/index" >Kalimot kos password</a></p>

    <div class="container">
      <div class="row">
          <!-- since the matching information is already stored in accountFound, we can then access its attributes -->
          <div class="col-md-4 mt-1">
              <div class="card text-center sidebar">
                  <div class="card-body">
                      <img src="" alt="profile" class="rounded-circle" width="150">
                      <div class="mt-3"></div>
                      <h2>
                          <span><s:property value="account.username"/></span>
                      </h2>
                  </div>
              </div>
          </div>
          <div class="col-md-8 mt-1">
              <div class="card mb-3 content">
                  <h1 class="m-3">About</h1>
                  <div class="card-body">
                      <div class="row">
                          <div class="col-md-3">
                              <h5>Ngan: </h5>
                          </div>
                          <div class="col-md-9 text-secondary">
                              <span><s:property value="account.firstName"/></span>
                              <span><s:property value="account.lastName"/></span>
                          </div>
                      </div>
                      <hr>
                      <div class="row">
                          <div class="col-md-3">
                              <h5>Natawhan:</h5>
                          </div>
                          <div class="col-md-9 text-secondary">
                              <span><s:property value="account.birthDate"/></span>
                          </div>
                      </div>
                      <hr>
                      <div class="row">
                          <div class="col-md-3">
                              <h5>Email</h5>
                          </div>
                          <div class="col-md-9 text-secondary">
                              <span><s:property value="account.email"/></span>
                          </div>
                      </div>
                  </div>
              </div>
              <div class="card mb-3 content">
                  <h1 class="m-3"><s:property value="accountFound.status"></s:property></h1>
                  <div class="card-body">
                      <div class="row">
                          <div class="col-md-3">
                              <s:set var="accountType" value="accountFound.status"/>
                              <!-- ang accountFound.accountType is stored na siya sa typeAccount so no need to reiterate when accessing-->
                              <s:if test="%{#accountType == 'admin'}">
                                  <p>Admin information</p>
                                  <p>Number of booked seats: 754</p>
                                  <p>Revenue over the last 2 months: P866,491.43</p>
                                  <p>Growth for the last month: 101%</p>
                              </s:if>
                              <s:else>
                                  <p>I refer imohang friend</p>
                              </s:else>
                          </div>
                      </div>
                  </div>
              </div>
          </div>
      </div>
  </div>
  </body>
</html>