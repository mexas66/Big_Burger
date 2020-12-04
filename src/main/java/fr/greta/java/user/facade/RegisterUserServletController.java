package fr.greta.java.user.facade;

import fr.greta.java.adress.domain.Address;
import fr.greta.java.adress.domain.AddressService;
import fr.greta.java.adress.persistance.AddressRepository;
import fr.greta.java.generic.exception.ServiceException;
import fr.greta.java.user.domain.User;
import fr.greta.java.user.domain.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns="/register")
public class RegisterUserServletController extends HttpServlet {
    private AddressService addressService= new AddressService();
    private UserService service = new UserService();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Address address = new Address();
        User user = new User();
        try {
            address.setNumber(req.getParameter("number"));
            address.setStreet(req.getParameter("street"));
            address.setZipCode(req.getParameter("zipcode"));
            address.setCity(req.getParameter("city"));

            address = addressService.create(address);

            user.setAddress(address);
            user.setFirstname(req.getParameter("firstname"));
            user.setLastname(req.getParameter("lastname"));
            user.setEmail(req.getParameter("email"));
            user.setPassword(req.getParameter("password"));
            user.setPhone("phone");

            service.create(user);

            resp.sendRedirect(req.getContextPath()+"/accueil?message=REGISTER_SUCCESS");
        }catch(ServiceException e){
            e.printStackTrace();
            resp.sendRedirect(req.getContextPath()+"/register?message=REGISTER_ERROR");
        }
    }
}
