<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.samaxes.com/taglib/secure" prefix="secure"%>
<html>
<body>
	<h3>Zalogowano jako : ${username}</h3>

	<sec:authorize access="hasRole('ROLE_EMPLOYEE')">
		<P>
			<a href="<c:url value="clients" />">Lista klientow</a>
		</P>
	</sec:authorize>

	<P>
		<a href="<c:url value="/j_spring_security_logout" />"> Wyloguj
			(${username})</a>
	</P>

</body>
</html>