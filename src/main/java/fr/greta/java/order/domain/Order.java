package fr.greta.java.order.domain;

import fr.greta.java.burger.domain.Burger;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class Order {
    private int id;
    private int user_id;
    private List<Burger> burgers;
    private Calendar beginning;
    private Calendar end;
    private double total;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public List<Burger> getBurgers() {
        return burgers;
    }

    public void setBurgers(List<Burger> burgers) {
        this.burgers = burgers;
    }

    public Calendar getBeginning() {
        return beginning;
    }

    public void setBeginning(Calendar beginning) {
        this.beginning = beginning;
    }

    public Calendar getEnd() {
        return end;
    }

    public void setEnd(Calendar end) {
        this.end = end;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }
}
