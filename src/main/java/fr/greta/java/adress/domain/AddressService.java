package fr.greta.java.adress.domain;

import fr.greta.java.adress.persistance.AddressRepository;
import fr.greta.java.generic.exception.RepositoryException;
import fr.greta.java.generic.exception.ServiceException;

public class AddressService {
    private AddressRepository repository = new AddressRepository();
    private AddressWrapper wrapper = new AddressWrapper();

    public Address findById(int address_id) throws ServiceException {
        try {
            return wrapper.fromEntity(repository.findById(address_id));
        } catch (RepositoryException e) {
            throw new ServiceException(e);
        }
    }

    public Address create(Address address) throws ServiceException {
        try {
            return wrapper.fromEntity(repository.create(wrapper.toEntity(address)));
        } catch (RepositoryException e) {
            throw new ServiceException(e);
        }
    }
}
