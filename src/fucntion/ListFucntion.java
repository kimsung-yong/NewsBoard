package fucntion;

import dao.NewsBoardDao;
import dto.NewsBoardDto;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

public class ListFucntion extends HttpServlet {
    public ListFucntion(HttpServletRequest request, HttpServletResponse response){
        NewsBoardDao dao = new NewsBoardDao();
        List<NewsBoardDto> list = dao.selectAll();
        request.setAttribute("list",list);
    }
}
