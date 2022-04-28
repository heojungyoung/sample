package com.sample.sample.util;

public enum example {

    SK("에스케이"),
    LG("엘쥐"),
    KT("케이티"),
    SAMSUNG("삼성"),
    APPLE("애플");
    private final String value;

    example(String value){
        this.value = value;
    }

    public String getValue(){
        return value;
    }

}
