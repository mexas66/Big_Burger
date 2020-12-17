package fr.greta.java.order.domain;

import fr.greta.java.employee.domain.EmployeeRole;
import fr.greta.java.generic.exception.ConverterException;
import fr.greta.java.generic.exception.RepositoryException;
import fr.greta.java.generic.exception.ServiceException;
import fr.greta.java.generic.tools.RoleConverter;
import fr.greta.java.order.persistance.OrderRepository;

import java.util.Calendar;
import java.util.List;


public class OrderService {

    private OrderWrapper wrapper;
    private OrderRepository repository;
    private RoleConverter roleConverter = new RoleConverter();

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

    public Calendar setEndTime(Calendar calendar, OrderType orderType) {
        int toAdd = calendar.get(Calendar.MINUTE);
        toAdd %= 10;
        if(toAdd != 0){
            toAdd = 10 - toAdd;
        }
        toAdd += 20;
        if(orderType.equals(OrderType.DELIVERY)) {
        	toAdd += 10;
        }
        calendar.add(Calendar.MINUTE, toAdd);

        return calendar;
    }

    public List<Order> getOrderList(EmployeeRole role) throws ServiceException {
        try {
            return wrapper.fromEntities(repository.getOrderList(roleConverter.fromRole(role)));
        } catch (RepositoryException | ConverterException e) {
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

    public List<Order> getNotEndedOrders(int user_id) throws ServiceException {
        try {
            return wrapper.fromEntities(repository.getNotEndedOrders(user_id));
        } catch (RepositoryException e) {
            throw new ServiceException(e);
        }
    }

    public List<Order> getAllByUserId(int userId) throws ServiceException {
        try {
            return wrapper.fromEntities(repository.getAllByUserId(userId));
        } catch (RepositoryException e) {
            throw new ServiceException(e);
        }
    }
}
