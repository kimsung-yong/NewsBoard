package controller;

import fucntion.ListFucntion;
import fucntion.WriteFucntion;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

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



        if(action == null){
            new ListFucntion(request,response);

            request.getRequestDispatcher("/board/NewsBoard.jsp").forward(request,response);
        }else if(action.equals("write")){
            new WriteFucntion(request,response);
            new ListFucntion(request,response);
            request.getRequestDispatcher("/board/NewsBoard.jsp").forward(request,response);
        }



        
    }

}
