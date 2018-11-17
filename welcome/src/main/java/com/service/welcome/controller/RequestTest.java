package com.service.welcome.controller;

import com.huawei.cse.houseapp.common.ApiResponse;
import com.huawei.cse.houseapp.common.HelloTime;
import org.apache.servicecomb.provider.rest.common.RestSchema;
import org.apache.servicecomb.provider.springmvc.reference.RestTemplateBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;


/**
 * Created by Administrator on 2018/7/31.
 */
@RestSchema(schemaId = "request-test")
@RequestMapping(path = "/")
public class RequestTest {

    private static RestTemplate restTemplate = RestTemplateBuilder.create();

    @GetMapping(path = "/time1")
    public HelloTime getTime1() {
        HelloTime ht = restTemplate.getForObject("cse://upload-service/time/getTime", HelloTime.class);
        System.out.println(ht.getDate().toString());
        return ht;
    }

    @GetMapping(path = "/time2")
    public HelloTime getTime2() {
        HelloTime ht = restTemplate.getForObject("cse://customer-service/test/getTime", HelloTime.class);
        System.out.println(ht.getDate().toString());
        return ht;
    }

    @GetMapping(path = "/testObject")
    public HelloTime getObject() {
        HelloTime ht = restTemplate.getForObject("cse://hellomesher/test1?name=jhw", HelloTime.class);
        System.out.println(ht.getDate().toString());
        return ht;
    }

    @GetMapping(path = "/testPlain")
    public String getPlain() {
        String str = restTemplate.getForObject("cse://hellomesher/test2?name=jhw", String.class);
        return str;
    }

    @GetMapping(path = "/testzk")
    public ApiResponse testZK() {
        ApiResponse ar = restTemplate.getForObject("cse://hellomesher/realware/external/queryStampPositionWithName?certID=certid&admDivCode=admDivCode&stYear=2018&vtCode=vtCode", ApiResponse.class);
        return ar;
    }
}
