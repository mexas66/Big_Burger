package fr.greta.java.order.persistance;

import fr.greta.java.burger.persistance.BurgerEntity;

import java.sql.Timestamp;
import java.util.List;

public class OrderEntity {
    private int id;
    private int user_id;
    private List<Integer> burgers_id;
    private Timestamp beginning;
    private Timestamp end;
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

    public List<Integer> getBurgersId() {
        return burgers_id;
    }

    public void setBurgerEntities(List<Integer> burgers_id) {
        this.burgers_id = burgers_id;
    }

    public Timestamp getBeginning() {
        return beginning;
    }

    public void setBeginning(Timestamp beginning) {
        this.beginning = beginning;
    }

    public Timestamp getEnd() {
        return end;
    }

    public void setEnd(Timestamp end) {
        this.end = end;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }
}
