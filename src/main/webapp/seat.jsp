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
    <div class="containerst">
      <div class="intro">
        <h1>Choose your seat: </h1>
        <s:form action="bookingOption">
            <s:textfield name="seatchosen" label="Seat" class="username" placeholder="Seat #"/><br>
            <s:hidden name="seatchosen" value="%{seatchosen}"/>
            <s:hidden name="date" value="%{date}"/>
            <s:hidden name="id" value="%{id}"/>
            <s:submit value="Select" class="submit"/>
        </s:form>
      </div>
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
              <td style="background-color:red;"></td>
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
              <td style="background-color:red;"></td>
              <td></td>
              <td></td>
            </tr>
            <tr>
              <td>E</td>
              <td style="background-color:red;"></td>
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
              <td style="background-color:red;"></td>
              <td></td>
              <td></td>
            </tr>
            <tr>
              <td>H</td>
              <td></td>
              <td></td>
              <td style="background-color:red;"></td>
              <td></td>
            </tr>
            <tr>
              <td>I</td>
              <td></td>
              <td></td>
              <td></td>
              <td style="background-color:red;"></td>
            </tr>
            <tr>
              <td>J</td>
              <td style="background-color:red;"></td>
              <td></td>
              <td></td>
              <td></td>
            </tr>
          </tbody>
          </table>
    </div>
  </body>
</html>

