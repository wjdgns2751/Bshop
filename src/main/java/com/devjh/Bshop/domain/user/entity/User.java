package com.devjh.Bshop.domain.user.entity;

import com.devjh.Bshop.common.entity.BaseEntity;
import jakarta.persistence.*;
import jakarta.validation.constraints.Pattern;
import lombok.*;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor()
@Builder
@Getter
public class User extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true)
    private Long id;
    @Column(unique = true)
    private String email;
    @Column(unique = true)
    private String username;
    private String password;
    private String firstname;
    private String lastname;
    @Column(unique = true)
    private String phone;
    private String role;
}
