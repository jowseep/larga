<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="sx" uri="/struts-dojo-tags" %>
<!DOCTYPE html>
<html>
  <head>
    <link rel="stylesheet" href="common/style.css">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
  </head>
  <body>
    <s:include value="./common/header.jsp" />
    <h1 class="mx-2">All bookings: </h1>
    <div class="head">
      <s:iterator value="booking">  
      <fieldset class="newst">
        <div class="news">
          <p>Booking reference: <s:property value="booking_reference"/></p>
          <p>Firstname: <s:property value="firstName"/></p>
          <p>Lastname: <s:property value="lastName"/></p>
          <p>Email: <s:property value="email"/></p>
          <p>Departure city: <s:property value="departure_city"/></p>
          <p>Arrival city: <s:property value="arrival_city"/></p>
          <p>Travel date: <s:property value="travel_date"/></p>
          <p>Time: <s:property value="travel_time"/></p>
          <p>Booking date: <s:property value="booking_date"/></p>
          <p>Bus operator: <s:property value="bus_operator"/></p>
          <p>Seat no: <s:property value="seat"/></p>
          <s:url value="confirmbookinguser" var="confirmbookinguser">
              <s:param name="booking_reference" value="%{booking_reference}" />
          </s:url>
          <a href="${confirmbookinguser}" class="btn btn-success btn-md mt-3">Accept and confirm booking</a>
        </div>
      </fieldset> 
      </s:iterator>
    </div>
  </body>
</html>
