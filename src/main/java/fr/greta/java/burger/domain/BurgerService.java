package fr.greta.java.burger.domain;

import fr.greta.java.burger.persistance.BurgerRepository;
import fr.greta.java.generic.exception.RepositoryException;
import fr.greta.java.generic.exception.ServiceException;

public class BurgerService {
    BurgerRepository repository = new BurgerRepository();
    BurgerWrapper wrapper = new BurgerWrapper();

    public Burger findById(int burger_id) throws ServiceException {
        try {
            return wrapper.fromEntity(repository.findById(burger_id));
        } catch (RepositoryException e) {
            throw new ServiceException(e);
        }
    }
}
