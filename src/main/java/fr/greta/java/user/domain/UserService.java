package fr.greta.java.user.domain;

import fr.greta.java.adress.domain.Address;
import fr.greta.java.adress.domain.AddressService;
import fr.greta.java.user.persistance.UserRepository;

public class UserService {

    AddressService addressService = new AddressService();
    UserWrapper wrapper = new UserWrapper();
    UserRepository repository = new UserRepository();

    public Address getAddressById(int address_id) {
        return addressService.findById(address_id);
    }

    public User findById(int user_id) {
        return wrapper.fromEntity(repository.findById(user_id));
    }
}
