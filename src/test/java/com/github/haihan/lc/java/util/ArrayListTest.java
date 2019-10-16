package com.github.haihan.lc.java.util;

import org.junit.jupiter.api.Test;

import java.util.List;

class ArrayListTest {

    @Test
    public void test() {
        List<String> list = new ArrayList<>(2);
        list.add("a");
        list.add("b");
        list.add("c");
        list.add("d");
        list.add("e");
        List<String> strings = list.subList(1, 4);
        strings.forEach(System.out::println);

    }

}