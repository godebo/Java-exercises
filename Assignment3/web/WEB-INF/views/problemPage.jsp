<%-- 

--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Exercises</title>
    </head>
    <body>
        <h1></h1>
        <form method="POST">
            <p>${showExercise.displayExercise()}<input autofocus type="text" name="answer"/></p>
                <c:choose>
                    <c:when test="${inputValidator.rightAnswer}">
                         <div class="alert alert-success">
                             <strong>Success!</strong>
                         </div>
                    </c:when>
                    <c:when test="${inputValidator.wrongAnswer}">
                        <div class="alert alert-warning">
                             <strong>Wrong!</strong>
                         </div>
                    </c:when>
                    <c:when test="${inputValidator.wrongInput}">
                         <div class="alert alert-warning">
                             <strong>Wrong Input</strong>
                         </div>
                    </c:when>
                </c:choose>    
            <input type="hidden" name="stage" value="EXERCISES"/>
            <input type="submit" value="Proceed"/>
        </form>
        <form method="POST">
            <input type="hidden" name="stage" value="END"/>
            <input type="submit" value="Quit"/>
        </form>
    </body>
</html>
