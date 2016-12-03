<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Student</title>
        <link href="<c:url value="/css/style.css" />" rel="stylesheet">
    </head>
    <body>
        <form:form commandName="student" method="post" action="${pageContext.request.contextPath}/student">
        <form:hidden path="id" id="id" />
        <table>
            <tr>
                <td><label><spring:message code="student.imie"/></label></td>
                <td><form:input path="imie" id="imie" />
                <form:errors path="imie" cssClass="error" /></td>
            </tr>
            <tr>
                <td><label><spring:message code="student.nazwisko"/></label></td>
                <td><form:input path="nazwisko" id="nazwisko" />
                <form:errors path="nazwisko" cssClass="error"/></td>
            </tr>
            <tr>
                <td><label><spring:message code="student.uczelnia"/></label></td>
                <td><form:input path="uczelnia" id="uczelnia" />
                <form:errors path="uczelnia" cssClass="error"/></td>
            </tr>
            <tr>
                <td><input type="submit" name="zapisz" value="<spring:message code="zapisz"/>"/></td>
            </tr>
        </table>
        </form:form>
    </body>
</html>
