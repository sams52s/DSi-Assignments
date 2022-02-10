<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="ISO-8859-1">
    <%@include file="../resources/links.jsp"%>
<%--    <link rel="stylesheet" href="../resources/style.css">--%>
    <meta charset="UTF-8">
    <title>Add Favourite Movies</title>
    <style>
        .addingForm{
            text-align: center;
        }
        table{
            margin-left: auto;
            margin-right: auto;
            max-width: 25%;
        }
    </style>
    
</head>
<body>
<jsp:include page="../resources/header.jsp"></jsp:include>
<div class="alert alert-success center" role="alert">
    <p>${NOTIFICATION}</p>1
</div>
<div class="addingForm">
        <form action="<%=request.getContextPath()%>/addFavouriteMovie" method="post" id="addMovie">
    <fieldset>
        <legend>
            Favourite movie adding form:
        </legend>
    <table class="table table-primary table-hover">
        <tr>
            <th>Name</th>
            <td><input type="text" name="name" required></td>
        </tr>
        <tr>
    <th>Release Date</th>
            <td><input type="date" name="releasedate" required></td>
        </tr>
        <tr>
            <th>Type</th>
            <td><input type="text" name="type"></td>
        </tr>
        <tr>
            <th>Duration</th>
            <td><input type="text" name="duration" required></td>
        </tr>
        <tr>
            <th>Description</th>
            <td><textarea rows="3" cols="50" name="description" form="addMovie" required></textarea></td>
        </tr>
        <tr>
            <th>Poster URL</th>
            <td><input type="text" name="img" required></td>
        </tr>
    </table>

    </fieldset>
    <center>
        <button type="submit">ADD Movie</button>
    </center>
    </form>
</div>
<jsp:include page="../resources/footer.jsp"></jsp:include>
</body>
</html>