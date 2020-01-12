<%@ page import="dto.NewsBoardDto" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2020-01-12
  Time: 오후 4:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
11

    <% List<NewsBoardDto> list = (List<NewsBoardDto>) request.getAttribute("list");
        System.out.println(list.size());
        for(int i =0; i<list.size();i++){ %>

        <%=list.get(i).getId() %>
        <%=list.get(i).getName() %>
        <%=list.get(i).getTitle() %>
        <%=list.get(i).getWriteDate() %>
        <%=list.get(i).getViewCount() %>

    <% } %>

</table>
</body>
</html>
