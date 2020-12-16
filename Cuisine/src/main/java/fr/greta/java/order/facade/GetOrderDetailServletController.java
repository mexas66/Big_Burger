package fr.greta.java.order.facade;

import fr.greta.java.employee.domain.Employee;
import fr.greta.java.employee.facade.EmployeeDTOWrapper;
import fr.greta.java.generic.exception.ConverterException;
import fr.greta.java.generic.exception.ServiceException;
import fr.greta.java.order.domain.Order;
import fr.greta.java.order.domain.OrderService;
import fr.greta.java.user.domain.User;
import fr.greta.java.user.facade.UserDTOWrapper;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(urlPatterns = "/detail")
public class GetOrderDetailServletController extends HttpServlet {
    private OrderService service = new OrderService();
    private OrderDTOWrapper dtoWrapper = new OrderDTOWrapper();
	private EmployeeDTOWrapper employeeDtoWrapper  = new EmployeeDTOWrapper();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session= req.getSession();

        try {
            Order order = service.findById(Integer.parseInt(req.getParameter("order_id")));

            Employee employee = (Employee)session.getAttribute("currentemployee");

            if(employee != null){
                req.setAttribute("currentemployee", employeeDtoWrapper.toDTO(employee));
            }

            req.setAttribute("orderDTO", dtoWrapper.toDTO(order));

            req.getRequestDispatcher("/TraitementCommande.jsp")
                    .forward(req, resp);

        } catch (ServiceException | ConverterException e) {
            e.printStackTrace();
            resp.sendRedirect(req.getContextPath()+"/menu?ORDER_REQUEST_ERROR");

        }
    }
}
