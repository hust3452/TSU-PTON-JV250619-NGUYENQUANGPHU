<%--
  Created by IntelliJ IDEA.
  User: Nguyen Quang Phu
  Date: 2025/11/27
  Time: 18:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>HOME</title>
</head>
<body>
<form action="/working" method="get">
    <input>
    <button>Search</button>
</form>

<table border="1">
    <thead>
    <tr>
        <th>Id</th>
        <th>WorkingName</th>
        <th>PersonName</th>
        <th>StartDate</th>
        <th>Duration</th>
        <th>DurationUnit</th>
        <th>Description</th>
        <th>Progress</th>
        <th>Image</th>
        <th>Status</th>
        <th>Action</th>
    </tr>
    </thead>

    <tbody>
    <c:forEach items="${workings}" var="working">
        <tr>
            <td>${working.id}</td>
            <td>${working.workingName}</td>
            <td>${working.personName}</td>
            <td>${working.startDate}</td>
            <td>${working.duration}</td>
            <td>${working.durationUnit}</td>
            <td>${working.workingDescription}</td>
            <td>${working.workingProgress}</td>
            <td><img src="${working.workingImage}" alt="${working.workingName}" height="50" width="50"/></td>
            <td>
                <c:choose>
                    <c:when test="${working.status == null}">
                        Working
                    </c:when>
                    <c:when test="${working.status == 'CANCEL'}">
                        Cancel
                    </c:when>
                    <c:when test="${working.status == 'WORKING'}">
                        Working
                    </c:when>
                    <c:when test="${working.status == 'DONE'}">
                        DONE
                    </c:when>
                </c:choose>
            </td>
            <td>
                <a href="/working/edit/${working.id}">Edit</a>
                <a href="/working/delete/${working.id}">Delete</a>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>

<a href="<%=request.getContextPath()%>/working/initCreate">Creat New Working</a>

<div>
    <c:forEach items="${page}" var="page">
        <a href="working?page=${page}">${page}</a>
    </c:forEach>
</div>

</body>
</html>
