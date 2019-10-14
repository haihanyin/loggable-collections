package com.github.haihan.lc.java.util;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ArrayListTest {

    @Test
    public void test() {
        List<String> list = new ArrayList<>(2);
        list.add("a");
        list.add("b");
        list.add("c");
        System.out.println(list.size());
    }

}