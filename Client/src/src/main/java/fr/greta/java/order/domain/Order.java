package fr.greta.java.order.domain;

import fr.greta.java.burger.domain.Burger;
import fr.greta.java.user.domain.User;

import java.util.Calendar;
import java.util.Map;

public class Order {
    private int id;
    private User user;
    private Map<Burger, Integer> burgers;
    private Calendar beginning;
    private Calendar end;
    private double total;
    private String state;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Map<Burger, Integer> getBurgers() {
        return burgers;
    }

    public void setBurgers(Map<Burger, Integer> burgers) {
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

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}
