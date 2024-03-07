package com.devjh.Bshop.common;

import lombok.Getter;
import org.springframework.context.annotation.Configuration;

@Getter
@Configuration

public class RegexConfig {
    public static final String EMAIL_REGEX = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";
    public static final String PHONE_REGEX = "^01(?:0|1|[6-9])-(?:\\d{3}|\\d{4})-\\d{4}$";
    public static final String PASSWORD_REGEX = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[!@#$%^&*()-_+=]).{8,}$";
    public static final String USERNAME_REGEX = "^[a-zA-Z0-9_]{3,20}$";
}

