package com.example.ioc2;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

@Component
public class ApplicationContextProvider implements ApplicationContextAware {
//스프링 컨테이너에 접근하여 객체를 가져오기 위한 코드
    //스프링이 ApplicationContextProvider를 만들때 set메소드에 ApplicationContext주입
    //그걸 받아서 static 변수에 할당당
    private static ApplicationContext context;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        context = applicationContext; //applicationcontext 할당
            }

    public static ApplicationContext getContext(){
        return context;
    }
}
