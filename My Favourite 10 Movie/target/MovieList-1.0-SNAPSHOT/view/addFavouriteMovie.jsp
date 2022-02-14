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
<div class="card">
    <div class="card-body">
        <c:if test="${movie != null}">
        <form action="update" method="post">
            </c:if>
            <c:if test="${movie == null}">
            <form action="insert" method="post">
                </c:if>

                <caption>
                    <h2>
                        <c:if test="${movie != null}">
                            Edit Todo
                        </c:if>
                        <c:if test="${movie == null}">
                            Add New Todo
                        </c:if>
                    </h2>
                </caption>
<jsp:include page="../resources/header.jsp"></jsp:include>
<div class="alert alert-success center" role="alert">
    <p>${NOTIFICATION}</p>1
</div>
<div class="addingForm">
        <form action="/insert" method="post" id="addMovie">
    <fieldset>
        <legend>
            Favourite movie adding form:
        </legend>
    <table class="table table-primary table-hover">
        <tr>
            <th></th>
            <th>    <c:if test="${movie != null}">
                <input type="hidden" name="id" value="<c:out value='${movie.id}' />" />
            </c:if>
            </th>
        </tr>
        <tr>
            <th>Name</th>
            <td><input type="text"
                       value="<c:out value='${movie.name}' />" class="form-control"
                       name="title" required="required" minlength="5">
            </td>
        </tr>
        <tr>
            <th>Release Date</th>
            <td>
            <input type="text"
                   value="<c:out value='${movie.releaseDate}' />" class="form-control"
                   name="title" required="required" minlength="5">
            </td>
        </tr>
        <tr>
            <th>Type</th>
            <td><input type="text"
                       value="<c:out value='${movie.type}' />" class="form-control"
                       name="title" required="required" minlength="5"></td>
        </tr>
        <tr>
            <th>Duration</th>
            <td><input type="text"
                       value="<c:out value='${movie.Duration}' />" class="form-control"
                       name="title" required="required" minlength="5"></td>
        </tr>
        <tr>
            <th>Description</th>
            <td><textarea rows="3" cols="50" name="description" form="addMovie" value="<c:out value='${movie.Description}' />" required></textarea></td>
        </tr>
        <tr>
            <th>Poster URL</th>
            <td><input type="text"
                       value="<c:out value='${movie.img}' />" class="form-control"
                       name="title" required="required" minlength="5"></td>
        </tr>
    </table>

    </fieldset>
    <center>
        <button type="submit">ADD Movie</button>
    </center>
    </form>
</div>
<footer>
<jsp:include page="../resources/footer.jsp"></jsp:include>
</footer>
</body>
</html>