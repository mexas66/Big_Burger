package fr.greta.java.user.domain;


import fr.greta.java.generic.exception.RepositoryException;
import fr.greta.java.generic.exception.ServiceException;
import fr.greta.java.user.persistance.UserEntity;
import fr.greta.java.user.persistance.UserRepository;
import org.junit.Test;
import org.mockito.InOrder;

import static org.mockito.Mockito.*;

public class UserServiceTest{

    UserWrapper wrapper = mock(UserWrapper.class);
    UserRepository repository = mock(UserRepository.class);

    UserService service = new UserService(wrapper, repository);

    @Test
    public void createSuccessfully() throws RepositoryException, ServiceException {
        User user = mock(User.class);
        UserEntity userEntity = mock(UserEntity.class);

        when(wrapper.toEntity(user)).thenReturn(userEntity);
        when(repository.create(userEntity)).thenReturn(userEntity);
        when(wrapper.fromEntity(userEntity)).thenReturn(user);

        service.create(user);

        InOrder inOrder = inOrder(wrapper, repository);
        inOrder.verify(wrapper).toEntity(user);
        inOrder.verify(repository).create(userEntity);
        inOrder.verify(wrapper).fromEntity(userEntity);
    }
}