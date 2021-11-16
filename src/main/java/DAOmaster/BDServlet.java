package DAOmaster;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
//Detail
@WebServlet("/Detail")
public class BDServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        String Siboard = req.getParameter("iboard");
        int iboard = Integer.parseInt(Siboard);

        boardVO param = new boardVO();
        param.setIboard(iboard);
        boardVO data = DAO.selDetail(param);

        int prevIboard = DAO.selPrevIboard(param);
        int nextIboard = DAO.selNextIboard(param);
        
        
        req.setAttribute("zzz", data);

        req.setAttribute("prevIdx",prevIboard); // 최상위면 0  // 최하위면 보다 하나 큰거
        req.setAttribute("nextIdx",nextIboard); // 최상위면 보다 하나 작은거 // 최하위면 0
        

        String path = "/WEB-INF/jsp/detail.jsp";
        req.getRequestDispatcher(path).forward(req, res);


    }


}
