<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<html>
	<h1>Search Movie</h1>
	<form:form action="/movie_load" method="POST" >
		Id - <form:input path="id"/>
		<input type="submit"/>
	</form:form>
</html>