package com.klaus.ecommerBack.services.customer.cart;

import com.klaus.ecommerBack.dto.AddProductInCartDto;
import com.klaus.ecommerBack.dto.OrderDto;
import org.springframework.http.ResponseEntity;

public interface CartService {
    ResponseEntity<?> addProductToCart(AddProductInCartDto addProductInCartDto);
    OrderDto getCartByUserId(Long userId);
}
