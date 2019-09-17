package com.chiyi.foundation;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;
import java.util.Optional;

/**
 * @author chiyi
 * @date 2019/7/8.
 */
public class OptionalTest {
    public static void main(String[] args) {
        Optional<String> optional1 = Optional.of("javaone");
        if(optional1.isPresent()){
            String value = optional1.get();
        }
        optional1.ifPresent(s-> System.out.println(s.length()));

        String nullName = null;
        String name = Optional.ofNullable(nullName).orElse("defaultName");
        System.out.println(name);
        String name1 = Optional.ofNullable(nullName).orElseGet(()->"john");

        OptionalTest optionalTest  =new OptionalTest();
        optionalTest.testElseGet();


    }

    public void testElseGet(){
        String text = "123";
        String defaultText = Optional.ofNullable(text).orElseGet(this::getDefaultValue);
        System.out.println("--------------");
        defaultText = Optional.ofNullable(text).orElse(getDefaultValue());
    }

    public String getDefaultValue() {
        System.out.println("Getting Default Value");
        return "Default Value";
    }
}
