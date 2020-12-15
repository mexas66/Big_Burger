package fr.greta.java.order.persistance;

import java.sql.Timestamp;
import java.util.List;
import java.util.Map;

public class OrderEntity {
    private int id;
    private int user_id;
    private Map<Integer, Integer> burgers_id;
    private Timestamp beginning;
    private Timestamp end;
    private double total;
    private String state;

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

    public Map<Integer, Integer> getBurgersId() {
        return burgers_id;
    }

    public void setBurgersId(Map<Integer, Integer> burgers_id) {
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

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}
