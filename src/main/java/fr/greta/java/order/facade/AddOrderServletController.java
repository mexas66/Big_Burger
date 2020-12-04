package fr.greta.java.order.facade;

import fr.greta.java.burger.domain.Burger;
import fr.greta.java.burger.domain.BurgerService;
import fr.greta.java.generic.exception.ServiceException;
import fr.greta.java.order.domain.Order;
import fr.greta.java.user.domain.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

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
                order.setBurgers(new ArrayList());
                order.setTotal(0);
                order.setUser((User)session.getAttribute("user"));
            }

            List<Burger> burgers = order.getBurgers();

            for(int i = 0; i < Integer.parseInt(req.getParameter("to_add")); i++){
                burgers.add(burger);
                order.setTotal(order.getTotal()+burger.getPrice());
            }

            session.setAttribute("order", order);


        } catch (ServiceException e) {
            e.printStackTrace();
            resp.sendRedirect(req.getContextPath()+"/menu");
        }


    }
}
