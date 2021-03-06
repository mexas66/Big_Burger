package fr.greta.java.order.domain;

import fr.greta.java.burger.domain.Burger;
import fr.greta.java.burger.domain.BurgerService;
import fr.greta.java.generic.exception.ServiceException;
import fr.greta.java.generic.tools.OrderTypeConverter;
import fr.greta.java.order.persistance.OrderEntity;
import fr.greta.java.user.domain.UserService;

import java.sql.Timestamp;
import java.util.*;

public class OrderWrapper {

    UserService userService = new UserService();
    BurgerService burgerService = new BurgerService();
    OrderTypeConverter converter = new OrderTypeConverter();


    public Order fromEntity(OrderEntity entity) throws ServiceException {
        Order model = new Order();
        model.setId(entity.getId());
        model.setTotal(entity.getTotal());
        model.setState(entity.getState());
        model.setUser(userService.findById(entity.getUser_id()));
        model.setType(converter.toType(entity.getType()));

        model.setBeginning(toCalendar(entity.getBeginning()));
        model.setEnd(toCalendar(entity.getEnd()));

        Map<Burger, Integer> burgers = new HashMap<Burger, Integer>();

        for(int burger_id : entity.getBurgersId().keySet()){
            burgers.put(burgerService.findById(burger_id),entity.getBurgersId().get(burger_id));
        }

        model.setBurgers(burgers);

        return model;
    }

    public OrderEntity toEntity(Order model){
        OrderEntity entity = new OrderEntity();
        entity.setId(model.getId());
        entity.setUser_id(model.getUser().getId());
        entity.setTotal(model.getTotal());
        entity.setBeginning(toTimestamp(model.getBeginning()));
        entity.setEnd(toTimestamp(model.getEnd()));
        entity.setState(model.getState());
        entity.setType(converter.fromType(model.getType()));

        Map<Integer, Integer> burgers_id = new HashMap<>();

        for(Burger burger: model.getBurgers().keySet()){
            burgers_id.put(burger.getId(), model.getBurgers().get(burger));
        }

        entity.setBurgersId(burgers_id);

        return entity;
    }


    public List<Order> fromEntities(List<OrderEntity> entities) throws ServiceException {
        List<Order> models = new ArrayList<>();

        for(OrderEntity entity: entities){
            models.add(fromEntity(entity));
        }

        return models;
    }


    private Timestamp toTimestamp(Calendar calendar){
        Date date = calendar.getTime();
        Timestamp timestamp = new Timestamp(date.getTime());
        return timestamp;
    }


    private Calendar toCalendar(Timestamp timestamp) {
        Date date = new Date(timestamp.getTime());
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return calendar;
    }
}
