package no.frode.cruddemo.service;

import no.frode.cruddemo.entity.Order;
import no.frode.cruddemo.entity.Product;
import no.frode.cruddemo.repository.OrderRepository;
import no.frode.cruddemo.repository.ProductRepository;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.*;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class OrderServiceTest {
    @Mock
    OrderRepository orderRepository;

    @InjectMocks
    OrderService orderService;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void getAllOrders() {

        Set<Long> uniqueOrderIds = new HashSet<>(Arrays.asList(555L, 556L, 557L, 558L));
        List<Order> orderList = new ArrayList<>();
        uniqueOrderIds.forEach(id ->
        {
            Order o = new Order();
            o.setId(id);
            orderList.add(o);
        });

        when(orderRepository.findAll()).thenReturn(orderList);

        List<Order> orderList1 = orderService.getAllOrders();

        verify(orderRepository).findAll();

        assertEquals(4, orderList1.size());
    }
}
