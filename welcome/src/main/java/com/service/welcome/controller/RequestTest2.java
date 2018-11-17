package com.service.welcome.controller;

import com.huawei.cse.houseapp.common.*;
import org.apache.servicecomb.provider.rest.common.RestSchema;
import org.apache.servicecomb.provider.springmvc.reference.RestTemplateBuilder;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

import java.util.Date;
import java.util.HashMap;
import java.util.Random;

/**
 * Created by Administrator on 2018/8/1.
 */
@RestSchema(schemaId = "shanxi-finance")
@RequestMapping(path = "/")
public class RequestTest2 {

    private static RestTemplate restTemplate = RestTemplateBuilder.create();

    @GetMapping(path = "/shanxi")
    public String bosi() {
        HashMap<String, String> uriVariables = new HashMap<>();
        uriVariables.put("name","jianghongwei");
        uriVariables.put("city","Beijing");
        uriVariables.put("province","Shanxi");
        uriVariables.put("country","China");
        String result = restTemplate.postForObject("cse://upload-service/time/bosi?name={name}&city={city}&province={province}&country={country}",
                null, String.class, uriVariables);


//        HttpHeaders headers = new HttpHeaders();
//        headers.set("name", "jianghongwei");
//        headers.set("city", "Beijing");
//        headers.set("province", "Shanxi");
//        headers.set("country", "China");
//        HttpEntity<String> entity = new HttpEntity<>(headers);
//        String result = restTemplate.postForObject("cse://upload-service/time/bosi", entity, String.class);
        return result;
    }

    @GetMapping(path = "/shanxi2")
    public String bosi2() {
        HelloTime ht = new HelloTime();
        Date day = new Date();
        ht.setName("Jason");
        ht.setNumber(new Random().nextInt(1000));
        ht.setDate(day);
        String result = restTemplate.postForObject("cse://upload-service/time/test", ht, String.class);
        return result;
    }
}