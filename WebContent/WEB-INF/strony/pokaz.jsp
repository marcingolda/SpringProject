<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
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
                <th>Imie</th>
                <th>Nazwisko</th>
                <th>Uczelnia</th>
            </tr>
            <c:forEach items="${studenci}" var="student">
                <tr>
                    <td>${student.imie}</td>
                    <td>${student.nazwisko}</td>
                    <td>${student.uczelnia}</td>
                    <td><a href="/SSISpring/student/edytuj/${student.id}">EDYTUJ</a></td>
                    <td><a href="/SSISpring/student/usun/${student.id}">USUN</a></td>
                </tr>
            </c:forEach>
        </table>
        <a href="/SSISpring/student/nowy">Dodaj nowego studenta</a>
    </body>
</html>
