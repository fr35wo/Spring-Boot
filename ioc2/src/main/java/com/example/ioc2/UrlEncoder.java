package com.example.ioc2;

import org.springframework.stereotype.Component;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

@Component//스프링이 실행될때 찾아서 직접 객체를 싱글톤 형태로 만들어 스프링 컨테이너에서 관리
public class UrlEncoder implements IEncoder {

    public String encode(String message){
        try {
            return URLEncoder.encode(message, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return null;
        }
    }
}