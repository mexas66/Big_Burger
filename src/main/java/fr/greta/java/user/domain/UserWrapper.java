package fr.greta.java.user.domain;

import fr.greta.java.adress.domain.Address;
import fr.greta.java.user.persistance.UserEntity;

public class UserWrapper {

    UserService service = new UserService();

    public User fromEntity(UserEntity entity){
        User model = new User();
        model.setId(entity.getId());
        model.setEmail(entity.getEmail());
        model.setFirstname(entity.getFirstname());
        model.setLastname(entity.getLastname());
        model.setPassword(entity.getPassword());
        model.setPhone(entity.getPhone());

        Address address = service.getAddressById(entity.getAddress_id());
        model.setAddress(address);

        return model;
    }


    public UserEntity toEntity(User model){
        UserEntity entity= new UserEntity();
        entity.setId(model.getId());
        entity.setFirstname(model.getFirstname());
        entity.setLastname(model.getLastname());
        entity.setPassword(model.getPassword());
        entity.setEmail(model.getEmail());
        entity.setPhone(model.getPhone());
        entity.setAddress_id(model.getAddress().getId());

        return entity;
    }
}
