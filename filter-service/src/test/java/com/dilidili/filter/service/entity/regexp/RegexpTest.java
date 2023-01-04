package com.dilidili.filter.service.entity.regexp;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class RegexpTest {

    @Test
    void findAllMatch() {
        String regexp = "习近平";

        String text = "习近平主席习近平领导习近平";

        Regexp regexp1 = new Regexp(regexp);
        List<int[]> matches = regexp1.findAllMatch(text);

        int[] a = matches.get(0);
        System.out.println(a);
        int[] b = matches.get(1);
        System.out.println(b);
        int[] c = matches.get(2);
        System.out.println(c);
    }
}