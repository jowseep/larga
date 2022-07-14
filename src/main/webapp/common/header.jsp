<%@ page contentType = "text/html; charset = UTF-8" %> <%@ taglib prefix = "s"
uri = "/struts-tags" %>
<header>
  <nav>
    <ul class="nav-list">
      <li class="nav-list">
        <p><a href="<s:url action='book'/>">Book</a></p>
      </li>
      <li class="nav-list">
        <p><a href="<s:url action='news'/>">News</a></p>
      </li>
      <li class="nav-list">
        <p><a href="<s:url action='weather'/>">Weather</a></p>
      </li>
      <li class="nav-list">
        <p><a href="<s:url action='index'/>">Home</a></p>
      </li>
    </ul>
  </nav>
</header>