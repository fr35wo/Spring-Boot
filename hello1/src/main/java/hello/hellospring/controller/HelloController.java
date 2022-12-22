package hello.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

//템플릿 엔진 동작
@Controller
public class HelloController {
    //1 웹브라우저 에서 내장 톰캣 서버로 보냄 내장 톰캣 서버에서 URL받고
    @GetMapping("hello")
    public String hello(Model model) {
        model.addAttribute("data", "hello!!");
        return "hello";
        //2 모델 애트리뷰터 가지고 hello.html 실행 , 템플릿 엔진 동작
        }
    //컨트롤러에서 리턴 값으로 문자를 반환하면 뷰 리졸버( viewResolver )가 화면을 찾아서 처리한다.
    //스프링 부트 템플릿엔진 기본 viewName 매핑
    //resources:templates/ +{ViewName}+ .html

    @GetMapping("hello-mvc")
    public String helloMvc(@RequestParam("name") String name, Model model) {
        model.addAttribute("name", name);
        return "hello-template";
    }

    @GetMapping("hello-string")
    @ResponseBody //뷰가 필요없이 queryparameter에 담은 걸 그대로 보냄
    public String helloString(@RequestParam("name") String name) {
        return "hello " + name;
    }

    //@ResponseBody 를 사용하고, 객체를 반환하면 객체가 JSON으로 변환됨 api방식(객체 반환)
    //json은 key, value로 이루어진 구조

    //@ResponseBody 를 사용
    //HTTP의 BODY에 문자 내용을 직접 반환
    //viewResolver 대신에 HttpMessageConverter 가 동작
    //기본 문자처리: StringHttpMessageConverter
    //기본 객체처리: MappingJackson2HttpMessageConverter
    //byte 처리 등등 기타 여러 HttpMessageConverter가 기본으로 등록되어 있음
   @GetMapping("hello-api")
    @ResponseBody
    public Hello helloApi(@RequestParam("name") String name) {
        Hello hello = new Hello();
        hello.setName(name);
        return hello;
    }
    static class Hello {
        private String name;
        public String getName() {
            return name;
        }
        public void setName(String name) {
            this.name = name;
        }
    }
}

