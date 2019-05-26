package no.frode.cruddemo.service;

import no.frode.cruddemo.entity.Order;
import no.frode.cruddemo.repository.OrderRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 * OrderService
 *
 * Class responsible of data manipulation between dto and entity
 *
 *
 */

@Service
public class OrderService {
    private static final Logger logger = LoggerFactory.getLogger(OrderService.class);

    @Autowired
    OrderRepository orderRepository;

    public List<Order> getAllOrders() {
        logger.info("__getAllOrders");
        return orderRepository.findAll();
    }
}
