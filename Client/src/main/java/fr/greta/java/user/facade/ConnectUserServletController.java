package fr.greta.java.user.facade;

import fr.greta.java.generic.exception.ServiceException;
import fr.greta.java.user.domain.User;
import fr.greta.java.user.domain.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(urlPatterns = "/connect")
public class ConnectUserServletController extends HttpServlet {

    UserService service = new UserService();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            User user = service.findUser(req.getParameter("login"), req.getParameter("password"));

            if (user != null) {
                HttpSession session = req.getSession();
                session.setAttribute("currentuser", user);

                resp.sendRedirect(req.getContextPath() + "/BigBurger.jsp?message=CONNECT_SUCCESS");
            }else {
                resp.sendRedirect(req.getContextPath() + "/BigBurger.jsp?message=CONNECT_ERROR");
            }
        }catch (ServiceException e){
            e.printStackTrace();
            resp.sendRedirect(req.getContextPath() + "/BigBurger.jsp?message=CONNECT_ERROR");
        }
    }
}
