<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>Rejestracja</title>
</head>
<style>
.errorblock {
	color: #ff0000;
	background-color: #ffEEEE;
	border: 3px solid #ff0000;
	padding: 8px;
	margin: 16px;
}
</style>
<body>
	<c:if test="${not empty error}">
		<div class="errorblock">
			<P align="center">${error}</P>
		</div>
	</c:if>
	<c:if test="${not empty emailError}">
		<div class="errorblock">
			<P align="center">${emailError}</P>
		</div>
	</c:if>
	<div>
		<form:form method="post" action="register"
			modelAttribute="klient">
			<table align="center">
				<thead>
					<tr>
						<th colspan="2">Wprowadz swoje dane:</th>
					</tr>
				</thead>
				<tbody>
					<tr />
					<tr>
						<td><form:label path="imie">Imie :</form:label></td>
						<td><form:input path="imie" /></td>
					</tr>
					<tr>
						<td><form:label path="nazwisko">Nazwisko :</form:label></td>
						<td><form:input path="nazwisko" /></td>
					</tr>
					<tr>
						<td><form:label path="email">Email :</form:label></td>
						<td><form:input path="email" /></td>
					</tr>
					<tr>
						<td><form:label path="login">Login :</form:label></td>
						<td><form:input path="login" /></td>
					</tr>
					<tr>
						<td><form:label path="haslo">Haslo: </form:label></td>
						<td><form:password path="haslo" /></td>
					</tr>
					<tr>
						<td> </td>
						<td><form:button type="submit">Zapisz</form:button></td>
					</tr>
				</tbody>
			</table>
		</form:form>
	</div>
	<P align="center">
		Masz juz konto? <a href="<c:url value="/login" />"> Zaloguj sie</a>
	</P>
	<P align="center">
		<a href="<c:url value="/" />"> Strona glowna</a>
	</P>
</body>
</html>
