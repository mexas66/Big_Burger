package fr.greta.java.burger.facade;

import fr.greta.java.burger.domain.Burger;

import java.util.ArrayList;
import java.util.List;

public class BurgerDTOWrapper {
    public BurgerDTO toDTO(Burger model){
        BurgerDTO dto = new BurgerDTO();
        dto.setId(model.getId());
        dto.setLabel(model.getLabel());
        dto.setPrice(model.getPrice());

        return dto;
    }

    public List<BurgerDTO> toDTOs(List<Burger> burgers) {
        List<BurgerDTO> dtos = new ArrayList();
        for(Burger burger: burgers){
            dtos.add(toDTO(burger));
        }
        return dtos;
    }
}
