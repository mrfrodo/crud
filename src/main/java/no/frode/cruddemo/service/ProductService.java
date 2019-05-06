package no.frode.cruddemo.service;

import no.frode.cruddemo.dto.ProductDTO;
import no.frode.cruddemo.entity.Product;
import no.frode.cruddemo.exception.ProductNotFoundException;
import no.frode.cruddemo.repository.ProductRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * ProductService
 *
 * Class responsible of data manipulation between dto and entity
 *
 *
 */

@Service
public class ProductService {

    @Autowired
    ProductRepository productRepository;

    @Autowired
    ModelMapper modelMapper;

    public List<Product> getAllProducts() {

        return productRepository.findAll();
    }

    public Product getProduct(Long id) {

        return productRepository.findById(id).orElseThrow(() -> new ProductNotFoundException(id));

    }

    //@Todo create delete functionality
    public Product deleteProduct(Long id) {

        Optional<Product> optionalProduct = productRepository.findById(id);
        if (!optionalProduct.isPresent()) {
            throw new ProductNotFoundException(id);
        } else {
            Product product = optionalProduct.get();

            productRepository.delete(product);

            return product;
        }
    }

    public Product createProduct(ProductDTO inputProduct) {

        Product product = convertToEntity(inputProduct);

        return productRepository.save(product);
    }

    //@Todo create update functionality
    public Product updateProduct(Long id, ProductDTO inputProduct) {

        Optional<Product> optionalProduct = productRepository.findById(id);

        if (!optionalProduct.isPresent()) {
            throw new ProductNotFoundException(id);
        } else {
            Product p = convertToEntity(inputProduct);
            p.setId(id);
            Product product = productRepository.save(p);

            return product;
        }
    }


    public ProductDTO convertToDTO(Product product) {

        ProductDTO productDTO = modelMapper.map(product, ProductDTO.class);

        return productDTO;
    }

    public Product convertToEntity(ProductDTO productDTO) {
        Product product = modelMapper.map(productDTO, Product.class);

        return product;

    }


}
