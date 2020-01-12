<%@ page import="java.util.List" %>
<%@ page import="dto.NewsBoardDto" %>
<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <title>Bootstrap Example</title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
    <style>
        /* Set height of the grid so .sidenav can be 100% (adjust if needed) */
        .row.content {height: 1500px}

        /* Set gray background color and 100% height */
        .sidenav {
            background-color: #f1f1f1;
            height: 100%;
        }

        /* Set black background color, white text and some padding */
        footer {
            background-color: #555;
            color: white;
            padding: 15px;
        }

        /* On small screens, set height to 'auto' for sidenav and grid */
        @media screen and (max-width: 767px) {
            .sidenav {
                height: auto;
                padding: 15px;
            }
            .row.content {height: auto;}
        }
        .col-sm-9{margin-top: 30px;}
        .col-sm-9 table{
            margin-right: auto;
            margin-left: auto;
            width: 100%;
            text-align: center;
        }
        .btn_write{
            float: right;
        }

        th{
            text-align: center;
        }
        .btn_sc{
            text-align: center;
        }
    </style>
</head>
<body>

<div class="container-fluid">
    <div class="row content">
        <div class="col-sm-3 sidenav">
            <h4>Blog</h4>
            <ul class="nav nav-pills nav-stacked">
                <li class="active"><a href="board/home.jsp">Home</a></li>
                <li><a href="/NewsBoard/boardview">NewsBoard</a></li>
                <li><a href="#section3">Family</a></li>
                <li><a href="#section3">Photos</a></li>
            </ul><br>
            <div class="input-group">
                <input type="text" class="form-control" placeholder="Search Blog..">
                <span class="input-group-btn">
          <button class="btn btn-default" type="button">
            <span class="glyphicon glyphicon-search"></span>
          </button>
        </span>
            </div>
        </div>

        <div class="col-sm-9">
           <table border="1" align="center">
               <tr>
                   <th>글번호</th>
                   <th>작성자</th>
                   <th>제목</th>
                   <th>날짜</th>
                   <th>조회수</th>
               </tr>
               <% List<NewsBoardDto> list = (List<NewsBoardDto>) request.getAttribute("list");
                   System.out.println(list.size());
                  for(int i =0; i<list.size();i++){ %>
               <tr>
                   <td><%=list.get(i).getId() %></td>
                   <td><%=list.get(i).getName() %></td>
                   <td><a href="http://localhost:8080/NewsBoard/boardview?action=detailview&searchtype=id&search=
                        <%=list.get(i).getId()%>">
                       <%=list.get(i).getTitle() %></a></td>
                   <td><%=list.get(i).getWriteDate() %></td>
                   <td><%=list.get(i).getViewCount() %></td>
               </tr>
                 <% } %>

           </table>
            <br>
            <form class="btn_sc" action="/NewsBoard/boardview" method="get">
                <select name="searchtype">
                    <option value="title">제목</option>
                </select>
                <input type="search" name = "search">
                <input type="hidden" name="action" value="search">
                <input type="submit" value="검색">
            </form>

            <input type="button" value="글쓰기" onclick="writeclick()" class="btn_write">
        </div>
    </div>
</div>

<footer class="container-fluid">
    <p>Footer Text</p>
</footer>
<script>
    function writeclick() {
        location.href="board/write.jsp";
    }
</script>
</body>
</html>
