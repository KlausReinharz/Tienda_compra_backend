package com.klaus.ecommerBack.services.auth;

import com.klaus.ecommerBack.dto.SignupRequest;
import com.klaus.ecommerBack.dto.UserDto;

public interface AuthService {

    UserDto createUser(SignupRequest signupRequest);

    Boolean hasUserWithEmail(String email);
}
