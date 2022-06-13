<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
  <head>
    <sx:head />
  </head>
  <body>
    <h3>News for today's video:</h3>  
    <s:iterator value="newsResponse.articles">  
        <fieldset>  
            <s:property value="title"/><br/> 
            <s:property value="author"/><br/>
            <s:property value="content"/><br/>
        </fieldset>  
    </s:iterator>
  </body>
</html>
