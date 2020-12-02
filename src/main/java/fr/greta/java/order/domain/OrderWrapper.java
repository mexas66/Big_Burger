package fr.greta.java.order.domain;

import fr.greta.java.burger.domain.Burger;
import fr.greta.java.order.persistance.OrderEntity;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class OrderWrapper {

    OrderService service = new OrderService();


    public Order fromEntity(OrderEntity entity){
        Order model = new Order();
        model.setId(entity.getId());
        model.setTotal(entity.getTotal());
        model.setUser(service.getUserById(entity.getUser_id()));

        model.setBeginning(toCalendar(entity.getBeginning()));
        model.setEnd(toCalendar(entity.getEnd()));

        List<Burger> burgers = new ArrayList();

        for(int burger_id : entity.getBurgersId()){
            burgers.add(service.getBurgerById(burger_id));
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

        List<Integer> burgers_id = new ArrayList();

        for(Burger burger : model.getBurgers()){
            burgers_id.add(burger.getId());
        }

        return entity;
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
