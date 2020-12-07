package fr.greta.java.order.facade;

import fr.greta.java.burger.domain.Burger;
import fr.greta.java.burger.domain.BurgerService;
import fr.greta.java.generic.exception.ServiceException;
import fr.greta.java.order.domain.Order;
import fr.greta.java.user.domain.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@WebServlet
public class AddOrderServletController extends HttpServlet {
    private BurgerService burgerService = new BurgerService();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        Order order = (Order)session.getAttribute("order");


        try {
        Burger burger = burgerService.findById(Integer.parseInt(req.getParameter("burger_id")));

            if(order == null){
                order = new Order();
                order.setBurgers(new HashMap<Burger, Integer>());
                order.setTotal(0);
                order.setUser((User)session.getAttribute("usercurrent"));
            }

            Map<Burger, Integer> burgers = order.getBurgers();

            burgers.put(burger, Integer.parseInt(req.getParameter("to_add")));

            order.setBurgers(burgers);

            session.setAttribute("order", order);

            RequestDispatcher dispatch = req.getRequestDispatcher("/menu");
            dispatch.forward(req, resp);


        } catch (ServiceException e) {
            e.printStackTrace();
            resp.sendRedirect(req.getContextPath()+"/menu");
        }


    }
}
