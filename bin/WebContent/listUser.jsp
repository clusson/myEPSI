<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<link href="bootstrap/css/bootstrap.min.css" rel="stylesheet" type="text/css" />
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script type="text/javascript" src="bootstrap/js/bootstrap.min.js"></script> 

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Liste des utilisateurs</title>
</head>
<body>
    <table border=1>
        <thead>
            <tr>
                <th>Email</th>
                <th>Password</th>
                <th>Administrateur?</th>
                <th colspan=2>Action</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="{users}" var="user">
                <tr>
                    <td><c:out value="{user.ID}" /></td>
                    <td><c:out value="{user.PASSWORD}" /></td>
                    <td><c:out value="{user.ISADMINISTRATOR}" /></td>
                    <td><a href="UserServlet?action=edit&userId=<c:out value="{user.ID}"/>">Update</a></td>
                    <td><a href="UserServlet?action=delete&userId=<c:out value="{user.ID}"/>">Delete</a></td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
    <p><a href="UserServlet?action=insert">Add User</a></p>
</body>
</html>