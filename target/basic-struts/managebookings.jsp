<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="sx" uri="/struts-dojo-tags" %>
<!DOCTYPE html>
<html>
  <head>
    <link rel="stylesheet" href="common/style.css">
  </head>
  <body>
    <s:include value="./common/header.jsp" />
    <s:set var="booking_reference" value="booking.booking_reference"/>
    <s:if test="%{#booking_reference == null}">
      <p>You have no bookings. You may click here to book yours.</p>
    </s:if>
    <s:else>
      <h2>Your current bookings: </h2>
      <s:iterator value="booking">  
      <fieldset>  
          <p>Booking reference: <s:property value="booking_reference"/></p>
          <p>Departure city: <s:property value="departure_city"/></p>
          <p>Arrival city: <s:property value="arrival_city"/></p>
          <p>Travel date: <s:property value="travel_date"/></p>
          <p>Time: <s:property value="travel_time"/></p>
          <p>Booking date: <s:property value="booking_date"/></p>
          <p>Bus operator: <s:property value="bus_operator"/></p>
          <p>Seat no: <s:property value="seat"/></p>
          <a href="<s:url action='cancelbooking'/>">Cancel booking</a>
      </fieldset>  
      </s:iterator>
  </s:else>
  </body>
</html>
