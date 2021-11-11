package DAOmaster;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/Detail")
public class BDServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        String Siboard = req.getParameter("iboard");
        int iboard = Integer.parseInt(Siboard);

        boardVO param = new boardVO();
        param.setIboard(iboard);
        boardVO data = DAO.selDetail(param);

        req.setAttribute("zzz", data);


        String path = "/WEB-INF/jsp/detail.jsp";
        req.getRequestDispatcher(path).forward(req, res);


    }


}
