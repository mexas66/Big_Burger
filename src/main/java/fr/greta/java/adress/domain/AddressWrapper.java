package fr.greta.java.adress.domain;

import fr.greta.java.adress.persistance.AddressEntity;

public class AddressWrapper {

    public Address fromEntity(AddressEntity entity){
        Address model = new Address();
        model.setId(entity.getId());
        model.setNumber(entity.getNumber());
        model.setStreet(entity.getStreet());
        model.setZipCode(entity.getZipCode());
        model.setCity(entity.getCity());

        return model;
    }

    public AddressEntity toEntity(Address model){
        AddressEntity entity = new AddressEntity();
        entity.setId(model.getId());
        entity.setNumber(model.getNumber());
        entity.setStreet(model.getStreet());
        entity.setZipCode(model.getZipCode());
        entity.setCity(model.getCity());

        return entity;
    }
}
