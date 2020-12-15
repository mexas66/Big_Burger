package fr.greta.java.burger.facade;

import fr.greta.java.burger.domain.Burger;
import fr.greta.java.burger.domain.BurgerService;
import fr.greta.java.generic.exception.ServiceException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = "/menu")
public class GetMenuServletController extends HttpServlet {
    private BurgerService service = new BurgerService();
    private BurgerDTOWrapper dtoWrapper = new BurgerDTOWrapper();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            List<Burger> burgers = service.getAllBurgers();
            req.setAttribute("burgers", dtoWrapper.toDTOs(burgers));

            RequestDispatcher dispatcher = req.getRequestDispatcher("Commande.jsp");
            dispatcher.forward(req,resp);
        } catch (ServiceException e) {
            e.printStackTrace();
            resp.sendRedirect(req.getContextPath()+"/accueil?message=REGISTER_ERROR");
        }
    }
}
