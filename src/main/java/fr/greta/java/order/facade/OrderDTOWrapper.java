package fr.greta.java.order.facade;

import fr.greta.java.burger.domain.Burger;
import fr.greta.java.burger.facade.BurgerDTO;
import fr.greta.java.burger.facade.BurgerDTOWrapper;
import fr.greta.java.order.domain.Order;

import java.util.HashMap;
import java.util.Map;


public class OrderDTOWrapper {
    private BurgerDTOWrapper burgerDTOWrapper = new BurgerDTOWrapper();

    public OrderDTO toDTO(Order model){
        OrderDTO dto = new OrderDTO();
        dto.setId(model.getId());
        dto.setBeginning(model.getBeginning().getTime());
        dto.setEnd(model.getEnd().getTime());
        dto.setTotal(model.getTotal());

        Map<BurgerDTO, Integer> burgersDTO = new HashMap<BurgerDTO, Integer>();

        for(Burger burger : model.getBurgers().keySet()){
            burgersDTO.put(burgerDTOWrapper.toDTO(burger), model.getBurgers().get(burger));
        }

        dto.setBurgerDTOs(burgersDTO);

        return dto;
    }

}
