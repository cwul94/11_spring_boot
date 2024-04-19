package com.ohgiraffers.interceptor;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/*")
public class InterceptorTestController {

    @GetMapping("stopwatch")
    public String handlerMethod() throws InterruptedException {

        System.out.println("핸들러 메소드 호출함...");

        /* 아무것도 하는일이 없으니 수행시간이 0으로 나올 수 있기 때문에 호출 */
        Thread.sleep(1000);

        return "result";
    }

}
