package fr.greta.java.order.facade;

import fr.greta.java.burger.facade.BurgerDTO;
import fr.greta.java.user.facade.UserDTO;

import java.util.Date;
import java.util.List;

public class OrderDTO {
    private List<BurgerDTO> burgerDTOs;
    private int id;
    private Date beginning;
    private Date end;
    private double total;

    public List<BurgerDTO> getBurgerDTOs() {
        return burgerDTOs;
    }

    public void setBurgerDTOs(List<BurgerDTO> burgerDTOs) {
        this.burgerDTOs = burgerDTOs;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public Date getBeginning() {
        return beginning;
    }

    public void setBeginning(Date beginning) {
        this.beginning = beginning;
    }

    public Date getEnd() {
        return end;
    }

    public void setEnd(Date end) {
        this.end = end;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }
}
