<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="bootstrap/css/bootstrap.min.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="bootstrap/js/bootstrap.min.js"></script> 
<title>Inscription</title>
</head>
<body>

<form action = "sign.jsp" method = "POST">
<h2>Votre e-mail</h2>
<input type="email" name="id"></input>
<h2>Votre mot de passe</h2>
<input type="password" name="password"></input>
<h2>Confirmer votre mot de passe</h2>
<input type="password"></input>
<input type="submit" value="S'inscrire"></input>
</form>

</body>
</html>