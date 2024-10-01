package com.klaus.ecommerBack.repository;

import com.klaus.ecommerBack.entity.Order;
import com.klaus.ecommerBack.enums.OrderStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {

    Order findByUserIdAndOrderStatus(Long userId, OrderStatus orderStatus);
}
