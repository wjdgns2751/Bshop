package com.devjh.Bshop.domain.user.entity.dto;



public record SignUpDTO(String username, String password, String email, String firstname, String lastname,
                        String city, String street, Integer number, String zipcode, String lat, String lng,
                        String phone, String role) {


}
