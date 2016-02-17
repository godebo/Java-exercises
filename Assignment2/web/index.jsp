<%-- 
************* By Bereket Godebo *********************
************* Assignment 2 **************************
***********Problem Description***********************
A web page is needed for multiplication table drills.

When the page is accessed it shows 10 random
multiplication problems of integers from 1 to 9.
On the page there shall be no two identical problems.

The page only shows the problems, but there is no
form for answers or checking of the results.

    Document   : index
    Created on : 10-Oct-2015, 21:25:59
    Author     : bereket
--%>

<%@page import="java.util.*"%>
<%@page import="fi.oamk.students.r8hibe00.javaee.assignments.IntMultiplication"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Multiplication Table</title>
    </head>
    <body>
        <% 
            Set<IntMultiplication> multiDril = new HashSet(10);

            int index = 0;
            while(index < 10) {
                while(!multiDril.add(new IntMultiplication()));
                ++index;
            }
            %>
            <table border="1">
                <% for(IntMultiplication dril: multiDril) { %>
                <tr><td><%=dril.display() %></td></tr>
                <% }%>
            </table>
    </body>
</html>
