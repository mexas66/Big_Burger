package fr.greta.java.order.facade;

import fr.greta.java.generic.exception.ServiceException;
import fr.greta.java.order.domain.Order;
import fr.greta.java.order.domain.OrderService;

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

        order.setBeginning(Calendar.getInstance());
        order.setEnd(service.setEndTime(Calendar.getInstance()));

        order.setState("VALIDATED");

        try {
            service.create(order);

            session.removeAttribute("order");

            resp.sendRedirect(req.getContextPath()+"/user");

        } catch (ServiceException e) {
            e.printStackTrace();
            resp.sendRedirect(req.getContextPath()+"/menu?message=ORDER_ERROR");
        }
    }
}
