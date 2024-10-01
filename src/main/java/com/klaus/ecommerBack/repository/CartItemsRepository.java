package com.klaus.ecommerBack.repository;

import com.klaus.ecommerBack.entity.CartItems;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

//los rerpositorios simpre estan de la mano con los dto
//lUEGO NOS DIRIGIMOS A SERVICES A CREAR UNA INTERFACE SERVICO PARA EL CARRITO
@Repository
public interface CartItemsRepository extends JpaRepository<CartItems,Long> {

    Optional<CartItems>findByProductIdAndOrderIdAndUserId(Long productId,Long orderId, Long userId);
}
