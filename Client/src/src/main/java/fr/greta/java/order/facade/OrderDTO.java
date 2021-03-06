package fr.greta.java.order.facade;

import fr.greta.java.burger.facade.BurgerDTO;
import fr.greta.java.user.facade.UserDTO;

import java.util.Date;
import java.util.List;
import java.util.Map;

public class OrderDTO {
    private Map<BurgerDTO,Integer> burgerDTOs;
    private int id;
    private UserDTO userDTO;
    private Date beginning;
    private Date end;
    private double total;
    private String state;

    public Map<BurgerDTO, Integer> getBurgerDTOs() {
        return burgerDTOs;
    }

    public void setBurgerDTOs(Map<BurgerDTO, Integer> burgerDTOs) {
        this.burgerDTOs = burgerDTOs;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public UserDTO getUserDTO() {
        return userDTO;
    }

    public void setUserDTO(UserDTO userDTO) {
        this.userDTO = userDTO;
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

    public String getState() {
        return state;
    }

    public void setState(String _state) {
        this.state = _state;
    }
}
