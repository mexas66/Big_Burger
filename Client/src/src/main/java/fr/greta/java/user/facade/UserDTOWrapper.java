package fr.greta.java.user.facade;

import fr.greta.java.adress.facade.AddressDTO;
import fr.greta.java.adress.facade.AddressDTOWrapper;
import fr.greta.java.user.domain.User;

public class UserDTOWrapper {

    private AddressDTOWrapper addressDTOWrapper = new AddressDTOWrapper();
    public UserDTO toDTO(User model){
        UserDTO dto = new UserDTO();
        dto.setId(model.getId());
        dto.setEmail(model.getEmail());
        dto.setFirstname(model.getFirstname());
        dto.setLastname(model.getLastname());
        dto.setPhone(model.getPhone());
        dto.setAddressDTO(addressDTOWrapper.toDTO(model.getAddress()));
        dto.setRole(model.getRole());

        return dto;
    }
}
