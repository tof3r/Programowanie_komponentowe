<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.samaxes.com/taglib/secure" prefix="secure"%>
<%@ taglib uri="http://www.springframework.org/security/tags"
	prefix="sec"%>
<%@ page session="false"%>
<html>
<head>
<title>Lista pracownikow</title>
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
			<h2 align="center">Usunieto pracownika.</h2>
			</P>
		</div>
	</c:if>
	<c:if test="${success_add}">
		<div class="added">
			<P>
			<h2 align="center">Dodano pracownika.</h2>
			</P>
		</div>
	</c:if>
	<c:if test="${success_edit}">
		<div class="added">
			<P>
			<h2 align="center">Zmieniono dane pracownika.</h2>
			</P>
		</div>
	</c:if>
	<c:if test="${not success_add}">
		<c:if test="${not success_edit}">
			<c:if test="${not success}">
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
								<td> <secure:one roles="ROLE_ADMIN">
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
					<a href="/dbloginapp/employees/add_employee"> Dodaj pracownika</a>
				</P>
			</c:if>
		</c:if>
	</c:if>
	<P align="center">
		<a href="/dbloginapp/welcome"> Panel uzytkownika</a>
	</P>
</body>
</html>
