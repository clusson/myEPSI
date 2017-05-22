<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link href="bootstrap/css/bootstrap.min.css" rel="stylesheet" type="text/css" />
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js">
<script type="text/javascript" src="bootstrap/js/bootstrap.min.js"></script> 
<title>Inscription</title>
</head>
<body>
<h1>myEpsi</h1>
<h2>Connexion utilisateur</h2>
<div class="container">
<form action ="sign" method = "POST">
<div class="form-group">
<label for="email">Email
<input type="email" name="id" id="id" required></input>
</label>
</div>
<div class="form-group">
<label for="pwd">Mot de passe
<input type="password" name="password" id="password" required onkeyup='check();'></input>
</label>
</div>
<div class="form-group">
<label for="pwd2">Confirmation mot de passe
<input type="password" name="confirm_password" id="confirm_password" required onkeyup='check();'></input>
</label>
<span id='message'></span>
</div>
<button type="submit" class="btn btn-default">S'inscrire</button>

</form>
</div>

<script>
var check = function() {
	  if (document.getElementById('password').value ==
	    document.getElementById('confirm_password').value) {
	    document.getElementById('message').style.color = 'green';
	    document.getElementById('message').innerHTML = 'OK';
	  } else {
	    document.getElementById('message').style.color = 'red';
	    document.getElementById('message').innerHTML = 'Mot de passe différent';
	  }
	}</script>
</body>
</html>