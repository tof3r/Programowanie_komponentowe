<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<body>
	<h3>Zalogowano jako : ${username}</h3>
	
		<a href="clients">Lista klientow</a>

	<a href="<c:url value="/j_spring_security_logout" />"> Wyloguj
		(${username})</a>

</body>
</html>