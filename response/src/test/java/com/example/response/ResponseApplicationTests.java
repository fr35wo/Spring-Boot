package com.example.response;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ResponseApplicationTests {

    @Test
    void contextLoads() throws JsonProcessingException {
        System.out.println("----------");

        var objectMapper = new ObjectMapper();

        //object -> text
        //objectmapper가 getter를 활용한다.
        //내가 작성한 클래스에서 objectmapper가 활용된다면 메소드 이름에 getDefaultUser처럼 get을 붙혀주면 안된다.
        var user = new User("steve", 10);
        var text = objectMapper.writeValueAsString(user);
        System.out.println(text);

        //text -> object
        //object mapper는 default 생성자를 필요로 한다.
        var objectUser = objectMapper.readValue(text, User.class);
        System.out.println(objectUser);

    }

}
