package com.klaus.ecommerBack.services.customer.cart;

import com.klaus.ecommerBack.dto.AddProductInCartDto;
import com.klaus.ecommerBack.entity.CartItems;
import com.klaus.ecommerBack.entity.Order;
import com.klaus.ecommerBack.entity.Product;
import com.klaus.ecommerBack.entity.User;
import com.klaus.ecommerBack.enums.OrderStatus;
import com.klaus.ecommerBack.repository.CartItemsRepository;
import com.klaus.ecommerBack.repository.OrderRepository;
import com.klaus.ecommerBack.repository.ProductRepository;
import com.klaus.ecommerBack.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CartServiceImpl implements CartService{

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private CartItemsRepository cartItemsRepository;

    @Autowired
    private ProductRepository productRepository;

    //hacemos referecencia a la clase DTO
    public ResponseEntity<?> addProductToCart(AddProductInCartDto addProductInCartDto){
        Order activeOrder = orderRepository.findByUserIdAndOrderStatus(addProductInCartDto.getUserId(), OrderStatus.Pending);
        Optional<CartItems>optionalCartItems = cartItemsRepository.findByProductIdAndOrderIdAndUserId(addProductInCartDto.getProductId(),
                activeOrder.getId(), addProductInCartDto.getUserId());

        if(optionalCartItems.isPresent()){
            return ResponseEntity.status(HttpStatus.CONFLICT).body(null);
        }else{
            Optional<Product>optionalProduct = productRepository.findById(addProductInCartDto.getProductId());
            Optional<User>optionalUser = userRepository.findById(addProductInCartDto.getUserId());

            if(optionalProduct.isPresent() && optionalUser.isPresent()){
                CartItems cart = new CartItems();
                cart.setProduct(optionalProduct.get());
                cart.setPrice(optionalProduct.get().getPrice());
                cart.setQuantity(1L);
                cart.setUser(optionalUser.get());
                cart.setOrder(activeOrder);

                CartItems updatedCart = cartItemsRepository.save(cart);

                activeOrder.setTotalAmount(activeOrder.getTotalAmount() + cart.getPrice());
                activeOrder.setAmount(activeOrder.getAmount() + cart.getPrice());
                activeOrder.getCartItems().add(cart);

                orderRepository.save(activeOrder);

                return  ResponseEntity.status(HttpStatus.CREATED).body(cart);
            }else{

                return  ResponseEntity.status(HttpStatus.NOT_FOUND).body("user or product not found");
            }
        }
    }
}
