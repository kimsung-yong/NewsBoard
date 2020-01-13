package fucntion;

import dao.NewsBoardDao;
import dto.NewsBoardDto;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ViewCountFucntion{
    public ViewCountFucntion(HttpServletRequest request, HttpServletResponse response) {
        long i = Long.parseLong(request.getParameter("search"));
        NewsBoardDao dao = new NewsBoardDao();
        dao.countAdd(i);

    }
}
