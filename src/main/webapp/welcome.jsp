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
    <h2 class="maayo">Larga!</h2>
    <!-- <p class="maayo"><a href="https://larga.hub.loginradius.com/auth.aspx?action=logout&return_url=http://localhost:8080/basic-struts/index" >I-logout gamit ang LoginRadius</a></p>
    <p class="maayo"><a href="<s:url action='list'/>">I logout ang account</a></p>
    <p class="maayo"><a href="https://larga.hub.loginradius.com/auth.aspx?action=forgotpassword&return_url=http://localhost:8080/basic-struts/index" >Kalimot kos password</a></p> -->
    <!-- <p class="maayo"><a href="<s:url action='updateprofile'/>">Update Profile</a></p> -->
    <div class="container">
      <div class="row">
          <!-- since the matching information is already stored in accountFound, we can then access its attributes -->
          <div class="col-md-4 mt-1">
              <div class="card text-center sidebar">
                  <div class="card-body">
                      <div class="mt-3"></div>
                      <h3>
                        <span><s:property value="account.firstName"/></span>
                        <span><s:property value="account.lastName"/></span>
                      </h3>
                      <a href="<s:url action='logout'/>" class="btn btn-primary btn-sm">Logout</a>
                  </div>
              </div>
          </div>
          <div class="col-md-8 mt-1">
              <div class="card mb-3 content">
                  <h3 class="m-3">About</h3>
                  <div class="card-body">
                      <div class="row">
                          <div class="col-md-3">
                              <h5>Username: </h5>
                          </div>
                          <div class="col-md-9 text-secondary">
                              <span><s:property value="account.username"/></span>
                          </div>
                      </div>
                      <hr>
                      <div class="row">
                          <div class="col-md-3">
                              <h5>Email address: </h5>
                          </div>
                          <div class="col-md-9 text-secondary">
                              <span><s:property value="account.email"/></span>
                          </div>
                      </div>
                  </div>
              </div>
              <div class="card mb-3 content">
                  <h3 class="m-3">Here's what's more: </h3>
                  <div class="card-body">
                      <div class="row">
                          <div class="col-md-12">
                              <s:set var="accountType" value="account.status"/>
                              <!-- ang accountFound.accountType is stored na siya sa typeAccount so no need to reiterate when accessing-->
                              <s:if test="%{#accountType == 'admin'}">
                                <a href="<s:url action='list'/>" class="btn btn-warning btn-md">List of Users</a><br>
                                <a href="<s:url action='guestlist'/>" class="btn btn-primary btn-md mt-3">Guests Booking List</a><br>
                                <a href="<s:url action='userlist'/>" class="btn btn-success btn-md mt-3">Existing Users List</a>
                              </s:if>
                              <s:elseif test="%{#accountType == 'bus operator'}">
                                <a href="<s:url action='guestlist'/>" class="btn btn-primary btn-md">Guests Booking List</a><br>
                                <a href="<s:url action='userlist'/>" class="btn btn-success btn-md mt-3">Existing Users List</a>
                            </s:elseif>
                            <s:else>
                                <p>Refer a friend.</p>
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