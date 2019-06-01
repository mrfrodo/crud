package no.frode.cruddemo.service;

import no.frode.cruddemo.dto.ProductDTO;
import no.frode.cruddemo.entity.Product;
import no.frode.cruddemo.exception.ProductNotFoundException;
import no.frode.cruddemo.repository.ProductRepository;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.stubbing.Answer;
import org.modelmapper.ModelMapper;
import java.math.BigInteger;
import java.util.*;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;

public class ProductServiceTest {

    public ModelMapper mm = new ModelMapper();

    @InjectMocks
    ProductService productService;

    @Mock
    ProductRepository productRepository;

    @Mock
    ModelMapper modelMapper;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void getAllProducts() {

        Set<String> uniqueNames = new HashSet<>(Arrays.asList("Larry", "Steve", "James"));
        List<Product> productList = new ArrayList<>();
        uniqueNames.forEach(name ->
        {
            Product p = new Product();
            p.setProductName(name);
            productList.add(p);
        });

        when(productRepository.findAll()).thenReturn(productList);

        List<Product> productList1 = productService.getAllProducts();

        verify(productRepository).findAll();

        assertEquals(3, productList1.size());
    }

    @Test
    public void getProduct() {
        Product p = new Product();
        p.setId(1L);
        Optional<Product> op = Optional.of(p);

        when(productRepository.findById(anyLong())).thenReturn(op);

        Product product = productService.getProduct(1l);

        assertEquals(p,product);
    }

    @Test
    public void createProduct() {
        ProductDTO pDto = new ProductDTO();
        pDto.setId(1L);

        Product p = mm.map(pDto, Product.class);
        when(modelMapper.map(pDto,Product.class)).thenReturn(p);
        when(productRepository.save(p)).thenReturn(p);

        Product product = productService.createProduct(pDto);

        assertEquals(1L, product.getId().longValue());
    }

    @Test
    public void createProduct2() {
        ProductDTO pDto = createProductDto();
        pDto.setId(1L);

        Product p = mm.map(pDto, Product.class);
        when(modelMapper.map(pDto,Product.class)).thenReturn(p);
        when(productRepository.save(p)).thenReturn(p);

        Product product = productService.createProduct(pDto);

        assertEquals(1L, product.getId().longValue());
        assertEquals("banankake", product.getProductName());
        assertEquals("kake", product.getCategory());
        assertEquals(new Double(500), product.getUnitPrice());
        assertEquals(new Double(100), product.getUnitCost());
        assertEquals(new BigInteger("6"), product.getNumberSold());
    }

    @Test
    public void updateProduct() {

        List<Product> productList = createProductList();

        ProductDTO endretProduktDto = createProductDto();

        Product endretProdukt = mm.map(endretProduktDto, Product.class);

        Optional<Product> originaleProdukt = Optional.of(productList.get(0));

        when(productRepository.findById(1L)).thenReturn(originaleProdukt);
        when(productRepository.save(endretProdukt)).thenReturn(endretProdukt);
        when(modelMapper.map(endretProduktDto, Product.class)).thenReturn(endretProdukt);

        Product p = productService.updateProduct(1L, endretProduktDto);

        assertEquals("banankake", p.getProductName());
        assertEquals("kake", p.getCategory());
        assertEquals("http://banankake.org", p.getImageLink());
        assertEquals(new Double("100.0"), p.getUnitCost());
        assertEquals(new Double("500.0"), p.getUnitPrice());
        assertEquals(new BigInteger("6"), p.getNumberSold());
    }

    @Test
    public void updateProductWithDoAnswer() {

        ProductDTO endretProduktDto = createProductDto();

        List<Product> productList = createProductList();
        Optional<Product> originaleProdukt = Optional.of(productList.get(0));
        when(productRepository.findById(1L)).thenReturn(originaleProdukt);

        Product endretProdukt = mm.map(endretProduktDto, Product.class);
        when(modelMapper.map(endretProduktDto, Product.class)).thenReturn(endretProdukt);

        doAnswer((Answer<Object>) invocation -> {
            Product product = (Product) invocation.getArguments()[0];

            assertNotNull(product);
            Long id = product.getId();
            String name = product.getProductName();
            String url = product.getImageLink();
            String category = product.getCategory();
            Double cost = product.getUnitCost();
            Double price = product.getUnitPrice();
            BigInteger sold = product.getNumberSold();

            assertEquals(new Long(1L), id);
            assertEquals("banankake", name);
            assertEquals("kake", category);
            assertEquals("http://banankake.org", url);
            assertEquals(new Double("100.0"), cost);
            assertEquals(new Double("500.0"), price);
            assertEquals(new BigInteger("6"), sold);

            return null;
        }).when(productRepository).save(any());

        Product p = productService.updateProduct(1L, endretProduktDto);

    }

    @Test(expected = ProductNotFoundException.class)
    public void updateProductWithException() {

        ProductDTO endretProduktDto = createProductDto();

        when(productRepository.findById(4L)).thenReturn(Optional.empty());

        Product p = productService.updateProduct(4L, endretProduktDto);

    }

    @Test
    public void deleteProduct() {
        Product p = new Product();
        p.setId(1L);
        Optional<Product> op = Optional.of(p);
        when(productRepository.findById(anyLong())).thenReturn(op);

        Product product = productService.deleteProduct(1l);
        verify(productRepository).delete(p);

        assertEquals(p,product);
    }


    @Test(expected = ProductNotFoundException.class)
    public void deleteProductWithException() {
        Optional<Product> op = Optional.empty();

        when(productRepository.findById(anyLong())).thenReturn(op);

        Product product = productService.deleteProduct(10l);

        verify(productRepository).findById(10l);
        fail("Didn't throw not found exception");
    }

    @Test
    public void convertToDTO() {
        Product product = new Product();
        product.setCategory("Hardware");
        product.setProductName("Seagate Baracuda 500GB");
        product.setNumberSold(BigInteger.valueOf(200));
        product.setUnitPrice(55.50);

        when(modelMapper.map(product, ProductDTO.class)).thenReturn(mm.map(product,ProductDTO.class));
        ProductDTO productDTO = productService.convertToDTO(product);
    }

    @Test
    public void convertToEntity() {

        ProductDTO productDTO = new ProductDTO();
        productDTO.setCategory("Hardware");
        productDTO.setProductName("Seagate Baracuda 500GB");
        productDTO.setNumbersold(BigInteger.valueOf(200));
        productDTO.setPrice(55.50);

        when(modelMapper.map(productDTO,Product.class)).thenReturn(mm.map(productDTO,Product.class));
        Product product = productService.convertToEntity(productDTO);

        assertEquals(product.getProductName(),productDTO.getProductName());
        assertEquals(product.getNumberSold(),productDTO.getNumberSold());
        assertEquals(product.getCategory(),productDTO.getCategory());

    }

    private ProductDTO createProductDto() {
        ProductDTO productDTO = new ProductDTO();
        productDTO.setProductName("banankake");
        productDTO.setCategory("kake");
        productDTO.setImageLink("http://banankake.org");
        productDTO.setPrice(500.0);
        productDTO.setUnitCost(100.0);
        productDTO.setNumbersold(new BigInteger("6"));

        return productDTO;
    }

    private List<Product> createProductList() {
        List<Product> productList = new ArrayList<>();

        Product p1 = new Product();
        p1.setId(1L);
        p1.setProductName("eplekake");
        p1.setCategory("kake");
        p1.setImageLink("http://eplekake.org");
        p1.setUnitPrice(100.9);
        p1.setUnitCost(66.1);
        p1.setNumberSold(new BigInteger("99"));
        productList.add(p1);

        Product p2 = new Product();
        p2.setId(2L);
        p2.setProductName("banankake");
        p2.setCategory("kake");
        p2.setImageLink("http://banankake.org");
        p2.setUnitPrice(10.9);
        p2.setUnitCost(6.1);
        p2.setNumberSold(new BigInteger("9"));
        productList.add(p2);

        Product p3 = new Product();
        p3.setId(3L);
        p3.setProductName("ananaskake");
        p3.setCategory("kake");
        p3.setImageLink("http://ananaskake.org");
        p3.setUnitPrice(200.9);
        p3.setUnitCost(6.1);
        p3.setNumberSold(new BigInteger("39"));
        productList.add(p3);

        return productList;
    }
}