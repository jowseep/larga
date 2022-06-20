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
    <div class="newstoday">
      <h1>News for today's video</h1>
      <div class="search-form">
        <s:form action="search">
          <s:select label="Language" 
            headerKey="-1" headerValue="Select language"
            list="languages" 
            name="yourLanguage" 
            class="dropdown"/>
            <s:select label="Sort by" 
            headerKey="-1" headerValue="Select sort"
            list="sorts" 
            name="yourSort" 
            class="dropdown"/>
          <s:textfield name="search" label="Search" class="city"/>
          <s:submit value="Search" class="submit"/>
        </s:form>
      </div>
    </div>
    <div class="head">
        <s:iterator value="newsResponse.articles">
            <fieldset class="newst">
              <div class="news">
                <p><s:property value="publishedAt"/></p>
                <p><s:property value="title"/></p>
                <p><s:property value="author"/></p>
                <p><s:property value="description"/></p>
                <s:url value="url" var="url"/>
                <p><s:a href="%{url}">Read more</s:a></p>
              </div>
            </fieldset>
        </s:iterator>
    </div>
  </body>
</html>
