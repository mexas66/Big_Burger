package fr.greta.java.order.domain;

import fr.greta.java.ConnectionFactory;
import fr.greta.java.burger.domain.Burger;
import fr.greta.java.burger.domain.BurgerService;
import fr.greta.java.generic.exception.RepositoryException;
import fr.greta.java.generic.exception.ServiceException;
import fr.greta.java.order.persistance.OrderRepository;
import fr.greta.java.user.domain.User;
import fr.greta.java.user.domain.UserService;


public class OrderService {

    private BurgerService burgerService = new BurgerService();
    private UserService userService = new UserService();
    private OrderWrapper wrapper;
    private OrderRepository repository;

    public OrderService(OrderWrapper wrapper, OrderRepository repository) {
        this.wrapper = wrapper;
        this.repository = repository;
    }

    public OrderService(){
        repository = new OrderRepository();
        wrapper = new OrderWrapper();
    }

    public Order create(Order order) throws ServiceException {
        try {
            return wrapper.fromEntity(repository.create(wrapper.toEntity(order)));
        } catch (RepositoryException e) {
            throw new ServiceException(e);
        }
    }
}
