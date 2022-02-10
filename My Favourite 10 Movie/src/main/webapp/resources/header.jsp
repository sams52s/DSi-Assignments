<%--
  Created by IntelliJ IDEA.
  User: dsi
  Date: 2/13/22
  Time: 7:27 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<head>
    <nav class="navbar navbar-dark bg-dark">
        <div class="container-fluid">
            <a class="navbar-brand" href="#">Add Favourite Movies</a>
            <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarText" aria-controls="navbarText" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="navbarText">
                <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                    <li class="nav-item">
                        <a class="nav-link active" aria-current="page" href="<%= request.getContextPath()%>/index.jsp">Home</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="<%= request.getContextPath()%>/addFavouriteMovie">Add Favourite Movie</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="#">Add Your Suggestion</a>
                    </li>
                </ul>
                <span class="navbar-text">
      </span>
            </div>
        </div>
    </nav>
</head>

