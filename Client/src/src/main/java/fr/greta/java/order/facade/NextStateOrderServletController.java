package fr.greta.java.order.facade;

import fr.greta.java.generic.exception.ServiceException;
import fr.greta.java.order.domain.Order;
import fr.greta.java.order.domain.OrderService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/next")
public class NextStateOrderServletController extends HttpServlet {
    private OrderService service = new OrderService();
    private OrderDTOWrapper dtoWrapper = new OrderDTOWrapper();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            Order order = service.updateOrderState(Integer.parseInt(req.getParameter("order_id")));

            req.setAttribute("order_id",order.getId());

            req.getRequestDispatcher("/detail")
                    .forward(req, resp);

        } catch (ServiceException e) {
            e.printStackTrace();
            resp.sendRedirect(req.getContextPath()+"/menu?ORDER_REQUEST_ERROR");

        }
    }
}
