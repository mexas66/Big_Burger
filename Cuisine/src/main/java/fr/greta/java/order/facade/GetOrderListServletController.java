package fr.greta.java.order.facade;

import fr.greta.java.employee.domain.Employee;
import fr.greta.java.employee.facade.EmployeeDTOWrapper;
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
import java.util.List;

@WebServlet(urlPatterns = "/employeeorderlist")
public class GetOrderListServletController extends HttpServlet {
    private OrderService service = new OrderService();
    private OrderDTOWrapper dtoWrapper = new OrderDTOWrapper();
    private EmployeeDTOWrapper employeeDtoWrapper = new EmployeeDTOWrapper(); 

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();

        Employee employee = (Employee)session.getAttribute("currentemployee");
        try {
            if(employee != null) {

                List<Order> orders = service.getOrderList(employee.getRole());
                req.setAttribute("orderlist", dtoWrapper.toDTOs(orders));

                req.getRequestDispatcher("/Cuisine.jsp")
                        .forward(req, resp);
            }else{
                resp.sendRedirect("/BigBurger.jsp?message=ACCESS_DENIED");
            }
        }catch (ServiceException e) {
            e.printStackTrace();
            resp.sendRedirect("/BigBurger.jsp?ORDER_REQUEST_ERROR");
        }
    }
}
