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
			<P align="center">
			<h2>Dodano nowa ksiazke.</h2>
			</P>
		</div>
	</c:if>
	<h2 align="center">Ksiazki</h2>
	<table align="center" border="2">
		<th>Tytul</th>
		<th>Autor</th>
		<th>Akcje</th>
		<tbody>
			<c:forEach var="ksiazka" items="${ksiazki}">
				<tr>
					<td>${ksiazka.tytul}</td>
					<td>${ksiazka.autor}</td>
					<td><secure:one roles="ROLE_USER">
							<form action="books/rent" method="post">
								<button type="submit">Wypozycz</button>
								<input name="id" type="hidden" value="${ksiazka.id}" />
							</form>
						</secure:one> <secure:one roles="ROLE_EMPLOYEE">
							<form action="books/edit" method="post">
								<button type="submit">Edytuj</button>
								<input name="id" type="hidden" value="${ksiazka.id}" />
							</form>

							<form action="books/remove" method="post">
								<button type="submit">Usun</button>
								<input name="id" type="hidden" value="${ksiazka.id}" />
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
