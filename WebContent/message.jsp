<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<link href="bootstrap/css/bootstrap.min.css" rel="stylesheet" type="text/css" />
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js">
		</script>
		<title>Message</title>
	</head>
	<body>
		<h1>myEpsi</h1>
		<h2>Envoi d'un message</h2>
		<div class="container">
			<form action ="sign" method = "POST">
				<div class="form-group">
					<label for="title">Title<input name="title" required=required></input></label>
				</div>
				<div class="form-group">
					<label for="user">Author<input type="User" name="user" required=required></input></label>
				</div>
				<div class="form-group">
					<label for="msg">Content<input type="Message" name="message" id="message" required=required></input></label>
				</div>
				<button type="submit" class="btn btn-default">Envoyer le message</button>
			</form>
		</div>
	</body>
</html>

