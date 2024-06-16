package hello.springmvc.basic;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class LogTestController {

//    private final Logger log = LoggerFactory.getLogger(getClass()); // @Slf4j 애노테이션으로 생략가능

    @RequestMapping("/log-test")
    public String logTest() {
        String name = "Spring";

        // sout 는 다나온다. 좋지 않다.
        System.out.println("name = " + name);

        // 사용하지도 않은데 문자 연산이 일어난다.
        log.trace(" trace my log = " + name);  // 이렇게 사용하면 안된다.  application.properties 에서 기본 설정을 debug 로 했기에 출력 안된다.

        log.trace("trace log={}", name); //  그냥 메서드 호출 위와 다르다.

        // 현재 로그의 상태를 지정할 수 있다.
        // 아래로 갈수혹 더 작은 개념 (포함하고 있다.)
        // 로그는 파일로 남길 수 있다.
        log.trace("trace log={}", name);
        log.debug("debug log={}", name);
        log.info(" info log={}", name);
        log.warn(" warn log={}", name);
        log.error(" error log={}", name);

        return "ok"; //Http body 에 바로 넣어버림
    }
}
