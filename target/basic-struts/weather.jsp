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
        <div class="containerst">
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
                            <span>
                                <s:set var="weathertype" value="weather.icon"/>
                                <s:if test="%{#weathertype == 't01n' || #weathertype == 't02n' || #weathertype == 't03n' || #weathertype == 't04n' || #weathertype == 't05n'}">
                                    <img src="./photos/t01n.png" alt="thunder">
                                </s:if>
                                <s:elseif test="%{#weathertype == 'd01n' || #weathertype == 'd02n' || #weathertype == 'd03n'}">
                                    <img src="./photos/d01n.png" alt="drizzle">
                                </s:elseif>
                                <s:elseif test="%{#weathertype == 'r01n' || #weathertype == 'r02n' || #weathertype == 'r03n' || #weathertype == 'f01n' || #weathertype == 'r04n' || #weathertype == 'r05n' || #weathertype == 'r06n'}">
                                    <img src="./photos/r01n.png" alt="rain">
                                </s:elseif>
                                <s:elseif test="%{#weathertype == 's01n' || #weathertype == 's02n' || #weathertype == 's03n' || #weathertype == 's04n' || #weathertype == 's05n'}">
                                    <img src="./photos/s01n.png" alt="snow">
                                </s:elseif>
                                <s:elseif test="%{#weathertype == 'a01n' || #weathertype == 'a02n' || #weathertype == 'a03n' || #weathertype == 'a04n' || #weathertype == 'a05n' || #weathertype == 'a06n'}">
                                    <img src="./photos/a01n.png" alt="haze">
                                </s:elseif>
                                <s:elseif test="%{#weathertype == 'c01n'}">
                                    <img src="./photos/c01n.png" alt="clearsky">
                                </s:elseif>
                                <s:elseif test="%{#weathertype == 'c02n' || #weathertype == 'c03n' || #weathertype == 'c04n'}">
                                    <img src="./photos/c02n.png" alt="cloudy">
                                </s:elseif>
                                <s:else>
                                    <img src="./photos/r01n.png" alt="clearsky">
                                </s:else>
                            </span>
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