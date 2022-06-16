<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
  <head>
    <link rel="stylesheet" href="./common/style.css">
    <title>News | Larga!</title>
  </head>
  <body>
    <s:include value="./common/header.jsp" />
    <h3>News for today's video:</h3>
    <p><a href="index.jsp">Home</a></p>
    <s:form action="search">
      <s:select label="Language" 
        headerKey="-1" headerValue="Select language"
        list="languages" 
        name="yourLanguage" />
        <s:select label="Sort by" 
        headerKey="-1" headerValue="Select sort"
        list="sorts" 
        name="yourSort" />
      <s:textfield name="search" label="Search"/>
      <s:submit value="Search"/>
    </s:form>
      <s:iterator value="newsResponse.articles">
          <fieldset>
              <p><s:property value="publishedAt"/></p>
              <p><s:property value="title"/></p>
              <p><s:property value="author"/></p>
              <p><s:property value="description"/></p>
              <s:url value="url" var="url"/>
              <p><s:a href="%{url}">Read more</s:a></p>
          </fieldset>
        </s:iterator>
  </body>
</html>
