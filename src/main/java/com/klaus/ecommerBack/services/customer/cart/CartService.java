package com.klaus.ecommerBack.services.customer.cart;

import com.klaus.ecommerBack.dto.AddProductInCartDto;
import org.springframework.http.ResponseEntity;

public interface CartService {
    ResponseEntity<?> addProductToCart(AddProductInCartDto addProductInCartDto);
}
