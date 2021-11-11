package DAOmaster;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/insert")
public class BIServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        String path = "/WEB-INF/jsp/insert.jsp";
        RequestDispatcher rd = req.getRequestDispatcher(path);
        rd.forward(req,res);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        String Title = req.getParameter("title");
        String Ctnt = req.getParameter("ctnt");
        String Writer = req.getParameter("writer");

        boardVO aa = new boardVO();

        aa.setTitle(Title);
        aa.setCtnt(Ctnt);
        aa.setWriter(Writer);

        int result = DAO.insertBoard(aa);


        switch (result){
            case 1:
                res.sendRedirect("/List");
                break;
            default:
                res.sendRedirect("/insert");
                break;
        }


    }
}
