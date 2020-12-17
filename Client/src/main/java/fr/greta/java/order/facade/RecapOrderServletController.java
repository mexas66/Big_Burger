package fr.greta.java.order.facade;

import fr.greta.java.burger.domain.Burger;
import fr.greta.java.burger.domain.BurgerService;
import fr.greta.java.generic.exception.ServiceException;
import fr.greta.java.generic.tools.OrderTypeConverter;
import fr.greta.java.order.domain.Order;
import fr.greta.java.user.domain.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static java.lang.String.valueOf;


@WebServlet(urlPatterns = "/recap")
public class RecapOrderServletController extends HttpServlet {
    private BurgerService burgerService = new BurgerService();

    private OrderDTOWrapper dtoWrapper = new OrderDTOWrapper();
    private OrderTypeConverter converter = new OrderTypeConverter();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();

        Order order = new Order();
        int quantity;
        Map<Burger, Integer> tmp;

        try {
            List<Burger> burgers = burgerService.getAllBurgers();

            order.setTotal(0);
            order.setUser((User)session.getAttribute("currentuser"));
            order.setBurgers(new HashMap<Burger, Integer>());
            order.setType(converter.toType(req.getParameter("type")));

            for(Burger burger: burgers){
                quantity = Integer.parseInt(req.getParameter(valueOf(burger.getId())+"to_add"));
                if(quantity != 0) {
                    tmp = order.getBurgers();
                    tmp.put(burger, quantity);
                    order.setBurgers(tmp);
                    order.setTotal(order.getTotal() + burger.getPrice() * quantity);
                }
            }

            req.setAttribute("orderDTO", dtoWrapper.toDTO(order));
            session.setAttribute("order", order);

            req.getRequestDispatcher("/RecapCommande.jsp")
                    .forward(req, resp);

        } catch (ServiceException e) {
            e.printStackTrace();
            resp.sendRedirect(req.getContextPath()+"/menu");
        }

    }
}
