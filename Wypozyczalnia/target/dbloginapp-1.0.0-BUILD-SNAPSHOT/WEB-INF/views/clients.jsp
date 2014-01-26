<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="security" %>
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
						<form action="clients/edit/show" method="post">
							<button type="submit">Edytuj</button>
							<input name="user_id" type="hidden" value="${klient.user_id}" />
						</form>

						<form action="clients/remove" method="post">
							<button type="submit">Usun</button>
							<input name="user_id" type="hidden" value="${klient.user_id}" />
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
