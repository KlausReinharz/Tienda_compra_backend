package com.klaus.ecommerBack.dto;

import lombok.Data;

//Luego creamos el respositorio CartItemsRepository

@Data
public class AddProductInCartDto {
    private Long userId;
    private Long productId;
}
