package no.frode.cruddemo.controller;

import no.frode.cruddemo.dto.ProductDTO;
import no.frode.cruddemo.entity.Product;
import no.frode.cruddemo.service.ProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

/**
 *
 * RestController to handle CRUD operations for Products
 *
 */

@RestController
@RequestMapping(name = "Products", value = "products")
public class ProductController {
    private static final Logger logger = LoggerFactory.getLogger(ProductController.class);

    @Autowired
    ProductService productService;

    @GetMapping(value = "/")
    List<Product> getAllProducts() {
        logger.info("__getAllProducts");
        return productService.getAllProducts();
    }

    @GetMapping(value = "/{id}")
    Product getProduct(@PathVariable("id") Long id) {
        Product product = productService.getProduct(id);
        return product;
    }

    @PostMapping(value = "/")
    Product createProduct(@RequestBody ProductDTO inputProduct) {
        Product product = productService.createProduct(inputProduct);
        return product;
    }

    @PutMapping(value = "/{id}")
    Product updateProduct(@PathVariable("id") Long id, @RequestBody ProductDTO inputProduct) {
        Product product = productService.getProduct(id);

        return productService.updateProduct(id, inputProduct);
    }

    @DeleteMapping(value = "/{id}")
    Product deleteProduct(@PathVariable("id") Long id) {
        return productService.deleteProduct(id);
    }
}
