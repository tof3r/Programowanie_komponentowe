<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.samaxes.com/taglib/secure" prefix="secure"%>
<%@ taglib uri="http://www.springframework.org/security/tags"
	prefix="sec"%>
<%@ page session="false"%>
<html>
<head>
<title>Lista klientow</title>
</head>
<body>
	<h2 align="center">Ksiazki</h2>
	<table align="center" border="2">
		<th>Tytul</th>
		<th>Autor</th>
		<tbody>
			<c:forEach var="ksiazka" items="${ksiazki}">
				<tr>
					<td>${ksiazka.tytul}</td>
					<td>${ksiazka.autor}</td>
					<td>
						<form action="books/edit" method="post">
							<button type="submit">Edytuj</button>
							<input name="id" type="hidden" value="${ksiazka.id}" />
						</form>

						<form action="books/remove" method="post">
							<button type="submit">Usun</button>
							<input name="id" type="hidden" value="${ksiazka.id}" />
						</form>

					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>

	<P align="center">
		<a href="<c:url value="/welcome" />"> Panel uzytkownika</a>
	</P>
</body>
</html>
