package com.ohgiraffers.jwtsecurity.auth.model.service;


import com.ohgiraffers.jwtsecurity.auth.model.DetailsUser;
import com.ohgiraffers.jwtsecurity.user.dto.LoginUserDTO;
import com.ohgiraffers.jwtsecurity.user.sevice.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationServiceException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.Optional;

@Service
public class DetailsService implements UserDetailsService {

    @Autowired
    private final UserService userService;

    public DetailsService(UserService userService) {
        this.userService = userService;
    }

    /* 로그인 요청 시 사용자의 id를 받아 DB에서 사용자 정보를 가져오는 메소드 */
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        LoginUserDTO login = userService.findByUsername(username);

        if(Objects.isNull(login)) {
            throw new UsernameNotFoundException("해당하는 회원 정보가 없습니다.");
        }

        return new DetailsUser(login);
    }
}
