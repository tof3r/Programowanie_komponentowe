<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.samaxes.com/taglib/secure" prefix="secure"%>
<%@ taglib uri="http://www.springframework.org/security/tags"
	prefix="sec"%>
<html>
<body>
	<h3>Zalogowano jako : ${username}</h3>

	<secure:one roles='ROLE_USER'>
		<P>
			<a href="<c:url value="books/search" />">Szukaj ksiazki</a>
		</P>
		<P>
			<a href="<c:url value="books" />">Wypozyczenia</a>
		</P>
	</secure:one>
	<secure:one roles='ROLE_EMPLOYEE'>
		<P>
			<a href="<c:url value="books/add_book" />">Dodaj ksiazke</a>
		</P>
		<P>
			<a href="<c:url value="clients" />">Lista klientow</a>
			
		</P>
	</secure:one>
	<secure:one roles='ROLE_ADMIN'>
		<P>
			<a href="<c:url value="employees" />">Lista pracownikow</a>
		</P>
	</secure:one>

	<P>
		<a href="<c:url value="/j_spring_security_logout" />"> Wyloguj
			(${username})</a>
	</P>

</body>
</html>