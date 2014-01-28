<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.samaxes.com/taglib/secure" prefix="secure"%>
<%@ taglib uri="http://www.springframework.org/security/tags"
	prefix="sec"%>
<%@ page session="false"%>
<html>
<head>
<title>Lista ksiazek</title>
</head>
<style>
.added {
	color: #00ff00;
	background-color: #EEffEE;
	border: 3px solid #00ff00;
	padding: 8px;
	margin: 16px;
}

.errorblock {
	color: #ff0000;
	background-color: #ffEEEE;
	border: 3px solid #ff0000;
	padding: 8px;
	margin: 16px;
}
</style>
<body>
	<c:if test="${success}">
		<div class="added">
			<P>
			<h2 align="center">Dodano nowa ksiazke.</h2>
			</P>
		</div>
	</c:if>
	<c:if test="${success_remove}">
		<div class="added">
			<P>
			<h2 align="center">Usunieto ksiazke.</h2>
			</P>
		</div>
	</c:if>

	<c:if test="${not success}">
		<c:if test="${not success_remove}">
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
									<form action="books/remove" method="post">
										<button type="submit">Usun</button>
										<input name="id" type="hidden" value="${ksiazka.id}" />
									</form>
								</secure:one></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
			<form action="/dbloginapp/books/search" method="get">
				<P align="center">
					<input type="text" name="tytul" placeholder="Podaj tytul ksiazki">
					<button type="submit">Szukaj</button>
				</P>
				<P align="center">
					<a href="/dbloginapp/books"> Powrot</a>
				</P>
			</form>
		</c:if>
	</c:if>



	<secure:one roles="ROLE_EMPLOYEE">
		<P align="center">
			<a href="/dbloginapp/books/add_book"> Dodaj ksiazke</a>
		</P>
	</secure:one>
	<P align="center">
		<a href="/dbloginapp/welcome"> Panel uzytkownika</a>
	</P>
</body>
</html>
