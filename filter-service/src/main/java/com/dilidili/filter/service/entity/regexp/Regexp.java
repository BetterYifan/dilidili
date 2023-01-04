package com.dilidili.filter.service.entity.regexp;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.MatchResult;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Stream;

/**
 * 自定义正则结构体，提供一系列正则匹配的能力
 */
public class Regexp {
    private String regexpStr;

    private Pattern pattern;

    public String GetRegexpStr() {
        return this.regexpStr;
    }

    public Regexp(String regexpStr) {
        this.regexpStr = regexpStr;
        this.pattern = Pattern.compile(regexpStr);
    }


    /**
     * 返回字符串中匹配位置的index
     *
     * @param text
     * @return
     */
    public List<int[]> findAllMatch(String text) {
        List<int[]> match = new ArrayList<>();
        Matcher matcher = this.pattern.matcher(text);
        while (matcher.find()) {
            int start = matcher.start();
            int end = matcher.end();
            int[] position = new int[]{start, end};
            match.add(position);
        }
        return match;
    }
}
