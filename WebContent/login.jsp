<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link href="bootstrap/css/bootstrap.min.css" rel="stylesheet" type="text/css" />
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js">
<script type="text/javascript" src="bootstrap/js/bootstrap.min.js"></script> 
<title>Connexion</title>
</head>
<body>
<h1>myEpsi</h1>
<h2>Connexion utilisateur</h2>
<div class="container">
<form action="login" method="POST">
<div class="form-group">
<label for="email">Email</label>
<input type="email" class="form-control" required placeholder="Entrer votre email">
</div>
<div class="form-group">
<label for="exampleInputPassword1">Mot de passe</label>
<input type="password" class="form-control" required placeholder="Mot de passe">
</div>

<button type="submit" class="btn btn-default">Se connecter</button>
</form>
</div>

</body>
</html>