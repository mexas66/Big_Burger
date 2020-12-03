package fr.greta.java.burger.facade;

import fr.greta.java.burger.domain.Burger;

public class BurgerDTOWrapper {
    public BurgerDTO toDTO(Burger model){
        BurgerDTO dto = new BurgerDTO();
        dto.setId(model.getId());
        dto.setLabel(model.getLabel());
        dto.setPrice(model.getPrice());

        return dto;
    }
}
