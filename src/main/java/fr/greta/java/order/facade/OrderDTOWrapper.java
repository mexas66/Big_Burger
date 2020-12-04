package fr.greta.java.order.facade;

import fr.greta.java.burger.domain.Burger;
import fr.greta.java.burger.facade.BurgerDTO;
import fr.greta.java.burger.facade.BurgerDTOWrapper;
import fr.greta.java.order.domain.Order;
import fr.greta.java.user.facade.UserDTOWrapper;

import java.util.ArrayList;
import java.util.List;


public class OrderDTOWrapper {
    private BurgerDTOWrapper burgerDTOWrapper = new BurgerDTOWrapper();

    public OrderDTO toDTO(Order model){
        OrderDTO dto = new OrderDTO();
        dto.setId(model.getId());
        dto.setBeginning(model.getBeginning().getTime());
        dto.setEnd(model.getEnd().getTime());
        dto.setTotal(model.getTotal());

        List<BurgerDTO> burgersDTO = new ArrayList();

        for(Burger burger : model.getBurgers()){
            burgersDTO.add(burgerDTOWrapper.toDTO(burger));
        }

        dto.setBurgerDTOs(burgersDTO);

        return dto;
    }

}
