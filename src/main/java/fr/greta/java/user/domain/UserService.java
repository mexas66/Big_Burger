package fr.greta.java.user.domain;

import fr.greta.java.generic.exception.RepositoryException;
import fr.greta.java.generic.exception.ServiceException;
import fr.greta.java.user.persistance.UserRepository;

public class UserService {

    UserWrapper wrapper = new UserWrapper();
    UserRepository repository = new UserRepository();

    public UserService(UserWrapper wrapper, UserRepository repository) {
        this.wrapper = wrapper;
        this.repository = repository;
    }

    public UserService(){
        wrapper = new UserWrapper();
        repository = new UserRepository();
    }

    public User findById(int user_id) throws ServiceException {
        try {
            return wrapper.fromEntity(repository.findById(user_id));
        } catch (RepositoryException e) {
            throw new ServiceException(e);
        }
    }



    public User create(User user) throws ServiceException {
        try {
            return wrapper.fromEntity(repository.create(wrapper.toEntity(user)));
        } catch (RepositoryException e) {
            throw new ServiceException(e);
        }
    }

    public User findUser(String login, String password) throws ServiceException {
        try {
            return wrapper.fromEntity(repository.findUser(login,password));
        } catch (RepositoryException e) {
            throw new ServiceException(e);
        }
    }
}
