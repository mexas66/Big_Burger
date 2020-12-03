package fr.greta.java.adress.facade;

import fr.greta.java.adress.domain.Address;

public class AddressDTOWrapper {
    public AddressDTO toDTO(Address model){
        AddressDTO dto = new AddressDTO();
        dto.setId(model.getId());
        dto.setNumber(model.getNumber());
        dto.setStreet(model.getStreet());
        dto.setZipCode(model.getZipCode());
        dto.setCity(model.getCity());

        return dto;
    }
}
