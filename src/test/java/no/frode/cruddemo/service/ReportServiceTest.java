package  no.frode.cruddemo.service;

import no.frode.cruddemo.entity.Product;
import no.frode.cruddemo.model.FinancialReport;
import no.frode.cruddemo.repository.ProductRepository;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import java.math.BigInteger;
import java.util.*;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

public class ReportServiceTest {

    @InjectMocks
    ReportService reportService;

    @Mock
    ProductRepository productRepository;

    List<Product> productList;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        productList = createProductList();
    }

    @Test
    //Total revenue – sum of units sold multiplied by unit price.
    public void totalRevenue() {

        when (productRepository.findAll()).thenReturn(productList);

        FinancialReport report = reportService.generateReport();

        assertEquals(new Double("26"), report.getTotalTurnover());

    }

    @Test
    //Total cost – sum of units sold multiplied by unit cost.
    public void totalCost() {

        when (productRepository.findAll()).thenReturn(productList);

        FinancialReport report = reportService.generateReport();

        assertEquals(new Double("7"), report.getTotalCost());


    }

    @Test
    //Total margin – revenue minus cost.
    public void totalMargin() {

        when (productRepository.findAll()).thenReturn(productList);

        FinancialReport report = reportService.generateReport();

        assertEquals(new Double("19"), report.getTotalMargin());

    }

    @Test
    public void product_information_of_the_most_sold_product() {

        when (productRepository.findAll()).thenReturn(productList);

        FinancialReport report = reportService.generateReport();

        Product mostSoldProduct = report.getMostSoldProduct();

        assertEquals("ananaskake", mostSoldProduct.getProductName());
        assertEquals("kake", mostSoldProduct.getCategory());
        assertEquals("http://ananaskake.org", mostSoldProduct.getImageLink());
        assertEquals(new Double("5.0"), mostSoldProduct.getUnitPrice());
        assertEquals(new Double("1.0"), mostSoldProduct.getUnitCost());
        assertEquals(new BigInteger("3"), mostSoldProduct.getNumberSold());

    }

    @Test
    public void product_information_of_the_least_sold_product() {

        when (productRepository.findAll()).thenReturn(productList);

        FinancialReport report = reportService.generateReport();

        Product mostSoldProduct = report.getLeastSoldProduct();

        assertEquals("eplekake", mostSoldProduct.getProductName());
        assertEquals("kake", mostSoldProduct.getCategory());
        assertEquals("http://eplekake.org", mostSoldProduct.getImageLink());
        assertEquals(new Double("3.0"), mostSoldProduct.getUnitPrice());
        assertEquals(new Double("2.0"), mostSoldProduct.getUnitCost());
        assertEquals(new BigInteger("1"), mostSoldProduct.getNumberSold());


    }

    @Test
    public void product_information_of_the_product_with_highest_contribution_to_the_margin() {

        when (productRepository.findAll()).thenReturn(productList);

        FinancialReport report = reportService.generateReport();

        Product highestMarginProduct = report.getHighestMarginProduct();

        assertEquals("ananaskake", highestMarginProduct.getProductName());
        assertEquals("kake", highestMarginProduct.getCategory());
        assertEquals("http://ananaskake.org", highestMarginProduct.getImageLink());
        assertEquals(new Double("5.0"), highestMarginProduct.getUnitPrice());
        assertEquals(new Double("1.0"), highestMarginProduct.getUnitCost());
        assertEquals(new BigInteger("3"), highestMarginProduct.getNumberSold());

    }

    @Test
    public void product_information_of_the_product_with_lowest_contribution_to_the_margin() {

        when (productRepository.findAll()).thenReturn(productList);

        FinancialReport report = reportService.generateReport();

        Product lowestMarginProduct = report.getLowestMarginProduct();

        assertEquals("eplekake", lowestMarginProduct.getProductName());
        assertEquals("kake", lowestMarginProduct.getCategory());
        assertEquals("http://eplekake.org", lowestMarginProduct.getImageLink());
        assertEquals(new Double("3.0"), lowestMarginProduct.getUnitPrice());
        assertEquals(new Double("2.0"), lowestMarginProduct.getUnitCost());
        assertEquals(new BigInteger("1"), lowestMarginProduct.getNumberSold());


    }

    @Test
    public void product_information_of_the_product_with_lowest_contribution_to_the_margin_alg2() {

        when (productRepository.findAll()).thenReturn(productList);

        FinancialReport report = reportService.generateReport();

        Product lowestMarginProduct = report.getLowestMarginProduct();

        assertEquals("eplekake", lowestMarginProduct.getProductName());
        assertEquals("kake", lowestMarginProduct.getCategory());
        assertEquals("http://eplekake.org", lowestMarginProduct.getImageLink());
        assertEquals(new Double("3.0"), lowestMarginProduct.getUnitPrice());
        assertEquals(new Double("2.0"), lowestMarginProduct.getUnitCost());
        assertEquals(new BigInteger("1"), lowestMarginProduct.getNumberSold());


    }

    @Test
    public void timestamp_of_when_the_report_was_generated() {


    }

    private List<Product> createProductList() {
        List<Product> productList = new ArrayList<>();

        Product p1 = new Product();
        p1.setId(1L);
        p1.setProductName("eplekake");
        p1.setCategory("kake");
        p1.setImageLink("http://eplekake.org");
        p1.setUnitPrice(3.0);
        p1.setUnitCost(2.0);
        p1.setNumberSold(new BigInteger("1"));
        productList.add(p1);

        Product p2 = new Product();
        p2.setId(2L);
        p2.setProductName("banankake");
        p2.setCategory("kake");
        p2.setImageLink("http://banankake.org");
        p2.setUnitPrice(4.0);
        p2.setUnitCost(1.0);
        p2.setNumberSold(new BigInteger("2"));
        productList.add(p2);

        Product p3 = new Product();
        p3.setId(3L);
        p3.setProductName("ananaskake");
        p3.setCategory("kake");
        p3.setImageLink("http://ananaskake.org");
        p3.setUnitPrice(5.0);
        p3.setUnitCost(1.0);
        p3.setNumberSold(new BigInteger("3"));
        productList.add(p3);

        return productList;
    }
}
