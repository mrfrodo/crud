package no.frode.cruddemo.controller;

import no.frode.cruddemo.entity.Product;
import no.frode.cruddemo.service.OrderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

/**
 *
 * RestController to handle CRUD operations for Orders
 *
 */

@RestController
@RequestMapping(name = "Orders", value = "orders")
public class OrderController {
    private static final Logger logger = LoggerFactory.getLogger(OrderController.class);
    private final OrderService orderService;

    @Autowired
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping(value = "/")
    List<Product> getOrders() {
        logger.info("__getAllOrders");
        return orderService.getAllOrders();
    }
}
