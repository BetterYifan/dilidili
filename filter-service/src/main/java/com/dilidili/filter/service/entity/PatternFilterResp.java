package com.dilidili.filter.service.entity;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class PatternFilterResp {

    private List<Hit> hits = new ArrayList<>();

}
