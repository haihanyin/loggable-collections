package com.github.haihan.lc.support;

public aspect LoggingAspect {

    after() : execution(public * com.github.haihan.lc.java.util.ArrayList.*(..)) {
        System.out.printf("after advice");
    }
}
