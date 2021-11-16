package DAOmaster;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/up")
public class BUpServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

        String Siboard = req.getParameter("iboard");
        int iboard = Integer.parseInt(Siboard);

        boardVO param = new boardVO();
        param.setIboard(iboard);
        boardVO AAA = DAO.selDetail(param);

        req.setAttribute("abc",AAA);

        String path = "/WEB-INF/jsp/up.jsp";
        req.getRequestDispatcher(path).forward(req, res);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

        String Siboard = req.getParameter("iboard");
        int iboard = Integer.parseInt(Siboard);

        String Title = req.getParameter("title");
        String Ctnt = req.getParameter("ctnt");
        String Writer = req.getParameter("writer");
        System.out.println(Title);


        boardVO papa = new boardVO();

        papa.setIboard(iboard);
        papa.setTitle(Title);
        papa.setCtnt(Ctnt);
        papa.setWriter(Writer);

        int result = DAO.upBoard(papa);
        System.out.println("up Result : " + result);

        switch (result){
            case 1:
                res.sendRedirect("/Detail?iboard=" + Siboard);
                break;
        }
    }
}
