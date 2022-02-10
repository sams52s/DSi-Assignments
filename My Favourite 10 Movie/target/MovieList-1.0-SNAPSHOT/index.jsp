<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>

    <title>Movie List</title>
    <style>
        .x{
            background: aquamarine;
        }
        table,th{
            border: solid blueviolet 5px
        }
        tr{
            background: palegoldenrod;
        }
    </style>
</head>
<body>
<h1><%= "My Movie" %>
</h1>
<table class="table table-dark table-striped">
    <tr>
        <th>Number</th>
        <th>Name</th>
    </tr>
    <tr>
        <td><ul><li>Pushpa</li></ul></td>
        <td>
            <script>
                $(document).ready(function(){
                    $(".btn1").click(function(){
                        $("p").hide();
                    });
                    $(".btn2").click(function(){
                        $("p").show();
                    });
                });
            </script>
            <p>
            <img src="https://www.cinejosh.com/newsimg/newsmainimg/allu-arjun-pushpa_b_1306211116.jpg" class="img-thumbnail" alt="...">
            </p>
        </td>
    </tr>
</table>


<button class="btn1">Hide</button>
<button class="btn2">Show</button>
<br/>
<div class="x">HIII I am class</div>
<a class="link-success" href="hello-servlet">Hello Servlet</a>

</body>
</html>