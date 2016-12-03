<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Lista studentów</title>
    </head>
    <body>
        <h1>Lista studentów</h1>
        <table>
            <tr>
                <th><spring:message code="student.imie"/></th>
                <th><spring:message code="student.nazwisko"/></th>
                <th><spring:message code="student.uczelnia"/></th>
            </tr>
            <c:forEach items="${studenci}" var="student">
                <tr>
                    <td>${student.imie}</td>
                    <td>${student.nazwisko}</td>
                    <td>${student.uczelnia}</td>
                    <td><a href="${pageContext.request.contextPath}/student/edytuj/${student.id}"><spring:message code="edytuj"/></a></td>
                    <td><a href="${pageContext.request.contextPath}/student/usun/${student.id}"><spring:message code="usun"/></a></td>
                </tr>
            </c:forEach>
        </table>
        <a href="${pageContext.request.contextPath}/student/nowy"><spring:message code="dodaj"/></a>
    </body>
</html>
