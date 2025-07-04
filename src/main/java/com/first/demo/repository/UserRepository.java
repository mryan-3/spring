package com.first.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.first.demo.model.UserModel;

public interface UserRepository extends JpaRepository<UserModel, Long> {
    // This interface will automatically provide CRUD operations for UserModel
    // No additional methods are needed unless custom queries are required

    
}