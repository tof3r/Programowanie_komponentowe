<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<title>Logowanie</title>
<style>
.errorblock {
	color: #ff0000;
	background-color: #ffEEEE;
	border: 3px solid #ff0000;
	padding: 8px;
	margin: 16px;
}
</style>
</head>
<body onload='document.f.j_username.focus();'>
	<h3 align="center">Zaloguj sie</h3>

	<c:if test="${not empty error}">
		<div class="errorblock">
			Proba zalogowania sie nie powiodla. Sprobuj ponownie.<br /> Caused :
			${sessionScope["SPRING_SECURITY_LAST_EXCEPTION"].message}
		</div>
	</c:if>

	<form name='f' action="<c:url value='j_spring_security_check' />"
		method='POST'>

		<table align="center">
			<tr>
				<td>Uzytkownik:</td>
				<td><input type='text' name='j_username' value=''></td>
			</tr>
			<tr>
				<td>Haslo:</td>
				<td><input type='password' name='j_password' /></td>
			</tr>
			<tr>
				<td><input name="submit" type="submit" value="Zaloguj" /></td>
				<td><input name="reset" type="reset" /></td>
			</tr>
		</table>

	</form>

	<P align="center">
		Nie masz jeszcze konta? <a href="<c:url value="/register" />">
			Zarejestruj sie.</a>
	</P>
	<P align="center">
		<a href="<c:url value="/" />"> Strona glowna</a>
	</P>
</body>
</html>