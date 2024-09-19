package com.klaus.ecommerBack.repository;

import com.klaus.ecommerBack.entity.User;
import com.klaus.ecommerBack.enums.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User>findFirstByEmail(String email);

    User findByRole(UserRole userRole);
}
