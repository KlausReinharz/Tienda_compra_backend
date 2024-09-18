package com.klaus.ecommerBack.dto;

import com.klaus.ecommerBack.enums.UserRole;
import lombok.Data;

@Data
public class UserDto {
    private Long id;
    private String email;
    private String name;
    private UserRole userRole;

}
