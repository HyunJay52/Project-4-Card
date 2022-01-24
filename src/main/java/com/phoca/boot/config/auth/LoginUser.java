package com.phoca.boot.config.auth;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.PARAMETER) //어노테이션 생성위치 지정 > parameter 지정해서 메소드의 파라미터로 선언된 객체에만 사용가능
@Retention(RetentionPolicy.RUNTIME)
public @interface LoginUser {
        //어노테이션 클레스로 지정함
}
