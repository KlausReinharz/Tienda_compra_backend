package com.klaus.ecommerBack.controller.admin;

import com.klaus.ecommerBack.dto.ProductDto;
import com.klaus.ecommerBack.services.admin.product.AdminProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("api/admin")
@RequiredArgsConstructor
public class AdminProductController {

    //creamos el objecto para el servicio producto administrador que es la interfac
    private  final AdminProductService adminProductService;

    //mencionar el atributo de tarifa
    @PostMapping("/product")
    public ResponseEntity<ProductDto> addProduct(@ModelAttribute ProductDto productDto) throws IOException {
        ProductDto productDto1 = adminProductService.addProduct(productDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(productDto1);

    }
    //este va estar relacionado con el front
    //con el servicio getAllProducto con el componete dashboard admin
    @GetMapping("/products")
    public ResponseEntity<List<ProductDto>>getAllProducts(){
        List<ProductDto> productDtos=adminProductService.getAllProducts();
        return ResponseEntity.ok(productDtos);
    }

    @GetMapping("/search/{name}")
    public ResponseEntity<List<ProductDto>>getAllProductByName(@PathVariable String name){
        List<ProductDto> productDtos=adminProductService.getAllProductByName(name);
        return ResponseEntity.ok(productDtos);
    }


    @DeleteMapping("/product/{productId}")
    public ResponseEntity<Void> deleteProduct(@PathVariable Long productId){
        boolean deleted = adminProductService.deleteProduct(productId);
        if(deleted){
            return  ResponseEntity.noContent().build();
        }
        return  ResponseEntity.notFound().build();

    }


}
