package no.frode.cruddemo.controller;

import no.frode.cruddemo.controller.ProductController;
import no.frode.cruddemo.dto.ProductDTO;
import no.frode.cruddemo.entity.Product;
import no.frode.cruddemo.exception.ProductNotFoundException;
import no.frode.cruddemo.service.ProductService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import java.math.BigInteger;
import java.util.*;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class ProductControllerTest {

    @InjectMocks
    private ProductController productController;

    @Mock
    private ProductService productService;

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void getProducts() {
        Set<String> uniqueNames = new HashSet<>(Arrays.asList("Larry", "Steve", "James"));
        List<Product> productList = new ArrayList<>();
        uniqueNames.forEach(name ->
        {
            Product p = new Product();
            p.setProductName(name);
            productList.add(p);
        });


        when(productService.getAllProducts()).thenReturn(productList);

        List<Product> productList1 = productController.getProducts();

        verify(productService).getAllProducts();

        assertEquals(3, productList1.size());

    }

    @Test
    public void getProduct() {
        Product p = new Product();
        p.setId(1l);

        when(productService.getProduct(1l)).thenReturn(p);

        Product product = productController.getProduct(1l);

        verify(productService).getProduct(1l);
        assertEquals(1l, product.getId().longValue());
    }

    @Test
    public void createProduct() {
        ProductDTO pDto = new ProductDTO();
        pDto.setId(2L);

        Product p = createEplekakeProduct();

        when(productService.createProduct(pDto)).thenReturn(p);

        Product product = productController.createProduct(pDto);

        verify(productService).createProduct(pDto);

        assertEquals(2L, product.getId().longValue());

    }

    @Test
    public void updateProduct() {
        ProductDTO pDto = new ProductDTO();
        pDto.setId(2L);
        pDto.setProductName("eplekake");
        pDto.setCategory("kake");

        Product p = new Product();
        p.setId(2L);
        p.setProductName("banankake");
        p.setCategory("kake");

        when(productService.updateProduct(2L, pDto)).thenReturn(p);

        Product product = productController.updateProduct(2L, pDto);

        verify(productService).updateProduct(2L, pDto);

        assertEquals(2l, product.getId().longValue());
        assertEquals("banankake", product.getProductName());
        assertEquals("kake", product.getCategory());
    }

    @Test(expected = ProductNotFoundException.class)
    public void updateProductWithException() {

        ProductDTO pDto = new ProductDTO();
        pDto.setId(2L);
        pDto.setProductName("eplekake");
        pDto.setCategory("banankake");

        when(productService.getProduct(2L)).thenThrow(new ProductNotFoundException(2L));

        productController.updateProduct(2L, pDto);

    }

    @Test
    public void deleteProduct() {

        Product p = new Product();
        p.setId(1l);

        when(productService.deleteProduct(1l)).thenReturn(p);

        Product product = productController.deleteProduct(1l);

        verify(productService).deleteProduct(1l);

        assertEquals(1l, product.getId().longValue());
    }

    private Product createEplekakeProduct() {
        Product product = new Product();
        product.setId(2L);
        product.setProductName("eplekake");
        product.setCategory("kake");
        product.setImageLink("http://eplekake.org");
        product.setUnitCost(new Double(3));
        product.setUnitPrice(new Double(4));
        product.setNumberSold(new BigInteger("8"));
        return product;
    }
}