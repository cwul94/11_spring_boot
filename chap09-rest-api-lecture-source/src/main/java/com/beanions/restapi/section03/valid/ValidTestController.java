package com.beanions.restapi.section03.valid;

import com.beanions.restapi.section02.response.ResponseMessage;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.nio.charset.StandardCharsets;
import java.util.*;
import java.util.stream.Collectors;

@Tag(name="유효성 검사")
@RestController
@RequestMapping("/valid")
public class ValidTestController {

    private List<UserDTO> users;

    public ValidTestController(){
        users = new ArrayList<>();

        users.add(new UserDTO(1,"user01","pass01","코알라",new Date()));
        users.add(new UserDTO(2,"user02","pass02","기린",new Date()));
        users.add(new UserDTO(3,"user03","pass03","고릴라",new Date()));
    }

    @GetMapping("/users")
    public ResponseEntity<ResponseMessage> findAllUsers() {
        /* 응답  헤더 설정 */
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(new MediaType("application", "json", StandardCharsets.UTF_8));

        /* 응답 데이터 설정 */
        Map<String, Object> responseMap = new HashMap<>();
        responseMap.put("users", users);

        ResponseMessage responseMessage = new ResponseMessage(200, "조회 성공!", responseMap);
        return new ResponseEntity<>(responseMessage,headers, HttpStatus.OK);
    }

    @GetMapping("/users/{userNo}")
    public ResponseEntity<ResponseMessage> findUserByNo(@PathVariable int userNo) throws UserNotFoundException{
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(new MediaType("application", "json", StandardCharsets.UTF_8));

        List<UserDTO> foundUserList = users.stream().filter(user->user.getNo() == userNo)
                .collect(Collectors.toList());


        UserDTO foundUser = null;
        if(foundUserList.size() > 0) {
            foundUser = foundUserList.get(0);
        } else {
            throw new UserNotFoundException("회원정보 ㄴㄴ");
        }

        Map<String, Object> responseMap = new HashMap<>();
        responseMap.put("user",foundUser);

        return ResponseEntity
                .ok()
                .headers(headers)
                .body(new ResponseMessage(200,"조회 성공!", responseMap));
    }

    @PostMapping("/users")
    public ResponseEntity<?> registUser(@Valid @RequestBody UserDTO newUser){

        return ResponseEntity.created(URI.create("/valid/users/"+"userNo")).build();
    }
}
