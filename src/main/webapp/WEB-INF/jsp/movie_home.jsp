<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="core" %>
<html>
<h3>${param['message']}</h3>
<h3>${requestScope['message']}</h3>
<h3>${message}</h3>


<core:if test="${not empty movie}">
		<h1>Movie Form</h1>
		<core:if test="${editAction}">
		<form:form action="/movie_edit" method="POST"  modelAttribute="movie">
		Id - <form:input path="id" disabled="true"/> <form:hidden path="id"/><font color="RED" ><form:errors path="id"/></font></br>
		Movie Name - <form:input path="movieName"/> <font color="RED" ><form:errors path="movieName"/></font></br>
		Actor Name - <form:input path="actorName"/> <font color="RED" ><form:errors path="actorName"/></font></br>
		Director Name - <form:input path="directorName"/> <font color="RED" ><form:errors path="directorName"/></font></br>
		IMDB - <form:input path="imdb"/> <font color="RED" ><form:errors path="imdb"/></font></br>
		Release Date (dd-MM-yyyy) - <form:input path="releaseDate" /> <font color="RED" ><form:errors path="releaseDate"/></font></br>
		<input type="submit"/>
		<input type = "reset"/>
		</form:form>
		</core:if>
		<core:if test="${!editAction}">
		<form:form action="/movie_load" method="POST"  modelAttribute="movie">
		Id - <form:input path="id"/> <font color="RED" ><form:errors path="id"/></font></br>
		Movie Name - <form:input path="movieName"/> <font color="RED" ><form:errors path="movieName"/></font></br>
		Actor Name - <form:input path="actorName"/> <font color="RED" ><form:errors path="actorName"/></font></br>
		Director Name - <form:input path="directorName"/> <font color="RED" ><form:errors path="directorName"/></font></br>
		IMDB - <form:input path="imdb"/> <font color="RED" ><form:errors path="imdb"/></font></br>
		Release Date (dd-MM-yyyy) - <form:input path="releaseDate" /> <font color="RED" ><form:errors path="releaseDate"/></font></br>
		<input type="submit"/>
		<input type = "reset"/>
		</form:form>
		</core:if>
		</core:if>	
	</hr>
	<a href="/movie_form"><input type="button" value="Add Movie"></a>
	<core:if test="${not empty movies}">
	<jsp:include page="movies.jsp"></jsp:include>
	</core:if>
	
	
</html>

<!-- //empty movie means no movie object
//null movie means movie object with null value -->
