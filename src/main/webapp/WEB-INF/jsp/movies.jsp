<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="core" %>
<html>
<h3>List Of Movies</h3>
<table>
<thead>
<td>Id</td>
<td>Movie Name</td>
<td>Actor</td>
<td>Director</td>
<td>Date</td>
</thead>
<core:forEach items="${movies}" var="m">
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