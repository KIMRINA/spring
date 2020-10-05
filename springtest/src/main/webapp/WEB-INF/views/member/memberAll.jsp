<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!-- tiles는 바디이런것들 필요없음 -->
<h3 class="page_title">회원 전체조회</h3>
<ul class="search">
	<li>메일수신여부</li>
	<li>성별</li>
	<li><button type="button">검색</button>
</ul>
<table border=1 id="members">
<thead>
  <tr>
    <th>id</th>
    <th>pw</th>
    <th>job</th>
    <th>reason</th>
    <th>gender</th>
    <th>mailyn</th>
    <th>hobby</th>
    <th>regdate</th>
  </tr>
</thead>
  <tbody>
  <c:forEach items="${list}" var="member">

  <tr>
    <td><a href="memberSelect?id=${member.id}">${member.id}</a></td>
    <td>${member.getPw()}</td>
    <td>${member.getJob()}</td>
    <td>${member.getReason()}</td>
    <td>${member.getGender()}</td>
    <td>${member.getMailyn()}
    <button type="button">메일발송</button>
    </td>
    <td>${member.getHobby()}</td>
    <td>${member.getRegdate()}</td>
  </tr>
  </c:forEach>
  </tbody>
</table>
</body>
</html>