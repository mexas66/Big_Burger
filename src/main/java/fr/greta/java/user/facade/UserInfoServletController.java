package fr.greta.java.user.facade;
import fr.greta.java.generic.exception.ServiceException;
import fr.greta.java.order.domain.Order;
import fr.greta.java.order.domain.OrderService;
import fr.greta.java.order.facade.OrderDTOWrapper;
import fr.greta.java.user.domain.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet (urlPatterns = "/user")
public class UserInfoServletController extends HttpServlet {
    private OrderService orderService= new OrderService();
    private OrderDTOWrapper orderDTO = new OrderDTOWrapper();
    private UserDTOWrapper dtoWrapper = new UserDTOWrapper();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();

        User user = (User)session.getAttribute("currentuser");

        List<Order> orders = null;
        try {
            orders = orderService.getNotEndedOrders();


            req.setAttribute("orders", orderDTO.toDTOs(orders));
            req.setAttribute("currentuser", dtoWrapper.toDTO(user));

            req.getRequestDispatcher("/Utilisateur.jsp")
                    .forward(req, resp);

        } catch (ServiceException e) {
            e.printStackTrace();
            resp.sendRedirect(req.getContextPath()+"/BigBurger.jsp?message=USER_ERROR_MESSAGE");
        }
    }
}
