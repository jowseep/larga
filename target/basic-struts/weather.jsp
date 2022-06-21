<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
  <head>
    <link rel="stylesheet" href="./common/style.css" type="text/css">
    <title>Weather | Larga!</title>
  </head>
    <body>
        <s:include value="./common/header.jsp" />
        <div class="intro">
            <h1>Weather for today's video</h1>
            <s:form action="weather">
                <s:textfield name="city" placeholder="Enter city" class="city"/>
                <s:submit value="Search City" class="submit"/>
            </s:form>
        </div>
        <s:iterator value="dataResponse.data">  
            <fieldset class="weatherst">
                <div class="news">
                    <div class="news-font">
                        <h3><s:property value="city_name" /></h3><br/>
                    </div>
                    <span>Timezone: <s:property value="timezone" /></span><br/>
                    <span>Weather: <s:property value="weather.description" /></span><br/>
                    <span>Temperature in Celcius: <s:property value="temp" /><span>&deg;C</span></span><br/>
                    <span>Date and time: <s:property value="datetime" /></span><br/>
                    <span>Longitude: <s:property value="lon" /></span><br/>
                    <span>Latitude: <s:property value="lat" /></span><br/>
                    <span>Wind direction: <s:property value="wind_cdir_full" /></span><br/>
                </div>
            </fieldset>  
        </s:iterator>
        </div>
    </body>
</html>