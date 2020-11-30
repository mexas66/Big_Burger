package fr.greta.java.order.persistance;

import fr.greta.java.burger.domain.Burger;


import java.sql.Date;
import java.util.List;

public class OrderEntity {
    private int id;
    private int user_id;
    private List<Integer> burgers_id;
    private Date beginning;
    private Date end;
    private double total;
}
