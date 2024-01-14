package com.company.ioc;

import java.util.Base64;

//DI란 외부에서 내가 사용하는 객체 주입
public class Encoder {

    private IEncoder iEncoder;

    public Encoder(IEncoder iEncoder){
        this.iEncoder = iEncoder;
    }

    public String encode(String message){
        return iEncoder.encode(message);
    }
}
