package com.ohgiraffers.requestmapping.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/*
    클래스 레벨에 @RequestMapping 어노테이션 사용이 가능하다.
    클래스 레벨에 URL을 공통 부분을 이용해 설정하고 나면, 매번
    핸들러 메소드에 요청할 URL의 중복되는 경로를 작성하지 않아도 된다.
 */
@Controller
@RequestMapping("/order/*")
public class ClassMappingTestController {

    /* 1. Class레벨 매핑 */
    @GetMapping("/regist")  // URL 끝에 존재하지 않는 / 만 조심하면 된다.
    public String registOrder(Model model) {
        model.addAttribute("message","GET 방식의 주문 등록용 핸들러 메소드 호출함...");
        return "mappingResult";
    }

    /*
        2. 여러 개의 패턴 매핑
        value 속성에 증괄호를 이용해 매핑할 URL을 나열한다.
     */
    @RequestMapping(value={"/modify","/delete"},method = RequestMethod.POST)
    public String modifyAndDeleteMethod(Model model){
        model.addAttribute("message","POST 방식의 주문정보 수정/삭제 공통 처리용 핸들러 메소드 호출함..");
        return "mappingResult";
    }

    /*
        3. path variable
        @Pathvariable 어노테이션을 이용해 요청 path로부터 변수를 받아올 수 있다.
        pathvariable로 전달되는 {변수명} 값은 매개변수명과 동일해야한다.
        만약 동일하지 않으면 @Pathvariable("이름")을 설정해주어야 한다.
        이는 REST형 웹 서비스를 설계할 때 유용하게 사용된다.
     */

    @GetMapping("/detail/{orderNum}")
    public String selectOrderDetail(Model model, @PathVariable("orderNum") int orderNo){
        model.addAttribute("message",orderNo+"번 주문 상세 내용 조회용 핸들러 메소드 호출함..");
        return "mappingResult";
    }

}
