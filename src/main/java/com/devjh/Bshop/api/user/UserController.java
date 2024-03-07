package com.devjh.Bshop.api.user;

import com.devjh.Bshop.common.RegexConfig;
import com.devjh.Bshop.domain.user.entity.dto.SignUpDTO;
import com.devjh.Bshop.domain.user.service.UserService;
import lombok.RequiredArgsConstructor;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
@Slf4j
public class UserController {
    private final UserService userService;

    @PostMapping("/signUp")
    public ResponseEntity<String> signUp(@RequestBody @Validated SignUpDTO sign, BindingResult bindingResult){

        if(bindingResult.hasErrors()){
            log.info("error : {}",bindingResult);
            List<ObjectError> error  = bindingResult.getAllErrors();
        }
        log.info("sign: {}",sign.toString());
        userService.signUp(sign);

        return ResponseEntity.ok(sign.lastname() + sign.firstname() +" 님 회원가입이 완료되었습니다.");
    }

    @PostMapping("/checkEmail")
    public ResponseEntity<String> checkEmailDuplication (@RequestParam(name = "email") String email) {
        log.info("입력 받은 이메일 : {}", email);

        if(!email.matches(RegexConfig.EMAIL_REGEX)){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("유효하지 않은 이메일 주소 입니다.");
        }
        if(!userService.checkEmailDuplication(email))
            return ResponseEntity.ok("사용 가능한 이메일 입니다.");

        return ResponseEntity.status(HttpStatus.CONFLICT).body("중복된 이메일 입니다.");

    }

    @PostMapping("/checkUsername")
    public ResponseEntity<String> checkUsernameDuplication (@RequestParam(name = "username") String username) {
        log.info("입력 받은 유저 명 : {}", username);
        if(!username.matches(RegexConfig.USERNAME_REGEX)){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("사용자 명은 3 ~ 20 사이의 문자로 작성 해야 합니다. ");
        }
        if(!userService.checkUsernameDuplication(username))
            return ResponseEntity.ok("사용 가능한 유저명 입니다.");

        return ResponseEntity.status(HttpStatus.CONFLICT).body("중복된 유저명 입니다.");

    }

    @PostMapping("/checkPhone")
    public ResponseEntity<String> checkPhoneDuplication (@RequestParam(name = "phone") String phone) {
        log.info("입력 받은 핸드폰 번호 : {}", phone);
        if(!phone.matches(RegexConfig.PHONE_REGEX)){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("유효하지 않은 핸드폰 번호입니다. 다음과 같이 작성 해주세요. ex 010-1324-4567 ");
        }
        if(!userService.checkPhoneDuplication(phone))
            return ResponseEntity.ok("사용 가능한 핸드폰 번호 입니다.");

        return ResponseEntity.status(HttpStatus.CONFLICT).body("사용 중인 핸드폰 번호 입니다.");

    }

}
