package com.dilidili.filter.common.translate;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.File;
import java.util.HashMap;
import java.util.Objects;

public class MultiLanguageConfiguration {
    private final static HashMap<Integer, String> errCode = new HashMap<>();


    private void initMultiLanguageConf(String folder) {
        try {
            File dir = new File(folder);
            for (File file : Objects.requireNonNull(dir.listFiles())) {
                String fullPath = file.getName();
                System.out.println("here: " + fullPath);
            }
        } catch (Exception e) {

        }
    }
}
