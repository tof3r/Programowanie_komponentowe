<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.samaxes.com/taglib/secure" prefix="secure"%>
<%@ taglib uri="http://www.springframework.org/security/tags"
	prefix="sec"%>
<%@ page session="false"%>
<html>
<head>
<title>Lista klientow</title>
</head>
<style>
.added {
	color: #00ff00;
	background-color: #EEffEE;
	border: 3px solid #00ff00;
	padding: 8px;
	margin: 16px;
}
</style>
<body>
	<c:if test="${success}">
		<div class="added">
			<P>
			<h2 align="center">Usunieto klienta.</h2>
			</P>
		</div>
	</c:if>
	<c:if test="${not success}">
		<h2 align="center">Lista uzytkownikow</h2>
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
						<td><secure:one roles="ROLE_USER,ROLE_EMPLOYEE">
								<form action="clients/edit" method="post">
									<button type="submit">Edytuj</button>
									<input name="id" type="hidden" value="${klient.id}" />
								</form>
							</secure:one> <secure:one roles="ROLE_EMPLOYEE">
								<form action="clients/remove" method="post">
									<button type="submit">Usun</button>
									<input name="id" type="hidden" value="${klient.id}" />
								</form>
							</secure:one></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</c:if>
	<P align="center">
		<a href="/dbloginapp/welcome"> Panel uzytkownika</a>
	</P>
</body>
</html>
