<%@ page import="dto.NewsBoardDto" %>
<%@ page import="java.util.List" %>
<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <title>Bootstrap Example</title>
    <meta charset="utf-8">
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
        .col-sm-9{
            margin-top: 30px;
            margin-left: auto;
            margin-right: auto;
        }
        .col-sm-9 table{


            width: 100%;
            border-top: 1px solid #444444;
            border-collapse: collapse;
            text-align: center;
        }
        .col-sm-9 table td{
            border-bottom: 1px solid;
            /*solid #444444;*/
            /*padding: 10px;*/
        }
        #tb_tr1{
            height: 50px;
        }
        #tb_tr2{
            height: 50px;
        }
        #tb_tr3{
            height: 400px;
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
            <% List<NewsBoardDto> list = (List<NewsBoardDto>) request.getAttribute("list");
                System.out.println(list.size());
                for(int i =0; i<list.size();i++){ %>
            <table>

                <tr id="tb_tr1">
                    <td>글번호</td>
                    <td><%=list.get(i).getId() %></td>
                    <td>작성자</td>
                    <td><%=list.get(i).getName() %></td>
                    <td>작성날짜</td>
                    <td><%=list.get(i).getWriteDate() %></td>
                    <td>조회수</td>
                    <td><%=list.get(i).getViewCount() %></td>
                </tr>
                <tr id="tb_tr2">
                    <td colspan="8"><%=list.get(i).getTitle() %></td>
                </tr>
                <tr id="tb_tr3">
                    <td colspan="8"><%=list.get(i).getContent()%></td>
                </tr>
                <% } %>
            </table>
            <button onclick="beforPage()">목록으로</button>
            <button onclick="" style="float: right" >수정</button>
            <button onclick="" style="float: right">삭제</button>






        </div>
    </div>
</div>

<footer class="container-fluid">
    <p>Footer Text</p>
</footer>
<script>
    function beforPage() {
        location.href="/NewsBoard/boardview";
    }
</script>
</body>
</html>
