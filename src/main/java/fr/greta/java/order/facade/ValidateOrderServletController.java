package fr.greta.java.order.facade;

import fr.greta.java.generic.exception.ServiceException;
import fr.greta.java.order.domain.Order;
import fr.greta.java.order.domain.OrderService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Calendar;


@WebServlet(urlPatterns = "/validate")
public class ValidateOrderServletController extends HttpServlet {
    OrderService service = new OrderService();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        Order order = (Order)session.getAttribute("order");

        Calendar calendar = Calendar.getInstance();

        order.setBeginning(calendar);
        order.setEnd(service.setEndTime(calendar));

        try {
            service.create(order);

            session.removeAttribute("order");

            RequestDispatcher dispatcher = req.getRequestDispatcher("/user");
            dispatcher.forward(req, resp);

        } catch (ServiceException e) {
            e.printStackTrace();
            resp.sendRedirect(req.getContextPath()+"/menu?message=ORDER_ERROR");
        }
    }
}
