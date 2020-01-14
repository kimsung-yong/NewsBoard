package controller;

import dao.NewsBoardDao;
import dto.NewsBoardDto;
import fucntion.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/boardview")
public class ViewController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doProcess(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doProcess(request,response);
    }

    protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws  ServletException, IOException{
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        String action = request.getParameter("action");



        if(action == null){ // 처음 글목록
            new ListFucntion(request,response);
            request.getRequestDispatcher("/board/NewsBoard.jsp").forward(request,response);
        }else if(action.equals("write")){ // 글쓰기
            new WriteFucntion(request,response);
            new ListFucntion(request,response);
            request.getRequestDispatcher("/board/NewsBoard.jsp").forward(request,response);
        }else if(action.equals("search")){ // 검색
            new SearchFucntion(request,response);
            request.getRequestDispatcher("/board/NewsBoard.jsp").forward(request,response);
        }else if(action.equals("detailview")){//상세페이지
            new ViewCountFucntion(request,response);
            new SearchFucntion(request,response);
            request.getRequestDispatcher("/board/detailPage.jsp").forward(request,response);
        }else if(action.equals("modify")){//수정
            new SearchFucntion(request,response);
            request.getRequestDispatcher("/board/modify.jsp").forward(request,response);
        }else if(action.equals("modifyResult")){//수정결과
            new ModifyFucntion(request,response);
            new SearchFucntion(request,response);
            request.getRequestDispatcher("/board/detailResult.jsp").forward(request,response);
        }else if(action.equals("delete")){//삭제
            new deleteFucntion(request,response);
            response.sendRedirect("/NewsBoard/boardview");
        }



        
    }

}
