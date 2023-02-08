package com.dilidili.filter.admin.controller;

import com.dilidili.filter.admin.entity.DTO.AreaContentListDTO;
import com.dilidili.proxy.RestTemplateProxy;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class AreaContentApiTest {
    @Autowired
    private RestTemplateProxy restTemplateProxy;

    @Test
    public void testGetAreaContentList() {
        HttpHeaders headers = new HttpHeaders();
        headers.add("content-type", "application/json");

        AreaContentListDTO areaContentListDTO = new AreaContentListDTO();
        areaContentListDTO.setArea("common");
        areaContentListDTO.setPageSize(10);
        areaContentListDTO.setPageNum(0);

        HttpEntity<AreaContentListDTO> entity = new HttpEntity(areaContentListDTO, headers);

        String resp = restTemplateProxy.exchangeByPost("http://127.0.0.1:8002/area/content/list", entity, String.class);

        System.out.println(resp);
    }
}