package com.boot;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.*;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.boot.controllers.ProductController;
import com.boot.models.Product;
import com.boot.service.ProductService;
public class ProductControllerTest {
	@Mock
	private ProductService productService;
	
	@InjectMocks
	private ProductController productController;
	
	@Before
	public void init() {
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
    public void testGetProduct()
    {
        Product product = new Product();
        product.setId("4455");
        when(productService.get("4455")).thenReturn(product);
        
        Product prod = productController.get("4455");
        verify(productService).get("4455");
        assertEquals("4455", prod.getId());
    }
	
	@Test
    public void testGetAllProducts()
    {
		List<Product> prods = new ArrayList<Product>();
        Product product = new Product();
        product.setId("4455");
        product.setTechnologyCategory("tc");
        product.setTechnologyType("ty");
        prods.add(product);
        when(productService.getAll()).thenReturn(prods);
        
        List<Product> products = productController.getAll();
        assertEquals("4455", products.get(0).getId());
    }
}
