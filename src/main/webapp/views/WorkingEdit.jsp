<%--
  Created by IntelliJ IDEA.
  User: Nguyen Quang Phu
  Date: 2025/11/27
  Time: 18:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Edit</title>
</head>
<body>
<form:form modelAttribute="editWorkingDTO" action="${pageContext.request.contextPath}/working/edit/${id}" method="post"
           enctype="multipart/form-data">

    <form:label path="workingName">Working Name</form:label>
    <form:input path="workingName"/>
    <form:errors path="workingName" cssClass="cssError"/><br>

    <form:label path="personName">Person Name</form:label>
    <form:input path="personName"/>
    <form:errors path="personName" cssClass="cssError"/><br>


    <form:label path="startDate">startDate</form:label>
    <form:input path="startDate" type="date"/>
    <form:errors path="startDate" cssClass="cssError"/><br>

    <form:label path="duration">duration</form:label>
    <form:input path="duration"/>
    <form:errors path="duration" cssClass="cssError"/><br>

    <form:label path="durationUnit">durationUnit</form:label>
    <form:input path="durationUnit"/>
    <form:errors path="durationUnit" cssClass="cssError"/><br>

    <form:label path="workingDescription">workingDescription</form:label>
    <form:input path="workingDescription"/>
    <form:errors path="workingDescription" cssClass="cssError"/><br>

    <form:label path="workingProgress">workingProgress</form:label>
    <form:input path="workingProgress"/>
    <form:errors path="workingProgress" cssClass="cssError"/><br>

    <form:label path="workingImage">workingImage</form:label>
    <form:input type="file" path="workingImage"/><br>
    <form:errors path="workingImage" cssClass="cssError"/><br>

    <form:label path="status">Status</form:label>
    <form:select path="status">
        <form:option value="CANCEL" label="Cancel"/>
        <form:option value="WORKING" label="Working"/>
        <form:option value="DONE" label="Done"/>
    </form:select>
    <form:errors path="status" cssClass="cssError"/><br>

    <input type="submit" value="edit">
</form:form>


</body>
</html>
