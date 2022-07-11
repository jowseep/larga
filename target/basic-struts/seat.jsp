<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8" %> <%@ taglib prefix="s" uri="/struts-tags" %>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <link rel="stylesheet" href="./common/style.css">
    <title>Seats | Larga!</title>
  </head>
  <body>
    <s:include value="./common/header.jsp" />

    <s:property value="%{date}"/><br/>
    <s:property value="%{id}"/><br/> 
    <!-- mao ni siya atong sa travel id -->
    <!-- <s:iterator value="travel">  
    <fieldset>  
        <s:property value="departure"/><br/> 
        <s:property value="arrival"/><br/>
        <s:property value="bus_company"/><br/>
        <s:property value="time"/><br/>
        <s:property value="price"/><br/>
        <hr>
    </fieldset>  
    </s:iterator> -->
    
    <s:form action="seatchosen">
        <s:textfield name="seatchosen" label="Seat" class="username" placeholder="Seat #"/><br>
        <s:hidden name="seatchosen" value="%{seatchosen}"/>
        <s:hidden name="date" value="%{date}"/>
        <s:hidden name="id" value="%{id}"/>
        <s:submit value="Select" class="submit"/>
    </s:form>
    <table class="table">
        <thead>
          <tr>
            <td></td>
            <td>1</td>
            <td>2</td>
            <td>3</td>
            <td>4</td>
          </tr>
        </thead>
        <tbody>
          <tr>
            <td>A</td>
            <td style="background-color:red;"></td>
            <td></td>
            <td></td>
            <td></td>
          </tr>
          <tr>
            <td>B</td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
          </tr>
          <tr>
            <td>C</td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
          </tr>
          <tr>
            <td>D</td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
          </tr>
          <tr>
            <td>E</td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
          </tr>
          <tr>
            <td>F</td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
          </tr>
          <tr>
            <td>G</td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
          </tr>
          <tr>
            <td>H</td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
          </tr>
          <tr>
            <td>I</td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
          </tr>
          <tr>
            <td>J</td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
          </tr>
        </tbody>
        </table>
  </body>
</html>

