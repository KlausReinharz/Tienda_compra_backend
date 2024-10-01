package com.klaus.ecommerBack.services.customer;


import com.klaus.ecommerBack.dto.ProductDto;

import java.util.List;

public interface CustomerProductService {

    List<ProductDto> getAllProducts();
    List<ProductDto> searchProductByTitle(String name);

}
