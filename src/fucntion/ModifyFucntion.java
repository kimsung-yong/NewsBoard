package fucntion;

import dao.NewsBoardDao;
import dto.NewsBoardDto;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;

public class ModifyFucntion extends HttpServlet {
    public ModifyFucntion(HttpServletRequest request, HttpServletResponse response) {

        Long id = Long.parseLong(request.getParameter("id"));
        String name = request.getParameter("name");
        String title = request.getParameter("title");
        String content = request.getParameter("content");

        NewsBoardDto dto = new NewsBoardDto();
        dto.setId(id);
        dto.setName(name);
        dto.setTitle(title);
        dto.setContent(content);

        NewsBoardDao dao = new NewsBoardDao();
        dao.modify(dto);

    }
}
