package com.devjh.Bshop.domain.user.service;

import com.devjh.Bshop.domain.user.entity.User;
import com.devjh.Bshop.domain.user.entity.dto.FindIdDTO;
import com.devjh.Bshop.domain.user.entity.dto.SignUpDTO;
import com.devjh.Bshop.domain.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    //회원 가입
    public void signUp(SignUpDTO sign) {
        User user = User.builder().
                email(sign.email()).
                username(sign.username()).
                password(bCryptPasswordEncoder.encode(sign.password())).
                firstname(sign.firstname()).
                lastname(sign.lastname()).
                phone(bCryptPasswordEncoder.encode(sign.phone())).
                role(sign.role()).build();

        userRepository.save(user);
    }

    //아이디 찾기
    public String findId(FindIdDTO findIdDTO){
        String id = "";

        User user = User.builder().
                lastname(findIdDTO.lastname()).
                firstname(findIdDTO.firstname()).
                phone(bCryptPasswordEncoder.encode(findIdDTO.phone())).
                build();

        //select email from user where lastName = g
        return id;
    }
    //비밀번호 변경


    //이메일 중복 확인
    public Boolean checkEmailDuplication(String email){return userRepository.existsByEmail(email);}
    //닉네임 중복 확인
    public Boolean checkUsernameDuplication(String username){return userRepository.existsByUsername(username);}
    //핸드폰 중복 확인
    public Boolean checkPhoneDuplication(String phone){return userRepository.existsByPhone(phone);}
}
