package no.frode.cruddemo.repository;

import no.frode.cruddemo.entity.Product;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;
import java.util.List;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Need to check that programmatically configured
 * DataSource is working
 */

@RunWith(SpringRunner.class)
@DataJpaTest
public class ProductRepositoryIntTest {

    @Autowired
    private ProductRepository productRepository;

    @Test
    public void contextLoads() {

    }

    @Test
    public void should_return_1_product_after_save() {
        Product aNewProduct = new Product();
        aNewProduct.setProductName("kneiploff");
        productRepository.save(aNewProduct);
        List<Product> products = productRepository.findAll();
        assertThat(products.size(), equalTo(1));
        Product theSavedProduct = products.get(0);
        String name = theSavedProduct.getProductName();
        assertThat(name, equalTo("kneiploff"));
    }
}
