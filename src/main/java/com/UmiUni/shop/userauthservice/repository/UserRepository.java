package com.UmiUni.shop.userauthservice.repository;

import com.UmiUni.shop.userauthservice.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
