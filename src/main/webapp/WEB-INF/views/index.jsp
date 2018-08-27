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

				<h1 class="text-primary mx-auto">Créer un sondage</h1>

				<form method="post">
					<div class="form-group">
						<label for="datedebut">Date de début</label> <input
							name="dateDebut" type="date" class="form-control" id="datedebut"
							required>
					</div>
					<div class="form-group">
						<label for="datedebut">Date de fin</label> <input name="dateFin"
							type="date" class="form-control" id="datefin" required>
					</div>
					<button type="submit" class="btn btn-primary mb-2">Valider</button>
				</form>
			</div>
			<div class="row">
				<h1 class="text-primary">Sondages en cours</h1>
				<table class="table">
					<thead>
						<tr class="table-primary text-white">
							<th scope="col">Id</th>
							<th scope="col">Date d'ouverture</th>
							<th scope="col">Date de fin prévue</th>
							<th scope="col">Date de fermeture</th>
							<th scope="col">Détails</th>
							<th scope="col">Actions</th>
						</tr>
					</thead>
					<tbody>

						<c:url value="/detail.html" var="detail" />
						<c:url value="/action.html" var="action" />
						<c:forEach var="sondage" items="${sondages}">
							<tr>
								<td>${sondage.id }</td>
								<td>${sondage.dateDebut }</td>
								<td>${sondage.dateFin }</td>
								<td>${sondage.dateFermeture }</td>
								<td><a
									href="<c:url value='/detail.html?id='/>${sondage.id}"
									class="detail">voir les détails</a></td>
								<td><a
									href="<c:url value='/fermeture.html?isOpen=true&id='/>${sondage.id}"
									class="action">Fermer le sondage</a></td>

							</tr>
						</c:forEach>
					</tbody>
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