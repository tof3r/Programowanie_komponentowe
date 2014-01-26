<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.samaxes.com/taglib/secure" prefix="secure"%>
<%@ taglib uri="http://www.springframework.org/security/tags"
	prefix="sec"%>
<%@ page session="false"%>
<html>
<head>
<title>Lista pracownikow</title>
</head>
<body>

	<table align="center" border="2">
		<th>Imie i nazwisko</th>
		<th>Login</th>
		<th>Email</th>
		<th>Adres</th>
		<th>Akcje</th>
		<tbody>
			<c:forEach var="pracownik" items="${pracownicy}">
				<tr>
					<td>${pracownik.imie}&nbsp;${pracownik.nazwisko}</td>
					<td>${pracownik.email}</td>
					<td>${pracownik.telefon}</td>
					<td>${pracownik.adres }</td>
					<td>
						<form action="patients/edit/show" method="post">
							<button type="submit">Edytuj</button>
							<input name="pesel" type="hidden" value="${patient.pesel}" />
						</form>

						<form action="patient/remove" method="post">
							<button type="submit" >Usun</button>
							<input name="pesel" type="hidden" value="${patient.pesel}" />
						</form>
					
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>

	<P align="center">
		<a href="<c:url value="welcome" />"> Panel uzytkownika</a>
	</P>
</body>
</html>
