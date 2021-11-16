package DAOmaster;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/Del")
public class BDelServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        String Siboard = req.getParameter("iboard");
        int iboard = Integer.parseInt(Siboard);

        int result = DAO.delBoard(iboard);
        System.out.println(" Del result :" + result);

        switch (result){
            case 1:
                res.sendRedirect("/List");
                break;
        }
    }
}
