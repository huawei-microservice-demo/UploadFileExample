package com.huawei.cse.houseapp.customer.service;

import com.huawei.cse.houseapp.common.HelloTime;
import org.apache.servicecomb.provider.rest.common.RestSchema;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.ws.rs.core.MediaType;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Random;
import java.util.TimeZone;

/**
 * Created by j00347529 on 2018/6/28.
 */
@RestSchema(schemaId = "time")
@RequestMapping(path = "/time", produces = MediaType.APPLICATION_JSON)
public class TimeServiceImpl {

    @RequestMapping(path = "/getTime", method = RequestMethod.GET)
    public HelloTime echoTime() {
        HelloTime ht = new HelloTime();
        ht.setName("Jason");
        ht.setNumber(new Random().nextInt(1000));
        Date day = new Date();
//        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        df.setTimeZone(TimeZone.getTimeZone("Asia/Shanghai"));
        ht.setDate(day);
        return ht;
    }
}
