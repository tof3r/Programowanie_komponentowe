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
	<h2 align="center">Lista pracownikow</h2>
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
					<td><secure:one roles="ROLE_EMPLOYEE,ROLE_ADMIN">
							<form action="employees/edit" method="post">
								<button type="submit">Edytuj</button>
								<input name="id" type="hidden" value="${pracownik.id}" />
							</form>
						</secure:one> <secure:one roles="ROLE_ADMIN">
							<form action="employees/remove" method="post">
								<button type="submit">Usun</button>
								<input name="id" type="hidden" value="${pracownik.id}" />
							</form>
						</secure:one></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>

	<P align="center">
		<a href="<c:url value="/welcome" />"> Panel uzytkownika</a>
	</P>
</body>
</html>
