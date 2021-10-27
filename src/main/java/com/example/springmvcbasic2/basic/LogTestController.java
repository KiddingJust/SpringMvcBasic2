package com.example.springmvcbasic2.basic;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class LogTestController {
    
//    private final Logger log = LoggerFactory.getLogger(getClass());

    @RequestMapping("/log-test")
    public String logTest(){
        String name = "Spring";

        System.out.println("name = " + name);

        //level 별 로그 출력
        //모든 로그 보고싶을 경우 application.properties에서 로그 레벨 설정
        log.trace("trace log={}", name);
        log.debug("debug log={}", name);
        log.info(" info log={}", name);
        log.warn(" warn log={}", name);
        log.error("error log={}", name);
        //이런 형태도 가능은 함. 그런데 권장 X
        //자바 언어는 특성상 + 연산이 먼저 일어나서 가지고 있음
        //즉 메모리와 CPU를 쓰게 됨. 출력 안하는데 연산이 일어나는 게 문제
        log.info(" info log=" + name);

        return "ok";
    }
}
