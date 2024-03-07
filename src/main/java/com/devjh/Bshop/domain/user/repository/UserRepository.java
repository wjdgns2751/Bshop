package com.devjh.Bshop.domain.user.repository;

import com.devjh.Bshop.domain.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {
     Boolean existsByUsername(String username);
     Boolean existsByPhone(String email);
     Boolean existsByEmail(String phone);

     User findByUsername(String username);


}
