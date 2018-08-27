<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!doctype html>
<html lang="fr">

<head>
<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">

<!-- Bootstrap CSS -->
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css"
	integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO"
	crossorigin="anonymous">

<title>Tableau de bord</title>

</head>

<body>

	<div class="container">
		<div class="col-10 mx-auto">
			<div class="row d-flex flex-column">
				<h1 class="text-primary mx-auto">Etat des Réponses</h1>
				<div class="card mx-auto mt-2" style="width: 18rem;">
					<div class="table-primary text-white text-center"><h2>Sondage N° ${idSond}</h2></div>
					<ul class="list-group list-group-flush">
						<li class="list-group-item">Nombre d'Avis positif : <span class="badge badge-pill badge-success">${aviOk}</span> </li>
						<li class="list-group-item">Nombre d'Avis négatif : <span class="badge badge-pill badge-danger">${aviNot}</span> </li>
						<li class="list-group-item">Nouveau Clients : <span class="badge badge-pill badge-primary">${nbClient}</span> </li>
					</ul>
				</div>
				<table class="table">
					<thead>
						
					</thead>
					
				</table>
			</div>
		</div>
	</div>




	<!-- Optional JavaScript -->
	<!-- jQuery first, then Popper.js, then Bootstrap JS -->
	<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
		integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
		crossorigin="anonymous"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"
		integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49"
		crossorigin="anonymous"></script>
	<script
		src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"
		integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy"
		crossorigin="anonymous"></script>

</body>

</html>