package fucntion;

import dao.NewsBoardDao;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class deleteFucntion extends HttpServlet {
    public deleteFucntion(HttpServletRequest request, HttpServletResponse response) {
        long id = Long.parseLong(request.getParameter("id"));

        NewsBoardDao dao = new NewsBoardDao();
        dao.delete(id);
    }
}
