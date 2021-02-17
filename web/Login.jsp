<%@page contentType="text/html" pageEncoding="UTF-8"%>
<html>
    <head>
        <title>Log In</title>
    </head>
    <body bgcolor="green">
        <p style="margin-top: 100px;">
            <%if(request.getParameter("Err") != null){%>
        <h1 align="center" style="color: red">Login failed. Please try again</h1>
            <%}%>
        </p>
        <form action="Login" style="margin-top: 200px;" method="post">
            <table bordr="2" align="center">
                <tr><td><input type="text" placeholder="Username" name="User" size="29" required></td></tr>
                <tr><td><input type="password" placeholder="Password" name="Pass" size="30" required></td></tr>
            <tr><td align="center"><input type="submit" value="Submit"></td></tr>
        </form>
    </body>
</html>
