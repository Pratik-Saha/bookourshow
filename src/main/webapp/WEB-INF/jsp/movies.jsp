<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="core" %>
<html>
<h3>List Of Movies</h3>
<table border="1">
<thead>
<td>Id</td>
<td>Movie Name</td>
<td>Actor</td>
<td>Director</td>
<td>Date</td>
<td>action</td>
</thead>
<core:forEach items="${movies}" var="m">
<tr>
<td>${m.id}</td>
<td>${m.movieName}</td>
<td>${m.actorName}</td>
<td>${m.directorName}</td>
<td>${m.releaseDate}</td>
<td><a href="/movie_form?id=${m.id}">Edit</a>
<a href="/movie_delete?id=${m.id}">delete</a>
<a href="/movie_cart?id=${m.id}">Add to Cart</a></td>

</tr>
</core:forEach>
</table border="1">
<hr>
<h3>List Of Movies Request Scope</h3>
<table>
<thead>
<td>Id</td>
<td>Movie Name</td>
<td>Actor</td>
<td>Director</td>
<td>Date</td>
<td>action</td>
<td>delete</td>
</thead>
<core:forEach items="${requestSpe.movies}" var="m">
<tr>
<td>${m.id}</td>
<td>${m.movieName}</td>
<td>${m.actorName}</td>
<td>${m.directorName}</td>
<td>${m.releaseDate}</td>
</tr>
</core:forEach>
</table>
<hr>
<h3>List Of Movies Session Scope</h3>
<table>
<thead>
<td>Id</td>
<td>Movie Name</td>
<td>Actor</td>
<td>Director</td>
<td>Date</td>
<td>action</td>
<td>delete</td>
</thead>
<core:forEach items="${sessionSpe.movies}" var="m">
<tr>
<td>${m.id}</td>
<td>${m.movieName}</td>
<td>${m.actorName}</td>
<td>${m.directorName}</td>
<td>${m.releaseDate}</td>
</tr>
</core:forEach>
</table>
</html>