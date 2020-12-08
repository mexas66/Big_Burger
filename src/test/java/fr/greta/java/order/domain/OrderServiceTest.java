package fr.greta.java.order.domain;

import fr.greta.java.generic.exception.RepositoryException;
import fr.greta.java.generic.exception.ServiceException;
import fr.greta.java.order.persistance.OrderEntity;
import fr.greta.java.order.persistance.OrderRepository;
import org.checkerframework.checker.units.qual.C;
import org.junit.Test;
import org.mockito.InOrder;

import java.util.Calendar;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

public class OrderServiceTest {

    OrderWrapper wrapper = mock(OrderWrapper.class);
    OrderRepository repository = mock(OrderRepository.class);

    OrderService service = new OrderService(wrapper, repository);

    @Test
    public void createSuccessfully() throws ServiceException, RepositoryException {
        Order order = mock(Order.class);
        OrderEntity orderEntity = mock(OrderEntity.class);

        when(wrapper.toEntity(order)).thenReturn(orderEntity);
        when(repository.create(orderEntity)).thenReturn(orderEntity);
        when(wrapper.fromEntity(orderEntity)).thenReturn(order);

        service.create(order);

        InOrder inOrder = inOrder(wrapper,repository);
        inOrder.verify(wrapper).toEntity(order);
        inOrder.verify(repository).create(orderEntity);
        inOrder.verify(wrapper).fromEntity(orderEntity);
    }

    @Test
    public void setCorrectEndTime(){
        Calendar calendar = Calendar.getInstance();
        Calendar toTest= calendar;
        calendar.set(Calendar.MINUTE, 14);
        toTest.set(Calendar.MINUTE, 40);

        assertEquals(service.setEndTime(calendar), toTest);
    }

}