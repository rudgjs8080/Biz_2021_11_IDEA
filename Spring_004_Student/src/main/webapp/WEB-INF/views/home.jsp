<%--
  Created by IntelliJ IDEA.
  User: 403
  Date: 2021-11-03
  Time: 오전 9:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="rootPath" value="${pageContext.request.contextPath}"/>
<html>
<head>
    <title>학사관리 시스템</title>
</head>
<link href="${rootPath}/static/css/home.css" rel="stylesheet"/>

<body>
<div class="main_header">${MY}<br>학사관리 시스템</div>
<div class="nav">
    <div class="home">Home</div>
    <div class="list_student">학생정보</div>
    <div class="list_grade">성적일람표</div>
    <div class="login">로그인</div>
</div>
<div class="main">
    <c:choose>
        <c:when test="${BODY eq 'ST-LIST'}">
            <%@ include file="/WEB-INF/views/student/list.jsp"%>
        </c:when>
        <c:when test="${BODY eq 'GR-LIST'}">
            <%@ include file="/WEB-INF/views/grade/list.jsp"%>
        </c:when>
        <c:when test="${BODY eq 'LOGIN'}">
            <%@ include file="/WEB-INF/views/member/login.jsp"%>
        </c:when>
        <c:otherwise>
            <h1 class="main_home">이곳은 홈입니다~</h1>
        </c:otherwise>
    </c:choose>

</div>
</body>
<script>
    const nav = document.querySelector("div.nav")
    if(nav) {
        nav.addEventListener("click", (e) => {
            let menu = e.target
            if(menu.tagName === "DIV"){
                if(menu.innerText === "학생정보"){
                    location.href = "${rootPath}/student/list"
                } else if(menu.innerText === "성적일람표"){
                    location.href = "${rootPath}/grade/list"
                } else if(menu.innerText === "로그인"){
                    location.href = "${rootPath}/member/login"
                } else if(menu.innerText === "Home"){
                    location.href = "${rootPath}"
                }
            }
        })
    }
</script>
</html>
