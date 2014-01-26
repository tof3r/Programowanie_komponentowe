<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.samaxes.com/taglib/secure" prefix="secure"%>
<%@ taglib uri="http://www.springframework.org/security/tags"
	prefix="sec"%>
<html>
<head>
<title>Dodaj ksiazke</title>
</head>
<body>
	<div>
		<form:form id="gatunki" method="post" action="/dbloginapp/books/add_book"
			modelAttribute="ksiazka">
			<table align="center">
				<thead>
					<tr>
						<th colspan="2">Wprowadz dane ksiazki:</th>
					</tr>
				</thead>
				<tbody>
					<tr />
					<tr>
						<td><form:label path="tytul">Tytul :</form:label></td>
						<td><form:input path="tytul" /></td>
					</tr>
					<tr>
						<td><form:label path="autor">Autor :</form:label></td>
						<td><form:input path="autor" /></td>
					</tr>
					<tr>
						<td>Gatunek :</td>
						<td><select id="gatunki" name="gatunki">
								<option value=0>--- Wybierz ---</option>
								<option value=1>Fantastyka</option>
								<option value=2>Sci-Fi</option>
								<option value=3>Biografia</option>
								<option value=4>Thriller</option>
								<option value=5>Historia</option>
						</select></td>
					</tr>
					<tr>
						<td><form:button type="submit">Zapisz</form:button></td>
						<td><form:button type="reset">Wyczysc</form:button></td>
					</tr>
				</tbody>
			</table>
		</form:form>
		<secure:one roles="ROLE_EMPLOYEE">
		<P align="center">
			<a href="<c:url value="/welcome" />"> Powrot</a>
		</P></secure:one>
	</div>
</body>
</html>
