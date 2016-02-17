<%-- 

--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Summary Page</title>
    </head>
    <body>
        <h1>Summary</h1>
        <table border="1">
            <thead><tr><td>Problem</td><td>&nbsp;&nbsp;Your Answer</td><td>&nbsp;&nbsp;Comment</td></tr></thead>
            <% int summary = 0; %>
            <c:forEach var="item" begin="0" end="9" items="${showExercise.summary}">
                <tr><td> <c:out value="${item.display() }"/></td>
                    <td> = <c:out value="${item.userAnswer}"/></td> 
                    <c:choose>
                        <c:when test="${item.operation() == item.userAnswer}">
                            <% summary++; %>
                            <td> <c:out value="<%='\u2713' %>"/> </td>
                        </c:when>
                        <c:otherwise>
                           <td> <c:out value="X"/>  </td>
                        </c:otherwise> 
                    </c:choose>
                </tr>
            </c:forEach>
                <tr><td></td><td>Total:</td><td> <%= summary + "/" + 10 %></td></tr>
        </table>
        <form method="POST">
            <input type="hidden" name="stage" value="END"/>
            <input type="submit" value="Quit"/>
        </form>
    </body>
</html>
