package fr.greta.java.order.domain;

import fr.greta.java.generic.exception.RepositoryException;
import fr.greta.java.generic.exception.ServiceException;
import fr.greta.java.order.persistance.OrderRepository;

import java.util.Calendar;
import java.util.List;


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

    public Calendar setEndTime(Calendar calendar) {
        int toAdd = calendar.get(Calendar.MINUTE);
        toAdd %= 10;
        if(toAdd != 0){
            toAdd = 10 - toAdd;
        }
        toAdd += 20;
        calendar.add(Calendar.MINUTE, toAdd);

        return calendar;
    }

    public List<Order> getToPrepareOrders() throws ServiceException {
        try {
            return wrapper.fromEntities(repository.getToPrepareOrders());
        } catch (RepositoryException e) {
            throw new ServiceException(e);
        }
    }

    public Order updateOrderState(int order_id) throws ServiceException {
        try {
            return wrapper.fromEntity(repository.updateOrderState(order_id));
        } catch (RepositoryException e) {
            throw new ServiceException(e);
        }
    }
}
