package com.ohgiraffers.thymeleaf.controller;

import com.ohgiraffers.thymeleaf.model.dto.MemberDTO;
import com.ohgiraffers.thymeleaf.model.dto.SelectCriteria;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("lecture")  // 공통된 상위 경로 지정
public class LectureController {

    @GetMapping("expression") // root 매핑
    public ModelAndView expression(ModelAndView mv) {

        mv.addObject("member",new MemberDTO("홍길동",20,'남',"서울시 서초구"));
        mv.addObject("hello","hello!<h3>Thymeleaf</h3>");

        mv.setViewName("/lecture/expression");
        System.out.println(mv);

        return mv;
    }

    @GetMapping("conditional")      // Handler Mapping
    public ModelAndView conditional(ModelAndView mv) {

        mv.addObject("num",1);
        mv.addObject("str","바나나");

        List<MemberDTO> memberList = new ArrayList<>();
        memberList.add(new MemberDTO("홍길동1",20,'남',"서울시 서초구"));
        memberList.add(new MemberDTO("홍길동2",21,'남',"서울시 강서구"));
        memberList.add(new MemberDTO("홍길동3",22,'남',"서울시 종로구"));
        memberList.add(new MemberDTO("홍길동4",23,'남',"서울시 마포구"));

        mv.addObject("memberList",memberList);
        System.out.println(mv);

//        mv.setViewName("/lecture/conditional");   // @GetMapping으로 생략가능

        return mv;
    }

    @GetMapping("etc")
    public ModelAndView etc(ModelAndView mv) {

        SelectCriteria criteria = new SelectCriteria(1,10,3);

        mv.addObject(criteria);
        System.out.println(mv);

        return mv;
    }
}