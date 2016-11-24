<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Student</title>
    </head>
    <body>
        <form:form commandName="student" method="post" action="/SSISpring/student">
        <form:hidden path="id" id="id" />
        <table>
            <tr>
                <td><label>Imię</label></td>
                <td><form:input path="imie" id="imie" /></td>
            </tr>
            <tr>
                <td><label>Nazwisko</label></td>
                <td><form:input path="nazwisko" id="nazwisko" /></td>
            </tr>
            <tr>
                <td><label>Uczelnia</label></td>
                <td><form:input path="uczelnia" id="uczelnia" /></td>
            </tr>
            <tr>
                <td><input type="submit" name="zapisz" value="Zapisz"/></td>
            </tr>
        </table>
        </form:form>
    </body>
</html>
