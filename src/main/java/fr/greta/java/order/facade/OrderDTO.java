package fr.greta.java.order.facade;

import fr.greta.java.burger.facade.BurgerDTO;
import fr.greta.java.user.facade.UserDTO;

import java.util.Date;
import java.util.List;

public class OrderDTO {
    private List<BurgerDTO> burgerDTOs;
    private int id;
    private UserDTO userDTO;
    private Date beginning;
    private Date end;
    private double total;
}
