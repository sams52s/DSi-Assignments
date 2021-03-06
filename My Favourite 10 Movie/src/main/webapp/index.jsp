<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <%@include file="resources/links.jsp"%>
    <link rel="stylesheet" href="./resources/style.css">
    <title>Movie List</title>
</head>
<body>
<div class="table-sub-heading-color">
    <div style="text-align: center;">
        <h1> My Movie List </h1>
        <hr>
        <hr>
    </div>

</div>
<div class="favorite">
    <div style="text-align: center;">
    <table class="table table-dark table-hover">
        <thead>
        <tr class="table-success">
            <th>Name</th>
            <th>Release Date</th>
            <th>Type</th>
            <th>Duration</th>
            <th>Description</th>
            <th>Image</th>
        </tr>
        </thead>
        <tr class="table-info">
            <td>Push</td>
            <td>December 17, 2021 (India)</td>
            <td>Action/Drama</td>
            <td>2h 59m</td>
            <td>Violence erupts between red sandalwood smugglers <br> and the police charged with bringing down their organisation
                <br> in the Seshachalam forests of South India.</td>
            <td><img src="https://www.koimoi.com/wp-content/new-galleries/2021/12/allu-arjun-opens-up-about-his-plans-for-pushpa-2-001.jpg" alt="poster"></td>
        </tr>
        <tbody>
        <c:forEach var="movie" items="${movie}">

            <tr>
                <td><c:out value="${movie.name}" /></td>
                <td><c:out value="${movie.releaseDate}" /></td>
                <td><c:out value="${movie.type}" /></td>
                <td><c:out value="${movie.Duration}" /></td>
                <td><c:out value="${movie.Description}" /></td>
                <td><c:out value="${movie.img}" /></td>

                <td><a href="edit?id=<c:out value='${movie.id}' />">Edit</a>
                    &nbsp;&nbsp;&nbsp;&nbsp; <a
                            href="delete?id=<c:out value='${movie.id}' />">Delete</a></td>
            </tr>
        </c:forEach>
        <!-- } -->
        </tbody>
    </table>
    </div>
    <a href="view/addFavouriteMovie.jsp">Add</a>
</div>
</body>
</html>