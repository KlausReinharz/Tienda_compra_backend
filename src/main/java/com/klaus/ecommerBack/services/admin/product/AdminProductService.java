package com.klaus.ecommerBack.services.admin.product;

import com.klaus.ecommerBack.dto.ProductDto;

import java.io.IOException;
import java.util.List;

public interface AdminProductService  {

    ProductDto addProduct(ProductDto productDto) throws IOException;
    List<ProductDto> getAllProducts();

    List<ProductDto> getAllProductByName(String name);

    boolean deleteProduct(Long id);
}
