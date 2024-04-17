package com.ohgiraffers.requestmapping.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/*
    DispatcherServlet은 웹 요청을 받는 즉시 @Controller로 등록된 컨트롤러 클래스에 처리를 위임한다.
    그 과정은 컨트롤러 클래스의 핸들러 메소드에 선언된 다양한 @RequestMapping 설정에 따른다.
 */
@Controller
public class MethodMappingTestController {

    /*  1. 메소드 방식 미지정  */
    @RequestMapping("/menu/regist")         // GET/POST 방식 상관없이 요청하는 어노테이션 @RequestMapping
    public String registMenu(Model model) { // Model Object는 값 자체를 담는 객체, View Object는 경로를 담는 객체

        /* Model 객체에 addAttribute 메소드를 이용해 key,value 값을 등록해 사용할 수 있다. */
        model.addAttribute("message","신규 메뉴 등록용 핸들러 메소드 호출함...");

        return "mappingResult";     // model객체에 담긴 값을 사용할 HTML 파일명과 동일하게 선언한다.
    }
    
    /*
        2. 메소드 방식 지정
        요청 URL을 value 속성에, 요청 method 방식을 method 속성에 설정
     */
    @RequestMapping(value="/menu/modify", method = RequestMethod.GET)
    public String modifyMenu(Model model) {
        model.addAttribute("message","GET 방식의 메뉴 수정용 핸들러 메소드 호출함...");
        return "mappingResult";
    }
    /*
        3. 요청 메소드 전용 어노테이션
        요청 메소드          어노테이션
        POST                @PostMapping
        GET                 @GetMapping
        PUT                 @PutMapping
        DELETE              @DeleteMapping
        PATCH               @PatchMapping
        이 어노테이션들은 @RequestMapping 어노테이션 method 속성을 사용하여 요청 방법을 지정하는 것과 같다.
        각 어노테이션은 해당하는 요청 메소드에 대해서만 처리할 수 있도록 제한하는 역할을 한다.
     */

//    @RequestMapping(value="/menu/modify", method = RequestMethod.POST)
//    public String modifyMenu(Model model) {
//        model.addAttribute("message","GET 방식의 메뉴 수정용 핸들러 메소드 호출함...");
//        return "mappingResult";
//    }

    @GetMapping("/menu/delete")
    public String getDeleteMenu(Model model){
        model.addAttribute("message","GET 방식의 삭제용 핸들러 메소드 호출함");
        return "mappingResult";
    }

    @PostMapping("/menu/delete")
    public String postDeleteMenu(Model model){
        model.addAttribute("message","POST 방식의 삭제용 핸들러 메소드 호출함");
        return "mappingResult";
    }

}
