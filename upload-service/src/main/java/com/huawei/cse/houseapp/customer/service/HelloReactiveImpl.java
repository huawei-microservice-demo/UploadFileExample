package com.huawei.cse.houseapp.customer.service;

import com.huawei.cse.houseapp.common.HelloReactive;
import org.apache.servicecomb.provider.rest.common.RestSchema;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.ws.rs.core.MediaType;
import java.util.concurrent.CompletableFuture;

/**
 * Created by j00347529 on 2018/6/15.
 */
@RestSchema(schemaId = "reactiveHello")
@RequestMapping(path = "reactiveHello", produces = MediaType.APPLICATION_JSON)
public class HelloReactiveImpl implements HelloReactive {
    private static final Logger LOGGER = LoggerFactory.getLogger(HelloReactiveImpl.class);

    @RequestMapping(path = "/sayHello", method = RequestMethod.PUT)
    @Override
    public CompletableFuture<String> sayHello(@RequestParam(name = "hello") String name) {
        LOGGER.info("sayHello is called, name = {}", name);
        CompletableFuture<String> completableFuture = new CompletableFuture<>();

        completableFuture.complete(name);
        return completableFuture;
    }
}
