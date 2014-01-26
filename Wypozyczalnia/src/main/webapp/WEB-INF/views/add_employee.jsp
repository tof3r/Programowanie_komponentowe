<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.samaxes.com/taglib/secure" prefix="secure"%>
<%@ taglib uri="http://www.springframework.org/security/tags"
	prefix="sec"%>
<html>
<head>
<title>Dodaj pracownika</title>
</head>
<body>
	<div>
		<form:form method="post" action="employees/add_employee"
			modelAttribute="pracownik">
			<table align="center">
				<thead>
					<tr>
						<th colspan="2">Wprowadz dane pracownika:</th>
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
						<td><form:label path="telefon">Telefon :</form:label></td>
						<td><form:input path="telefon" /></td>
					</tr>
					<tr>
						<td><form:label path="adres">Adres: </form:label></td>
						<td><form:input path="adres" /></td>
					</tr>
					<tr>
						<td><form:button type="submit">Zapisz</form:button></td>
						<td><form:button type="reset">Wyczysc</form:button></td>
					</tr>
				</tbody>
			</table>
		</form:form>
		<P align="center"> <a href="<c:url value="welcome" />" > Powrot do strony glownej</a> </P>
	</div>
</body>
</html>
