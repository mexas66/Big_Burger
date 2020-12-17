package fr.greta.java.order.facade;

import fr.greta.java.burger.domain.Burger;
import fr.greta.java.burger.facade.BurgerDTO;
import fr.greta.java.burger.facade.BurgerDTOWrapper;
import fr.greta.java.generic.tools.OrderTypeConverter;
import fr.greta.java.order.domain.Order;
import fr.greta.java.user.facade.UserDTOWrapper;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class OrderDTOWrapper {
    private BurgerDTOWrapper burgerDTOWrapper = new BurgerDTOWrapper();
    private UserDTOWrapper userDTOWrapper = new UserDTOWrapper();
    private OrderTypeConverter converter = new OrderTypeConverter();

    public OrderDTO toDTO(Order model){
        OrderDTO dto = new OrderDTO();
        dto.setId(model.getId());
        if(model.getBeginning() != null) {
            dto.setBeginning(model.getBeginning().getTime());
        }
        if(model.getEnd() != null) {
            dto.setEnd(model.getEnd().getTime());
        }
        dto.setTotal(model.getTotal());

        if(model.getUser() != null){
            dto.setUserDTO(userDTOWrapper.toDTO(model.getUser()));
        }

        Map<BurgerDTO, Integer> burgersDTO = new HashMap<BurgerDTO, Integer>();

        for(Burger burger : model.getBurgers().keySet()){
            burgersDTO.put(burgerDTOWrapper.toDTO(burger), model.getBurgers().get(burger));
        }

        dto.setState(model.getState());
        dto.setBurgerDTOs(burgersDTO);
        dto.setType(converter.fromType(model.getType()));

        return dto;
    }

    public List<OrderDTO> toDTOs(List<Order> orders) {
        List<OrderDTO> dtos = new ArrayList<>();

        for(Order order : orders){
            dtos.add(toDTO(order));
        }

        return dtos;
    }
}
