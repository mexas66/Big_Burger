package fr.greta.java.employee.facade;

import fr.greta.java.employee.domain.Employee;
import fr.greta.java.employee.domain.EmployeeService;
import fr.greta.java.generic.exception.ServiceException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class RegisterEmployeeServletController extends HttpServlet {

    EmployeeService service = new EmployeeService();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Employee employee = new Employee();

        try {
            employee.setRole(service.toRole(req.getParameter("role")));
            employee.setFirstname(req.getParameter("firstname"));
            employee.setLastname(req.getParameter("lastname"));
            employee.setPhone(req.getParameter("phone"));

            service.create(employee);

        } catch (ServiceException e) {
            e.printStackTrace();
        }
    }
}
