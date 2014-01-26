<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<html>
<head>
<title>Lista klientow</title>
</head>
<body>

	<table align="center" border="2">
		<th>Imie i nazwisko</th>
		<th>Login</th>
		<th>Email</th>
		<th>Akcje</th>
		<tbody>
			<c:forEach var="klient" items="${klienci}">
				<tr>
					<td>${klient.imie}&nbsp;${klient.nazwisko}</td>
					<td>${klient.login}</td>
					<td>${klient.email}</td>
					<td>
						<form action="patients/edit/show" method="post">
							<button type="submit" class="btn btn-primary">Edytuj</button>
							<input name="pesel" type="hidden" value="${patient.pesel}" />
						</form>
						<form action="patient/visits" method="post">
							<button type="submit" class="btn btn-warning">Wizyty</button>
							<input name="pesel" type="hidden" value="${patient.pesel}" />
						</form>

						<form action="patient/remove" method="post">
							<button type="submit" class="btn btn-danger">Usun</button>
							<input name="pesel" type="hidden" value="${patient.pesel}" />
						</form>
					
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>

	<P align="center">
		<a href="<c:url value="/" />"> Strona glowna</a>
	</P>
</body>
</html>
