package fr.greta.java.order.domain;

import fr.greta.java.generic.exception.RepositoryException;
import fr.greta.java.generic.exception.ServiceException;
import fr.greta.java.order.persistance.OrderRepository;


public class OrderService {

    private OrderWrapper wrapper;
    private OrderRepository repository;

    public OrderService(OrderWrapper wrapper, OrderRepository repository) {
        this.wrapper = wrapper;
        this.repository = repository;
    }

    public OrderService(){
        wrapper= new OrderWrapper();
        repository = new OrderRepository();
    }

    public Order findById(int order_id) throws ServiceException {
        try {
            return wrapper.fromEntity(repository.findById(order_id));
        } catch (RepositoryException e) {
            throw new ServiceException(e);
        }
    }

    public Order create(Order order) throws ServiceException {
        try {
            return wrapper.fromEntity(repository.create(wrapper.toEntity(order)));
        } catch (RepositoryException e) {
            throw new ServiceException(e);
        }
    }
}
