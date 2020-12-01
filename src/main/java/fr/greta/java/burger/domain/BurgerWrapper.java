package fr.greta.java.burger.domain;

import fr.greta.java.burger.persistance.BurgerEntity;

public class BurgerWrapper {
    public Burger fromEntity(BurgerEntity entity){
        Burger model = new Burger();
        model.setId(entity.getId());
        model.setLabel(entity.getLabel());
        model.setPrice(entity.getPrice());

        return model;
    }

    public BurgerEntity toEntity(Burger model){
        BurgerEntity entity = new BurgerEntity();
        entity.setId(model.getId());
        entity.setLabel(model.getLabel());
        entity.setPrice(model.getPrice());

        return entity;
    }

}
