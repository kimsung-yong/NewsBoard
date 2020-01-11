package fucntion;

import dao.NewsBoardDao;
import dto.NewsBoardDto;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class WriteFucntion extends HttpServlet {

    public WriteFucntion(HttpServletRequest request, HttpServletResponse response) {
        String name = request.getParameter("name");
        String title = request.getParameter("title");
        String content = request.getParameter("content");

        NewsBoardDto dto = new NewsBoardDto();
        dto.setName(name);
        dto.setTitle(title);
        dto.setContent(content);

        NewsBoardDao dao = new NewsBoardDao();
        dao.insert(dto);
    }
}
