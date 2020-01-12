package fucntion;

import dao.NewsBoardDao;
import dto.NewsBoardDto;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class SearchFucntion extends HttpServlet {
    public SearchFucntion(HttpServletRequest request, HttpServletResponse response) {
        String search = request.getParameter("search");
        String searchtype = request.getParameter("searchtype");
        NewsBoardDao dao = new NewsBoardDao();
        List<NewsBoardDto> list = dao.select(search,searchtype);
        request.setAttribute("list",list);
    }
}
