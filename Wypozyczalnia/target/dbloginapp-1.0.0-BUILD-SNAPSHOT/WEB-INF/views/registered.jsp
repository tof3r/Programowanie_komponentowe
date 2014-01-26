<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>Rejestracja</title>
</head>
<style>
.registered {
	color: #00ff00;
	background-color: #EEffEE;
	border: 3px solid #00ff00;
	padding: 8px;
	margin: 16px;
}
</style>
<body>
	<c:if test="${success}">
		<div class="registered">
			<P align="center">
			<h2>Zarejestrowano pomyslnie</h2>
			<h4>Prosze czekac na aktywacje konta</h4>
			</P>
		</div>
	</c:if>
	<P align="center">
		<a href="<c:url value="/" />"> Powrot do strony glownej</a>
	</P>
</body>
</html>
