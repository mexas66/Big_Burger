package fr.greta.java.order.facade;

import fr.greta.java.generic.exception.ServiceException;
import fr.greta.java.order.domain.Order;
import fr.greta.java.order.domain.OrderService;
import fr.greta.java.user.domain.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = "/orderlist")
public class GetOrderListServletController extends HttpServlet {
    private OrderService service = new OrderService();
    private OrderDTOWrapper dtoWrapper = new OrderDTOWrapper();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();

        User user = (User)session.getAttribute("currentuser");
        try {
            if(user != null && (user.getRole().equals("COOKER") || user.getRole().equals("DELIVERY"))) {

                List<Order> orders = service.getOrderList(user.getRole());
                req.setAttribute("orderlist", dtoWrapper.toDTOs(orders));

                req.getRequestDispatcher("/Cuisine.jsp")
                        .forward(req, resp);
            }else{
                resp.sendRedirect(req.getContextPath()+"BigBurger.jsp?message=ACCESS_DENIED");
            }
        } catch (ServiceException e) {
            e.printStackTrace();
            resp.sendRedirect(req.getContextPath()+"/menu?ORDER_REQUEST_ERROR");
        }
    }
}
